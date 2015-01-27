package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Invoice. This utility wraps
 * {@link com.arman.csb.modules.service.impl.InvoiceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceService
 * @see com.arman.csb.modules.service.base.InvoiceServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.InvoiceServiceImpl
 * @generated
 */
public class InvoiceServiceUtil {
    private static InvoiceService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.InvoiceServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.portal.kernel.json.JSONObject addInvoice(
        java.util.Map<java.lang.String, java.lang.Object> invoice,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addInvoice(invoice, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updateInvoice(
        java.util.Map<java.lang.String, java.lang.Object> invoice,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateInvoice(invoice, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray search(
        java.lang.String filter, java.lang.String status, int start,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.json.JSONException {
        return getService()
                   .search(filter, status, start, maxResult, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getById(
        long invoiceId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getById(invoiceId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updateInvoiceStatus(
        long invoiceId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateInvoiceStatus(invoiceId, status, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static InvoiceService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    InvoiceService.class.getName());

            if (invokableService instanceof InvoiceService) {
                _service = (InvoiceService) invokableService;
            } else {
                _service = new InvoiceServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(InvoiceServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(InvoiceService service) {
    }
}
