package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.UserActivity;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class UserActivityActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public UserActivityActionableDynamicQuery() throws SystemException {
        setBaseLocalService(UserActivityLocalServiceUtil.getService());
        setClass(UserActivity.class);

        setClassLoader(com.arman.csb.modules.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
