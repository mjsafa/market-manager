package com.arman.csb.modules.service.impl;

import com.arman.csb.constant.UserActivityConstant;
import com.arman.csb.modules.service.MyUserLocalServiceUtil;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.service.base.MyUserServiceBaseImpl;
import com.arman.csb.modules.util.RoleEnum;
import com.arman.csb.modules.util.RoleUtil;
import com.arman.csb.util.DateUtil;
import com.arman.csb.util.MapUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.*;
import com.liferay.portal.service.impl.UserLocalServiceImpl;
import com.liferay.util.portlet.PortletProps;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * The implementation of the my user remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.MyUserService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.MyUserServiceBaseImpl
 * @see com.arman.csb.modules.service.MyUserServiceUtil
 */
public class MyUserServiceImpl extends MyUserServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.MyUserServiceUtil} to access the my user remote service.
     */


    public JSONObject newUser(Map<String, Object> user, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.USER_MANAGER.toString());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        //prepare an array of role ids
        List<Long> roles = new ArrayList<Long>();
        if (null != user.get("roles")) {
            Map<String, Boolean> selectedRoles = (Map<String, Boolean>) user.get("roles");
            for (String role : selectedRoles.keySet()) {
                if (selectedRoles.get(role)) {
                    roles.add(RoleServiceUtil.getRole(serviceContext.getCompanyId(), role).getRoleId());
                }
            }
        }

        //adding Custom Fields
        Map<String, Serializable> expandoAttributes = new HashMap<String, Serializable>();
        expandoAttributes.put("mobile", (String) user.get("mobile"));
        serviceContext.setExpandoBridgeAttributes(expandoAttributes);

        String screenName = ((String) user.get("email")).replace("@", "-");

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        UserGroup operatorGroup = UserGroupLocalServiceUtil.fetchUserGroup(serviceContext.getCompanyId(), PortletProps.get("market-manager.userGroup.operator"));

        //save user with liferay user service
        User savedUser = UserLocalServiceUtil.addUser(serviceContext.getUserId(), serviceContext.getCompanyId(),
                false, (String) user.get("password1"), (String) user.get("password2"), false,
                screenName, (String) user.get("email"), 0L, null, Locale.US, (String) user.get("firstName"), (String) user.get("mobile"), (String) user.get("lastName"),
                0, 0, true, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.YEAR), (String) user.get("jobTitle"), new long[0], new long[0], ArrayUtil.toLongArray(roles),
                new long[]{operatorGroup.getUserGroupId()}, true, serviceContext);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_USER, UserActivityConstant.ACTION_ADD,
                UserActivityConstant.IMPORTANCE_HIGH, getPaymentActivityJSONObject(savedUser).toString(), serviceContext);

        result.put("userId", savedUser.getUserId());
        return result;
    }


    public JSONArray findUsers(Map<String, Object> filter, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.USER_MANAGER.toString());
        UserGroup operatorGroup = UserGroupLocalServiceUtil.fetchUserGroup(serviceContext.getCompanyId(), PortletProps.get("market-manager.userGroup.operator"));

        LinkedHashMap<String, Object> params = new LinkedHashMap<String, java.lang.Object>();
        params.put("usersUserGroups", operatorGroup.getUserGroupId());
        List<User> users = UserLocalServiceUtil.search(serviceContext.getCompanyId(), (String) filter.get("query"), WorkflowConstants.STATUS_ANY, params, 0, 20, (OrderByComparator) null);

        //put users inside JSON Array
        JSONArray result = JSONFactoryUtil.createJSONArray();
        for (User user : users) {
            JSONObject userJsonObject = JSONFactoryUtil.createJSONObject();
            userJsonObject.put("firstName", user.getFirstName());
            userJsonObject.put("lastName", user.getLastName());
            userJsonObject.put("email", user.getEmailAddress());
            userJsonObject.put("id", user.getUserId());
            userJsonObject.put("mobile", user.getMiddleName());

            if (user.getStatus() == WorkflowConstants.STATUS_APPROVED) {
                userJsonObject.put("isActive", true);
            } else {
                userJsonObject.put("isActive", false);
            }
            result.put(userJsonObject);
        }

        return result;
    }

    public JSONObject updateStatus(Long userId, boolean isActive, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.USER_MANAGER.toString());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        if (isActive) {
            UserLocalServiceUtil.updateStatus(userId, WorkflowConstants.STATUS_APPROVED);
        } else {
            UserLocalServiceUtil.updateStatus(userId, WorkflowConstants.STATUS_INACTIVE);
        }

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_USER, UserActivityConstant.ACTION_CHANGE_STATUS,
                UserActivityConstant.IMPORTANCE_HIGH, getPaymentActivityJSONObject(UserLocalServiceUtil.fetchUser(userId)).toString(), serviceContext);
        return result;
    }


    public JSONObject getById(Long userId, ServiceContext serviceContext) throws PortalException, SystemException {
        if (userId != serviceContext.getUserId()) {
            RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.USER_MANAGER.toString());
        }

        JSONObject userJsonObject = JSONFactoryUtil.createJSONObject();
        User user = UserLocalServiceUtil.getUserById(userId);
        userJsonObject.put("firstName", user.getFirstName());
        userJsonObject.put("lastName", user.getLastName());
        userJsonObject.put("email", user.getEmailAddress());
        userJsonObject.put("id", user.getUserId());
        userJsonObject.put("mobile", user.getMiddleName());

        //load userRoles that are present in RoleEnum
        JSONArray roles = JSONFactoryUtil.createJSONArray();
        List<Role> userRoles = RoleLocalServiceUtil.getRoles(user.getRoleIds());
        for (Role userRole : userRoles) {
            try {
                if (null != RoleEnum.valueOf(userRole.getName())) {
                    roles.put(userRole.getName());
                }
            } catch (Exception e) {}
        }
        userJsonObject.put("roles", roles);

        return userJsonObject;
    }

    public JSONObject updateUser(Map<String, Object> userMap, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.USER_MANAGER.toString());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        long userId = MapUtil.getLong(userMap, "id");
        User user = UserLocalServiceUtil.fetchUser(userId);

        MyUserLocalServiceUtil.updateUserRoles(userId, (List<String>) userMap.get("roles"), serviceContext);

        if (!StringUtils.isEmpty(MapUtil.getString(userMap, "firstName"))) {
            user.setFirstName(MapUtil.getString(userMap, "firstName"));
        }
        if (!StringUtils.isEmpty(MapUtil.getString(userMap, "lastName"))) {
            user.setLastName(MapUtil.getString(userMap, "lastName"));
        }

        if (!StringUtils.isEmpty(MapUtil.getString(userMap, "mobile"))) {
            user.getExpandoBridge().setAttribute("mobile", MapUtil.getString(userMap, "mobile"));
            user.setMiddleName( MapUtil.getString(userMap, "mobile"));
        }

        user.setModifiedDate(new Date());
        userPersistence.update(user);

        result.put("name", user.getFirstName() + " " + user.getLastName());
        result.put("id", user.getUserId());
        result.put("date", new Date().getTime());

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_USER, UserActivityConstant.ACTION_EDIT,
                UserActivityConstant.IMPORTANCE_MEDIUM, result.toString(), serviceContext);

        return result;
    }

    public JSONObject agreed(Long userId, ServiceContext serviceContext) throws PortalException, SystemException {
        if (serviceContext.getUserId() != userId) {
            throw new PrincipalException();
        }

        RoleUtil.hasAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();
        UserLocalServiceUtil.updateAgreedToTermsOfUse(userId, true);
        return result;
    }


    public JSONObject updatePassword(Long userId, String oldPassword, String password1, String password2, ServiceContext serviceContext) throws PortalException, SystemException {
        if (serviceContext.getUserId() != userId) {
            RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.USER_MANAGER.toString());
        }

        User user = UserLocalServiceUtil.fetchUser(userId);
        long authUserId = UserLocalServiceUtil.authenticateForBasic(serviceContext.getCompanyId(), "emailAddress", user.getEmailAddress(), oldPassword);
        if (authUserId != userId) {
            throw new PortalException("wrong-current-password");
        }

        UserLocalServiceUtil.updatePassword(userId, password1, password2, false);

        JSONObject result = JSONFactoryUtil.createJSONObject();
        result.put("userId", userId);
        return result;
    }


    public JSONObject getPaymentActivityJSONObject(User user) {
        JSONObject userJson = JSONFactoryUtil.createJSONObject();
        userJson.put("firstName", user.getFirstName());
        userJson.put("lastName", user.getLastName());
        userJson.put("id", user.getUserId());
        userJson.put("isActive", user.getStatus() == WorkflowConstants.STATUS_APPROVED ? true : false);
        userJson.put("createDate", DateUtil.getString(user.getCreateDate()));
        return userJson;
    }


}
