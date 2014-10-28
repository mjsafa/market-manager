package com.armansoft.csb.service.wrapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.*;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalService;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceWrapper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 9/14/14
 * Time: 8:04 PM
 */
public class BlogsEntryLocalServiceWrapperImpl extends BlogsEntryLocalServiceWrapper {
    public BlogsEntryLocalServiceWrapperImpl(BlogsEntryLocalService blogsEntryLocalService) {
        super(blogsEntryLocalService);
    }


    /**
     * wraps original service to save permissions based on more than just guest and member roles
     *
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    @Override
    public BlogsEntry updateEntry(
            long userId, long entryId, String title, String description,
            String content, int displayDateMonth, int displayDateDay,
            int displayDateYear, int displayDateHour, int displayDateMinute,
            boolean allowPingbacks, boolean allowTrackbacks,
            String[] trackbacks, boolean smallImage, String smallImageURL,
            String smallImageFileName, InputStream smallImageInputStream,
            ServiceContext serviceContext)
            throws PortalException, SystemException {

        serviceContext.setGroupPermissions(null);
        serviceContext.setGuestPermissions(null);

        BlogsEntry entry = super.updateEntry(userId, entryId, title, description,
                content, displayDateMonth, displayDateDay,
                displayDateYear, displayDateHour, displayDateMinute,
                allowPingbacks, allowTrackbacks,
                trackbacks, smallImage, smallImageURL,
                smallImageFileName, smallImageInputStream,
                serviceContext);

        addPermissions(entry, serviceContext);
        return entry;
    }

    @Override
    public BlogsEntry addEntry(long userId, String title, String description, String content, int displayDateMonth, int displayDateDay, int displayDateYear, int displayDateHour, int displayDateMinute, boolean allowPingbacks, boolean allowTrackbacks, String[] trackbacks, boolean smallImage, String smallImageURL, String smallImageFileName, InputStream smallImageInputStream, ServiceContext serviceContext) throws PortalException, SystemException {
        serviceContext.setGroupPermissions(null);
        serviceContext.setGuestPermissions(null);

        BlogsEntry entry = super.addEntry(userId, title, description, content, displayDateMonth, displayDateDay, displayDateYear, displayDateHour, displayDateMinute, allowPingbacks, allowTrackbacks, trackbacks, smallImage, smallImageURL, smallImageFileName, smallImageInputStream, serviceContext);

        addPermissions(entry, serviceContext);
        return entry;
    }

    private void addPermissions(BlogsEntry entry, ServiceContext serviceContext) throws SystemException, PortalException {
        String[] viewableBy = (String[]) (serviceContext.getAttribute("viewableBy").getClass().isArray() ? serviceContext.getAttribute("viewableBy") : new String[]{(String) serviceContext.getAttribute("viewableBy")});
        String[] viewableByRoles = {};

        String[] commentableBy = (String[]) (serviceContext.getAttribute("commentableBy").getClass().isArray() ? serviceContext.getAttribute("commentableBy") : new String[]{(String) serviceContext.getAttribute("commentableBy")});
        String[] commentableByRoles = {};
        Map<Long, String[]> rolesPermissions = new HashMap<Long, String[]>();

        List<Role> allRoles = RoleLocalServiceUtil.getRoles(serviceContext.getCompanyId());
        for (Role role : allRoles) {
            rolesPermissions.put(role.getRoleId(), new String[]{});
        }

        if (viewableBy != null) {
            if (ArrayUtil.contains(viewableBy, RoleConstants.GUEST)) {
                viewableByRoles = ArrayUtil.append(viewableByRoles, RoleConstants.GUEST);
                viewableByRoles = ArrayUtil.append(viewableByRoles, RoleConstants.USER);
            } else if (ArrayUtil.contains(viewableBy, RoleConstants.USER)) {
                viewableByRoles = ArrayUtil.append(viewableByRoles, RoleConstants.USER);
            } else {
                for (String role : viewableBy) {
                    viewableByRoles = ArrayUtil.append(viewableByRoles, role);
                }
            }
        }

        if (commentableBy != null) {
            if (ArrayUtil.contains(commentableBy, RoleConstants.GUEST)) {
                commentableByRoles = ArrayUtil.append(commentableByRoles, RoleConstants.GUEST);
                commentableByRoles = ArrayUtil.append(commentableByRoles, RoleConstants.USER);
            } else if (ArrayUtil.contains(commentableBy, RoleConstants.USER)) {
                commentableByRoles = ArrayUtil.append(commentableByRoles, RoleConstants.USER);
            } else {
                for (String role : viewableBy) {
                    commentableByRoles = ArrayUtil.append(commentableByRoles, role);
                }
            }
        }

        for (String role : viewableByRoles) {
            long roleId = RoleLocalServiceUtil.getRole(entry.getCompanyId(), role).getRoleId();
            String[] permissions = (rolesPermissions.get(roleId)) == null ? new String[0] : rolesPermissions.get(roleId);
            permissions = ArrayUtil.append(permissions, ActionKeys.VIEW);
            rolesPermissions.put(roleId, permissions);
        }

        for (String role : commentableByRoles) {
            long roleId = RoleLocalServiceUtil.getRole(entry.getCompanyId(), role).getRoleId();
            String[] permissions = (rolesPermissions.get(roleId)) == null ? new String[0] : rolesPermissions.get(roleId);
            permissions = ArrayUtil.append(permissions, ActionKeys.ADD_DISCUSSION);
            rolesPermissions.put(roleId, permissions);
        }

        String[] ownerRoles = new String[]{ActionKeys.VIEW, ActionKeys.ADD_DISCUSSION, ActionKeys.UPDATE, ActionKeys.DELETE_DISCUSSION, ActionKeys.DELETE, ActionKeys.PERMISSIONS, ActionKeys.UPDATE_DISCUSSION};
        long ownerId = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), RoleConstants.OWNER).getRoleId();
        rolesPermissions.put(ownerId, ownerRoles);

        ResourcePermissionServiceUtil.setIndividualResourcePermissions(serviceContext.getScopeGroupId(),
                serviceContext.getCompanyId(),
                BlogsEntry.class.getName(),
                String.valueOf(entry.getEntryId()),
                rolesPermissions);


    }
}
