package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.Product;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
public class ProductCacheModel implements CacheModel<Product>, Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String code;
    public long basePrice;
    public long score;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

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
        sb.append(", code=");
        sb.append(code);
        sb.append(", basePrice=");
        sb.append(basePrice);
        sb.append(", score=");
        sb.append(score);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Product toEntityModel() {
        ProductImpl productImpl = new ProductImpl();

        if (uuid == null) {
            productImpl.setUuid(StringPool.BLANK);
        } else {
            productImpl.setUuid(uuid);
        }

        productImpl.setId(id);
        productImpl.setGroupId(groupId);
        productImpl.setCompanyId(companyId);
        productImpl.setUserId(userId);

        if (userName == null) {
            productImpl.setUserName(StringPool.BLANK);
        } else {
            productImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            productImpl.setCreateDate(null);
        } else {
            productImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            productImpl.setModifiedDate(null);
        } else {
            productImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            productImpl.setName(StringPool.BLANK);
        } else {
            productImpl.setName(name);
        }

        if (code == null) {
            productImpl.setCode(StringPool.BLANK);
        } else {
            productImpl.setCode(code);
        }

        productImpl.setBasePrice(basePrice);
        productImpl.setScore(score);
        productImpl.setStatus(status);

        productImpl.resetOriginalValues();

        return productImpl;
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
        code = objectInput.readUTF();
        basePrice = objectInput.readLong();
        score = objectInput.readLong();
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

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (code == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(code);
        }

        objectOutput.writeLong(basePrice);
        objectOutput.writeLong(score);
        objectOutput.writeInt(status);
    }
}
