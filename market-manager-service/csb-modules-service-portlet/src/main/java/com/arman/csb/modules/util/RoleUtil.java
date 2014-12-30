package com.arman.csb.modules.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.UserServiceUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 12/22/14
 * Time: 2:51 PM
 */
public abstract class RoleUtil {


    /**
     * check to see if user has any of given roleNames ,
     *      if user has not any of them, throws PrincipalException
     * @param userId
     * @param roleNames
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException - if user has not any of roleNames
     */
    public static void hasAnyRoles(long userId , String ... roleNames) throws PortalException, SystemException{
        List<Role> userRoles = UserServiceUtil.getUserById(userId).getRoles();
        for (String roleName : roleNames) {
            for (Role userRole : userRoles) {
                if(userRole.getName().equals(roleName) || userRole.equals(RoleEnum.ADMINISTRATOR.toString())){
                    return;
                }
            }
        }
        throw new PrincipalException("access-denied");
    }



}
