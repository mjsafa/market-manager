package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.UserActivity;
import com.arman.csb.modules.model.impl.UserActivityImpl;
import com.arman.csb.modules.service.base.UserActivityServiceBaseImpl;
import com.arman.csb.util.DateUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.math.BigInteger;
import java.util.Date;
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

    public JSONObject search(String text, String entity, String action, String importance, Date fromDate, Date toDate,
                            int start, int maxResult, ServiceContext serviceContext)
            throws JSONException {

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        JSONArray result = JSONFactoryUtil.createJSONArray();

        if(null != toDate) {
            toDate = DateUtil.adding24HourToDate(toDate);
        }

        SQLQuery searchQuery = createQueryObject(text, entity, action, importance, fromDate, toDate, start, maxResult,
                "com.arman.csb.modules.service.UserActivity.search", false, serviceContext);

        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(maxResult);
        List<UserActivity> activities = searchQuery.list();

        for (UserActivity activity : activities) {
            result.put(getJSONObject(activity));
        }

        SQLQuery countQuery = createQueryObject(text, entity, action, importance, fromDate, toDate, start, maxResult,
                "com.arman.csb.modules.service.UserActivity.count", true, serviceContext);
        List<BigInteger> temp = countQuery.list();
        long totalPayments = 0;
        totalPayments = Long.valueOf(String.valueOf(temp.get(0)));

        jsonObject.put("result", result);
        jsonObject.put("total", totalPayments);

        return jsonObject;
    }

    private SQLQuery createQueryObject (String text, String entity, String action, String importance,
                                    Date fromDate, Date toDate, int start, int maxResult, String queryName,
                                    boolean isCount, ServiceContext serviceContext) {
        Session session = invoicePersistence.openSession();

        String sql = CustomSQLUtil.get(queryName);
        sql = sql.replaceAll("##KEYWORD##","%" + text + "%");

        SQLQuery queryObject = session.createSQLQuery(sql);

        if(!isCount) {
            queryObject.addEntity(UserActivityImpl.TABLE_NAME, UserActivityImpl.class);
        }

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

        if(null == fromDate) {
            qPos.add(true);
            qPos.add(new Date());
        } else {
            qPos.add(false);
            qPos.add(fromDate);
        }

        if(null == toDate) {
            qPos.add(true);
            qPos.add(new Date());
        } else {
            qPos.add(false);
            qPos.add(toDate);
        }

        qPos.add(serviceContext.getScopeGroupId());

        return queryObject;
    }

    private JSONObject getJSONObject(UserActivity activity) throws JSONException {
        JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
        JSONObject result = JSONFactoryUtil.createJSONObject(jsonSerializer.serialize(activity));

        result.remove("data");
        result.put("data", JSONFactoryUtil.createJSONObject(activity.getData()));

        return result;
    }


}
