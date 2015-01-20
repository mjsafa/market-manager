package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserActivityService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserActivityService
 * @generated
 */
public class UserActivityServiceWrapper implements UserActivityService,
    ServiceWrapper<UserActivityService> {
    private UserActivityService _userActivityService;

    public UserActivityServiceWrapper(UserActivityService userActivityService) {
        _userActivityService = userActivityService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _userActivityService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _userActivityService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _userActivityService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONArray search(
        java.lang.String filter, java.lang.String entity,
        java.lang.String action, java.lang.String importance, int start,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.json.JSONException {
        return _userActivityService.search(filter, entity, action, importance,
            start, maxResult, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public UserActivityService getWrappedUserActivityService() {
        return _userActivityService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedUserActivityService(
        UserActivityService userActivityService) {
        _userActivityService = userActivityService;
    }

    @Override
    public UserActivityService getWrappedService() {
        return _userActivityService;
    }

    @Override
    public void setWrappedService(UserActivityService userActivityService) {
        _userActivityService = userActivityService;
    }
}
