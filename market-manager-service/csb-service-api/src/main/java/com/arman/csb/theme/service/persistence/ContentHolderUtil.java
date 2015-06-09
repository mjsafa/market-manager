package com.arman.csb.theme.service.persistence;

import com.arman.csb.theme.model.ContentHolder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the content holder service. This utility wraps {@link ContentHolderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContentHolderPersistence
 * @see ContentHolderPersistenceImpl
 * @generated
 */
public class ContentHolderUtil {
    private static ContentHolderPersistence _persistence;

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
    public static void clearCache(ContentHolder contentHolder) {
        getPersistence().clearCache(contentHolder);
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
    public static List<ContentHolder> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ContentHolder> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ContentHolder> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ContentHolder update(ContentHolder contentHolder)
        throws SystemException {
        return getPersistence().update(contentHolder);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ContentHolder update(ContentHolder contentHolder,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(contentHolder, serviceContext);
    }

    /**
    * Returns all the content holders where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the content holders where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of content holders
    * @param end the upper bound of the range of content holders (not inclusive)
    * @return the range of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the content holders where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of content holders
    * @param end the upper bound of the range of content holders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first content holder in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first content holder in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last content holder in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last content holder in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the content holders before and after the current content holder in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current content holder
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
    }

    /**
    * Removes all the content holders where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of content holders where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the content holder where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.theme.NoSuchContentHolderException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the content holder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the content holder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the content holder where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the content holder that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of content holders where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the content holders where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the content holders where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of content holders
    * @param end the upper bound of the range of content holders (not inclusive)
    * @return the range of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the content holders where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of content holders
    * @param end the upper bound of the range of content holders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first content holder in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first content holder in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last content holder in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last content holder in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the content holders before and after the current content holder in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param id the primary key of the current content holder
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(id, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the content holders where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of content holders where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the content holders where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByCompanyIdAndName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyIdAndName(companyId, name);
    }

    /**
    * Returns a range of all the content holders where companyId = &#63; and name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param name the name
    * @param start the lower bound of the range of content holders
    * @param end the upper bound of the range of content holders (not inclusive)
    * @return the range of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByCompanyIdAndName(
        long companyId, java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndName(companyId, name, start, end);
    }

    /**
    * Returns an ordered range of all the content holders where companyId = &#63; and name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param name the name
    * @param start the lower bound of the range of content holders
    * @param end the upper bound of the range of content holders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByCompanyIdAndName(
        long companyId, java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndName(companyId, name, start, end,
            orderByComparator);
    }

    /**
    * Returns the first content holder in the ordered set where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder findByCompanyIdAndName_First(
        long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndName_First(companyId, name,
            orderByComparator);
    }

    /**
    * Returns the first content holder in the ordered set where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByCompanyIdAndName_First(
        long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyIdAndName_First(companyId, name,
            orderByComparator);
    }

    /**
    * Returns the last content holder in the ordered set where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder findByCompanyIdAndName_Last(
        long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndName_Last(companyId, name,
            orderByComparator);
    }

    /**
    * Returns the last content holder in the ordered set where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByCompanyIdAndName_Last(
        long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyIdAndName_Last(companyId, name,
            orderByComparator);
    }

    /**
    * Returns the content holders before and after the current content holder in the ordered set where companyId = &#63; and name = &#63;.
    *
    * @param id the primary key of the current content holder
    * @param companyId the company ID
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder[] findByCompanyIdAndName_PrevAndNext(
        long id, long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyIdAndName_PrevAndNext(id, companyId, name,
            orderByComparator);
    }

    /**
    * Removes all the content holders where companyId = &#63; and name = &#63; from the database.
    *
    * @param companyId the company ID
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyIdAndName(long companyId,
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyIdAndName(companyId, name);
    }

    /**
    * Returns the number of content holders where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the number of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyIdAndName(long companyId,
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyIdAndName(companyId, name);
    }

    /**
    * Caches the content holder in the entity cache if it is enabled.
    *
    * @param contentHolder the content holder
    */
    public static void cacheResult(
        com.arman.csb.theme.model.ContentHolder contentHolder) {
        getPersistence().cacheResult(contentHolder);
    }

    /**
    * Caches the content holders in the entity cache if it is enabled.
    *
    * @param contentHolders the content holders
    */
    public static void cacheResult(
        java.util.List<com.arman.csb.theme.model.ContentHolder> contentHolders) {
        getPersistence().cacheResult(contentHolders);
    }

    /**
    * Creates a new content holder with the primary key. Does not add the content holder to the database.
    *
    * @param id the primary key for the new content holder
    * @return the new content holder
    */
    public static com.arman.csb.theme.model.ContentHolder create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the content holder with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the content holder
    * @return the content holder that was removed
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder remove(long id)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arman.csb.theme.model.ContentHolder updateImpl(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(contentHolder);
    }

    /**
    * Returns the content holder with the primary key or throws a {@link com.arman.csb.theme.NoSuchContentHolderException} if it could not be found.
    *
    * @param id the primary key of the content holder
    * @return the content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder findByPrimaryKey(
        long id)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the content holder with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the content holder
    * @return the content holder, or <code>null</code> if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the content holders.
    *
    * @return the content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the content holders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of content holders
    * @param end the upper bound of the range of content holders (not inclusive)
    * @return the range of content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the content holders.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of content holders
    * @param end the upper bound of the range of content holders (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of content holders
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the content holders from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of content holders.
    *
    * @return the number of content holders
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ContentHolderPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ContentHolderPersistence) PortletBeanLocatorUtil.locate(com.arman.csb.theme.service.ClpSerializer.getServletContextName(),
                    ContentHolderPersistence.class.getName());

            ReferenceRegistry.registerReference(ContentHolderUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ContentHolderPersistence persistence) {
    }
}
