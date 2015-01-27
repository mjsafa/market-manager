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

    @Override
    public com.liferay.portal.kernel.json.JSONObject customerScoresByDate(
        java.lang.Long customerId, java.lang.String fromDate,
        java.lang.String toDate,
        com.liferay.portal.service.ServiceContext serviceContext) {
        return _scoreService.customerScoresByDate(customerId, fromDate, toDate,
            serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject scoresByDate(
        java.lang.String fromDate, java.lang.String toDate,
        java.lang.String timePeriod,
        com.liferay.portal.service.ServiceContext serviceContext) {
        return _scoreService.scoresByDate(fromDate, toDate, timePeriod,
            serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject addScore(
        java.lang.Long customerId, long value,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _scoreService.addScore(customerId, value, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONArray customerScores(
        java.lang.Long customerId, int start, int total,
        java.util.Map<java.lang.String, java.lang.Object> filter,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _scoreService.customerScores(customerId, start, total, filter,
            serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getTotalStats()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _scoreService.getTotalStats();
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getScoreActivityJSONObject(
        com.arman.csb.modules.model.Score score,
        com.arman.csb.modules.model.Customer customer) {
        return _scoreService.getScoreActivityJSONObject(score, customer);
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
