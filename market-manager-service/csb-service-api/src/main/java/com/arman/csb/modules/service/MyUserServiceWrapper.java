package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyUserService
 * @generated
 */
public class MyUserServiceWrapper implements MyUserService,
    ServiceWrapper<MyUserService> {
    private MyUserService _myUserService;

    public MyUserServiceWrapper(MyUserService myUserService) {
        _myUserService = myUserService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _myUserService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _myUserService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _myUserService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject newUser(
        java.util.Map<java.lang.String, java.lang.Object> user,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _myUserService.newUser(user, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONArray findUsers(
        java.util.Map<java.lang.String, java.lang.Object> filter,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _myUserService.findUsers(filter, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject updateStatus(
        java.lang.Long userId, boolean isActive,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _myUserService.updateStatus(userId, isActive, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getById(
        java.lang.Long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _myUserService.getById(userId, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject agreed(
        java.lang.Long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _myUserService.agreed(userId, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getPaymentActivityJSONObject(
        com.liferay.portal.model.User user) {
        return _myUserService.getPaymentActivityJSONObject(user);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MyUserService getWrappedMyUserService() {
        return _myUserService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMyUserService(MyUserService myUserService) {
        _myUserService = myUserService;
    }

    @Override
    public MyUserService getWrappedService() {
        return _myUserService;
    }

    @Override
    public void setWrappedService(MyUserService myUserService) {
        _myUserService = myUserService;
    }
}
