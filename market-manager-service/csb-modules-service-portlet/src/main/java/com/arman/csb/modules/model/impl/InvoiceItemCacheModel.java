package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.InvoiceItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing InvoiceItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceItem
 * @generated
 */
public class InvoiceItemCacheModel implements CacheModel<InvoiceItem>,
    Externalizable {
    public String uuid;
    public long id;
    public long createDate;
    public long modifiedDate;
    public long invoiceId;
    public long productId;
    public Short number;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", id=");
        sb.append(id);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", invoiceId=");
        sb.append(invoiceId);
        sb.append(", productId=");
        sb.append(productId);
        sb.append(", number=");
        sb.append(number);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public InvoiceItem toEntityModel() {
        InvoiceItemImpl invoiceItemImpl = new InvoiceItemImpl();

        if (uuid == null) {
            invoiceItemImpl.setUuid(StringPool.BLANK);
        } else {
            invoiceItemImpl.setUuid(uuid);
        }

        invoiceItemImpl.setId(id);

        if (createDate == Long.MIN_VALUE) {
            invoiceItemImpl.setCreateDate(null);
        } else {
            invoiceItemImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            invoiceItemImpl.setModifiedDate(null);
        } else {
            invoiceItemImpl.setModifiedDate(new Date(modifiedDate));
        }

        invoiceItemImpl.setInvoiceId(invoiceId);
        invoiceItemImpl.setProductId(productId);
        invoiceItemImpl.setNumber(number);

        invoiceItemImpl.resetOriginalValues();

        return invoiceItemImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        id = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        invoiceId = objectInput.readLong();
        productId = objectInput.readLong();
        number = objectInput.readShort();
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
        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeLong(invoiceId);
        objectOutput.writeLong(productId);
        objectOutput.writeShort(number);
    }
}
