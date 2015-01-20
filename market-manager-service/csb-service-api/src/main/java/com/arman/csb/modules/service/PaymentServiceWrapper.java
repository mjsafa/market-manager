package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PaymentService}.
 *
 * @author Brian Wing Shun Chan
 * @see PaymentService
 * @generated
 */
public class PaymentServiceWrapper implements PaymentService,
    ServiceWrapper<PaymentService> {
    private PaymentService _paymentService;

    public PaymentServiceWrapper(PaymentService paymentService) {
        _paymentService = paymentService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _paymentService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _paymentService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _paymentService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject addPayment(
        java.util.Map<java.lang.String, java.lang.Object> paymentMap,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentService.addPayment(paymentMap, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject totalPayedAmount(
        java.lang.Long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentService.totalPayedAmount(customerId, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONArray search(
        java.util.Map<java.lang.String, java.lang.Object> filter, int first,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentService.search(filter, first, maxResult, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getTotalStats(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentService.getTotalStats(serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getPaymentActivityJSONObject(
        com.arman.csb.modules.model.Payment payment,
        com.arman.csb.modules.model.Customer customer) {
        return _paymentService.getPaymentActivityJSONObject(payment, customer);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PaymentService getWrappedPaymentService() {
        return _paymentService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPaymentService(PaymentService paymentService) {
        _paymentService = paymentService;
    }

    @Override
    public PaymentService getWrappedService() {
        return _paymentService;
    }

    @Override
    public void setWrappedService(PaymentService paymentService) {
        _paymentService = paymentService;
    }
}
