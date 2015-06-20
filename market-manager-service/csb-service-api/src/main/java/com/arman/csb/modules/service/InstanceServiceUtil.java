package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Instance. This utility wraps
 * {@link com.arman.csb.modules.service.impl.InstanceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see InstanceService
 * @see com.arman.csb.modules.service.base.InstanceServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.InstanceServiceImpl
 * @generated
 */
public class InstanceServiceUtil {
    private static InstanceService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.InstanceServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.portal.kernel.json.JSONObject addInstance(
        java.util.Map<java.lang.String, java.lang.Object> instance,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addInstance(instance, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updateInstance(
        java.util.Map<java.lang.String, java.lang.Object> instance,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateInstance(instance, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updateInstanceStatus(
        long instanceId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateInstanceStatus(instanceId, status, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getInstanceById(
        long instanceId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getInstanceById(instanceId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getInstanceByGroupId(
        long groupId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getInstanceByGroupId(groupId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray search(
        java.lang.String filter, int status, int start, int maxResult,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .search(filter, status, start, maxResult, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static InstanceService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    InstanceService.class.getName());

            if (invokableService instanceof InstanceService) {
                _service = (InstanceService) invokableService;
            } else {
                _service = new InstanceServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(InstanceServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(InstanceService service) {
    }
}
