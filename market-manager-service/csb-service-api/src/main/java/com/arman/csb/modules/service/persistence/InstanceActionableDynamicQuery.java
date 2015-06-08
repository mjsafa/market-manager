package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Instance;
import com.arman.csb.modules.service.InstanceLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class InstanceActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public InstanceActionableDynamicQuery() throws SystemException {
        setBaseLocalService(InstanceLocalServiceUtil.getService());
        setClass(Instance.class);

        setClassLoader(com.arman.csb.modules.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
