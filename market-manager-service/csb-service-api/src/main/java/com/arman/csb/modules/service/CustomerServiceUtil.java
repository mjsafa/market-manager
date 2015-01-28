package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Customer. This utility wraps
 * {@link com.arman.csb.modules.service.impl.CustomerServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerService
 * @see com.arman.csb.modules.service.base.CustomerServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.CustomerServiceImpl
 * @generated
 */
public class CustomerServiceUtil {
    private static CustomerService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.CustomerServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.portal.kernel.json.JSONArray search(
        java.lang.String filter, long mentorCustomerId, int start,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .search(filter, mentorCustomerId, start, maxResult,
            serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject addCustomer(
        java.util.Map<java.lang.String, java.lang.Object> customer,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addCustomer(customer, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getTotal(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTotal(serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getById(
        long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getById(customerId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray getInvitees(
        long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getInvitees(customerId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getStats(
        long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getStats(customerId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getTotalStats(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTotalStats(serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updateCustomer(
        java.util.Map<java.lang.String, java.lang.Object> customer,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateCustomer(customer, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updateCustomerStatus(
        long customerId, boolean isActive,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateCustomerStatus(customerId, isActive, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getCustomerActivityJSONObject(
        com.arman.csb.modules.model.Customer customer) {
        return getService().getCustomerActivityJSONObject(customer);
    }

    public static void clearService() {
        _service = null;
    }

    public static CustomerService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    CustomerService.class.getName());

            if (invokableService instanceof CustomerService) {
                _service = (CustomerService) invokableService;
            } else {
                _service = new CustomerServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(CustomerServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(CustomerService service) {
    }
}
