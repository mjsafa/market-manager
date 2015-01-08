package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Invoice;
import com.arman.csb.modules.service.InvoiceLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class InvoiceActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public InvoiceActionableDynamicQuery() throws SystemException {
        setBaseLocalService(InvoiceLocalServiceUtil.getService());
        setClass(Invoice.class);

        setClassLoader(com.arman.csb.modules.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
