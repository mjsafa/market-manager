package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.service.MyBlogLocalServiceUtil;
import com.arman.csb.modules.service.base.MyBlogServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;

import java.util.List;

/**
 * The implementation of the my blog remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.MyBlogService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.MyBlogServiceBaseImpl
 * @see com.arman.csb.modules.service.MyBlogServiceUtil
 */

public class MyBlogServiceImpl extends MyBlogServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.MyBlogServiceUtil} to access the my blog remote service.
     */


    public JSONArray getLatestBlogEntries(String blogName, int status, int start, int end, String tags, String categories) throws SystemException, PortalException {

        JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
        Group group = GroupLocalServiceUtil.getGroup(getPermissionChecker().getCompanyId(), blogName);

        //check security (can user "VIEW" the entity "BlogsEntry" in this site?)
        if (getPermissionChecker().hasUserPermission(group.getGroupId(), "com.liferay.portlet.blogs.model.BlogsEntry", "0", "VIEW", Boolean.TRUE)) {

            //get related blog entries
            List<BlogsEntry> entries = MyBlogLocalServiceUtil.findGroupEntries(getPermissionChecker().getCompanyId(), group.getGroupId(), status, start, end, tags, categories);

            //Creates Json Objects of each blogs entry
            for (BlogsEntry entry : entries) {
                JSONObject entryJsonObject = JSONFactoryUtil.createJSONObject();
                entryJsonObject.put("title", entry.getTitle());
                entryJsonObject.put("date", entry.getDisplayDate());
                entryJsonObject.put("content", entry.getContent());
                resultJsonArray.put(entryJsonObject);
            }

        } else {
            throw new PrincipalException("access_denied");
        }
        return resultJsonArray;
    }
}
