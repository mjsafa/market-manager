package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Product;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductPersistenceImpl
 * @see ProductUtil
 * @generated
 */
public interface ProductPersistence extends BasePersistence<Product> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ProductUtil} to access the product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the products where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the products where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @return the range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the products where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the products before and after the current product in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current product
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next product
    * @throws com.arman.csb.modules.NoSuchProductException if a product with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the products where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of products where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching products
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the product where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchProductException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the product where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the product that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of products where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching products
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the products where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the products where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @return the range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the products where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the products before and after the current product in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param id the primary key of the current product
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next product
    * @throws com.arman.csb.modules.NoSuchProductException if a product with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the products where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of products where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching products
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the products where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the products where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @return the range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the products where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the products before and after the current product in the ordered set where userId = &#63;.
    *
    * @param id the primary key of the current product
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next product
    * @throws com.arman.csb.modules.NoSuchProductException if a product with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product[] findByUserId_PrevAndNext(
        long id, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the products where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of products where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching products
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the products where name = &#63;.
    *
    * @param name the name
    * @return the matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the products where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @return the range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the products where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the products before and after the current product in the ordered set where name = &#63;.
    *
    * @param id the primary key of the current product
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next product
    * @throws com.arman.csb.modules.NoSuchProductException if a product with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product[] findByName_PrevAndNext(
        long id, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the products where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of products where name = &#63;.
    *
    * @param name the name
    * @return the number of matching products
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the products where code = &#63;.
    *
    * @param code the code
    * @return the matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByCode(
        java.lang.String code)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the products where code = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param code the code
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @return the range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByCode(
        java.lang.String code, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the products where code = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param code the code
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findByCode(
        java.lang.String code, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where code = &#63;.
    *
    * @param code the code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByCode_First(
        java.lang.String code,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first product in the ordered set where code = &#63;.
    *
    * @param code the code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByCode_First(
        java.lang.String code,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where code = &#63;.
    *
    * @param code the code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product
    * @throws com.arman.csb.modules.NoSuchProductException if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByCode_Last(
        java.lang.String code,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last product in the ordered set where code = &#63;.
    *
    * @param code the code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching product, or <code>null</code> if a matching product could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByCode_Last(
        java.lang.String code,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the products before and after the current product in the ordered set where code = &#63;.
    *
    * @param id the primary key of the current product
    * @param code the code
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next product
    * @throws com.arman.csb.modules.NoSuchProductException if a product with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product[] findByCode_PrevAndNext(
        long id, java.lang.String code,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the products where code = &#63; from the database.
    *
    * @param code the code
    * @throws SystemException if a system exception occurred
    */
    public void removeByCode(java.lang.String code)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of products where code = &#63;.
    *
    * @param code the code
    * @return the number of matching products
    * @throws SystemException if a system exception occurred
    */
    public int countByCode(java.lang.String code)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the product in the entity cache if it is enabled.
    *
    * @param product the product
    */
    public void cacheResult(com.arman.csb.modules.model.Product product);

    /**
    * Caches the products in the entity cache if it is enabled.
    *
    * @param products the products
    */
    public void cacheResult(
        java.util.List<com.arman.csb.modules.model.Product> products);

    /**
    * Creates a new product with the primary key. Does not add the product to the database.
    *
    * @param id the primary key for the new product
    * @return the new product
    */
    public com.arman.csb.modules.model.Product create(long id);

    /**
    * Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the product
    * @return the product that was removed
    * @throws com.arman.csb.modules.NoSuchProductException if a product with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product remove(long id)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arman.csb.modules.model.Product updateImpl(
        com.arman.csb.modules.model.Product product)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the product with the primary key or throws a {@link com.arman.csb.modules.NoSuchProductException} if it could not be found.
    *
    * @param id the primary key of the product
    * @return the product
    * @throws com.arman.csb.modules.NoSuchProductException if a product with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product findByPrimaryKey(long id)
        throws com.arman.csb.modules.NoSuchProductException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the product with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the product
    * @return the product, or <code>null</code> if a product with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Product fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the products.
    *
    * @return the products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the products.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @return the range of products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the products.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of products
    * @param end the upper bound of the range of products (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of products
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Product> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the products from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of products.
    *
    * @return the number of products
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
