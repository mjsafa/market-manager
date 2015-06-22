package com.arman.csb.modules.service.impl;

import com.arman.csb.constant.UserActivityConstant;
import com.arman.csb.constants.ScoreConstants;
import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.CustomerModel;
import com.arman.csb.modules.model.impl.CustomerImpl;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;
import com.arman.csb.modules.service.ScoreLocalServiceUtil;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.service.base.CustomerServiceBaseImpl;
import com.arman.csb.modules.util.RoleEnum;
import com.arman.csb.modules.util.RoleUtil;
import com.arman.csb.theme.model.Template;
import com.arman.csb.theme.service.TemplateLocalServiceUtil;
import com.arman.csb.util.DateUtil;
import com.arman.csb.util.MapUtil;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.auth.PrincipalException;
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


    public JSONArray search(String filter, long mentorCustomerId, int start, int maxResult, ServiceContext serviceContext) throws PortalException, SystemException {
        if(!RoleUtil.isSameCustomer(serviceContext.getUserId(), mentorCustomerId)){
            RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER_MANAGER.toString());
        }

        JSONArray result = JSONFactoryUtil.createJSONArray();

        SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
        Session session = customerPersistence.openSession();
        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.CustomerService.search");
        sql = sql.replaceAll("##KEYWORD##", "%" + filter + "%");
        SQLQuery queryObject = session.createSQLQuery(sql);
        queryObject.setCacheable(false);
        queryObject.addEntity(CustomerImpl.TABLE_NAME, CustomerImpl.class);
        QueryPos qPos = QueryPos.getInstance(queryObject);

        //set mentor customer id or 0 is that is null
        qPos.add(mentorCustomerId <= 0 ?  null : mentorCustomerId);
        qPos.add(mentorCustomerId);

        qPos.add(serviceContext.getScopeGroupId());

        queryObject.setFirstResult(start);
        queryObject.setMaxResults(maxResult);

        List<Customer> customers = queryObject.list();
        for (Customer customer : customers) {
            JSONObject customerJson = JSONFactoryUtil.createJSONObject();
            customerJson.put("name", customer.getName());
            customerJson.put("firstName", customer.getFirstName());
            customerJson.put("lastName", customer.getLastName());
            customerJson.put("mobile", customer.getMobile());
            customerJson.put("email", customer.getEmail());
            customerJson.put("score", customer.getScore());
            customerJson.put("nationalCode", customer.getNationalCode());
            customerJson.put("id", customer.getId());
            customerJson.put("isActive", customer.getStatus() == WorkflowConstants.STATUS_APPROVED ? true : false);
            result.put(customerJson);
        }
        return result;
    }

    public JSONObject addCustomer(Map<String, Object> customer, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRolesOrSameCustomer(serviceContext.getUserId(), MapUtil.getLong(customer, "mentorCustomerId"), RoleEnum.CUSTOMER_MANAGER.toString());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        Customer newCustomer = CustomerLocalServiceUtil.addCustomer(customer, serviceContext);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_CUSTOMER, UserActivityConstant.ACTION_ADD,
                UserActivityConstant.IMPORTANCE_MEDIUM, getCustomerActivityJSONObject(newCustomer).toString(), serviceContext);

        result.put("customerId", newCustomer.getId());
        result.put("firstName", newCustomer.getFirstName());
        result.put("lastName", newCustomer.getLastName());
        return result;
    }

    public JSONObject getTotal(ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER_MANAGER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();
        result.put("allTotal", customerPersistence.countAll());
        return result;
    }


    public JSONObject getById(long customerId, ServiceContext serviceContext) throws PortalException, SystemException {
        if (!RoleUtil.isSameCustomer(serviceContext.getUserId(), customerId) && !RoleUtil.hasAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER_MANAGER.toString())) {
            throw new PrincipalException();
        }

        JSONObject result = JSONFactoryUtil.createJSONObject();

        Customer customer = customerPersistence.fetchByPrimaryKey(customerId);
        result.put("name", customer.getName());
        result.put("firstName", customer.getFirstName());
        result.put("lastName", customer.getLastName());
        result.put("email", customer.getEmail());
        result.put("mobile", customer.getMobile());
        result.put("card", customer.getCard());
        result.put("nationalCode", customer.getNationalCode());
        result.put("status", customer.getStatus());
        result.put("score", customer.getScore());
        result.put("id", customer.getId());

        if (customer.getMentorCustomerId() > 0) {
            JSONObject mentorJSon = JSONFactoryUtil.createJSONObject();
            Customer mentorCustomer = customerPersistence.fetchByPrimaryKey(customer.getMentorCustomerId());
            mentorJSon.put("id", mentorCustomer.getId());
            mentorJSon.put("name", mentorCustomer.getName());
            mentorJSon.put("firstName", mentorCustomer.getFirstName());
            mentorJSon.put("lastName", mentorCustomer.getLastName());
            mentorJSon.put("email", mentorCustomer.getEmail());
            mentorJSon.put("mobile", mentorCustomer.getMobile());
            result.put("mentor", mentorJSon);
        }

        return result;
    }

    public JSONArray getInvitees(long customerId, ServiceContext serviceContext) throws PortalException, SystemException {
        if (!RoleUtil.isSameCustomer(serviceContext.getUserId(), customerId) && !RoleUtil.hasAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER_MANAGER.toString())) {
            throw new PrincipalException();
        }

        JSONArray result = JSONFactoryUtil.createJSONArray();
        List<Customer> invitees = customerPersistence.findByMentor(customerId);

        for (Customer invitee : invitees) {
            JSONObject customer = JSONFactoryUtil.createJSONObject();
            customer.put("name", invitee.getName());
            customer.put("firstName", invitee.getFirstName());
            customer.put("lastName", invitee.getLastName());
            customer.put("email", invitee.getEmail());
            customer.put("mobile", invitee.getMobile());
            customer.put("card", invitee.getCard());
            customer.put("nationalCode", invitee.getNationalCode());
            customer.put("status", invitee.getStatus());
            customer.put("score", invitee.getScore());
            customer.put("id", invitee.getId());
            result.put(customer);
        }

        return result;
    }


    public JSONObject getStats(long customerId, ServiceContext serviceContext) throws PortalException, SystemException {
        if (!RoleUtil.isSameCustomer(serviceContext.getUserId(), customerId) && !RoleUtil.hasAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER_MANAGER.toString())) {
            throw new PrincipalException();
        }

        JSONObject result = JSONFactoryUtil.createJSONObject();
        result.put("totalInvitees", CustomerLocalServiceUtil.countByMentorCustomerId(customerId));
        result.put("totalDirectScore", ScoreLocalServiceUtil.sumByCustomerAndType(customerId, ScoreConstants.TYPE_DIRECT, null, null));
        result.put("totalInDirectScore", ScoreLocalServiceUtil.sumByCustomerAndType(customerId, ScoreConstants.TYPE_INDIRECT, null, null));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        long totalWeekScore = ScoreLocalServiceUtil.sumByCustomerAndType(customerId, ScoreConstants.TYPE_INDIRECT, calendar.getTime(), new Date())
                + ScoreLocalServiceUtil.sumByCustomerAndType(customerId, ScoreConstants.TYPE_DIRECT, calendar.getTime(), new Date());
        result.put("totalWeekScore", totalWeekScore);

        long customerPayment = PaymentLocalServiceUtil.totalPaymentAmount(customerId, null, null);
        result.put("totalCustomerPayment", customerPayment);

        return result;
    }

    public JSONObject getTotalStats(ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER_MANAGER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        result.put("totalCustomers", CustomerLocalServiceUtil.count(null, null, serviceContext.getScopeGroupId()));
        result.put("lastWeekCustomers", CustomerLocalServiceUtil.count(calendar.getTime(), new Date(), serviceContext.getScopeGroupId()));
        return result;
    }


    public JSONObject updateCustomer(Map<String, Object> customer, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER_MANAGER.toString());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        Customer oldCustomer = CustomerLocalServiceUtil.getById((Long) customer.get("id"));
        oldCustomer.setLastName((String) customer.get("lastName"));
        oldCustomer.setFirstName((String) customer.get("firstName"));
        oldCustomer.setName((String) customer.get("firstName") + " " + (String) customer.get("lastName"));
        oldCustomer.setCard((String) customer.get("card"));
        oldCustomer.setEmail((String) customer.get("email"));
        oldCustomer.setMobile((String) customer.get("mobile"));

        CustomerLocalServiceUtil.updateCustomer(oldCustomer);
        result.put("customerId", (Long) customer.get("id"));

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_CUSTOMER, UserActivityConstant.ACTION_EDIT,
                UserActivityConstant.IMPORTANCE_MEDIUM, getCustomerActivityJSONObject(oldCustomer).toString(), serviceContext);

        return result;
    }

    public JSONObject updateCustomerStatus(long customerId, boolean isActive, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.CUSTOMER_MANAGER.toString());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        Customer oldCustomer = CustomerLocalServiceUtil.getById(customerId);
        oldCustomer.setStatus(isActive ? WorkflowConstants.STATUS_APPROVED : WorkflowConstants.STATUS_DENIED);
        CustomerLocalServiceUtil.updateCustomer(oldCustomer);
        UserLocalServiceUtil.updateStatus(oldCustomer.getCustomerUserId(), isActive ? WorkflowConstants.STATUS_APPROVED : WorkflowConstants.STATUS_DENIED);
        result.put("customerId", customerId);
        result.put("isActive", isActive);
        result.put("name", oldCustomer.getFirstName() + " " + oldCustomer.getLastName());

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_CUSTOMER, UserActivityConstant.ACTION_CHANGE_STATUS,
                UserActivityConstant.IMPORTANCE_MEDIUM, getCustomerActivityJSONObject(oldCustomer).toString(), serviceContext);

        return result;
    }


    public JSONObject getCustomerActivityJSONObject(Customer customer){
        JSONObject customerJson = JSONFactoryUtil.createJSONObject();
        customerJson.put("firstName", customer.getFirstName());
        customerJson.put("lastName", customer.getLastName());
        customerJson.put("id", customer.getId());
        customerJson.put("createDate", DateUtil.getString(customer.getCreateDate()));
        customerJson.put("isActive", customer.getStatus() == WorkflowConstants.STATUS_APPROVED);

        return customerJson;
    }

}
