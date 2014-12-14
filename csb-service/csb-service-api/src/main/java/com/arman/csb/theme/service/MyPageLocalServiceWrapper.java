package com.arman.csb.theme.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyPageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyPageLocalService
 * @generated
 */
public class MyPageLocalServiceWrapper implements MyPageLocalService,
    ServiceWrapper<MyPageLocalService> {
    private MyPageLocalService _myPageLocalService;

    public MyPageLocalServiceWrapper(MyPageLocalService myPageLocalService) {
        _myPageLocalService = myPageLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _myPageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _myPageLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _myPageLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public void editPageContent(long pageId, java.lang.String itemId,
        java.lang.String newContent) {
        _myPageLocalService.editPageContent(pageId, itemId, newContent);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> renderPageHTML(
        long pageId) {
        return _myPageLocalService.renderPageHTML(pageId);
    }

    @Override
    public java.util.Map<java.lang.String, java.lang.Object> renderAdminHTML(
        long pageId) {
        return _myPageLocalService.renderAdminHTML(pageId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MyPageLocalService getWrappedMyPageLocalService() {
        return _myPageLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMyPageLocalService(
        MyPageLocalService myPageLocalService) {
        _myPageLocalService = myPageLocalService;
    }

    @Override
    public MyPageLocalService getWrappedService() {
        return _myPageLocalService;
    }

    @Override
    public void setWrappedService(MyPageLocalService myPageLocalService) {
        _myPageLocalService = myPageLocalService;
    }
}
