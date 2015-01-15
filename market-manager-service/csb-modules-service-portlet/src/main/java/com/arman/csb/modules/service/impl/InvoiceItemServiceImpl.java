package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.Invoice;
import com.arman.csb.modules.model.InvoiceItem;
import com.arman.csb.modules.model.impl.InvoiceItemImpl;
import com.arman.csb.modules.service.InvoiceItemLocalServiceUtil;
import com.arman.csb.modules.service.InvoiceItemServiceUtil;
import com.arman.csb.modules.service.base.InvoiceItemServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.dao.orm.CustomSQLUtil;
import sun.misc.Sort;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the invoice item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.InvoiceItemService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.InvoiceItemServiceBaseImpl
 * @see com.arman.csb.modules.service.InvoiceItemServiceUtil
 */
public class InvoiceItemServiceImpl extends InvoiceItemServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.InvoiceItemServiceUtil} to access the invoice item remote service.
     */

    public JSONObject addInvoiceItem(Map<String, Object> invoiceItem, ServiceContext serviceContext) throws SystemException, JSONException {
        InvoiceItem newInvoiceItem = InvoiceItemLocalServiceUtil.createInvoiceItem(counterLocalService.increment(InvoiceItem.class.getName()));

        newInvoiceItem.setCreateDate(new Date());
        newInvoiceItem.setModifiedDate(new Date());

        newInvoiceItem = getInvoiceItemData(newInvoiceItem, invoiceItem, serviceContext);

        InvoiceItemLocalServiceUtil.addInvoiceItem(newInvoiceItem);

        return getJSONObject(newInvoiceItem);
    }

    public Long deleteInvoiceItem(long invoiceItemId, ServiceContext serviceContext) throws SystemException, PortalException {
        InvoiceItemLocalServiceUtil.deleteInvoiceItem(invoiceItemId);

        return invoiceItemId;
    }

    public JSONArray search(String filter, long invoiceId, int start, int maxResult, ServiceContext serviceContext)
            throws JSONException {

        JSONArray result = JSONFactoryUtil.createJSONArray();

        Session session = invoicePersistence.openSession();

        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.InvoiceItemService.search");
        sql = sql.replaceAll("##KEYWORD##","%" + filter + "%");

        SQLQuery queryObject = session.createSQLQuery(sql);

        queryObject.addEntity(InvoiceItemImpl.TABLE_NAME, InvoiceItemImpl.class);
        queryObject.setFirstResult(start);
        queryObject.setMaxResults(maxResult);

        QueryPos qPos = QueryPos.getInstance(queryObject);
        qPos.add(invoiceId);

        List<InvoiceItem> items = queryObject.list();

        for (InvoiceItem item : items) {
            result.put(getJSONObject(item));
        }

        return result;
    }

    private InvoiceItem getInvoiceItemData(InvoiceItem invoiceItemObject, Map<String, Object> invoiceItem, ServiceContext serviceContext) {
        invoiceItemObject.setProductName(String.valueOf(invoiceItem.get("productName")));
        invoiceItemObject.setProductCode(String.valueOf(invoiceItem.get("productCode")));
        invoiceItemObject.setNumber(Short.valueOf(String.valueOf(invoiceItem.get("number"))));
        invoiceItemObject.setBasePrice(Long.valueOf(String.valueOf(invoiceItem.get("basePrice"))));
        invoiceItemObject.setInvoiceId(Long.valueOf(String.valueOf(invoiceItem.get("invoiceId"))));

        return invoiceItemObject;
    }

    private JSONObject getJSONObject(InvoiceItem invoiceItem) throws JSONException {
        JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
        JSONObject result = JSONFactoryUtil.createJSONObject(jsonSerializer.serialize(invoiceItem));

        return result;
    }

}
