package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for UserActivity. This utility wraps
 * {@link com.arman.csb.modules.service.impl.UserActivityServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserActivityService
 * @see com.arman.csb.modules.service.base.UserActivityServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.UserActivityServiceImpl
 * @generated
 */
public class UserActivityServiceUtil {
    private static UserActivityService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.UserActivityServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.portal.kernel.json.JSONObject search(
        java.lang.String text, java.lang.String entity,
        java.lang.String action, java.lang.String importance,
        java.util.Date fromDate, java.util.Date toDate, int start,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.json.JSONException {
        return getService()
                   .search(text, entity, action, importance, fromDate, toDate,
            start, maxResult, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static UserActivityService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    UserActivityService.class.getName());

            if (invokableService instanceof UserActivityService) {
                _service = (UserActivityService) invokableService;
            } else {
                _service = new UserActivityServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(UserActivityServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(UserActivityService service) {
    }
}
