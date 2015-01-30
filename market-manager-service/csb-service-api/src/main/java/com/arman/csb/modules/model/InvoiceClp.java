package com.arman.csb.modules.model;

import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.InvoiceLocalServiceUtil;

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


public class InvoiceClp extends BaseModelImpl<Invoice> implements Invoice {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _customerId;
    private String _address;
    private String _telephone;
    private String _mobile;
    private Short _typeOfDelivery;
    private int _status;
    private BaseModel<?> _invoiceRemoteModel;

    public InvoiceClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Invoice.class;
    }

    @Override
    public String getModelClassName() {
        return Invoice.class.getName();
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
        attributes.put("customerId", getCustomerId());
        attributes.put("address", getAddress());
        attributes.put("telephone", getTelephone());
        attributes.put("mobile", getMobile());
        attributes.put("typeOfDelivery", getTypeOfDelivery());
        attributes.put("status", getStatus());

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

        Long customerId = (Long) attributes.get("customerId");

        if (customerId != null) {
            setCustomerId(customerId);
        }

        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }

        String telephone = (String) attributes.get("telephone");

        if (telephone != null) {
            setTelephone(telephone);
        }

        String mobile = (String) attributes.get("mobile");

        if (mobile != null) {
            setMobile(mobile);
        }

        Short typeOfDelivery = (Short) attributes.get("typeOfDelivery");

        if (typeOfDelivery != null) {
            setTypeOfDelivery(typeOfDelivery);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_invoiceRemoteModel, uuid);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_invoiceRemoteModel, id);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_invoiceRemoteModel, groupId);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_invoiceRemoteModel, companyId);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_invoiceRemoteModel, userId);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_invoiceRemoteModel, userName);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_invoiceRemoteModel, createDate);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_invoiceRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCustomerId() {
        return _customerId;
    }

    @Override
    public void setCustomerId(long customerId) {
        _customerId = customerId;

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setCustomerId", long.class);

                method.invoke(_invoiceRemoteModel, customerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAddress() {
        return _address;
    }

    @Override
    public void setAddress(String address) {
        _address = address;

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setAddress", String.class);

                method.invoke(_invoiceRemoteModel, address);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTelephone() {
        return _telephone;
    }

    @Override
    public void setTelephone(String telephone) {
        _telephone = telephone;

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setTelephone", String.class);

                method.invoke(_invoiceRemoteModel, telephone);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setMobile", String.class);

                method.invoke(_invoiceRemoteModel, mobile);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Short getTypeOfDelivery() {
        return _typeOfDelivery;
    }

    @Override
    public void setTypeOfDelivery(Short typeOfDelivery) {
        _typeOfDelivery = typeOfDelivery;

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setTypeOfDelivery", Short.class);

                method.invoke(_invoiceRemoteModel, typeOfDelivery);
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

        if (_invoiceRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_invoiceRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Invoice.class.getName()));
    }

    public BaseModel<?> getInvoiceRemoteModel() {
        return _invoiceRemoteModel;
    }

    public void setInvoiceRemoteModel(BaseModel<?> invoiceRemoteModel) {
        _invoiceRemoteModel = invoiceRemoteModel;
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

        Class<?> remoteModelClass = _invoiceRemoteModel.getClass();

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

        Object returnValue = method.invoke(_invoiceRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            InvoiceLocalServiceUtil.addInvoice(this);
        } else {
            InvoiceLocalServiceUtil.updateInvoice(this);
        }
    }

    @Override
    public Invoice toEscapedModel() {
        return (Invoice) ProxyUtil.newProxyInstance(Invoice.class.getClassLoader(),
            new Class[] { Invoice.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        InvoiceClp clone = new InvoiceClp();

        clone.setUuid(getUuid());
        clone.setId(getId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setCustomerId(getCustomerId());
        clone.setAddress(getAddress());
        clone.setTelephone(getTelephone());
        clone.setMobile(getMobile());
        clone.setTypeOfDelivery(getTypeOfDelivery());
        clone.setStatus(getStatus());

        return clone;
    }

    @Override
    public int compareTo(Invoice invoice) {
        long primaryKey = invoice.getPrimaryKey();

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

        if (!(obj instanceof InvoiceClp)) {
            return false;
        }

        InvoiceClp invoice = (InvoiceClp) obj;

        long primaryKey = invoice.getPrimaryKey();

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
        StringBundler sb = new StringBundler(29);

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
        sb.append(", customerId=");
        sb.append(getCustomerId());
        sb.append(", address=");
        sb.append(getAddress());
        sb.append(", telephone=");
        sb.append(getTelephone());
        sb.append(", mobile=");
        sb.append(getMobile());
        sb.append(", typeOfDelivery=");
        sb.append(getTypeOfDelivery());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.arman.csb.modules.model.Invoice");
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
            "<column><column-name>customerId</column-name><column-value><![CDATA[");
        sb.append(getCustomerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>address</column-name><column-value><![CDATA[");
        sb.append(getAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>telephone</column-name><column-value><![CDATA[");
        sb.append(getTelephone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mobile</column-name><column-value><![CDATA[");
        sb.append(getMobile());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>typeOfDelivery</column-name><column-value><![CDATA[");
        sb.append(getTypeOfDelivery());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
