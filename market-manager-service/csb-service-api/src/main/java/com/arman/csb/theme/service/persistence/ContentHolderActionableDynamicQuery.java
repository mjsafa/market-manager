package com.arman.csb.theme.service.persistence;

import com.arman.csb.theme.model.ContentHolder;
import com.arman.csb.theme.service.ContentHolderLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ContentHolderActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ContentHolderActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ContentHolderLocalServiceUtil.getService());
        setClass(ContentHolder.class);

        setClassLoader(com.arman.csb.theme.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
