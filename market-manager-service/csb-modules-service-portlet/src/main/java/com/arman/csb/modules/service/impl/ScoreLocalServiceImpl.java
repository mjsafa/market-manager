package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.Score;
import com.arman.csb.modules.model.impl.CustomerImpl;
import com.arman.csb.modules.service.base.ScoreLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the score local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.ScoreLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.ScoreLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.ScoreLocalServiceUtil
 */
public class ScoreLocalServiceImpl extends ScoreLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.ScoreLocalServiceUtil} to access the score local service.
     */

    public int sumByCustomerAndType(Long customerId, Integer type, Date fromDate, Date toDate) throws SystemException, PortalException {

        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.ScoreService.sumByCustomerAndType");

        Session session = scorePersistence.openSession();
        SQLQuery queryObject = session.createSQLQuery(sql);
        queryObject.setCacheable(false);

        QueryPos qPos = QueryPos.getInstance(queryObject);
        qPos.add(customerId);
        qPos.add(type);

        qPos.add(fromDate == null ? null : "not_null");
        qPos.add(fromDate);
        qPos.add(toDate == null ? null : "not_null");
        qPos.add(toDate);

        List<BigInteger> result = queryObject.list();
        if (!result.isEmpty()) {
            return result.get(0).intValue();
        } else {
            return 0;
        }
    }


    /**
     *
     * @param type direct/indirect/null: if null then sums all scores
     * @param fromDate
     * @param toDate
     * @return
     * @throws SystemException
     * @throws PortalException
     */
    public int sumByType( Integer type, Date fromDate, Date toDate) throws SystemException, PortalException {

        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.ScoreService.sumByType");

        Session session = scorePersistence.openSession();
        SQLQuery queryObject = session.createSQLQuery(sql);
        queryObject.setCacheable(false);

        QueryPos qPos = QueryPos.getInstance(queryObject);
        qPos.add(type == null ? 0 : type);
        qPos.add(type == null ? 0 : type);

        qPos.add(fromDate == null ? null : "not_null");
        qPos.add(fromDate);
        qPos.add(toDate == null ? null : "not_null");
        qPos.add(toDate);

        List<BigInteger> result = queryObject.list();
        if (!result.isEmpty()) {
            return result.get(0).intValue();
        } else {
            return 0;
        }
    }


}
