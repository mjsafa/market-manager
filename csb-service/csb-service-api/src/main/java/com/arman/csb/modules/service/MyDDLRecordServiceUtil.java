package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for MyDDLRecord. This utility wraps
 * {@link com.arman.csb.modules.service.impl.MyDDLRecordServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MyDDLRecordService
 * @see com.arman.csb.modules.service.base.MyDDLRecordServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.MyDDLRecordServiceImpl
 * @generated
 */
public class MyDDLRecordServiceUtil {
    private static MyDDLRecordService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.MyDDLRecordServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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

    public static com.liferay.portlet.dynamicdatalists.model.DDLRecord addRecord(
        java.lang.String siteName, java.lang.String formName,
        java.util.Map<java.lang.String, java.io.Serializable> fieldsMap,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addRecord(siteName, formName, fieldsMap, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static MyDDLRecordService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MyDDLRecordService.class.getName());

            if (invokableService instanceof MyDDLRecordService) {
                _service = (MyDDLRecordService) invokableService;
            } else {
                _service = new MyDDLRecordServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(MyDDLRecordServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MyDDLRecordService service) {
    }
}
