package com.arman.csb.modules.util;

import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
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
     * if user has not any of them, throws PrincipalException
     *
     * @param userId
     * @param roleNames
     * @throws PortalException
     * @throws SystemException
     * @throws PrincipalException - if user has not any of roleNames
     */
    public static void checkAnyRoles(long userId, String... roleNames) throws PortalException, SystemException {
        if (!hasAnyRoles(userId, roleNames)) {
            throw new PrincipalException();
        }
    }

    public static boolean hasAnyRoles(long userId, String... roleNames) throws PortalException, SystemException {
        List<Role> userRoles = UserServiceUtil.getUserById(userId).getRoles();
        for (String roleName : roleNames) {
            for (Role userRole : userRoles) {
                if (userRole.getName().equals(roleName) || userRole.equals(RoleEnum.ADMINISTRATOR.toString())) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * checks if the given user id belongs to a customer or not
     * @param userId
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public static boolean isCustomer(long userId) throws PortalException, SystemException {
        Customer customer = CustomerLocalServiceUtil.findByUserId(userId);
        if(null != customer){
            return true;
        }
        return false;
    }


    public static void checkCustomer(long userId) throws PortalException, SystemException {
        if(!isCustomer(userId)){
            throw new PrincipalException();
        }
    }


}
