drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table CSB_ContentHolder (
	uuid_ VARCHAR2(75 CHAR) null,
	id_ number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name VARCHAR2(75 CHAR) null,
	head VARCHAR2(75 CHAR) null,
	bottom VARCHAR2(75 CHAR) null,
	htmlContent VARCHAR2(75 CHAR) null
);

create table CSB_Template (
	uuid_ VARCHAR2(75 CHAR) null,
	id_ number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name VARCHAR2(75 CHAR) null,
	head VARCHAR2(75 CHAR) null,
	bottom VARCHAR2(75 CHAR) null,
	htmlContent VARCHAR2(75 CHAR) null
);


create index IX_C41B4A76 on CSB_ContentHolder (uuid_);
create index IX_F02EB3F2 on CSB_ContentHolder (uuid_, companyId);
create unique index IX_21578EF4 on CSB_ContentHolder (uuid_, groupId);

create index IX_81336A7 on CSB_Template (uuid_);
create index IX_994BEF21 on CSB_Template (uuid_, companyId);
create unique index IX_D997C9E3 on CSB_Template (uuid_, groupId);



quit