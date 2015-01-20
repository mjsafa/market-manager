create index IX_C41B4A76 on CSB_ContentHolder (uuid_);
create index IX_F02EB3F2 on CSB_ContentHolder (uuid_, companyId);
create unique index IX_21578EF4 on CSB_ContentHolder (uuid_, groupId);

create index IX_81336A7 on CSB_Template (uuid_);
create index IX_994BEF21 on CSB_Template (uuid_, companyId);
create unique index IX_D997C9E3 on CSB_Template (uuid_, groupId);
