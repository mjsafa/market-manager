package com.arman.csb.theme.service.persistence;

import com.arman.csb.theme.model.Template;
import com.arman.csb.theme.service.TemplateLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class TemplateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TemplateActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TemplateLocalServiceUtil.getService());
        setClass(Template.class);

        setClassLoader(com.arman.csb.theme.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
