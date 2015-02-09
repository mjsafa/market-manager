package com.arman.csb.modules.model;

import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;

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


public class PaymentClp extends BaseModelImpl<Payment> implements Payment {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _description;
    private String _card;
    private long _amount;
    private int _status;
    private Date _paymentDate;
    private long _customerId;
    private long _factorId;
    private BaseModel<?> _paymentRemoteModel;

    public PaymentClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Payment.class;
    }

    @Override
    public String getModelClassName() {
        return Payment.class.getName();
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
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("description", getDescription());
        attributes.put("card", getCard());
        attributes.put("amount", getAmount());
        attributes.put("status", getStatus());
        attributes.put("paymentDate", getPaymentDate());
        attributes.put("customerId", getCustomerId());
        attributes.put("factorId", getFactorId());

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

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String card = (String) attributes.get("card");

        if (card != null) {
            setCard(card);
        }

        Long amount = (Long) attributes.get("amount");

        if (amount != null) {
            setAmount(amount);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date paymentDate = (Date) attributes.get("paymentDate");

        if (paymentDate != null) {
            setPaymentDate(paymentDate);
        }

        Long customerId = (Long) attributes.get("customerId");

        if (customerId != null) {
            setCustomerId(customerId);
        }

        Long factorId = (Long) attributes.get("factorId");

        if (factorId != null) {
            setFactorId(factorId);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_paymentRemoteModel, uuid);
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

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_paymentRemoteModel, id);
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

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_paymentRemoteModel, groupId);
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

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_paymentRemoteModel, companyId);
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

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_paymentRemoteModel, userId);
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
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_paymentRemoteModel, createDate);
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

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_paymentRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_paymentRemoteModel, description);
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

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setCard", String.class);

                method.invoke(_paymentRemoteModel, card);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAmount() {
        return _amount;
    }

    @Override
    public void setAmount(long amount) {
        _amount = amount;

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setAmount", long.class);

                method.invoke(_paymentRemoteModel, amount);
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

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_paymentRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getPaymentDate() {
        return _paymentDate;
    }

    @Override
    public void setPaymentDate(Date paymentDate) {
        _paymentDate = paymentDate;

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setPaymentDate", Date.class);

                method.invoke(_paymentRemoteModel, paymentDate);
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

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setCustomerId", long.class);

                method.invoke(_paymentRemoteModel, customerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFactorId() {
        return _factorId;
    }

    @Override
    public void setFactorId(long factorId) {
        _factorId = factorId;

        if (_paymentRemoteModel != null) {
            try {
                Class<?> clazz = _paymentRemoteModel.getClass();

                Method method = clazz.getMethod("setFactorId", long.class);

                method.invoke(_paymentRemoteModel, factorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Payment.class.getName()));
    }

    public BaseModel<?> getPaymentRemoteModel() {
        return _paymentRemoteModel;
    }

    public void setPaymentRemoteModel(BaseModel<?> paymentRemoteModel) {
        _paymentRemoteModel = paymentRemoteModel;
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

        Class<?> remoteModelClass = _paymentRemoteModel.getClass();

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

        Object returnValue = method.invoke(_paymentRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PaymentLocalServiceUtil.addPayment(this);
        } else {
            PaymentLocalServiceUtil.updatePayment(this);
        }
    }

    @Override
    public Payment toEscapedModel() {
        return (Payment) ProxyUtil.newProxyInstance(Payment.class.getClassLoader(),
            new Class[] { Payment.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PaymentClp clone = new PaymentClp();

        clone.setUuid(getUuid());
        clone.setId(getId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setDescription(getDescription());
        clone.setCard(getCard());
        clone.setAmount(getAmount());
        clone.setStatus(getStatus());
        clone.setPaymentDate(getPaymentDate());
        clone.setCustomerId(getCustomerId());
        clone.setFactorId(getFactorId());

        return clone;
    }

    @Override
    public int compareTo(Payment payment) {
        long primaryKey = payment.getPrimaryKey();

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

        if (!(obj instanceof PaymentClp)) {
            return false;
        }

        PaymentClp payment = (PaymentClp) obj;

        long primaryKey = payment.getPrimaryKey();

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
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", card=");
        sb.append(getCard());
        sb.append(", amount=");
        sb.append(getAmount());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", paymentDate=");
        sb.append(getPaymentDate());
        sb.append(", customerId=");
        sb.append(getCustomerId());
        sb.append(", factorId=");
        sb.append(getFactorId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.arman.csb.modules.model.Payment");
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
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>card</column-name><column-value><![CDATA[");
        sb.append(getCard());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>amount</column-name><column-value><![CDATA[");
        sb.append(getAmount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>paymentDate</column-name><column-value><![CDATA[");
        sb.append(getPaymentDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>customerId</column-name><column-value><![CDATA[");
        sb.append(getCustomerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>factorId</column-name><column-value><![CDATA[");
        sb.append(getFactorId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
