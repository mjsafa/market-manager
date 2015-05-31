package com.arman.csb.theme.service.persistence;

import com.arman.csb.theme.model.ContentHolder;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the content holder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContentHolderPersistenceImpl
 * @see ContentHolderUtil
 * @generated
 */
public interface ContentHolderPersistence extends BasePersistence<ContentHolder> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContentHolderUtil} to access the content holder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the content holders where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching content holders
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first content holder in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first content holder in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last content holder in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last content holder in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.theme.model.ContentHolder[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the content holders where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of content holders where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the content holder where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.theme.NoSuchContentHolderException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the content holder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the content holder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the content holder where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the content holder that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of content holders where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the content holders where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching content holders
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.theme.model.ContentHolder findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first content holder in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.theme.model.ContentHolder findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last content holder in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.theme.model.ContentHolder[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the content holders where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of content holders where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the content holders where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the matching content holders
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByCompanyIdAndName(
        long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByCompanyIdAndName(
        long companyId, java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByCompanyIdAndName(
        long companyId, java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.theme.model.ContentHolder findByCompanyIdAndName_First(
        long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first content holder in the ordered set where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByCompanyIdAndName_First(
        long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.theme.model.ContentHolder findByCompanyIdAndName_Last(
        long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last content holder in the ordered set where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByCompanyIdAndName_Last(
        long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.theme.model.ContentHolder[] findByCompanyIdAndName_PrevAndNext(
        long id, long companyId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the content holders where companyId = &#63; and name = &#63; from the database.
    *
    * @param companyId the company ID
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyIdAndName(long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of content holders where companyId = &#63; and name = &#63;.
    *
    * @param companyId the company ID
    * @param name the name
    * @return the number of matching content holders
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyIdAndName(long companyId, java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the content holder in the entity cache if it is enabled.
    *
    * @param contentHolder the content holder
    */
    public void cacheResult(
        com.arman.csb.theme.model.ContentHolder contentHolder);

    /**
    * Caches the content holders in the entity cache if it is enabled.
    *
    * @param contentHolders the content holders
    */
    public void cacheResult(
        java.util.List<com.arman.csb.theme.model.ContentHolder> contentHolders);

    /**
    * Creates a new content holder with the primary key. Does not add the content holder to the database.
    *
    * @param id the primary key for the new content holder
    * @return the new content holder
    */
    public com.arman.csb.theme.model.ContentHolder create(long id);

    /**
    * Removes the content holder with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the content holder
    * @return the content holder that was removed
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder remove(long id)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arman.csb.theme.model.ContentHolder updateImpl(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the content holder with the primary key or throws a {@link com.arman.csb.theme.NoSuchContentHolderException} if it could not be found.
    *
    * @param id the primary key of the content holder
    * @return the content holder
    * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder findByPrimaryKey(long id)
        throws com.arman.csb.theme.NoSuchContentHolderException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the content holder with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the content holder
    * @return the content holder, or <code>null</code> if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.theme.model.ContentHolder fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the content holders.
    *
    * @return the content holders
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the content holders from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of content holders.
    *
    * @return the number of content holders
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
