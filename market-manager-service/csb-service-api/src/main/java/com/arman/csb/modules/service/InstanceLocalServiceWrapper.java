package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InstanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InstanceLocalService
 * @generated
 */
public class InstanceLocalServiceWrapper implements InstanceLocalService,
    ServiceWrapper<InstanceLocalService> {
    private InstanceLocalService _instanceLocalService;

    public InstanceLocalServiceWrapper(
        InstanceLocalService instanceLocalService) {
        _instanceLocalService = instanceLocalService;
    }

    /**
    * Adds the instance to the database. Also notifies the appropriate model listeners.
    *
    * @param instance the instance
    * @return the instance that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance addInstance(
        com.arman.csb.modules.model.Instance instance)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.addInstance(instance);
    }

    /**
    * Creates a new instance with the primary key. Does not add the instance to the database.
    *
    * @param id the primary key for the new instance
    * @return the new instance
    */
    @Override
    public com.arman.csb.modules.model.Instance createInstance(long id) {
        return _instanceLocalService.createInstance(id);
    }

    /**
    * Deletes the instance with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the instance
    * @return the instance that was removed
    * @throws PortalException if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance deleteInstance(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.deleteInstance(id);
    }

    /**
    * Deletes the instance from the database. Also notifies the appropriate model listeners.
    *
    * @param instance the instance
    * @return the instance that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance deleteInstance(
        com.arman.csb.modules.model.Instance instance)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.deleteInstance(instance);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _instanceLocalService.dynamicQuery();
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
        return _instanceLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _instanceLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _instanceLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _instanceLocalService.dynamicQueryCount(dynamicQuery);
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
        return _instanceLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.arman.csb.modules.model.Instance fetchInstance(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.fetchInstance(id);
    }

    /**
    * Returns the instance with the matching UUID and company.
    *
    * @param uuid the instance's UUID
    * @param companyId the primary key of the company
    * @return the matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance fetchInstanceByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.fetchInstanceByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the instance matching the UUID and group.
    *
    * @param uuid the instance's UUID
    * @param groupId the primary key of the group
    * @return the matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance fetchInstanceByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.fetchInstanceByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the instance with the primary key.
    *
    * @param id the primary key of the instance
    * @return the instance
    * @throws PortalException if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance getInstance(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.getInstance(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the instance with the matching UUID and company.
    *
    * @param uuid the instance's UUID
    * @param companyId the primary key of the company
    * @return the matching instance
    * @throws PortalException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance getInstanceByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.getInstanceByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the instance matching the UUID and group.
    *
    * @param uuid the instance's UUID
    * @param groupId the primary key of the group
    * @return the matching instance
    * @throws PortalException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance getInstanceByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.getInstanceByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the instances.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @return the range of instances
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arman.csb.modules.model.Instance> getInstances(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.getInstances(start, end);
    }

    /**
    * Returns the number of instances.
    *
    * @return the number of instances
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getInstancesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.getInstancesCount();
    }

    /**
    * Updates the instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param instance the instance
    * @return the instance that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Instance updateInstance(
        com.arman.csb.modules.model.Instance instance)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instanceLocalService.updateInstance(instance);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _instanceLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _instanceLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _instanceLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public InstanceLocalService getWrappedInstanceLocalService() {
        return _instanceLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedInstanceLocalService(
        InstanceLocalService instanceLocalService) {
        _instanceLocalService = instanceLocalService;
    }

    @Override
    public InstanceLocalService getWrappedService() {
        return _instanceLocalService;
    }

    @Override
    public void setWrappedService(InstanceLocalService instanceLocalService) {
        _instanceLocalService = instanceLocalService;
    }
}
