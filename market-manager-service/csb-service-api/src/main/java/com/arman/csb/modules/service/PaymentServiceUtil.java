package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Payment. This utility wraps
 * {@link com.arman.csb.modules.service.impl.PaymentServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PaymentService
 * @see com.arman.csb.modules.service.base.PaymentServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.PaymentServiceImpl
 * @generated
 */
public class PaymentServiceUtil {
    private static PaymentService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.PaymentServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.liferay.portal.kernel.json.JSONObject addPayment(
        java.util.Map<java.lang.String, java.lang.Object> paymentMap,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addPayment(paymentMap, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject totalPayedAmount(
        java.lang.Long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().totalPayedAmount(customerId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray search(
        java.util.Map<java.lang.String, java.lang.Object> filter, int first,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().search(filter, first, maxResult, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getTotalStats(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTotalStats(serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject isDownloaded(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().isDownloaded(serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject downloadPayments(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().downloadPayments(serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject acceptPayments(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().acceptPayments(serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject cancelDownloadPayments(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().cancelDownloadPayments(serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject rejectPayment(
        java.lang.Long paymentId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().rejectPayment(paymentId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject deletePayment(
        long paymentId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePayment(paymentId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getStats(
        long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getStats(customerId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getPaymentActivityJSONObject(
        com.arman.csb.modules.model.Payment payment,
        com.arman.csb.modules.model.Customer customer) {
        return getService().getPaymentActivityJSONObject(payment, customer);
    }

    public static void clearService() {
        _service = null;
    }

    public static PaymentService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PaymentService.class.getName());

            if (invokableService instanceof PaymentService) {
                _service = (PaymentService) invokableService;
            } else {
                _service = new PaymentServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(PaymentServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PaymentService service) {
    }
}
