package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.UserActivity;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.service.base.UserActivityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;

/**
 * The implementation of the user activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.UserActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.UserActivityLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.UserActivityLocalServiceUtil
 */
public class UserActivityLocalServiceImpl
    extends UserActivityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.UserActivityLocalServiceUtil} to access the user activity local service.
     */

    public UserActivity addUserActivity(String entity, Short action, Short importance, String data, ServiceContext serviceContext) throws SystemException, PortalException, SystemException, PortalException {
        User onlineUser = UserLocalServiceUtil.getUser(serviceContext.getUserId());
        UserActivity activity = UserActivityLocalServiceUtil.createUserActivity(counterLocalService.increment(UserActivity.class.getName()));

        activity.setUserId(onlineUser.getUserId());
        activity.setUserName(onlineUser.getFullName());
        activity.setCompanyId(serviceContext.getCompanyId());
        activity.setGroupId(serviceContext.getScopeGroupId());
        activity.setCreateDate(new Date());
        activity.setEntity(entity);
        activity.setAction(action);
        activity.setImportance(importance);
        activity.setData(data);

        UserActivityLocalServiceUtil.addUserActivity(activity);

        return activity;
    }

}
