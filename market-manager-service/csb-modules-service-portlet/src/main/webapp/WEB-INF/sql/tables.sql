create table CSBModules_Customer (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	mobile VARCHAR(75) null,
	nationalCode VARCHAR(75) null,
	email VARCHAR(75) null,
	card VARCHAR(75) null,
	score INTEGER,
	status INTEGER,
	customerUserId LONG,
	mentorCustomerId LONG
);

create table CSBModules_Score (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	value INTEGER,
	customerId LONG,
	originCustomerId LONG,
	type_ INTEGER
);

create table CSB_ContentHolder (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	head VARCHAR(75) null,
	bottom VARCHAR(75) null,
	htmlContent VARCHAR(75) null
);

create table CSB_Template (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	head VARCHAR(75) null,
	bottom VARCHAR(75) null,
	htmlContent VARCHAR(75) null
);