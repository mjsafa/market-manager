package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.service.base.MyUserLocalServiceBaseImpl;
import com.arman.csb.modules.util.RoleEnum;
import com.arman.csb.util.MapUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.BooleanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the my user local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.MyUserLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.MyUserLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.MyUserLocalServiceUtil
 */
public class MyUserLocalServiceImpl extends MyUserLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.MyUserLocalServiceUtil} to access the my user local service.
     */

    public void updateUserRoles(Long userId, List<String> userRoles, ServiceContext serviceContext) throws PortalException, SystemException {
        List<Long> newRoleIds = new ArrayList<Long>();
        for (String roleName : userRoles) {
                Role role = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), roleName);
                newRoleIds.add(role.getRoleId());
        }

        long[] roleIdArray = new long[newRoleIds.size()];
        int i = 0;
        for (Long newRoleId : newRoleIds) {
            roleIdArray[i] = newRoleId;
            i++;
        }

        RoleLocalServiceUtil.setUserRoles(userId, roleIdArray);
    }

    public List<Role> getOperatorRoles(ServiceContext serviceContext) throws PortalException, SystemException {
        List<Role> roles = new ArrayList<Role>();
        List<Role> allRoles = RoleLocalServiceUtil.getRoles(serviceContext.getCompanyId());
        for (Role role : allRoles) {
            if (role.getExpandoBridge().getAttribute("forOperator") != null &&
                    ((Boolean) role.getExpandoBridge().getAttribute("forOperator")) == true) {
                roles.add(role);
            }
        }

        return roles;
    }
}
