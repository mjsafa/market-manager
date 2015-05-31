package com.arman.csb.theme.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContentHolderService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContentHolderService
 * @generated
 */
public class ContentHolderServiceWrapper implements ContentHolderService,
    ServiceWrapper<ContentHolderService> {
    private ContentHolderService _contentHolderService;

    public ContentHolderServiceWrapper(
        ContentHolderService contentHolderService) {
        _contentHolderService = contentHolderService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _contentHolderService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _contentHolderService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _contentHolderService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ContentHolderService getWrappedContentHolderService() {
        return _contentHolderService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedContentHolderService(
        ContentHolderService contentHolderService) {
        _contentHolderService = contentHolderService;
    }

    @Override
    public ContentHolderService getWrappedService() {
        return _contentHolderService;
    }

    @Override
    public void setWrappedService(ContentHolderService contentHolderService) {
        _contentHolderService = contentHolderService;
    }
}
