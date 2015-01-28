package com.arman.csb.modules.service.impl;

import com.arman.csb.constant.UserActivityConstant;
import com.arman.csb.constants.ScoreConstants;
import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.Score;
import com.arman.csb.modules.model.impl.CustomerImpl;
import com.arman.csb.modules.model.impl.ScoreModelImpl;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.ScoreLocalServiceUtil;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.service.base.ScoreServiceBaseImpl;
import com.arman.csb.util.DateUtil;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.liferay.util.portlet.PortletProps;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The implementation of the score remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.ScoreService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.ScoreServiceBaseImpl
 * @see com.arman.csb.modules.service.ScoreServiceUtil
 */
public class ScoreServiceImpl extends ScoreServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.ScoreServiceUtil} to access the score remote service.
     */

    public JSONObject customerScoresByDate(Long customerId, String fromDate, String toDate, ServiceContext serviceContext) {
        JSONObject result = JSONFactoryUtil.createJSONObject();

        Session session = scorePersistence.openSession();
        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.ScoreService.customerScoresByDate");
        SQLQuery queryObject = session.createSQLQuery(sql);
        queryObject.setCacheable(false);

        QueryPos qPos = QueryPos.getInstance(queryObject);
        qPos.add(customerId);

        //Set dates
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            qPos.add(format.parse(fromDate));
            qPos.add(format.parse(toDate));
        } catch (ParseException e) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -1);
            qPos.add(calendar.getTime());
            qPos.add(new Date());
        }

        queryObject.setFirstResult(0);
        queryObject.setMaxResults(30);

        result.put("records", JSONFactoryUtil.createJSONArray());
        result.put("customerId", customerId);
        List<Object[]> records = queryObject.list();
        for (Object[] record : records) {
            JSONObject recordJson = JSONFactoryUtil.createJSONObject();
            recordJson.put("value", ((BigDecimal) record[0]).longValue());
            recordJson.put("date", ((Timestamp) record[1]).getTime());

            result.getJSONArray("records").put(recordJson);
        }
        return result;
    }


    public JSONObject scoresByDate(String fromDate, String toDate, String timePeriod, ServiceContext serviceContext) {
        JSONObject result = JSONFactoryUtil.createJSONObject();

        Session session = scorePersistence.openSession();
        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.ScoreService.scoresByDate");

        Calendar calendar = Calendar.getInstance();
        if (null != timePeriod) {
            if (timePeriod.equals("month")) {
                calendar.add(Calendar.MONTH, -1);
            } else if (timePeriod.equals("week")) {
                calendar.add(Calendar.DATE, -7);
            } else if (timePeriod.equals("year")) {
                sql = CustomSQLUtil.get("com.arman.csb.modules.service.ScoreService.scoresByMonth"); //load scores by monthes instead of days
                calendar.add(Calendar.YEAR, -1);
            }
        }

        SQLQuery queryObject = session.createSQLQuery(sql);
        queryObject.setCacheable(false);

        QueryPos qPos = QueryPos.getInstance(queryObject);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //Set dates
        if (null != timePeriod) {
            qPos.add(calendar.getTime());
            qPos.add(new Date());
        } else {
            try {

                Date from = new Date(), to = new Date();
                if (StringUtils.isEmpty(fromDate) && StringUtils.isEmpty(toDate)) {
                    calendar.add(Calendar.MONTH, -1);
                    from = calendar.getTime();
                    to = new Date();
                } else if (StringUtils.isEmpty(fromDate) && !StringUtils.isEmpty(fromDate)) {
                    to = format.parse(toDate);
                    calendar.setTime(to);
                    calendar.add(Calendar.MONTH, -1);
                    from = calendar.getTime();
                } else if (!StringUtils.isEmpty(fromDate) && StringUtils.isEmpty(fromDate)) {
                    from = format.parse(fromDate);
                    calendar.setTime(from);
                    calendar.add(Calendar.MONTH, 1);
                    to = calendar.getTime();
                }

                qPos.add(from);
                qPos.add(to);
            } catch (ParseException e) {
                calendar.add(Calendar.MONTH, -1);
                qPos.add(calendar.getTime());
                qPos.add(new Date());
            }
        }

        queryObject.setFirstResult(0);
        queryObject.setMaxResults(30);

        result.put("records", JSONFactoryUtil.createJSONArray());
        List<Object[]> records = queryObject.list();
        for (Object[] record : records) {
            JSONObject recordJson = JSONFactoryUtil.createJSONObject();
            recordJson.put("value", ((BigDecimal) record[0]).intValue());
            recordJson.put("date", new SimpleDateFormat("MM-dd").format((Timestamp) record[1]));

            result.getJSONArray("records").put(recordJson);
        }
        return result;
    }

    public JSONObject addScore(Long customerId, long value, ServiceContext serviceContext) throws PortalException, SystemException {
        JSONObject result = JSONFactoryUtil.createJSONObject();

        Customer customer = customerPersistence.fetchByPrimaryKey(customerId);

        Score newScore = ScoreLocalServiceUtil.addScore(customerId, value, serviceContext);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_SCORE, UserActivityConstant.ACTION_ADD,
                UserActivityConstant.IMPORTANCE_HIGH, getScoreActivityJSONObject(newScore, customer).toString(), serviceContext);

        return result;
    }


    public JSONArray customerScores(Long customerId, int start, int total, Map<String, Object> filter, ServiceContext serviceContext) throws PortalException, SystemException {
        JSONArray result = JSONFactoryUtil.createJSONArray();
        List<Score> scores = new ArrayList<Score>();

        if (null == customerId) {
            scores = scorePersistence.findAll(start, start + total);
        } else {
            scores = scorePersistence.findByCustomerId(customerId, start, start + total, OrderByComparatorFactoryUtil.create(ScoreModelImpl.TABLE_NAME, "createDate", false));
        }
        for (Score score : scores) {
            JSONObject scoreJson = JSONFactoryUtil.createJSONObject();
            scoreJson.put("value", score.getValue());
            scoreJson.put("date", new SimpleDateFormat("yyyy-MM-dd").format(score.getCreateDate()));
            scoreJson.put("isDirect", score.getType() == ScoreConstants.TYPE_DIRECT ? true : false);


            Customer customer = CustomerLocalServiceUtil.getById(score.getCustomerId());
            if (null != customer) {
                scoreJson.put("customer", JSONFactoryUtil.createJSONObject());
                scoreJson.getJSONObject("customer").put("name", customer.getName());
                scoreJson.getJSONObject("customer").put("firstName", customer.getFirstName());
                scoreJson.getJSONObject("customer").put("lastName", customer.getLastName());
                scoreJson.getJSONObject("customer").put("id", customer.getId());
            }
            result.put(scoreJson);
        }
        return result;
    }

    public JSONObject getTotalStats() throws SystemException, PortalException {
        JSONObject result = JSONFactoryUtil.createJSONObject();
        result.put("totalDirectScores", ScoreLocalServiceUtil.sumByType(ScoreConstants.TYPE_DIRECT, null, null));
        result.put("totalIndirectScores", ScoreLocalServiceUtil.sumByType(ScoreConstants.TYPE_INDIRECT, null, null));
        result.put("totalScores", ScoreLocalServiceUtil.sumByType(null, null, null));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        result.put("totalWeekScores", ScoreLocalServiceUtil.sumByType(null, calendar.getTime(), new Date()));

        return result;
    }

    public JSONObject getScoreActivityJSONObject(Score score, Customer customer) {
        JSONObject scoreJson = JSONFactoryUtil.createJSONObject();
        scoreJson.put("firstName", customer.getFirstName());
        scoreJson.put("lastName", customer.getLastName());
        scoreJson.put("id", score.getId());
        scoreJson.put("amount", score.getValue());
        scoreJson.put("customerId", customer.getId());
        scoreJson.put("createDate", DateUtil.getString(score.getCreateDate()));

        return scoreJson;
    }
}
