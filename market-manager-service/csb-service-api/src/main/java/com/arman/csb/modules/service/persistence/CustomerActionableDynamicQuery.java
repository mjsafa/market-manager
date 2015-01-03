package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class CustomerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CustomerActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CustomerLocalServiceUtil.getService());
        setClass(Customer.class);

        setClassLoader(com.arman.csb.modules.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
