package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScoreService}.
 *
 * @author Brian Wing Shun Chan
 * @see ScoreService
 * @generated
 */
public class ScoreServiceWrapper implements ScoreService,
    ServiceWrapper<ScoreService> {
    private ScoreService _scoreService;

    public ScoreServiceWrapper(ScoreService scoreService) {
        _scoreService = scoreService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _scoreService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _scoreService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _scoreService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ScoreService getWrappedScoreService() {
        return _scoreService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedScoreService(ScoreService scoreService) {
        _scoreService = scoreService;
    }

    @Override
    public ScoreService getWrappedService() {
        return _scoreService;
    }

    @Override
    public void setWrappedService(ScoreService scoreService) {
        _scoreService = scoreService;
    }
}
