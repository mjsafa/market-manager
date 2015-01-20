package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.UserActivity;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user activity service. This utility wraps {@link UserActivityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserActivityPersistence
 * @see UserActivityPersistenceImpl
 * @generated
 */
public class UserActivityUtil {
    private static UserActivityPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(UserActivity userActivity) {
        getPersistence().clearCache(userActivity);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<UserActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<UserActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<UserActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static UserActivity update(UserActivity userActivity)
        throws SystemException {
        return getPersistence().update(userActivity);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static UserActivity update(UserActivity userActivity,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(userActivity, serviceContext);
    }

    /**
    * Returns all the user activities where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the user activities where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @return the range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the user activities where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the user activities before and after the current user activity in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current user activity
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
    }

    /**
    * Removes all the user activities where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of user activities where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the user activity where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchUserActivityException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the user activity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the user activity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the user activity where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the user activity that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of user activities where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the user activities where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the user activities where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @return the range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the user activities where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the user activities before and after the current user activity in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param id the primary key of the current user activity
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(id, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the user activities where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of user activities where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the user activities where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the user activities where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @return the range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the user activities where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the user activities before and after the current user activity in the ordered set where userId = &#63;.
    *
    * @param id the primary key of the current user activity
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity[] findByUserId_PrevAndNext(
        long id, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId_PrevAndNext(id, userId, orderByComparator);
    }

    /**
    * Removes all the user activities where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of user activities where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns all the user activities where entity = &#63;.
    *
    * @param entity the entity
    * @return the matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByEntity(
        java.lang.String entity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEntity(entity);
    }

    /**
    * Returns a range of all the user activities where entity = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entity the entity
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @return the range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByEntity(
        java.lang.String entity, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEntity(entity, start, end);
    }

    /**
    * Returns an ordered range of all the user activities where entity = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param entity the entity
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByEntity(
        java.lang.String entity, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEntity(entity, start, end, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where entity = &#63;.
    *
    * @param entity the entity
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByEntity_First(
        java.lang.String entity,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEntity_First(entity, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where entity = &#63;.
    *
    * @param entity the entity
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByEntity_First(
        java.lang.String entity,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEntity_First(entity, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where entity = &#63;.
    *
    * @param entity the entity
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByEntity_Last(
        java.lang.String entity,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEntity_Last(entity, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where entity = &#63;.
    *
    * @param entity the entity
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByEntity_Last(
        java.lang.String entity,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEntity_Last(entity, orderByComparator);
    }

    /**
    * Returns the user activities before and after the current user activity in the ordered set where entity = &#63;.
    *
    * @param id the primary key of the current user activity
    * @param entity the entity
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity[] findByEntity_PrevAndNext(
        long id, java.lang.String entity,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEntity_PrevAndNext(id, entity, orderByComparator);
    }

    /**
    * Removes all the user activities where entity = &#63; from the database.
    *
    * @param entity the entity
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEntity(java.lang.String entity)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEntity(entity);
    }

    /**
    * Returns the number of user activities where entity = &#63;.
    *
    * @param entity the entity
    * @return the number of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByEntity(java.lang.String entity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEntity(entity);
    }

    /**
    * Returns all the user activities where action = &#63;.
    *
    * @param action the action
    * @return the matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByAction(
        java.lang.Short action)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAction(action);
    }

    /**
    * Returns a range of all the user activities where action = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param action the action
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @return the range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByAction(
        java.lang.Short action, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAction(action, start, end);
    }

    /**
    * Returns an ordered range of all the user activities where action = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param action the action
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findByAction(
        java.lang.Short action, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAction(action, start, end, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where action = &#63;.
    *
    * @param action the action
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByAction_First(
        java.lang.Short action,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAction_First(action, orderByComparator);
    }

    /**
    * Returns the first user activity in the ordered set where action = &#63;.
    *
    * @param action the action
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByAction_First(
        java.lang.Short action,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAction_First(action, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where action = &#63;.
    *
    * @param action the action
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByAction_Last(
        java.lang.Short action,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAction_Last(action, orderByComparator);
    }

    /**
    * Returns the last user activity in the ordered set where action = &#63;.
    *
    * @param action the action
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByAction_Last(
        java.lang.Short action,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAction_Last(action, orderByComparator);
    }

    /**
    * Returns the user activities before and after the current user activity in the ordered set where action = &#63;.
    *
    * @param id the primary key of the current user activity
    * @param action the action
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity[] findByAction_PrevAndNext(
        long id, java.lang.Short action,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAction_PrevAndNext(id, action, orderByComparator);
    }

    /**
    * Removes all the user activities where action = &#63; from the database.
    *
    * @param action the action
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAction(java.lang.Short action)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAction(action);
    }

    /**
    * Returns the number of user activities where action = &#63;.
    *
    * @param action the action
    * @return the number of matching user activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByAction(java.lang.Short action)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAction(action);
    }

    /**
    * Caches the user activity in the entity cache if it is enabled.
    *
    * @param userActivity the user activity
    */
    public static void cacheResult(
        com.arman.csb.modules.model.UserActivity userActivity) {
        getPersistence().cacheResult(userActivity);
    }

    /**
    * Caches the user activities in the entity cache if it is enabled.
    *
    * @param userActivities the user activities
    */
    public static void cacheResult(
        java.util.List<com.arman.csb.modules.model.UserActivity> userActivities) {
        getPersistence().cacheResult(userActivities);
    }

    /**
    * Creates a new user activity with the primary key. Does not add the user activity to the database.
    *
    * @param id the primary key for the new user activity
    * @return the new user activity
    */
    public static com.arman.csb.modules.model.UserActivity create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the user activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the user activity
    * @return the user activity that was removed
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity remove(long id)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arman.csb.modules.model.UserActivity updateImpl(
        com.arman.csb.modules.model.UserActivity userActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(userActivity);
    }

    /**
    * Returns the user activity with the primary key or throws a {@link com.arman.csb.modules.NoSuchUserActivityException} if it could not be found.
    *
    * @param id the primary key of the user activity
    * @return the user activity
    * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity findByPrimaryKey(
        long id)
        throws com.arman.csb.modules.NoSuchUserActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the user activity with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the user activity
    * @return the user activity, or <code>null</code> if a user activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.UserActivity fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the user activities.
    *
    * @return the user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the user activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @return the range of user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the user activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of user activities
    * @param end the upper bound of the range of user activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of user activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.UserActivity> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the user activities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of user activities.
    *
    * @return the number of user activities
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static UserActivityPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (UserActivityPersistence) PortletBeanLocatorUtil.locate(com.arman.csb.modules.service.ClpSerializer.getServletContextName(),
                    UserActivityPersistence.class.getName());

            ReferenceRegistry.registerReference(UserActivityUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(UserActivityPersistence persistence) {
    }
}
