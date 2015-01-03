package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Score;
import com.arman.csb.modules.service.ScoreLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ScoreActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ScoreActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ScoreLocalServiceUtil.getService());
        setClass(Score.class);

        setClassLoader(com.arman.csb.modules.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
