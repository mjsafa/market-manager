create index IX_9BB9A3B on CSBModules_Customer (customerId);
create index IX_933615A6 on CSBModules_Customer (customerUserId);
create index IX_F6299F2C on CSBModules_Customer (factorId);
create index IX_9B46FB26 on CSBModules_Customer (id_);
create index IX_A6B0949C on CSBModules_Customer (mentorCustomerId);
create index IX_7DEA3C86 on CSBModules_Customer (uuid_);
create index IX_130ED7E2 on CSBModules_Customer (uuid_, companyId);
create unique index IX_40CFEEE4 on CSBModules_Customer (uuid_, groupId);

create index IX_DD25BDE5 on CSBModules_Instance (groupId);
create index IX_638A0864 on CSBModules_Instance (name);
create index IX_2BA17B9F on CSBModules_Instance (userId);
create index IX_A1EB85AF on CSBModules_Instance (uuid_);
create index IX_F8096B19 on CSBModules_Instance (uuid_, companyId);
create unique index IX_1EF3E3DB on CSBModules_Instance (uuid_, groupId);

create index IX_BE9A9176 on CSBModules_Invoice (customerId);
create index IX_13D36C63 on CSBModules_Invoice (userId);
create index IX_5F166C6B on CSBModules_Invoice (uuid_);
create index IX_7DA836DD on CSBModules_Invoice (uuid_, companyId);
create unique index IX_F29AD09F on CSBModules_Invoice (uuid_, groupId);

create index IX_6595373C on CSBModules_InvoiceItem (invoiceId);
create index IX_D6ED0018 on CSBModules_InvoiceItem (uuid_);

create index IX_36E94CF2 on CSBModules_MyBlog ();

create index IX_E5E5108F on CSBModules_Payment (customerId);
create index IX_A5249A80 on CSBModules_Payment (factorId);
create index IX_F1DAFC0E on CSBModules_Payment (groupId, status);
create index IX_D06446A8 on CSBModules_Payment (status);
create index IX_59DD21B2 on CSBModules_Payment (uuid_);
create index IX_E7533F36 on CSBModules_Payment (uuid_, companyId);
create unique index IX_63EE1B38 on CSBModules_Payment (uuid_, groupId);

create index IX_6EBD7D77 on CSBModules_Product (code_);
create index IX_CB4401EA on CSBModules_Product (name);
create index IX_8CC32BA5 on CSBModules_Product (userId);
create index IX_3170BCE9 on CSBModules_Product (uuid_);
create index IX_DC2B4B9F on CSBModules_Product (uuid_, companyId);
create unique index IX_55002DE1 on CSBModules_Product (uuid_, groupId);

create index IX_C84DDD9B on CSBModules_Score (customerId);
create index IX_955A17DA on CSBModules_Score (customerId, type_);
create index IX_7D135D26 on CSBModules_Score (uuid_);
create index IX_33F91342 on CSBModules_Score (uuid_, companyId);
create unique index IX_1BD18244 on CSBModules_Score (uuid_, groupId);

create index IX_1D9F53B4 on CSBModules_UserActivity (action);
create index IX_30B0221 on CSBModules_UserActivity (entity);
create index IX_706F3FC4 on CSBModules_UserActivity (userId);
create index IX_DDF228EA on CSBModules_UserActivity (uuid_);
create index IX_FE8004FE on CSBModules_UserActivity (uuid_, companyId);
create unique index IX_19A1B300 on CSBModules_UserActivity (uuid_, groupId);

create index IX_2F992C29 on CSB_ContentHolder (companyId, name);
create index IX_C41B4A76 on CSB_ContentHolder (uuid_);
create index IX_F02EB3F2 on CSB_ContentHolder (uuid_, companyId);
create unique index IX_21578EF4 on CSB_ContentHolder (uuid_, groupId);

create index IX_A9A35F9B on CSB_Template (companyId);
create index IX_81336A7 on CSB_Template (uuid_);
create index IX_994BEF21 on CSB_Template (uuid_, companyId);
create unique index IX_D997C9E3 on CSB_Template (uuid_, groupId);