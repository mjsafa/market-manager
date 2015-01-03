create index IX_9B46FB26 on CSBModules_Customer (id_);
create index IX_7DEA3C86 on CSBModules_Customer (uuid_);
create index IX_130ED7E2 on CSBModules_Customer (uuid_, companyId);
create unique index IX_40CFEEE4 on CSBModules_Customer (uuid_, groupId);

create index IX_36E94CF2 on CSBModules_MyBlog ();

create index IX_7D135D26 on CSBModules_Score (uuid_);
create index IX_33F91342 on CSBModules_Score (uuid_, companyId);
create unique index IX_1BD18244 on CSBModules_Score (uuid_, groupId);

create index IX_2F992C29 on CSB_ContentHolder (companyId, name);
create index IX_C41B4A76 on CSB_ContentHolder (uuid_);
create index IX_F02EB3F2 on CSB_ContentHolder (uuid_, companyId);
create unique index IX_21578EF4 on CSB_ContentHolder (uuid_, groupId);

create index IX_A9A35F9B on CSB_Template (companyId);
create index IX_81336A7 on CSB_Template (uuid_);
create index IX_994BEF21 on CSB_Template (uuid_, companyId);
create unique index IX_D997C9E3 on CSB_Template (uuid_, groupId);