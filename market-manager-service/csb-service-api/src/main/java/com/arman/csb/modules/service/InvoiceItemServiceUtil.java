package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for InvoiceItem. This utility wraps
 * {@link com.arman.csb.modules.service.impl.InvoiceItemServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceItemService
 * @see com.arman.csb.modules.service.base.InvoiceItemServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.InvoiceItemServiceImpl
 * @generated
 */
public class InvoiceItemServiceUtil {
    private static InvoiceItemService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.InvoiceItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.portal.kernel.json.JSONObject addInvoiceItem(
        java.util.Map<java.lang.String, java.lang.Object> invoiceItem,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addInvoiceItem(invoiceItem, serviceContext);
    }

    public static java.lang.Long deleteInvoiceItem(long invoiceItemId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteInvoiceItem(invoiceItemId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray search(
        java.lang.String filter, long invoiceId, int start, int maxResult,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.json.JSONException {
        return getService()
                   .search(filter, invoiceId, start, maxResult, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static InvoiceItemService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    InvoiceItemService.class.getName());

            if (invokableService instanceof InvoiceItemService) {
                _service = (InvoiceItemService) invokableService;
            } else {
                _service = new InvoiceItemServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(InvoiceItemServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(InvoiceItemService service) {
    }
}
