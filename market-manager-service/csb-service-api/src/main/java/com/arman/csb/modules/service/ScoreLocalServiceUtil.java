package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Score. This utility wraps
 * {@link com.arman.csb.modules.service.impl.ScoreLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ScoreLocalService
 * @see com.arman.csb.modules.service.base.ScoreLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.ScoreLocalServiceImpl
 * @generated
 */
public class ScoreLocalServiceUtil {
    private static ScoreLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.ScoreLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the score to the database. Also notifies the appropriate model listeners.
    *
    * @param score the score
    * @return the score that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score addScore(
        com.arman.csb.modules.model.Score score)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addScore(score);
    }

    /**
    * Creates a new score with the primary key. Does not add the score to the database.
    *
    * @param id the primary key for the new score
    * @return the new score
    */
    public static com.arman.csb.modules.model.Score createScore(long id) {
        return getService().createScore(id);
    }

    /**
    * Deletes the score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the score
    * @return the score that was removed
    * @throws PortalException if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score deleteScore(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteScore(id);
    }

    /**
    * Deletes the score from the database. Also notifies the appropriate model listeners.
    *
    * @param score the score
    * @return the score that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score deleteScore(
        com.arman.csb.modules.model.Score score)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteScore(score);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.arman.csb.modules.model.Score fetchScore(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchScore(id);
    }

    /**
    * Returns the score with the matching UUID and company.
    *
    * @param uuid the score's UUID
    * @param companyId the primary key of the company
    * @return the matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score fetchScoreByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchScoreByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the score matching the UUID and group.
    *
    * @param uuid the score's UUID
    * @param groupId the primary key of the group
    * @return the matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score fetchScoreByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchScoreByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the score with the primary key.
    *
    * @param id the primary key of the score
    * @return the score
    * @throws PortalException if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score getScore(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getScore(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the score with the matching UUID and company.
    *
    * @param uuid the score's UUID
    * @param companyId the primary key of the company
    * @return the matching score
    * @throws PortalException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score getScoreByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getScoreByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the score matching the UUID and group.
    *
    * @param uuid the score's UUID
    * @param groupId the primary key of the group
    * @return the matching score
    * @throws PortalException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score getScoreByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getScoreByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the scores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @return the range of scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Score> getScores(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getScores(start, end);
    }

    /**
    * Returns the number of scores.
    *
    * @return the number of scores
    * @throws SystemException if a system exception occurred
    */
    public static int getScoresCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getScoresCount();
    }

    /**
    * Updates the score in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param score the score
    * @return the score that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Score updateScore(
        com.arman.csb.modules.model.Score score)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateScore(score);
    }

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

    public static void clearService() {
        _service = null;
    }

    public static ScoreLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ScoreLocalService.class.getName());

            if (invokableLocalService instanceof ScoreLocalService) {
                _service = (ScoreLocalService) invokableLocalService;
            } else {
                _service = new ScoreLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ScoreLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ScoreLocalService service) {
    }
}
