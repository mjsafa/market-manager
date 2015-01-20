package com.arman.csb.modules.service.impl;

import com.arman.csb.constant.UserActivityConstant;
import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.Invoice;
import com.arman.csb.modules.model.InvoiceItem;
import com.arman.csb.modules.model.impl.CustomerImpl;
import com.arman.csb.modules.model.impl.InvoiceImpl;
import com.arman.csb.modules.service.*;
import com.arman.csb.modules.service.base.InvoiceServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.impl.UserLocalServiceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the invoice remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.InvoiceService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.InvoiceServiceBaseImpl
 * @see com.arman.csb.modules.service.InvoiceServiceUtil
 */
public class InvoiceServiceImpl extends InvoiceServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.InvoiceServiceUtil} to access the invoice remote service.
     */

    public JSONObject addInvoice(Map<String, Object> invoice, ServiceContext serviceContext) throws SystemException, PortalException {

        User onlineUser = UserLocalServiceUtil.getUser(serviceContext.getUserId());

        Invoice newInvoice = InvoiceLocalServiceUtil.createInvoice(counterLocalService.increment(Invoice.class.getName()));
        newInvoice.setGroupId(serviceContext.getScopeGroupId());
        newInvoice.setCompanyId(serviceContext.getCompanyId());
        newInvoice.setUserId(onlineUser.getUserId());
        newInvoice.setUserName(onlineUser.getFullName());
        newInvoice.setCreateDate(new Date());
        newInvoice.setModifiedDate(new Date());

        newInvoice = getInvoiceData(newInvoice, invoice, serviceContext);

        InvoiceLocalServiceUtil.addInvoice(newInvoice);

        List<Map<String, Object>> items = (List) invoice.get("invoiceItems");
        JSONArray invoiceItems = JSONFactoryUtil.createJSONArray();;
        for (Map<String, Object> item : items) {
            item.put("invoiceId", newInvoice.getId());
            JSONObject itemObject = InvoiceItemServiceUtil.addInvoiceItem(item, serviceContext);
            invoiceItems.put(itemObject);
        }

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_INVOICE, UserActivityConstant.ACTION_ADD,
                UserActivityConstant.IMPORTANCE_MEDIUM, getUserActivityJSONObject(newInvoice, invoiceItems).toString(), serviceContext);

        return getJSONObject(newInvoice);
    }

    public JSONObject updateInvoice(Map<String, Object> invoice, ServiceContext serviceContext) throws SystemException, PortalException {
        long invoiceId = Long.valueOf(String.valueOf(invoice.get("id")));
        Invoice updateInvoice = InvoiceLocalServiceUtil.getInvoice(invoiceId);

        updateInvoice.setModifiedDate(new Date());

        updateInvoice = getInvoiceData(updateInvoice, invoice, serviceContext);

        InvoiceLocalServiceUtil.updateInvoice(updateInvoice);

        JSONArray invoiceItems = InvoiceItemServiceUtil.search("", updateInvoice.getId(), 0, Integer.MAX_VALUE, serviceContext);
        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_INVOICE, UserActivityConstant.ACTION_EDIT,
                UserActivityConstant.IMPORTANCE_MEDIUM, getUserActivityJSONObject(updateInvoice, invoiceItems).toString(), serviceContext);

        return getJSONObject(updateInvoice);
    }

    public JSONArray search(String filter, int start, int maxResult, ServiceContext serviceContext) throws JSONException {
        JSONArray result = JSONFactoryUtil.createJSONArray();

        Session session = invoicePersistence.openSession();

        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.InvoiceService.search");
        sql = sql.replaceAll("##KEYWORD##","%" + filter + "%");

        SQLQuery queryObject = session.createSQLQuery(sql);
        //queryObject.addEntity(InvoiceImpl.TABLE_NAME, InvoiceImpl.class);
        queryObject.setFirstResult(start);
        queryObject.setMaxResults(maxResult);

        List<Object[]> objects = queryObject.list();

        for (Object[] data : objects) {
            JSONObject json = JSONFactoryUtil.createJSONObject();
            json.put("customerName", (String)data[0]);
            json.put("invoiceDate", (Date)data[1]);

            data[2] = null==data[2] ? 0 : data[2];
            data[3] = null==data[3] ? 0 : data[3];

            json.put("itemNumber", Long.valueOf(String.valueOf(data[2])) );
            json.put("totalCost", Long.valueOf(String.valueOf(data[3])));

            json.put("id", Long.valueOf(String.valueOf(data[4])));

            result.put(json);
        }

        return result;
    }

    public JSONObject getById(long invoiceId,ServiceContext serviceContext) throws PortalException, SystemException {
        Invoice invoice = InvoiceLocalServiceUtil.getInvoice(invoiceId);

        return getJSONObject(invoice);
    }

    private Invoice getInvoiceData(Invoice invoiceObject, Map<String, Object> invoice, ServiceContext serviceContext) {
        invoiceObject.setCustomerId(Long.valueOf(String.valueOf(invoice.get("customerId"))));
        invoiceObject.setAddress(String.valueOf(invoice.get("address")));
        invoiceObject.setTelephone(String.valueOf(invoice.get("telephone")));
        invoiceObject.setMobile(String.valueOf(invoice.get("mobile")));
        invoiceObject.setTypeOfDelivery(Short.valueOf(String.valueOf(invoice.get("typeOfDelivery"))));

        return invoiceObject;
    }

    private JSONObject getJSONObject(Invoice invoice) throws JSONException {
        JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
        JSONObject result = JSONFactoryUtil.createJSONObject(jsonSerializer.serialize(invoice));

        return result;
    }

    private JSONObject getUserActivityJSONObject(Invoice invoice, JSONArray items) throws PortalException, SystemException {
        JSONObject result = getJSONObject(invoice);

        long totalCost = 0;
        for (int i=0 ; i<items.length() ; i++) {
            JSONObject item = items.getJSONObject(i);
            totalCost += item.getLong("basePrice") * item.getInt("number");
        }

        Customer customer = CustomerLocalServiceUtil.getCustomer(invoice.getCustomerId());

        result.put("totalCost", totalCost);
        result.put("itemNumber", items.length());
        result.put("customerName", customer.getName());

        return result;
    }
}
