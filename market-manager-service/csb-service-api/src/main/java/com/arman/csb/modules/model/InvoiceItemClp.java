package com.arman.csb.modules.model;

import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.InvoiceItemLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class InvoiceItemClp extends BaseModelImpl<InvoiceItem>
    implements InvoiceItem {
    private String _uuid;
    private long _id;
    private Date _createDate;
    private Date _modifiedDate;
    private long _invoiceId;
    private long _productId;
    private Short _number;
    private BaseModel<?> _invoiceItemRemoteModel;

    public InvoiceItemClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return InvoiceItem.class;
    }

    @Override
    public String getModelClassName() {
        return InvoiceItem.class.getName();
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
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("invoiceId", getInvoiceId());
        attributes.put("productId", getProductId());
        attributes.put("number", getNumber());

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

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Long invoiceId = (Long) attributes.get("invoiceId");

        if (invoiceId != null) {
            setInvoiceId(invoiceId);
        }

        Long productId = (Long) attributes.get("productId");

        if (productId != null) {
            setProductId(productId);
        }

        Short number = (Short) attributes.get("number");

        if (number != null) {
            setNumber(number);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_invoiceItemRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_invoiceItemRemoteModel, uuid);
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

        if (_invoiceItemRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_invoiceItemRemoteModel, id);
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

        if (_invoiceItemRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_invoiceItemRemoteModel, createDate);
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

        if (_invoiceItemRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_invoiceItemRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getInvoiceId() {
        return _invoiceId;
    }

    @Override
    public void setInvoiceId(long invoiceId) {
        _invoiceId = invoiceId;

        if (_invoiceItemRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setInvoiceId", long.class);

                method.invoke(_invoiceItemRemoteModel, invoiceId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getProductId() {
        return _productId;
    }

    @Override
    public void setProductId(long productId) {
        _productId = productId;

        if (_invoiceItemRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setProductId", long.class);

                method.invoke(_invoiceItemRemoteModel, productId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Short getNumber() {
        return _number;
    }

    @Override
    public void setNumber(Short number) {
        _number = number;

        if (_invoiceItemRemoteModel != null) {
            try {
                Class<?> clazz = _invoiceItemRemoteModel.getClass();

                Method method = clazz.getMethod("setNumber", Short.class);

                method.invoke(_invoiceItemRemoteModel, number);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getInvoiceItemRemoteModel() {
        return _invoiceItemRemoteModel;
    }

    public void setInvoiceItemRemoteModel(BaseModel<?> invoiceItemRemoteModel) {
        _invoiceItemRemoteModel = invoiceItemRemoteModel;
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

        Class<?> remoteModelClass = _invoiceItemRemoteModel.getClass();

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

        Object returnValue = method.invoke(_invoiceItemRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            InvoiceItemLocalServiceUtil.addInvoiceItem(this);
        } else {
            InvoiceItemLocalServiceUtil.updateInvoiceItem(this);
        }
    }

    @Override
    public InvoiceItem toEscapedModel() {
        return (InvoiceItem) ProxyUtil.newProxyInstance(InvoiceItem.class.getClassLoader(),
            new Class[] { InvoiceItem.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        InvoiceItemClp clone = new InvoiceItemClp();

        clone.setUuid(getUuid());
        clone.setId(getId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setInvoiceId(getInvoiceId());
        clone.setProductId(getProductId());
        clone.setNumber(getNumber());

        return clone;
    }

    @Override
    public int compareTo(InvoiceItem invoiceItem) {
        long primaryKey = invoiceItem.getPrimaryKey();

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

        if (!(obj instanceof InvoiceItemClp)) {
            return false;
        }

        InvoiceItemClp invoiceItem = (InvoiceItemClp) obj;

        long primaryKey = invoiceItem.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", invoiceId=");
        sb.append(getInvoiceId());
        sb.append(", productId=");
        sb.append(getProductId());
        sb.append(", number=");
        sb.append(getNumber());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.arman.csb.modules.model.InvoiceItem");
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
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>invoiceId</column-name><column-value><![CDATA[");
        sb.append(getInvoiceId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>productId</column-name><column-value><![CDATA[");
        sb.append(getProductId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>number</column-name><column-value><![CDATA[");
        sb.append(getNumber());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
