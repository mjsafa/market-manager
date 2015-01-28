package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.InvoiceItem;
import com.arman.csb.modules.service.base.InvoiceItemLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the invoice item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.InvoiceItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.InvoiceItemLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.InvoiceItemLocalServiceUtil
 */
public class InvoiceItemLocalServiceImpl extends InvoiceItemLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.InvoiceItemLocalServiceUtil} to access the invoice item local service.
     */

    public List<InvoiceItem> getInvoiceItemsByInvoiceId(long invoiceId) throws SystemException {
        return invoiceItemPersistence.findByInvoiceId(invoiceId);
    }

}
