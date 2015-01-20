package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.InvoiceItem;
import com.arman.csb.modules.model.UserActivity;
import com.arman.csb.modules.model.impl.InvoiceItemImpl;
import com.arman.csb.modules.model.impl.UserActivityImpl;
import com.arman.csb.modules.service.base.UserActivityServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

/**
 * The implementation of the user activity remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.UserActivityService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.UserActivityServiceBaseImpl
 * @see com.arman.csb.modules.service.UserActivityServiceUtil
 */
public class UserActivityServiceImpl extends UserActivityServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.UserActivityServiceUtil} to access the user activity remote service.
     */

    public JSONArray search(String filter, String entity, String action, String importance,
                            int start, int maxResult, ServiceContext serviceContext)
            throws JSONException {

        JSONArray result = JSONFactoryUtil.createJSONArray();

        Session session = invoicePersistence.openSession();

        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.UserActivity.search");
        sql = sql.replaceAll("##KEYWORD##","%" + filter + "%");

        SQLQuery queryObject = session.createSQLQuery(sql);

        queryObject.addEntity(UserActivityImpl.TABLE_NAME, UserActivityImpl.class);
        queryObject.setFirstResult(start);
        queryObject.setMaxResults(maxResult);

        QueryPos qPos = QueryPos.getInstance(queryObject);
        if(entity.equals("")) {
            qPos.add(true);
            qPos.add("");
        } else {
            qPos.add(false);
            qPos.add(entity);
        }

        if(action.equals("")) {
            qPos.add(true);
            qPos.add(1);
        } else {
            qPos.add(false);
            qPos.add(Short.valueOf(action));
        }

        if(importance.equals("")) {
            qPos.add(true);
            qPos.add(1);
        } else {
            qPos.add(false);
            qPos.add(Short.valueOf(importance));
        }

        List<UserActivity> activities = queryObject.list();

        for (UserActivity activity : activities) {
            result.put(getJSONObject(activity));
        }

        return result;
    }

    private JSONObject getJSONObject(UserActivity activity) throws JSONException {
        JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
        JSONObject result = JSONFactoryUtil.createJSONObject(jsonSerializer.serialize(activity));

        result.remove("data");
        result.put("data", JSONFactoryUtil.createJSONArray("[" + activity.getData() + "]"));

        return result;
    }


}
