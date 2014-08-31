package com.arman.csb.theme.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContentHolderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContentHolderLocalService
 * @generated
 */
public class ContentHolderLocalServiceWrapper
    implements ContentHolderLocalService,
        ServiceWrapper<ContentHolderLocalService> {
    private ContentHolderLocalService _contentHolderLocalService;

    public ContentHolderLocalServiceWrapper(
        ContentHolderLocalService contentHolderLocalService) {
        _contentHolderLocalService = contentHolderLocalService;
    }

    /**
    * Adds the content holder to the database. Also notifies the appropriate model listeners.
    *
    * @param contentHolder the content holder
    * @return the content holder that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.theme.model.ContentHolder addContentHolder(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.addContentHolder(contentHolder);
    }

    /**
    * Creates a new content holder with the primary key. Does not add the content holder to the database.
    *
    * @param id the primary key for the new content holder
    * @return the new content holder
    */
    @Override
    public com.arman.csb.theme.model.ContentHolder createContentHolder(long id) {
        return _contentHolderLocalService.createContentHolder(id);
    }

    /**
    * Deletes the content holder with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the content holder
    * @return the content holder that was removed
    * @throws PortalException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.theme.model.ContentHolder deleteContentHolder(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.deleteContentHolder(id);
    }

    /**
    * Deletes the content holder from the database. Also notifies the appropriate model listeners.
    *
    * @param contentHolder the content holder
    * @return the content holder that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.theme.model.ContentHolder deleteContentHolder(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.deleteContentHolder(contentHolder);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _contentHolderLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arman.csb.theme.model.ContentHolder fetchContentHolder(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.fetchContentHolder(id);
    }

    /**
    * Returns the content holder with the matching UUID and company.
    *
    * @param uuid the content holder's UUID
    * @param companyId the primary key of the company
    * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.theme.model.ContentHolder fetchContentHolderByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.fetchContentHolderByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the content holder matching the UUID and group.
    *
    * @param uuid the content holder's UUID
    * @param groupId the primary key of the group
    * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.theme.model.ContentHolder fetchContentHolderByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.fetchContentHolderByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the content holder with the primary key.
    *
    * @param id the primary key of the content holder
    * @return the content holder
    * @throws PortalException if a content holder with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.theme.model.ContentHolder getContentHolder(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.getContentHolder(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public com.arman.csb.theme.model.ContentHolder getContentHolderByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.getContentHolderByUuidAndCompanyId(uuid,
            companyId);
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
    @Override
    public com.arman.csb.theme.model.ContentHolder getContentHolderByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.getContentHolderByUuidAndGroupId(uuid,
            groupId);
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
    @Override
    public java.util.List<com.arman.csb.theme.model.ContentHolder> getContentHolders(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.getContentHolders(start, end);
    }

    /**
    * Returns the number of content holders.
    *
    * @return the number of content holders
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getContentHoldersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.getContentHoldersCount();
    }

    /**
    * Updates the content holder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contentHolder the content holder
    * @return the content holder that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.theme.model.ContentHolder updateContentHolder(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.updateContentHolder(contentHolder);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _contentHolderLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _contentHolderLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _contentHolderLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<com.arman.csb.theme.model.ContentHolder> findByNameAndCompany(
        java.lang.String name, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolderLocalService.findByNameAndCompany(name, companyId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ContentHolderLocalService getWrappedContentHolderLocalService() {
        return _contentHolderLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedContentHolderLocalService(
        ContentHolderLocalService contentHolderLocalService) {
        _contentHolderLocalService = contentHolderLocalService;
    }

    @Override
    public ContentHolderLocalService getWrappedService() {
        return _contentHolderLocalService;
    }

    @Override
    public void setWrappedService(
        ContentHolderLocalService contentHolderLocalService) {
        _contentHolderLocalService = contentHolderLocalService;
    }
}
