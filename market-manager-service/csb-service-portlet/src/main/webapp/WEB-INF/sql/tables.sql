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