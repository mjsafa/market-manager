package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyDDLRecordService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyDDLRecordService
 * @generated
 */
public class MyDDLRecordServiceWrapper implements MyDDLRecordService,
    ServiceWrapper<MyDDLRecordService> {
    private MyDDLRecordService _myDDLRecordService;

    public MyDDLRecordServiceWrapper(MyDDLRecordService myDDLRecordService) {
        _myDDLRecordService = myDDLRecordService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _myDDLRecordService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _myDDLRecordService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _myDDLRecordService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portlet.dynamicdatalists.model.DDLRecord addRecord(
        java.lang.String siteName, java.lang.String formName,
        java.util.Map<java.lang.String, java.io.Serializable> fieldsMap,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _myDDLRecordService.addRecord(siteName, formName, fieldsMap,
            serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MyDDLRecordService getWrappedMyDDLRecordService() {
        return _myDDLRecordService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMyDDLRecordService(
        MyDDLRecordService myDDLRecordService) {
        _myDDLRecordService = myDDLRecordService;
    }

    @Override
    public MyDDLRecordService getWrappedService() {
        return _myDDLRecordService;
    }

    @Override
    public void setWrappedService(MyDDLRecordService myDDLRecordService) {
        _myDDLRecordService = myDDLRecordService;
    }
}
