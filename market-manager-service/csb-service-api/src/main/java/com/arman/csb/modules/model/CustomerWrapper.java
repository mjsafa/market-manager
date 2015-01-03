package com.arman.csb.modules.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Customer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Customer
 * @generated
 */
public class CustomerWrapper implements Customer, ModelWrapper<Customer> {
    private Customer _customer;

    public CustomerWrapper(Customer customer) {
        _customer = customer;
    }

    @Override
    public Class<?> getModelClass() {
        return Customer.class;
    }

    @Override
    public String getModelClassName() {
        return Customer.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("id", getId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("mobile", getMobile());
        attributes.put("nationalCode", getNationalCode());
        attributes.put("email", getEmail());
        attributes.put("card", getCard());
        attributes.put("score", getScore());
        attributes.put("status", getStatus());
        attributes.put("customerUserId", getCustomerUserId());
        attributes.put("mentorCustomerId", getMentorCustomerId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String mobile = (String) attributes.get("mobile");

        if (mobile != null) {
            setMobile(mobile);
        }

        String nationalCode = (String) attributes.get("nationalCode");

        if (nationalCode != null) {
            setNationalCode(nationalCode);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String card = (String) attributes.get("card");

        if (card != null) {
            setCard(card);
        }

        Integer score = (Integer) attributes.get("score");

        if (score != null) {
            setScore(score);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long customerUserId = (Long) attributes.get("customerUserId");

        if (customerUserId != null) {
            setCustomerUserId(customerUserId);
        }

        Long mentorCustomerId = (Long) attributes.get("mentorCustomerId");

        if (mentorCustomerId != null) {
            setMentorCustomerId(mentorCustomerId);
        }
    }

    /**
    * Returns the primary key of this customer.
    *
    * @return the primary key of this customer
    */
    @Override
    public long getPrimaryKey() {
        return _customer.getPrimaryKey();
    }

    /**
    * Sets the primary key of this customer.
    *
    * @param primaryKey the primary key of this customer
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _customer.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this customer.
    *
    * @return the uuid of this customer
    */
    @Override
    public java.lang.String getUuid() {
        return _customer.getUuid();
    }

    /**
    * Sets the uuid of this customer.
    *
    * @param uuid the uuid of this customer
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _customer.setUuid(uuid);
    }

    /**
    * Returns the ID of this customer.
    *
    * @return the ID of this customer
    */
    @Override
    public long getId() {
        return _customer.getId();
    }

    /**
    * Sets the ID of this customer.
    *
    * @param id the ID of this customer
    */
    @Override
    public void setId(long id) {
        _customer.setId(id);
    }

    /**
    * Returns the group ID of this customer.
    *
    * @return the group ID of this customer
    */
    @Override
    public long getGroupId() {
        return _customer.getGroupId();
    }

    /**
    * Sets the group ID of this customer.
    *
    * @param groupId the group ID of this customer
    */
    @Override
    public void setGroupId(long groupId) {
        _customer.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this customer.
    *
    * @return the company ID of this customer
    */
    @Override
    public long getCompanyId() {
        return _customer.getCompanyId();
    }

    /**
    * Sets the company ID of this customer.
    *
    * @param companyId the company ID of this customer
    */
    @Override
    public void setCompanyId(long companyId) {
        _customer.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this customer.
    *
    * @return the user ID of this customer
    */
    @Override
    public long getUserId() {
        return _customer.getUserId();
    }

    /**
    * Sets the user ID of this customer.
    *
    * @param userId the user ID of this customer
    */
    @Override
    public void setUserId(long userId) {
        _customer.setUserId(userId);
    }

    /**
    * Returns the user uuid of this customer.
    *
    * @return the user uuid of this customer
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customer.getUserUuid();
    }

    /**
    * Sets the user uuid of this customer.
    *
    * @param userUuid the user uuid of this customer
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _customer.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this customer.
    *
    * @return the user name of this customer
    */
    @Override
    public java.lang.String getUserName() {
        return _customer.getUserName();
    }

    /**
    * Sets the user name of this customer.
    *
    * @param userName the user name of this customer
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _customer.setUserName(userName);
    }

    /**
    * Returns the create date of this customer.
    *
    * @return the create date of this customer
    */
    @Override
    public java.util.Date getCreateDate() {
        return _customer.getCreateDate();
    }

    /**
    * Sets the create date of this customer.
    *
    * @param createDate the create date of this customer
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _customer.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this customer.
    *
    * @return the modified date of this customer
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _customer.getModifiedDate();
    }

    /**
    * Sets the modified date of this customer.
    *
    * @param modifiedDate the modified date of this customer
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _customer.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this customer.
    *
    * @return the name of this customer
    */
    @Override
    public java.lang.String getName() {
        return _customer.getName();
    }

    /**
    * Sets the name of this customer.
    *
    * @param name the name of this customer
    */
    @Override
    public void setName(java.lang.String name) {
        _customer.setName(name);
    }

    /**
    * Returns the mobile of this customer.
    *
    * @return the mobile of this customer
    */
    @Override
    public java.lang.String getMobile() {
        return _customer.getMobile();
    }

    /**
    * Sets the mobile of this customer.
    *
    * @param mobile the mobile of this customer
    */
    @Override
    public void setMobile(java.lang.String mobile) {
        _customer.setMobile(mobile);
    }

    /**
    * Returns the national code of this customer.
    *
    * @return the national code of this customer
    */
    @Override
    public java.lang.String getNationalCode() {
        return _customer.getNationalCode();
    }

    /**
    * Sets the national code of this customer.
    *
    * @param nationalCode the national code of this customer
    */
    @Override
    public void setNationalCode(java.lang.String nationalCode) {
        _customer.setNationalCode(nationalCode);
    }

    /**
    * Returns the email of this customer.
    *
    * @return the email of this customer
    */
    @Override
    public java.lang.String getEmail() {
        return _customer.getEmail();
    }

    /**
    * Sets the email of this customer.
    *
    * @param email the email of this customer
    */
    @Override
    public void setEmail(java.lang.String email) {
        _customer.setEmail(email);
    }

    /**
    * Returns the card of this customer.
    *
    * @return the card of this customer
    */
    @Override
    public java.lang.String getCard() {
        return _customer.getCard();
    }

    /**
    * Sets the card of this customer.
    *
    * @param card the card of this customer
    */
    @Override
    public void setCard(java.lang.String card) {
        _customer.setCard(card);
    }

    /**
    * Returns the score of this customer.
    *
    * @return the score of this customer
    */
    @Override
    public int getScore() {
        return _customer.getScore();
    }

    /**
    * Sets the score of this customer.
    *
    * @param score the score of this customer
    */
    @Override
    public void setScore(int score) {
        _customer.setScore(score);
    }

    /**
    * Returns the status of this customer.
    *
    * @return the status of this customer
    */
    @Override
    public int getStatus() {
        return _customer.getStatus();
    }

    /**
    * Sets the status of this customer.
    *
    * @param status the status of this customer
    */
    @Override
    public void setStatus(int status) {
        _customer.setStatus(status);
    }

    /**
    * Returns the customer user ID of this customer.
    *
    * @return the customer user ID of this customer
    */
    @Override
    public long getCustomerUserId() {
        return _customer.getCustomerUserId();
    }

    /**
    * Sets the customer user ID of this customer.
    *
    * @param customerUserId the customer user ID of this customer
    */
    @Override
    public void setCustomerUserId(long customerUserId) {
        _customer.setCustomerUserId(customerUserId);
    }

    /**
    * Returns the customer user uuid of this customer.
    *
    * @return the customer user uuid of this customer
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getCustomerUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customer.getCustomerUserUuid();
    }

    /**
    * Sets the customer user uuid of this customer.
    *
    * @param customerUserUuid the customer user uuid of this customer
    */
    @Override
    public void setCustomerUserUuid(java.lang.String customerUserUuid) {
        _customer.setCustomerUserUuid(customerUserUuid);
    }

    /**
    * Returns the mentor customer ID of this customer.
    *
    * @return the mentor customer ID of this customer
    */
    @Override
    public long getMentorCustomerId() {
        return _customer.getMentorCustomerId();
    }

    /**
    * Sets the mentor customer ID of this customer.
    *
    * @param mentorCustomerId the mentor customer ID of this customer
    */
    @Override
    public void setMentorCustomerId(long mentorCustomerId) {
        _customer.setMentorCustomerId(mentorCustomerId);
    }

    @Override
    public boolean isNew() {
        return _customer.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _customer.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _customer.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _customer.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _customer.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _customer.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _customer.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _customer.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _customer.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _customer.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _customer.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CustomerWrapper((Customer) _customer.clone());
    }

    @Override
    public int compareTo(com.arman.csb.modules.model.Customer customer) {
        return _customer.compareTo(customer);
    }

    @Override
    public int hashCode() {
        return _customer.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.arman.csb.modules.model.Customer> toCacheModel() {
        return _customer.toCacheModel();
    }

    @Override
    public com.arman.csb.modules.model.Customer toEscapedModel() {
        return new CustomerWrapper(_customer.toEscapedModel());
    }

    @Override
    public com.arman.csb.modules.model.Customer toUnescapedModel() {
        return new CustomerWrapper(_customer.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _customer.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _customer.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _customer.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CustomerWrapper)) {
            return false;
        }

        CustomerWrapper customerWrapper = (CustomerWrapper) obj;

        if (Validator.equals(_customer, customerWrapper._customer)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _customer.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Customer getWrappedCustomer() {
        return _customer;
    }

    @Override
    public Customer getWrappedModel() {
        return _customer;
    }

    @Override
    public void resetOriginalValues() {
        _customer.resetOriginalValues();
    }
}
