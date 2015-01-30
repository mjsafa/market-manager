package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Product;
import com.arman.csb.modules.service.ProductLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ProductActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ProductActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ProductLocalServiceUtil.getService());
        setClass(Product.class);

        setClassLoader(com.arman.csb.modules.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
