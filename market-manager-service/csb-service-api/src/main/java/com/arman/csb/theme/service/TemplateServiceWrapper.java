package com.arman.csb.theme.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TemplateService}.
 *
 * @author Brian Wing Shun Chan
 * @see TemplateService
 * @generated
 */
public class TemplateServiceWrapper implements TemplateService,
    ServiceWrapper<TemplateService> {
    private TemplateService _templateService;

    public TemplateServiceWrapper(TemplateService templateService) {
        _templateService = templateService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _templateService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _templateService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _templateService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TemplateService getWrappedTemplateService() {
        return _templateService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTemplateService(TemplateService templateService) {
        _templateService = templateService;
    }

    @Override
    public TemplateService getWrappedService() {
        return _templateService;
    }

    @Override
    public void setWrappedService(TemplateService templateService) {
        _templateService = templateService;
    }
}
