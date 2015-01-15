package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.Invoice;
import com.arman.csb.modules.model.InvoiceItem;
import com.arman.csb.modules.service.InvoiceItemLocalServiceUtil;
import com.arman.csb.modules.service.InvoiceItemServiceUtil;
import com.arman.csb.modules.service.base.InvoiceItemServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.service.ServiceContext;


import java.util.Date;
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
