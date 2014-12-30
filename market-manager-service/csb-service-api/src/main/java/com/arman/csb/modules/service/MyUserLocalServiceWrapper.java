package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyUserLocalService
 * @generated
 */
public class MyUserLocalServiceWrapper implements MyUserLocalService,
    ServiceWrapper<MyUserLocalService> {
    private MyUserLocalService _myUserLocalService;

    public MyUserLocalServiceWrapper(MyUserLocalService myUserLocalService) {
        _myUserLocalService = myUserLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _myUserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _myUserLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _myUserLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MyUserLocalService getWrappedMyUserLocalService() {
        return _myUserLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMyUserLocalService(
        MyUserLocalService myUserLocalService) {
        _myUserLocalService = myUserLocalService;
    }

    @Override
    public MyUserLocalService getWrappedService() {
        return _myUserLocalService;
    }

    @Override
    public void setWrappedService(MyUserLocalService myUserLocalService) {
        _myUserLocalService = myUserLocalService;
    }
}
