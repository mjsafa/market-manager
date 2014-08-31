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
