package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Payment;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class PaymentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PaymentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PaymentLocalServiceUtil.getService());
        setClass(Payment.class);

        setClassLoader(com.arman.csb.modules.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
