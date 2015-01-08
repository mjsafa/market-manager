package com.arman.csb.modules.model;

import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CustomerClp extends BaseModelImpl<Customer> implements Customer {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _firstName;
    private String _lastName;
    private String _mobile;
    private String _nationalCode;
    private String _email;
    private String _card;
    private int _score;
    private int _status;
    private long _customerUserId;
    private String _customerUserUuid;
    private long _mentorCustomerId;
    private BaseModel<?> _customerRemoteModel;

    public CustomerClp() {
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
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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
        attributes.put("firstName", getFirstName());
        attributes.put("lastName", getLastName());
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

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_customerRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_customerRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_customerRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_customerRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_customerRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_customerRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_customerRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_customerRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_customerRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFirstName() {
        return _firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstName", String.class);

                method.invoke(_customerRemoteModel, firstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLastName() {
        return _lastName;
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setLastName", String.class);

                method.invoke(_customerRemoteModel, lastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMobile() {
        return _mobile;
    }

    @Override
    public void setMobile(String mobile) {
        _mobile = mobile;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setMobile", String.class);

                method.invoke(_customerRemoteModel, mobile);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNationalCode() {
        return _nationalCode;
    }

    @Override
    public void setNationalCode(String nationalCode) {
        _nationalCode = nationalCode;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setNationalCode", String.class);

                method.invoke(_customerRemoteModel, nationalCode);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_customerRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCard() {
        return _card;
    }

    @Override
    public void setCard(String card) {
        _card = card;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setCard", String.class);

                method.invoke(_customerRemoteModel, card);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getScore() {
        return _score;
    }

    @Override
    public void setScore(int score) {
        _score = score;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setScore", int.class);

                method.invoke(_customerRemoteModel, score);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_customerRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCustomerUserId() {
        return _customerUserId;
    }

    @Override
    public void setCustomerUserId(long customerUserId) {
        _customerUserId = customerUserId;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setCustomerUserId", long.class);

                method.invoke(_customerRemoteModel, customerUserId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCustomerUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getCustomerUserId(), "uuid",
            _customerUserUuid);
    }

    @Override
    public void setCustomerUserUuid(String customerUserUuid) {
        _customerUserUuid = customerUserUuid;
    }

    @Override
    public long getMentorCustomerId() {
        return _mentorCustomerId;
    }

    @Override
    public void setMentorCustomerId(long mentorCustomerId) {
        _mentorCustomerId = mentorCustomerId;

        if (_customerRemoteModel != null) {
            try {
                Class<?> clazz = _customerRemoteModel.getClass();

                Method method = clazz.getMethod("setMentorCustomerId",
                        long.class);

                method.invoke(_customerRemoteModel, mentorCustomerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Customer.class.getName()));
    }

    public BaseModel<?> getCustomerRemoteModel() {
        return _customerRemoteModel;
    }

    public void setCustomerRemoteModel(BaseModel<?> customerRemoteModel) {
        _customerRemoteModel = customerRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _customerRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_customerRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CustomerLocalServiceUtil.addCustomer(this);
        } else {
            CustomerLocalServiceUtil.updateCustomer(this);
        }
    }

    @Override
    public Customer toEscapedModel() {
        return (Customer) ProxyUtil.newProxyInstance(Customer.class.getClassLoader(),
            new Class[] { Customer.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CustomerClp clone = new CustomerClp();

        clone.setUuid(getUuid());
        clone.setId(getId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setName(getName());
        clone.setFirstName(getFirstName());
        clone.setLastName(getLastName());
        clone.setMobile(getMobile());
        clone.setNationalCode(getNationalCode());
        clone.setEmail(getEmail());
        clone.setCard(getCard());
        clone.setScore(getScore());
        clone.setStatus(getStatus());
        clone.setCustomerUserId(getCustomerUserId());
        clone.setMentorCustomerId(getMentorCustomerId());

        return clone;
    }

    @Override
    public int compareTo(Customer customer) {
        long primaryKey = customer.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CustomerClp)) {
            return false;
        }

        CustomerClp customer = (CustomerClp) obj;

        long primaryKey = customer.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(39);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append(", mobile=");
        sb.append(getMobile());
        sb.append(", nationalCode=");
        sb.append(getNationalCode());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", card=");
        sb.append(getCard());
        sb.append(", score=");
        sb.append(getScore());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", customerUserId=");
        sb.append(getCustomerUserId());
        sb.append(", mentorCustomerId=");
        sb.append(getMentorCustomerId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(61);

        sb.append("<model><model-name>");
        sb.append("com.arman.csb.modules.model.Customer");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mobile</column-name><column-value><![CDATA[");
        sb.append(getMobile());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nationalCode</column-name><column-value><![CDATA[");
        sb.append(getNationalCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>card</column-name><column-value><![CDATA[");
        sb.append(getCard());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>score</column-name><column-value><![CDATA[");
        sb.append(getScore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>customerUserId</column-name><column-value><![CDATA[");
        sb.append(getCustomerUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mentorCustomerId</column-name><column-value><![CDATA[");
        sb.append(getMentorCustomerId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
