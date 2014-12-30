package com.arman.csb.theme.service.impl;

import com.arman.csb.theme.service.base.MyPageServiceBaseImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The implementation of the my page remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.theme.service.MyPageService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.theme.service.base.MyPageServiceBaseImpl
 * @see com.arman.csb.theme.service.MyPageServiceUtil
 */
public class MyPageServiceImpl extends MyPageServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.theme.service.MyPageServiceUtil} to access the my page remote service.
     */

    public JSONObject editPageContent(String pageId, String itemId, String newContent) {
        myPageLocalService.editPageContent(Long.valueOf(pageId), itemId, newContent);
        JSONObject result  = JSONFactoryUtil.createJSONObject();
        result.put("editableId", itemId);

        return result;
    }

}
