package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.Payment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Payment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Payment
 * @generated
 */
public class PaymentCacheModel implements CacheModel<Payment>, Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public String description;
    public String card;
    public long amount;
    public int status;
    public long paymentDate;
    public long customerId;
    public long factorId;

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
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", description=");
        sb.append(description);
        sb.append(", card=");
        sb.append(card);
        sb.append(", amount=");
        sb.append(amount);
        sb.append(", status=");
        sb.append(status);
        sb.append(", paymentDate=");
        sb.append(paymentDate);
        sb.append(", customerId=");
        sb.append(customerId);
        sb.append(", factorId=");
        sb.append(factorId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Payment toEntityModel() {
        PaymentImpl paymentImpl = new PaymentImpl();

        if (uuid == null) {
            paymentImpl.setUuid(StringPool.BLANK);
        } else {
            paymentImpl.setUuid(uuid);
        }

        paymentImpl.setId(id);
        paymentImpl.setGroupId(groupId);
        paymentImpl.setCompanyId(companyId);
        paymentImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            paymentImpl.setCreateDate(null);
        } else {
            paymentImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            paymentImpl.setModifiedDate(null);
        } else {
            paymentImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (description == null) {
            paymentImpl.setDescription(StringPool.BLANK);
        } else {
            paymentImpl.setDescription(description);
        }

        if (card == null) {
            paymentImpl.setCard(StringPool.BLANK);
        } else {
            paymentImpl.setCard(card);
        }

        paymentImpl.setAmount(amount);
        paymentImpl.setStatus(status);

        if (paymentDate == Long.MIN_VALUE) {
            paymentImpl.setPaymentDate(null);
        } else {
            paymentImpl.setPaymentDate(new Date(paymentDate));
        }

        paymentImpl.setCustomerId(customerId);
        paymentImpl.setFactorId(factorId);

        paymentImpl.resetOriginalValues();

        return paymentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        id = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        description = objectInput.readUTF();
        card = objectInput.readUTF();
        amount = objectInput.readLong();
        status = objectInput.readInt();
        paymentDate = objectInput.readLong();
        customerId = objectInput.readLong();
        factorId = objectInput.readLong();
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
        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (card == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(card);
        }

        objectOutput.writeLong(amount);
        objectOutput.writeInt(status);
        objectOutput.writeLong(paymentDate);
        objectOutput.writeLong(customerId);
        objectOutput.writeLong(factorId);
    }
}
