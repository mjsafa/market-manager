package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyBlogService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyBlogService
 * @generated
 */
public class MyBlogServiceWrapper implements MyBlogService,
    ServiceWrapper<MyBlogService> {
    private MyBlogService _myBlogService;

    public MyBlogServiceWrapper(MyBlogService myBlogService) {
        _myBlogService = myBlogService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _myBlogService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _myBlogService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _myBlogService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MyBlogService getWrappedMyBlogService() {
        return _myBlogService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMyBlogService(MyBlogService myBlogService) {
        _myBlogService = myBlogService;
    }

    @Override
    public MyBlogService getWrappedService() {
        return _myBlogService;
    }

    @Override
    public void setWrappedService(MyBlogService myBlogService) {
        _myBlogService = myBlogService;
    }
}
