package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Score;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the score service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePersistenceImpl
 * @see ScoreUtil
 * @generated
 */
public interface ScorePersistence extends BasePersistence<Score> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ScoreUtil} to access the score persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the scores where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the scores where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @return the range of matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the scores where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first score in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first score in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last score in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last score in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the scores before and after the current score in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current score
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next score
    * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score[] findByUuid_PrevAndNext(long id,
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the scores where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of scores where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching scores
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the score where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchScoreException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the score where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the score where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the score where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the score that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of scores where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching scores
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the scores where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the scores where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @return the range of matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the scores where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first score in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first score in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last score in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last score in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the scores before and after the current score in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param id the primary key of the current score
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next score
    * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the scores where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of scores where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching scores
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the scores where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @return the matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByCustomerId(
        long customerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the scores where customerId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param customerId the customer ID
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @return the range of matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByCustomerId(
        long customerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the scores where customerId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param customerId the customer ID
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByCustomerId(
        long customerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first score in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByCustomerId_First(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first score in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByCustomerId_First(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last score in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByCustomerId_Last(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last score in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByCustomerId_Last(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the scores before and after the current score in the ordered set where customerId = &#63;.
    *
    * @param id the primary key of the current score
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next score
    * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score[] findByCustomerId_PrevAndNext(
        long id, long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the scores where customerId = &#63; from the database.
    *
    * @param customerId the customer ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCustomerId(long customerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of scores where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @return the number of matching scores
    * @throws SystemException if a system exception occurred
    */
    public int countByCustomerId(long customerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the scores where customerId = &#63; and type = &#63;.
    *
    * @param customerId the customer ID
    * @param type the type
    * @return the matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByCustomerIdAndType(
        long customerId, int type)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the scores where customerId = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param customerId the customer ID
    * @param type the type
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @return the range of matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByCustomerIdAndType(
        long customerId, int type, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the scores where customerId = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param customerId the customer ID
    * @param type the type
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findByCustomerIdAndType(
        long customerId, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first score in the ordered set where customerId = &#63; and type = &#63;.
    *
    * @param customerId the customer ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByCustomerIdAndType_First(
        long customerId, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first score in the ordered set where customerId = &#63; and type = &#63;.
    *
    * @param customerId the customer ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByCustomerIdAndType_First(
        long customerId, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last score in the ordered set where customerId = &#63; and type = &#63;.
    *
    * @param customerId the customer ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching score
    * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByCustomerIdAndType_Last(
        long customerId, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last score in the ordered set where customerId = &#63; and type = &#63;.
    *
    * @param customerId the customer ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching score, or <code>null</code> if a matching score could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByCustomerIdAndType_Last(
        long customerId, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the scores before and after the current score in the ordered set where customerId = &#63; and type = &#63;.
    *
    * @param id the primary key of the current score
    * @param customerId the customer ID
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next score
    * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score[] findByCustomerIdAndType_PrevAndNext(
        long id, long customerId, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the scores where customerId = &#63; and type = &#63; from the database.
    *
    * @param customerId the customer ID
    * @param type the type
    * @throws SystemException if a system exception occurred
    */
    public void removeByCustomerIdAndType(long customerId, int type)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of scores where customerId = &#63; and type = &#63;.
    *
    * @param customerId the customer ID
    * @param type the type
    * @return the number of matching scores
    * @throws SystemException if a system exception occurred
    */
    public int countByCustomerIdAndType(long customerId, int type)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the score in the entity cache if it is enabled.
    *
    * @param score the score
    */
    public void cacheResult(com.arman.csb.modules.model.Score score);

    /**
    * Caches the scores in the entity cache if it is enabled.
    *
    * @param scores the scores
    */
    public void cacheResult(
        java.util.List<com.arman.csb.modules.model.Score> scores);

    /**
    * Creates a new score with the primary key. Does not add the score to the database.
    *
    * @param id the primary key for the new score
    * @return the new score
    */
    public com.arman.csb.modules.model.Score create(long id);

    /**
    * Removes the score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the score
    * @return the score that was removed
    * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score remove(long id)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arman.csb.modules.model.Score updateImpl(
        com.arman.csb.modules.model.Score score)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the score with the primary key or throws a {@link com.arman.csb.modules.NoSuchScoreException} if it could not be found.
    *
    * @param id the primary key of the score
    * @return the score
    * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score findByPrimaryKey(long id)
        throws com.arman.csb.modules.NoSuchScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the score with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the score
    * @return the score, or <code>null</code> if a score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Score fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the scores.
    *
    * @return the scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Score> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the scores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of scores
    * @param end the upper bound of the range of scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Score> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the scores from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of scores.
    *
    * @return the number of scores
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
