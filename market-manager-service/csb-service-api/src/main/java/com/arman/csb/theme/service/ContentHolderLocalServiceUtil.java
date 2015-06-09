package com.arman.csb.theme.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ContentHolder. This utility wraps
 * {@link com.arman.csb.theme.service.impl.ContentHolderLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContentHolderLocalService
 * @see com.arman.csb.theme.service.base.ContentHolderLocalServiceBaseImpl
 * @see com.arman.csb.theme.service.impl.ContentHolderLocalServiceImpl
 * @generated
 */
public class ContentHolderLocalServiceUtil {
    private static ContentHolderLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.theme.service.impl.ContentHolderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the content holder to the database. Also notifies the appropriate model listeners.
    *
    * @param contentHolder the content holder
    * @return the content holder that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder addContentHolder(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addContentHolder(contentHolder);
    }

    /**
    * Creates a new content holder with the primary key. Does not add the content holder to the database.
    *
    * @param id the primary key for the new content holder
    * @return the new content holder
    */
    public static com.arman.csb.theme.model.ContentHolder createContentHolder(
        long id) {
        return getService().createContentHolder(id);
    }

    /**
    * Deletes the content holder with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the content holder
    * @return the content holder that was removed
    * @throws PortalException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder deleteContentHolder(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContentHolder(id);
    }

    /**
    * Deletes the content holder from the database. Also notifies the appropriate model listeners.
    *
    * @param contentHolder the content holder
    * @return the content holder that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder deleteContentHolder(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContentHolder(contentHolder);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arman.csb.theme.model.ContentHolder fetchContentHolder(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchContentHolder(id);
    }

    /**
    * Returns the content holder with the matching UUID and company.
    *
    * @param uuid the content holder's UUID
    * @param companyId the primary key of the company
    * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchContentHolderByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchContentHolderByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the content holder matching the UUID and group.
    *
    * @param uuid the content holder's UUID
    * @param groupId the primary key of the group
    * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder fetchContentHolderByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchContentHolderByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the content holder with the primary key.
    *
    * @param id the primary key of the content holder
    * @return the content holder
    * @throws PortalException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder getContentHolder(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContentHolder(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the content holder with the matching UUID and company.
    *
    * @param uuid the content holder's UUID
    * @param companyId the primary key of the company
    * @return the matching content holder
    * @throws PortalException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder getContentHolderByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContentHolderByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the content holder matching the UUID and group.
    *
    * @param uuid the content holder's UUID
    * @param groupId the primary key of the group
    * @return the matching content holder
    * @throws PortalException if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder getContentHolderByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContentHolderByUuidAndGroupId(uuid, groupId);
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
    public static java.util.List<com.arman.csb.theme.model.ContentHolder> getContentHolders(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContentHolders(start, end);
    }

    /**
    * Returns the number of content holders.
    *
    * @return the number of content holders
    * @throws SystemException if a system exception occurred
    */
    public static int getContentHoldersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContentHoldersCount();
    }

    /**
    * Updates the content holder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contentHolder the content holder
    * @return the content holder that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.theme.model.ContentHolder updateContentHolder(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateContentHolder(contentHolder);
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

    public static java.util.List<com.arman.csb.theme.model.ContentHolder> findByNameAndCompany(
        java.lang.String name, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByNameAndCompany(name, companyId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ContentHolderLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ContentHolderLocalService.class.getName());

            if (invokableLocalService instanceof ContentHolderLocalService) {
                _service = (ContentHolderLocalService) invokableLocalService;
            } else {
                _service = new ContentHolderLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ContentHolderLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ContentHolderLocalService service) {
    }
}
