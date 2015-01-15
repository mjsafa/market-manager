package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.Payment;
import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;
import com.arman.csb.modules.service.base.PaymentLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the payment local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.PaymentLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.PaymentLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.PaymentLocalServiceUtil
 */
public class PaymentLocalServiceImpl extends PaymentLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.PaymentLocalServiceUtil} to access the payment local service.
     */

    public Payment addPayment(long amount, Long customerId, Date paymentDate, int status, Long factorId, String description,
                              ServiceContext serviceContext)
            throws PortalException, SystemException {

        Customer referencedCustomer = CustomerLocalServiceUtil.fetchCustomer(customerId);
        Payment newPayment = PaymentLocalServiceUtil.createPayment(counterLocalService.increment(Payment.class.getName()));
        newPayment.setAmount(amount);
        newPayment.setCustomerId(customerId);
        newPayment.setPaymentDate(paymentDate);
        newPayment.setStatus(status);
        newPayment.setFactorId(factorId);
        newPayment.setDescription(description);
        newPayment.setCard(referencedCustomer.getCard());
        newPayment.setUserId(serviceContext.getUserId());
        newPayment.setCompanyId(serviceContext.getCompanyId());
        newPayment.setCreateDate(new Date());
        newPayment.setGroupId(serviceContext.getScopeGroupId());
        newPayment.setModifiedDate(new Date());

        addPayment(newPayment);
        return newPayment;
    }

    public long totalPayedAmount(Long customerId) throws PortalException, SystemException {
        ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Payment.class, classLoader);
        query.add(PropertyFactoryUtil.forName("customerId").eq(customerId));
        query.setProjection(ProjectionFactoryUtil.sum("amount"));

        List<Object[]> results = dynamicQuery(query);
        for (Object[] result : results) {
            return (Long) result[0];
        }
        return 0;
    }


    public List<Payment> find(Long customerId, Date fromDate, Date toDate, long amountFrom, long amountTo, int first, int maxResult, ServiceContext serviceContext) throws PortalException, SystemException {
        ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Payment.class, classLoader);
        if (null != customerId && customerId > 0) {
            query.add(PropertyFactoryUtil.forName("customerId").eq(customerId));
        }
        if (null != fromDate) {
            query.add(PropertyFactoryUtil.forName("createDate").ge(fromDate));
        }
        if (null != toDate) {
            query.add(PropertyFactoryUtil.forName("createDate").le(toDate));
        }

        if (amountFrom > 0) {
            query.add(PropertyFactoryUtil.forName("amount").ge(amountFrom));
        }
        if (amountTo > 0) {
            query.add(PropertyFactoryUtil.forName("amount").le(amountTo));
        }

        return dynamicQuery(query);
    }

    public long totalPaymentAmount(Long customerId, Date fromDate, Date toDate) throws PortalException, SystemException{
        ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Payment.class, classLoader);
        if (null != customerId && customerId > 0) {
            query.add(PropertyFactoryUtil.forName("customerId").eq(customerId));
        }
        if (null != fromDate) {
            query.add(PropertyFactoryUtil.forName("createDate").ge(fromDate));
        }
        if (null != toDate) {
            query.add(PropertyFactoryUtil.forName("createDate").le(toDate));
        }

        query.setProjection(ProjectionFactoryUtil.sum("amount"));
        long amount = 0;
        List<Long> result = dynamicQuery(query);
        if(!result.isEmpty()){
            return result.get(0);
        }
        return amount;
    }
}
