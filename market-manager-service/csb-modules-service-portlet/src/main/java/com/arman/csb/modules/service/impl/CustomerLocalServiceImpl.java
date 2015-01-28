package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.NoSuchCustomerException;
import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.CustomerModel;
import com.arman.csb.modules.model.impl.CustomerModelImpl;
import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.base.CustomerLocalServiceBaseImpl;
import com.arman.csb.util.MapUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.*;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.portlet.PortletProps;

import java.util.*;

/**
 * The implementation of the customer local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.CustomerLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.CustomerLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.CustomerLocalServiceUtil
 */
public class CustomerLocalServiceImpl extends CustomerLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.CustomerLocalServiceUtil} to access the customer local service.
     */


    public Customer addCustomer(Map<String, Object> customer, ServiceContext serviceContext) throws PortalException, SystemException {
        JSONObject result = JSONFactoryUtil.createJSONObject();

        UserGroup customerGroup = UserGroupLocalServiceUtil.fetchUserGroup(serviceContext.getCompanyId(), PortletProps.get("market-manager.userGroup.customer"));

        int maxInviteeNumber = Integer.valueOf(PortletProps.get("market-manager.config.max-invitees"));
        int inviteeCount = customerPersistence.countByMentor(MapUtil.getLong(customer, "mentorCustomerId"));
        if (inviteeCount >= maxInviteeNumber) {
            throw new PortalException("customer-maximum-invitee-exceed");
        }

        String screenName = ((String) customer.get("email")).replace("@", "-");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        List<Long> roles = new ArrayList<Long>();
        roles.add(RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), "CUSTOMER").getRoleId());

        User user = UserLocalServiceUtil.addUser(serviceContext.getUserId(), serviceContext.getCompanyId(),
                false, (String) customer.get("password1"), (String) customer.get("password2"), false,
                screenName, (String) customer.get("email"), 0L, null, Locale.US, (String) customer.get("firstName"), (String) customer.get("mobile"), (String) customer.get("lastName"),
                0, 0, true, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.YEAR), (String) customer.get("jobTitle"), new long[0], new long[0], ArrayUtil.toLongArray(roles),
                new long[]{customerGroup.getUserGroupId()}, true, serviceContext);


        Customer newCustomer = CustomerLocalServiceUtil.createCustomer(counterLocalService.increment(Customer.class.getName()));
        newCustomer.setCompanyId(serviceContext.getCompanyId());
        newCustomer.setGroupId(serviceContext.getScopeGroupId());

        newCustomer.setName((String) customer.get("firstName") + " " + (String) customer.get("lastName"));
        newCustomer.setFirstName((String) customer.get("firstName"));
        newCustomer.setLastName((String) customer.get("lastName"));
        newCustomer.setEmail((String) customer.get("email"));
        newCustomer.setCard((String) customer.get("card"));
        newCustomer.setStatus(WorkflowConstants.STATUS_APPROVED);
        newCustomer.setMobile((String) customer.get("mobile"));
        newCustomer.setNationalCode((String) customer.get("nationalCode"));
        newCustomer.setCardExpireDate(MapUtil.getDate(customer, "expireDate"));
        newCustomer.setScore(0);

        if (null != customer.get("mentorCustomerId")) {
            newCustomer.setMentorCustomerId((Long) customer.get("mentorCustomerId"));
        }


        newCustomer.setUserId(serviceContext.getUserId());
        newCustomer.setCompanyId(serviceContext.getCompanyId());
        newCustomer.setCreateDate(new Date());
        newCustomer.setCustomerUserId(user.getUserId());
        newCustomer.setUserName("");

        CustomerLocalServiceUtil.addCustomer(newCustomer);

        return newCustomer;
    }

    public Customer getById(Long customerId) throws PortalException, SystemException {
        return customerPersistence.fetchByPrimaryKey(customerId);
    }

    public Customer findByUserId(Long userId) throws SystemException, PortalException {
        try {
            return customerPersistence.findByUserId(userId);
        } catch (NoSuchCustomerException e) {
            return null;
        }
    }

    public List<Customer> findByMentorCustomerId(Long mentorCustomerId) throws SystemException, PortalException {
        return customerPersistence.findByMentor(mentorCustomerId);
    }


    public int countByMentorCustomerId(Long customerId) throws SystemException, PortalException {
        return customerPersistence.countByMentor(customerId);
    }


    public long count(Date fromDate, Date toDate) throws SystemException, PortalException {
        ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Customer.class, classLoader);
        if (null != fromDate) {
            query.add(PropertyFactoryUtil.forName("createDate").ge(fromDate));
        }
        if (null != toDate) {
            query.add(PropertyFactoryUtil.forName("createDate").le(toDate));
        }

        return dynamicQueryCount(query);
    }

    public Customer updateCustomer(Customer customer, ServiceContext serviceContext) throws PortalException, SystemException {
        Customer updatedCustomer = customerPersistence.update(customer);
        return updatedCustomer;
    }

}
