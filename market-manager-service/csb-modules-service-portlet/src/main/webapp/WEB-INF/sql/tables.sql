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
	cardExpireDate DATE null,
	score LONG,
	status INTEGER,
	customerUserId LONG,
	mentorCustomerId LONG
);

create table CSBModules_Invoice (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	address VARCHAR(75) null,
	telephone VARCHAR(75) null,
	mobile VARCHAR(75) null,
	typeOfDelivery INTEGER,
	status INTEGER,
	explain_ VARCHAR(2000) null
);

create table CSBModules_InvoiceItem (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	invoiceId LONG,
	productId LONG,
	number_ INTEGER
);

create table CSBModules_Payment (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	card VARCHAR(75) null,
	amount LONG,
	status INTEGER,
	paymentDate DATE null,
	customerId LONG,
	factorId LONG
);

create table CSBModules_Product (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	basePrice LONG,
	score LONG,
	status INTEGER
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
	value LONG,
	customerId LONG,
	originCustomerId LONG,
	type_ INTEGER
);

create table CSBModules_UserActivity (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	entity VARCHAR(75) null,
	action INTEGER,
	importance INTEGER,
	data_ VARCHAR(2000) null
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