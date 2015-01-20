package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Score. This utility wraps
 * {@link com.arman.csb.modules.service.impl.ScoreServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ScoreService
 * @see com.arman.csb.modules.service.base.ScoreServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.ScoreServiceImpl
 * @generated
 */
public class ScoreServiceUtil {
    private static ScoreService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.ScoreServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.liferay.portal.kernel.json.JSONObject customerScoresByDate(
        java.lang.Long customerId, java.lang.String fromDate,
        java.lang.String toDate,
        com.liferay.portal.service.ServiceContext serviceContext) {
        return getService()
                   .customerScoresByDate(customerId, fromDate, toDate,
            serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject scoresByDate(
        java.lang.String fromDate, java.lang.String toDate,
        java.lang.String timePeriod,
        com.liferay.portal.service.ServiceContext serviceContext) {
        return getService()
                   .scoresByDate(fromDate, toDate, timePeriod, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject addScore(
        java.lang.Long customerId, long value,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addScore(customerId, value, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray customerScores(
        java.lang.Long customerId, int start, int total,
        java.util.Map<java.lang.String, java.lang.Object> filter,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .customerScores(customerId, start, total, filter,
            serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getTotalStats()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTotalStats();
    }

    public static com.liferay.portal.kernel.json.JSONObject getScoreActivityJSONObject(
        com.arman.csb.modules.model.Score score,
        com.arman.csb.modules.model.Customer customer) {
        return getService().getScoreActivityJSONObject(score, customer);
    }

    public static void clearService() {
        _service = null;
    }

    public static ScoreService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ScoreService.class.getName());

            if (invokableService instanceof ScoreService) {
                _service = (ScoreService) invokableService;
            } else {
                _service = new ScoreServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ScoreServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ScoreService service) {
    }
}
