package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.Customer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Customer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Customer
 * @generated
 */
public class CustomerCacheModel implements CacheModel<Customer>, Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String firstName;
    public String lastName;
    public String mobile;
    public String nationalCode;
    public String email;
    public String card;
    public long score;
    public int status;
    public long customerUserId;
    public long mentorCustomerId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(39);

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
        sb.append(", name=");
        sb.append(name);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", mobile=");
        sb.append(mobile);
        sb.append(", nationalCode=");
        sb.append(nationalCode);
        sb.append(", email=");
        sb.append(email);
        sb.append(", card=");
        sb.append(card);
        sb.append(", score=");
        sb.append(score);
        sb.append(", status=");
        sb.append(status);
        sb.append(", customerUserId=");
        sb.append(customerUserId);
        sb.append(", mentorCustomerId=");
        sb.append(mentorCustomerId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Customer toEntityModel() {
        CustomerImpl customerImpl = new CustomerImpl();

        if (uuid == null) {
            customerImpl.setUuid(StringPool.BLANK);
        } else {
            customerImpl.setUuid(uuid);
        }

        customerImpl.setId(id);
        customerImpl.setGroupId(groupId);
        customerImpl.setCompanyId(companyId);
        customerImpl.setUserId(userId);

        if (userName == null) {
            customerImpl.setUserName(StringPool.BLANK);
        } else {
            customerImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            customerImpl.setCreateDate(null);
        } else {
            customerImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            customerImpl.setModifiedDate(null);
        } else {
            customerImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            customerImpl.setName(StringPool.BLANK);
        } else {
            customerImpl.setName(name);
        }

        if (firstName == null) {
            customerImpl.setFirstName(StringPool.BLANK);
        } else {
            customerImpl.setFirstName(firstName);
        }

        if (lastName == null) {
            customerImpl.setLastName(StringPool.BLANK);
        } else {
            customerImpl.setLastName(lastName);
        }

        if (mobile == null) {
            customerImpl.setMobile(StringPool.BLANK);
        } else {
            customerImpl.setMobile(mobile);
        }

        if (nationalCode == null) {
            customerImpl.setNationalCode(StringPool.BLANK);
        } else {
            customerImpl.setNationalCode(nationalCode);
        }

        if (email == null) {
            customerImpl.setEmail(StringPool.BLANK);
        } else {
            customerImpl.setEmail(email);
        }

        if (card == null) {
            customerImpl.setCard(StringPool.BLANK);
        } else {
            customerImpl.setCard(card);
        }

        customerImpl.setScore(score);
        customerImpl.setStatus(status);
        customerImpl.setCustomerUserId(customerUserId);
        customerImpl.setMentorCustomerId(mentorCustomerId);

        customerImpl.resetOriginalValues();

        return customerImpl;
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
        name = objectInput.readUTF();
        firstName = objectInput.readUTF();
        lastName = objectInput.readUTF();
        mobile = objectInput.readUTF();
        nationalCode = objectInput.readUTF();
        email = objectInput.readUTF();
        card = objectInput.readUTF();
        score = objectInput.readLong();
        status = objectInput.readInt();
        customerUserId = objectInput.readLong();
        mentorCustomerId = objectInput.readLong();
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

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (firstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstName);
        }

        if (lastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lastName);
        }

        if (mobile == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mobile);
        }

        if (nationalCode == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(nationalCode);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        if (card == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(card);
        }

        objectOutput.writeLong(score);
        objectOutput.writeInt(status);
        objectOutput.writeLong(customerUserId);
        objectOutput.writeLong(mentorCustomerId);
    }
}
