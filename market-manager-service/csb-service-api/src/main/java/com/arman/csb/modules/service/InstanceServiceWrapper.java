package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see InstanceService
 * @generated
 */
public class InstanceServiceWrapper implements InstanceService,
    ServiceWrapper<InstanceService> {
    private InstanceService _instanceService;

    public InstanceServiceWrapper(InstanceService instanceService) {
        _instanceService = instanceService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _instanceService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _instanceService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _instanceService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject addInstance(
        java.util.Map<java.lang.String, java.lang.Object> instance,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceService.addInstance(instance, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject updateInstance(
        java.util.Map<java.lang.String, java.lang.Object> instance,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceService.updateInstance(instance, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject updateInstanceStatus(
        long instanceId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceService.updateInstanceStatus(instanceId, status,
            serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getInstanceById(
        long instanceId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceService.getInstanceById(instanceId, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONArray search(
        java.lang.String filter, int status, int start, int maxResult,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceService.search(filter, status, start, maxResult,
            serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public InstanceService getWrappedInstanceService() {
        return _instanceService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedInstanceService(InstanceService instanceService) {
        _instanceService = instanceService;
    }

    @Override
    public InstanceService getWrappedService() {
        return _instanceService;
    }

    @Override
    public void setWrappedService(InstanceService instanceService) {
        _instanceService = instanceService;
    }
}
