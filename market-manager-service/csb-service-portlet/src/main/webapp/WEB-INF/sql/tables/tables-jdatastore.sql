create table CSB_ContentHolder (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	name varchar(75) null,
	head varchar(75) null,
	bottom varchar(75) null,
	htmlContent varchar(75) null
);

create table CSB_Template (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	modifiedDate date null,
	name varchar(75) null,
	head varchar(75) null,
	bottom varchar(75) null,
	htmlContent varchar(75) null
);
