package com.arman.csb.modules.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Score. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ScoreServiceUtil
 * @see com.arman.csb.modules.service.base.ScoreServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.ScoreServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ScoreService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ScoreServiceUtil} to access the score remote service. Add custom service methods to {@link com.arman.csb.modules.service.impl.ScoreServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public com.liferay.portal.kernel.json.JSONObject customerScoresByDate(
        java.lang.Long customerId, java.lang.String fromDate,
        java.lang.String toDate,
        com.liferay.portal.service.ServiceContext serviceContext);

    public com.liferay.portal.kernel.json.JSONObject scoresByDate(
        java.lang.String fromDate, java.lang.String toDate,
        java.lang.String timePeriod,
        com.liferay.portal.service.ServiceContext serviceContext);

    public com.liferay.portal.kernel.json.JSONObject addScore(
        java.lang.Long customerId, long value,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.json.JSONArray customerScores(
        java.lang.Long customerId, int start, int total,
        java.util.Map<java.lang.String, java.lang.Object> filter,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.json.JSONObject getTotalStats()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.json.JSONObject getScoreActivityJSONObject(
        com.arman.csb.modules.model.Score score,
        com.arman.csb.modules.model.Customer customer);
}
