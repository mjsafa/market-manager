package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.InvoiceItem;
import com.arman.csb.modules.service.InvoiceItemLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class InvoiceItemActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public InvoiceItemActionableDynamicQuery() throws SystemException {
        setBaseLocalService(InvoiceItemLocalServiceUtil.getService());
        setClass(InvoiceItem.class);

        setClassLoader(com.arman.csb.modules.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
