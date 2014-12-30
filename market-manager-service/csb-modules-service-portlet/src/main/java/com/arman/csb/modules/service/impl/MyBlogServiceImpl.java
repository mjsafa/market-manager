package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.MyBlogDTO;
import com.arman.csb.modules.service.MyBlogLocalServiceUtil;
import com.arman.csb.modules.service.base.MyBlogServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.permission.GroupPermissionUtil;
import com.liferay.portal.service.permission.RolePermissionUtil;
import com.liferay.portal.template.ServiceLocator;
import com.liferay.portal.util.ResourcePermissionUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryService;
import com.liferay.portlet.blogs.service.permission.BlogsEntryPermission;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public BlogsEntry getEntry(long entryId) throws SystemException, PortalException {
        //BlogsEntryService blogsEntryService = (BlogsEntryService)ServiceLocator.getInstance().findService(BlogsEntryService.class.getName());
        BlogsEntry entry = blogsEntryLocalService.getEntry(entryId);
        //BlogsEntryPermission.check(getPermissionChecker(), entryId, ActionKeys.VIEW);
        if(getPermissionChecker().hasUserPermission(entry.getGroupId(), BlogsEntry.class.getName(), String.valueOf(entry.getEntryId()) , ActionKeys.VIEW, true)){
            return blogsEntryLocalService.getEntry(entryId);
        }else {
            throw new PrincipalException("access_denied");
        }


    }

    public JSONArray getLatestBlogEntries(String blogName, int status, int start, int end, String tags, String categories, Map<String, Object> options) throws SystemException, PortalException {

        JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
        Group group = GroupLocalServiceUtil.getGroup(getPermissionChecker().getCompanyId(), blogName);

        //check security (can user "VIEW" the entity "BlogsEntry" in this site?)
        if (getPermissionChecker().hasUserPermission(group.getGroupId(), "com.liferay.portlet.blogs.model.BlogsEntry", "0", "VIEW", Boolean.TRUE)) {


            prepareDates(options);
            //get related blog entries
            List<MyBlogDTO> entries = MyBlogLocalServiceUtil.findGroupEntries(getPermissionChecker().getCompanyId(), group.getGroupId(), status, start, end, tags, categories, options);

            //Creates Json Objects of each blogs entry
            for (MyBlogDTO dto : entries) {
                JSONObject entryJsonObject = JSONFactoryUtil.createJSONObject();

                entryJsonObject.put("id", dto.getEntry().getEntryId());
                entryJsonObject.put("title", dto.getEntry().getTitle());
                entryJsonObject.put("date", dto.getEntry().getDisplayDate());
                entryJsonObject.put("summary", dto.getEntry().getDescription());
                entryJsonObject.put("commentCount", dto.getCommentCount());

                try {
                    JSONObject jsonObject = JSONFactoryUtil.createJSONObject(dto.getEntry().getContent());
                    JSONArray array = jsonObject.getJSONArray("images");
                    if (array.length() > 0) {
                        entryJsonObject.put("image", array.getJSONObject(0));
                    }
                } catch (JSONException e) {

                }

                resultJsonArray.put(entryJsonObject);
            }
        } else {
            throw new PrincipalException("access_denied");
        }
        return resultJsonArray;
    }

    /**
     * read recent day count from options and add dateFrom and dateTo
     *
     * @param options
     */
    private void prepareDates(Map<String, Object> options) {
        if (null != options.get("recentDaysCount") &&
                !StringUtils.isBlank(String.valueOf(options.get("recentDaysCount"))) &&
                !String.valueOf(options.get("recentDaysCount")).equals("0")
                ) {
            int recentDaysCount = Integer.valueOf(String.valueOf(options.get("recentDaysCount")));
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.HOUR, 23);


            Date to = calendar.getTime();
            calendar.add(Calendar.DAY_OF_YEAR, -1 * recentDaysCount);

            Date from = calendar.getTime();

            options.put("dateFrom", from);
            options.put("dateTo", to);
        }
    }
}
