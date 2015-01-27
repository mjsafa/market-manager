package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.Invoice;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Invoice in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Invoice
 * @generated
 */
public class InvoiceCacheModel implements CacheModel<Invoice>, Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public long customerId;
    public String address;
    public String telephone;
    public String mobile;
    public Short typeOfDelivery;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", id=");
        sb.append(id);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", customerId=");
        sb.append(customerId);
        sb.append(", address=");
        sb.append(address);
        sb.append(", telephone=");
        sb.append(telephone);
        sb.append(", mobile=");
        sb.append(mobile);
        sb.append(", typeOfDelivery=");
        sb.append(typeOfDelivery);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Invoice toEntityModel() {
        InvoiceImpl invoiceImpl = new InvoiceImpl();

        if (uuid == null) {
            invoiceImpl.setUuid(StringPool.BLANK);
        } else {
            invoiceImpl.setUuid(uuid);
        }

        invoiceImpl.setId(id);
        invoiceImpl.setGroupId(groupId);
        invoiceImpl.setCompanyId(companyId);
        invoiceImpl.setUserId(userId);

        if (userName == null) {
            invoiceImpl.setUserName(StringPool.BLANK);
        } else {
            invoiceImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            invoiceImpl.setCreateDate(null);
        } else {
            invoiceImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            invoiceImpl.setModifiedDate(null);
        } else {
            invoiceImpl.setModifiedDate(new Date(modifiedDate));
        }

        invoiceImpl.setCustomerId(customerId);

        if (address == null) {
            invoiceImpl.setAddress(StringPool.BLANK);
        } else {
            invoiceImpl.setAddress(address);
        }

        if (telephone == null) {
            invoiceImpl.setTelephone(StringPool.BLANK);
        } else {
            invoiceImpl.setTelephone(telephone);
        }

        if (mobile == null) {
            invoiceImpl.setMobile(StringPool.BLANK);
        } else {
            invoiceImpl.setMobile(mobile);
        }

        invoiceImpl.setTypeOfDelivery(typeOfDelivery);
        invoiceImpl.setStatus(status);

        invoiceImpl.resetOriginalValues();

        return invoiceImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        id = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        customerId = objectInput.readLong();
        address = objectInput.readUTF();
        telephone = objectInput.readUTF();
        mobile = objectInput.readUTF();
        typeOfDelivery = objectInput.readShort();
        status = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(id);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeLong(customerId);

        if (address == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(address);
        }

        if (telephone == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(telephone);
        }

        if (mobile == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mobile);
        }

        objectOutput.writeShort(typeOfDelivery);
        objectOutput.writeInt(status);
    }
}
