create table CSB_ContentHolder (
	uuid_ varchar(75),
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	head varchar(75),
	bottom varchar(75),
	htmlContent varchar(75)
);

create table CSB_Template (
	uuid_ varchar(75),
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	name varchar(75),
	head varchar(75),
	bottom varchar(75),
	htmlContent varchar(75)
);
