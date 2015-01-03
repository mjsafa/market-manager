package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.CustomerModel;
import com.arman.csb.modules.model.impl.CustomerImpl;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.base.CustomerServiceBaseImpl;
import com.arman.csb.theme.model.Template;
import com.arman.csb.theme.service.TemplateLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.liferay.util.portlet.PortletProps;

import java.util.*;

/**
 * The implementation of the customer remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.CustomerService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.CustomerServiceBaseImpl
 * @see com.arman.csb.modules.service.CustomerServiceUtil
 */
public class CustomerServiceImpl extends CustomerServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.CustomerServiceUtil} to access the customer remote service.
     */


    public JSONArray search(String filter, int start , int maxResult, ServiceContext serviceContext) {
        JSONArray result = JSONFactoryUtil.createJSONArray();

        SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");

        Session session = customerPersistence.openSession();
        //session = sessionFactory.openSession();

        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.CustomerService.search");
        sql = sql.replaceAll("##KEYWORD##","%" + filter + "%");

        SQLQuery queryObject = session.createSQLQuery(sql);
        queryObject.setCacheable(false);
        queryObject.addEntity(CustomerImpl.TABLE_NAME, CustomerImpl.class);

        //queryObject.addScalar("commentCount", Type.INTEGER);

        QueryPos qPos = QueryPos.getInstance(queryObject);

        for (int i = 1; i <= 4; i++) {
            //qPos.add(filter);
        }

        queryObject.setFirstResult(start);
        queryObject.setMaxResults(maxResult);

        List<Customer> customers = queryObject.list();
        for (Customer customer : customers) {
            JSONObject customerJson = JSONFactoryUtil.createJSONObject();
            customerJson.put("name", customer.getName());
            customerJson.put("mobile", customer.getMobile());
            customerJson.put("email", customer.getEmail());
            customerJson.put("score", customer.getScore());
            customerJson.put("nationalCode", customer.getNationalCode());
            customerJson.put("id", customer.getId());
            result.put(customerJson);
        }
        return result;
    }

    public JSONObject addCustomer(Map<String, Object> customer, ServiceContext serviceContext) throws PortalException, SystemException {
       return CustomerLocalServiceUtil.addCustomer(customer, serviceContext);
    }

    public JSONObject getTotal(ServiceContext serviceContext) throws PortalException, SystemException {
        JSONObject result = JSONFactoryUtil.createJSONObject();
        result.put("allTotal", customerPersistence.countAll());
        return result;
    }


    public JSONObject getById(long customerId,ServiceContext serviceContext) throws PortalException, SystemException {
        JSONObject result = JSONFactoryUtil.createJSONObject();

        Customer customer = customerPersistence.fetchByPrimaryKey(customerId);
        result.put("name", customer.getName());
        result.put("email", customer.getEmail());
        result.put("mobile", customer.getMobile());
        result.put("card", customer.getCard());
        result.put("nationalCode", customer.getNationalCode());
        result.put("status", customer.getStatus());



        return result;
    }

}
