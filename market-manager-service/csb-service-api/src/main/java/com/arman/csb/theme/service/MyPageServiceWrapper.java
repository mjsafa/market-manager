package com.arman.csb.theme.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyPageService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyPageService
 * @generated
 */
public class MyPageServiceWrapper implements MyPageService,
    ServiceWrapper<MyPageService> {
    private MyPageService _myPageService;

    public MyPageServiceWrapper(MyPageService myPageService) {
        _myPageService = myPageService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _myPageService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _myPageService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _myPageService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject editPageContent(
        java.lang.String pageId, java.lang.String itemId,
        java.lang.String newContent) {
        return _myPageService.editPageContent(pageId, itemId, newContent);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MyPageService getWrappedMyPageService() {
        return _myPageService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMyPageService(MyPageService myPageService) {
        _myPageService = myPageService;
    }

    @Override
    public MyPageService getWrappedService() {
        return _myPageService;
    }

    @Override
    public void setWrappedService(MyPageService myPageService) {
        _myPageService = myPageService;
    }
}
