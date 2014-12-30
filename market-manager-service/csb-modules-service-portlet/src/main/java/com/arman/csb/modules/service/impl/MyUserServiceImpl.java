package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.service.base.MyUserServiceBaseImpl;
import com.arman.csb.modules.util.RoleEnum;
import com.arman.csb.modules.util.RoleUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactory;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.*;
import com.liferay.util.portlet.PortletProps;

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
        RoleUtil.hasAnyRoles(serviceContext.getUserId(), RoleEnum.USER_ADMINISTRATOR.toString());

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


        result.put("userId", savedUser.getUserId());
        return result;
    }


    public JSONArray findUsers(Map<String, Object> filter, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.hasAnyRoles(serviceContext.getUserId(), RoleEnum.USER_ADMINISTRATOR.toString());
        UserGroup operatorGroup = UserGroupLocalServiceUtil.fetchUserGroup(serviceContext.getCompanyId(), PortletProps.get("market-manager.userGroup.operator"));

        LinkedHashMap<String, Object> params = new LinkedHashMap<String, java.lang.Object>();
        params.put("usersUserGroups", operatorGroup.getUserGroupId());
        List<User> users = UserLocalServiceUtil.search(serviceContext.getCompanyId(), (String) filter.get("query"), 0, params, 0, 20, (OrderByComparator) null);

        JSONArray result = JSONFactoryUtil.createJSONArray();
        for (User user : users) {

            JSONObject userJsonObject = JSONFactoryUtil.createJSONObject();
            userJsonObject.put("firstName", user.getFirstName());
            userJsonObject.put("lastName", user.getLastName());
            userJsonObject.put("email", user.getEmailAddress());
            userJsonObject.put("id", user.getUserId());
            userJsonObject.put("mobile", user.getMiddleName());

            result.put(userJsonObject);
        }

        return result;
    }


    public JSONObject getById(Long userId, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.hasAnyRoles(serviceContext.getUserId(), RoleEnum.USER_ADMINISTRATOR.toString());

        JSONObject userJsonObject = JSONFactoryUtil.createJSONObject();
        User user = UserLocalServiceUtil.getUserById(userId);
        userJsonObject.put("firstName", user.getFirstName());
        userJsonObject.put("lastName", user.getLastName());
        userJsonObject.put("email", user.getEmailAddress());
        userJsonObject.put("id", user.getUserId());
        userJsonObject.put("mobile", user.getMiddleName());

        //load userRoles that are present in RoleEnum
        JSONObject roles = JSONFactoryUtil.createJSONObject();
        List<Role> userRoles = RoleLocalServiceUtil.getRoles(user.getRoleIds());
        for (Role userRole : userRoles) {
            try{
                if(null != RoleEnum.valueOf(userRole.getName())){
                    roles.put(userRole.getName(), true);
                }
            }catch (Exception e){}
        }
        userJsonObject.put("roles", roles);

        return userJsonObject;
    }
}
