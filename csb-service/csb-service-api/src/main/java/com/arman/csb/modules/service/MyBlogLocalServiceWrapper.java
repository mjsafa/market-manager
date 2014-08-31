package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyBlogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyBlogLocalService
 * @generated
 */
public class MyBlogLocalServiceWrapper implements MyBlogLocalService,
    ServiceWrapper<MyBlogLocalService> {
    private MyBlogLocalService _myBlogLocalService;

    public MyBlogLocalServiceWrapper(MyBlogLocalService myBlogLocalService) {
        _myBlogLocalService = myBlogLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _myBlogLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _myBlogLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _myBlogLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MyBlogLocalService getWrappedMyBlogLocalService() {
        return _myBlogLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMyBlogLocalService(
        MyBlogLocalService myBlogLocalService) {
        _myBlogLocalService = myBlogLocalService;
    }

    @Override
    public MyBlogLocalService getWrappedService() {
        return _myBlogLocalService;
    }

    @Override
    public void setWrappedService(MyBlogLocalService myBlogLocalService) {
        _myBlogLocalService = myBlogLocalService;
    }
}
