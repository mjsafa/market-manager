package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for MyUser. This utility wraps
 * {@link com.arman.csb.modules.service.impl.MyUserServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MyUserService
 * @see com.arman.csb.modules.service.base.MyUserServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.MyUserServiceImpl
 * @generated
 */
public class MyUserServiceUtil {
    private static MyUserService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.MyUserServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.portal.kernel.json.JSONObject newUser(
        java.util.Map<java.lang.String, java.lang.Object> user,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().newUser(user, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray findActiveUsers(
        java.util.Map<java.lang.String, java.lang.Object> filter,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findActiveUsers(filter, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray findAnyUsers(
        java.util.Map<java.lang.String, java.lang.Object> filter,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findAnyUsers(filter, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONArray findUsers(
        java.util.Map<java.lang.String, java.lang.Object> filter, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findUsers(filter, status, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updateStatus(
        java.lang.Long userId, boolean isActive,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateStatus(userId, isActive, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getById(
        java.lang.Long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getById(userId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updateUser(
        java.util.Map<java.lang.String, java.lang.Object> userMap,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().updateUser(userMap, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject agreed(
        java.lang.Long userId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().agreed(userId, serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject updatePassword(
        java.lang.Long userId, java.lang.String oldPassword,
        java.lang.String password1, java.lang.String password2,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updatePassword(userId, oldPassword, password1, password2,
            serviceContext);
    }

    public static com.liferay.portal.kernel.json.JSONObject getPaymentActivityJSONObject(
        com.liferay.portal.model.User user) {
        return getService().getPaymentActivityJSONObject(user);
    }

    public static void clearService() {
        _service = null;
    }

    public static MyUserService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MyUserService.class.getName());

            if (invokableService instanceof MyUserService) {
                _service = (MyUserService) invokableService;
            } else {
                _service = new MyUserServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(MyUserServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MyUserService service) {
    }
}
