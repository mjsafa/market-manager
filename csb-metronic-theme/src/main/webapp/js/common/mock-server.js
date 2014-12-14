var newsIdSeq = 0;
var messageIdSeq = 0;
var sequence = 0;
var createDateIdSeq = 200000000000;
var taskEntryIdSeq = 0;
var itemIdSeq = 0;

function callBack(data, options) {
    var defer = $.Deferred();
    setTimeout(function () {
        if (data == undefined) {
            defer.resolve(undefined);
        } else if (_.has(data, 'exception')) {
            ArmanJsManager.trigger("error", data);
            if (options && options.error) {
                options.error(data.exception);
            }
            defer.resolve(undefined);
        } else {
            if (options && options.success) {
                options.success(_.clone(data));
            }
            defer.resolve(_.clone(data));
        }
    }, delay);
    return defer.promise();
}
serverAPI = {
    Cabinet: {
        findTags: function (query, start, end, options) {
            return callBack(
                ["a", "ab", "abc", "abcd", "a1", "ab1", "abc1", "abcd1", "a2", "ab2", "abc2", "abcd2", "a3", "ab3", "abc3", "abcd3", 16]
                , options);
        },
        getCountTask: function (date, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success(Math.floor((Math.random() * 10)) + 1);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        findByParentNodeIdCabinetTree: function (parentNodeId) {
            var data = [
                {"companyId": 10154, "createDate": 1380783316000, "groupId": 11503, "modifiedDate": 1380783316000, "parentNodeId": 0, "title": "nodeItem 0", "treeId": 501, "userId": 10196},
                {"companyId": 10154, "createDate": 1383472182000, "groupId": 0, "modifiedDate": 1383472182000, "parentNodeId": 0, "title": "nodeItem 1", "treeId": 601, "userId": 10196},
                {"companyId": 10154, "createDate": 1383482235000, "groupId": 11426, "modifiedDate": 1383482235000, "parentNodeId": 0, "title": "nodeItem 2", "treeId": 701, "userId": 10196}
            ];
            return callBack(data);
        },
        findByParentNodeIdCabinetTreeItem: function (parentTreeId) {
            var data = [
                {"className": 10013, "classPK": 29318, "classUUID": "8f3a199c-fcf4-49ba-8615-227c4cad9ec9", "companyId": 10154, "createDate": 1404990538000, "groupId": 11503, "itemId": 303, "modifiedDate": 1404990538000, "parentTreeId": 701, "title": "salam", "userId": 10196},
                {"className": 10013, "classPK": 29325, "classUUID": "aa7e67b6-12e9-4887-b23f-71d48e0039ac", "companyId": 10154, "createDate": 1404992288000, "groupId": 11503, "itemId": 304, "modifiedDate": 1404992288000, "parentTreeId": 701, "title": "salam2", "userId": 10196},
                {"className": 10013, "classPK": 29325, "classUUID": "aa7e67b6-12e9-4887-b23f-71d48e0039ac", "companyId": 10154, "createDate": 1404992288000, "groupId": 11503, "itemId": 304, "modifiedDate": 1404992288000, "parentTreeId": 701, "title": "salam3", "userId": 10196}
            ];
            return callBack(data);

        },
        updateTitle: function (nodeId, title) {
            return callBack({});
        },
        deleteItem: function (itemId) {
            return callBack();
        },
        deleteNode: function (nodeId) {
            return callBack();
        },
        updateParentIdCabinetTree: function (nodeId, parentNodeId) {
            return callBack();
        },
        updateParentIdCabinetTreeItem: function (nodeId, parentNodeId) {
            return callBack();
        },
        addCabinetTree: function (title, parentNodeId) {
            var data = {"companyId": 10154, "createDate": 1406017018814, "groupId": 11503, "modifiedDate": 1406017018814, "parentNodeId": parentNodeId, "title": title, "treeId": 901, "userId": 10196};
            return callBack(data);
        },
        findByTag: function (query, start, end, options) {
            var defer = $.Deferred();
            setTimeout(function () {

                options.success(
                    [
                        {"groupId": 11503, "title": "search " + itemIdSeq, "itemId": ++itemIdSeq},
                        {"groupId": 11503, "title": "search " + itemIdSeq, "itemId": ++itemIdSeq},
                        {"groupId": 11503, "title": "search " + itemIdSeq, "itemId": ++itemIdSeq},
                        {"groupId": 11503, "title": "search " + itemIdSeq, "itemId": ++itemIdSeq},
                        {"groupId": 11503, "title": "search " + itemIdSeq, "itemId": ++itemIdSeq},
                        5
                    ]
                );
                defer.resolve();
            }, delay);
            return defer.promise();
        },

        getRecentCabinetTreeItems: function (date, start, end, options) {
            var defer = $.Deferred();
            if (options.afterOrBefore == 0) {
                createDateIdSeq = createDateIdSeq - 1000;
                setTimeout(function () {
                    options.success([
                        {"classPK": 29318, "className": 10013, "createDate": createDateIdSeq, "itemId": ++itemIdSeq, "title": "stream-recent" + options.documentType + " " + itemIdSeq},
                        {"classPK": 29318, "className": 10013, "createDate": createDateIdSeq - 10, "itemId": ++itemIdSeq, "title": "stream-recent" + " " + itemIdSeq},
                        {"classPK": 29318, "className": 10013, "createDate": createDateIdSeq - 20, "itemId": ++itemIdSeq, "title": "stream-recent" + " " + itemIdSeq},
                        {"classPK": 29318, "className": 10013, "createDate": createDateIdSeq - 30, "itemId": ++itemIdSeq, "title": "stream-recent" + " " + itemIdSeq},
                        {"classPK": 29318, "className": 10013, "createDate": createDateIdSeq - 40, "itemId": ++itemIdSeq, "title": "stream-recent" + " " + itemIdSeq},
                        5
                    ]);
                    defer.resolve();
                }, delay);
            } else if (options.afterOrBefore == 1) {
                setTimeout(function () {
                    options.success([
                        {"classPK": 29318, "className": 10013, "createDate": +new Date() + 90, "itemId": ++itemIdSeq, "title": "update&new-recent" + " " + itemIdSeq, parentTreeId: 0},
                        {"classPK": 29318, "className": 10013, "createDate": +new Date() + 80, "itemId": ++itemIdSeq, "title": "update&new-recent" + " " + itemIdSeq, parentTreeId: 0},
                        {"classPK": 29318, "className": 10013, "createDate": +new Date() + 80, "itemId": ++itemIdSeq, "title": "update&new-recent" + " " + itemIdSeq, parentTreeId: 701},
                        {"classPK": 29318, "className": 10013, "createDate": +new Date() + 70, "itemId": ++itemIdSeq, "title": "update&new-recent" + " " + itemIdSeq, parentTreeId: 0},
                        {"classPK": 29318, "className": 10013, "createDate": +new Date() + 60, "itemId": ++itemIdSeq, "title": "update&new-recent" + " " + itemIdSeq, parentTreeId: 0},
                        5
                    ]);
                    defer.resolve();
                }, delay);
            }
            return defer.promise();
        },
        getFavouriteCabinetTreeItems: function (start, end, options) {
            setTimeout(function () {
                options.success([
                    {"classPK": 29318, "className": 10013, "createDate": +new Date() + 90, "itemId": ++itemIdSeq, "title": "new-favourite" + " " + itemIdSeq, parentTreeId: 0},
                    {"classPK": 29318, "className": 10013, "createDate": +new Date() + 80, "itemId": ++itemIdSeq, "title": "new-favourite" + " " + itemIdSeq, parentTreeId: 0},
                    {"classPK": 29318, "className": 10013, "createDate": +new Date() + 80, "itemId": ++itemIdSeq, "title": "new-favourite" + " " + itemIdSeq, parentTreeId: 701},
                    {"classPK": 29318, "className": 10013, "createDate": +new Date() + 70, "itemId": ++itemIdSeq, "title": "new-favourite" + " " + itemIdSeq, parentTreeId: 0},
                    {"classPK": 29318, "className": 10013, "createDate": +new Date() + 60, "itemId": ++itemIdSeq, "title": "new-favourite" + " " + itemIdSeq, parentTreeId: 0},
                    5
                ]);
                defer.resolve();
            }, delay);
        },
        getTagCloud: function () {
            var data =
            {"salam": 4, "khodafez": 1, "test": 3, "havij": 1};
            return callBack(data);
        },
        getSearchTagCloud: function (query) {
            var data =
            {"khodafez": 1, "salam": 4};
            return callBack(data);
        },
        addNoteItem: function (model, options) {
            return callBack(model);
        },
        updatePage: function (model, options) { //wikiPage
            return callBack();
        },
        updateTags: function (itemId, tags, options) {
            return callBack();
        },
        getWikiPageByPageId: function (id) {
            var data = {"companyId": 10154, "content": "<p><s><u><em><strong>che khabar?</strong></em></u></s></p>", "createDate": 1406583272811, "format": "creole", "groupId": 11503, "head": false, "minorEdit": false, "modifiedDate": 1406583272811, "nodeId": 13618, "pageId": 31610, "parentTitle": "", "redirectTitle": "", "resourcePrimKey": 31611, "status": 2, "statusByUserId": 0, "statusByUserName": "", "statusDate": null, "summary": "summaryman", "title": "salamtitle", "userId": 10196, "userName": "Test Test", "uuid": "59f7a374-cf94-4763-b9ff-d8e0981782f0", "version": 1.0};
            return callBack(data);
        },
        getTags: function (className, classPK) {
            var data = [
                {"assetCount": 1, "companyId": 10154, "createDate": 1406583273584, "groupId": 11503, "modifiedDate": 1406583273584, "name": "mehditag", "tagId": 31614, "userId": 10196, "userName": "Test Test"},
                {"assetCount": 1, "companyId": 10154, "createDate": 1406583273606, "groupId": 11503, "modifiedDate": 1406583273606, "name": "mehdi", "tagId": 31616, "userId": 10196, "userName": "Test Test"},
                {"assetCount": 1, "companyId": 10154, "createDate": 1406583273596, "groupId": 11503, "modifiedDate": 1406583273596, "name": "reza", "tagId": 31615, "userId": 10196, "userName": "Test Test"},
                {"assetCount": 1, "companyId": 10154, "createDate": 1406583272841, "groupId": 11503, "modifiedDate": 1406583272841, "name": "khodahafez", "tagId": 31613, "userId": 10196, "userName": "Test Test"}
            ];
            return callBack(data);
        },
        copyNode: function (nodeId, newParentId) {
            return callBack();
        }
    },
    Table: {
        //get-users function
        getTableForGraph: function (tableId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve([
                    { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 11629, "createDate": 1374327804066, "defaultUser": false, "emailAddress": "", "emailAddressVerified": false, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "حسین", "graceLoginCount": 0, "greeting": "Welcome حسین امیری!", "jobTitle": "", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1375082355294, "lastLoginIP": "127.0.0.1", "lastName": "امیری", "lockout": false, "lockoutDate": null, "loginDate": 1375788473699, "loginIP": "127.0.0.1", "middleName": "", "modifiedDate": 1381754238069, "openId": "", "portraitId": 20102, "reminderQueryAnswer": "", "reminderQueryQuestion": "", "screenName": "parian66", "status": 0, "timeZoneId": null, "userId": 11628, "uuid": "0f7b92ee-1952-4f0d-8ef8-0f67cd208239" },
                    { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 10197, "createDate": 1374137798954, "defaultUser": false, "emailAddress": "test@liferay.com", "emailAddressVerified": true, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "Test", "graceLoginCount": 0, "greeting": "Welcome Test Test!", "jobTitle": "ٍEngineer", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1384181006455, "lastLoginIP": "127.0.0.1", "lastName": "Test", "lockout": false, "lockoutDate": null, "loginDate": 1384946666236, "loginIP": "127.0.0.1", "middleName": "", "modifiedDate": 1381754205095, "openId": "", "portraitId": 20101, "reminderQueryAnswer": "morteza", "reminderQueryQuestion": "what-is-your-father's-middle-name", "screenName": "test", "status": 0, "timeZoneId": null, "userId": 10196, "uuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                    { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 11618, "createDate": 1374327742687, "defaultUser": false, "emailAddress": "", "emailAddressVerified": false, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "سجاد", "graceLoginCount": 0, "greeting": "Welcome سجاد صفاییان!", "jobTitle": "", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1378038055333, "lastLoginIP": "192.168.0.133", "lastName": "صفاییان", "lockout": false, "lockoutDate": null, "loginDate": 1378047437133, "loginIP": "192.168.0.133", "middleName": "", "modifiedDate": 1378038256756, "openId": "", "portraitId": 19001, "reminderQueryAnswer": "", "reminderQueryQuestion": "", "screenName": "safairon", "status": 0, "timeZoneId": null, "userId": 11617, "uuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" }
                ]);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        //get-publish-tags function
        getPublishTagsForGraph: function (tableId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve({
                    "{uuid=ef010c3d-faa0-4476-aac3-9d2430fc7a49, publishId=501, groupId=11503, tableId=301, ownerId=10196, itemId=102, companyId=10154, userId=10196, userName=Test Test, createDate=Tue Oct 08 10:34:13 GMT 2013, modifiedDate=Tue Oct 08 10:34:13 GMT 2013, accessLevel=1}": 3,
                    "{uuid=f26a3564-9b97-4b9e-a34d-9b17a7e17757, publishId=301, groupId=11503, tableId=301, ownerId=10196, itemId=101, companyId=10154, userId=10196, userName=Test Test, createDate=Thu Oct 03 12:11:43 GMT 2013, modifiedDate=Thu Oct 03 12:11:43 GMT 2013, accessLevel=1}": 4,
                    "{uuid=ba1cb12f-cf3a-4dc7-9c75-c6995d7d29ff, publishId=302, groupId=11503, tableId=301, ownerId=10196, itemId=101, companyId=10154, userId=10196, userName=Test Test, createDate=Thu Oct 03 12:13:09 GMT 2013, modifiedDate=Thu Oct 03 12:13:09 GMT 2013, accessLevel=1}": 2
                });
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        //arman-js-portlet/publish/get-users function
        getUserConnectedToPublish: function (publishId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve([
                    { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 10197, "createDate": 1374137798954, "defaultUser": false, "emailAddress": "test@liferay.com", "emailAddressVerified": true, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "Test", "graceLoginCount": 0, "greeting": "Welcome Test Test!", "jobTitle": "ٍEngineer", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1384946666236, "lastLoginIP": "127.0.0.1", "lastName": "Test", "lockout": false, "lockoutDate": null, "loginDate": 1384950646138, "loginIP": "127.0.0.1", "middleName": "", "modifiedDate": 1381754205095, "openId": "", "portraitId": 20101, "reminderQueryAnswer": "morteza", "reminderQueryQuestion": "what-is-your-father's-middle-name", "screenName": "test", "status": 0, "timeZoneId": null, "userId": 10196, "uuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                ]);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        //arman-js-portlet/publish/find-by-user-id function
        getDocumentConnectedToUser: function (userId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve([
                    { "accessLevel": 1, "companyId": 10154, "createDate": 1380802303000, "groupId": 11503, "itemId": 101, "modifiedDate": 1380802303000, "ownerId": 10196, "publishId": 301, "tableId": 301, "title": "Note - 1 Title", "userId": 10196, "userName": "Test Test", "uuid": "f26a3564-9b97-4b9e-a34d-9b17a7e17757" },
                    { "accessLevel": 1, "companyId": 10154, "createDate": 1380802389000, "groupId": 11503, "itemId": 101, "modifiedDate": 1380802389000, "ownerId": 10196, "publishId": 302, "tableId": 301, "title": "Note - 1 Title", "userId": 10196, "userName": "Test Test", "uuid": "ba1cb12f-cf3a-4dc7-9c75-c6995d7d29ff" }
                ]);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        //arman-js-portlet/publish/get-publish function
        getPublishItemById: function (taskEntryId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve([
                    { "accessLevel": 1, "companyId": 10154, "createDate": 1381228453000, "groupId": 11503, "itemId": 102, "modifiedDate": 1381228453000, "ownerId": 10196, "publishId": 501, "tableId": 301, "title": "Note - 2 Title", "userId": 10196, "userName": "Test Test", "uuid": "ef010c3d-faa0-4476-aac3-9d2430fc7a49" }
                ]);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        getUserById: function (userId) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve(
                    { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 11629, "createDate": 1374327804066, "defaultUser": false, "emailAddress": "", "emailAddressVerified": false, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "حسین", "graceLoginCount": 0, "greeting": "Welcome حسین امیری!", "jobTitle": "", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1375082355294, "lastLoginIP": "127.0.0.1", "lastName": "امیری", "lockout": false, "lockoutDate": null, "loginDate": 1375788473699, "loginIP": "127.0.0.1", "middleName": "", "modifiedDate": 1381754238069, "openId": "", "portraitId": 20102, "reminderQueryAnswer": "", "reminderQueryQuestion": "", "screenName": "parian66", "status": 0, "timeZoneId": null, "userId": 11628, "uuid": "0f7b92ee-1952-4f0d-8ef8-0f67cd208239" }
                );
                defer.resolve();
            }, delay);
            return defer.promise();

        }
    },
    Task: {
        getAssigneeTasksEntries: function (userId, start, end, options) {
            var defer = $.Deferred();
            if (options.afterOrBefore == 0) {   //stream - before
                createDateIdSeq = createDateIdSeq - 1000;
                setTimeout(function () {
                    options.success([
                        { "assigneeUserId": 11617, "companyId": 10154, "createDate": createDateIdSeq, "dueDate": 1386002700000, "finishDate": 1320657852661, "groupId": 11503, "modifiedDate": 1290158652661, "priority": 2, "resolverUserId": 10196, "status": 6, "tasksEntryId": ++taskEntryIdSeq, "title": "stream-" + options.userType + " " + taskEntryIdSeq, "type": 4, "userId": 1000, "userName": "Test Test1" },
                        { "assigneeUserId": 11617, "companyId": 10154, "createDate": createDateIdSeq - 10, "dueDate": 1386002700000, "finishDate": 1367918653337, "groupId": 11503, "modifiedDate": 1352280253337, "priority": 3, "resolverUserId": 10196, "status": 6, "tasksEntryId": ++taskEntryIdSeq, "title": "stream-" + options.userType + " " + taskEntryIdSeq, "type": 1, "userId": 1000, "userName": "Test Test" },
                        { "assigneeUserId": 11617, "companyId": 10154, "createDate": createDateIdSeq - 20, "dueDate": 1386002700000, "finishDate": 1373189051286, "groupId": 11503, "modifiedDate": 1371461051286, "priority": 1, "resolverUserId": 10196, "status": 6, "tasksEntryId": ++taskEntryIdSeq, "title": "stream-" + options.userType + " " + taskEntryIdSeq, "type": 3, "userId": 10196, "userName": "Test Test" }
                    ]);
                    defer.resolve();
                }, delay);
            } else if (options.afterOrBefore == 1) {   //new+update - after
                setTimeout(function () {
                    options.success([
                        { "assigneeUserId": 11618, "companyId": 10155, "createDate": +new Date() + 20, "dueDate": 1386002700001, "finishDate": 1320657852662, "groupId": 11504, "modifiedDate": 1290158652662, "priority": 1, "resolverUserId": 10197, "status": 6, "tasksEntryId": ++taskEntryIdSeq, "title": "update&new-" + options.userType + " " + taskEntryIdSeq, "type": 3, "userId": 1001, "userName": "Test Test1" },
                        { "assigneeUserId": 11619, "companyId": 10156, "createDate": +new Date() + 10, "dueDate": 1386002700002, "finishDate": 1367918653338, "groupId": 11505, "modifiedDate": 1352280253338, "priority": 2, "resolverUserId": 10198, "status": 5, "tasksEntryId": ++taskEntryIdSeq, "title": "update&new-" + options.userType + " " + taskEntryIdSeq, "type": 1, "userId": 1002, "userName": "Test Test2" },
                        { "assigneeUserId": 11620, "companyId": 10157, "createDate": +new Date(), "dueDate": 1386002700003, "finishDate": 1373189051287, "groupId": 11506, "modifiedDate": 1371461051287, "priority": 3, "resolverUserId": 10199, "status": 4, "tasksEntryId": ++taskEntryIdSeq, "title": "update&new-" + options.userType + " " + taskEntryIdSeq, "type": 2, "userId": 10194, "userName": "Test Test3" }
                    ]);
                    defer.resolve();
                }, delay);
            }
            return defer.promise();
        },
        getAssigneeMapByGroupId: function (groupId, options) {
            var data = {
                "{uuid=64f2a63c-2181-4475-a627-d3645bc2670f, userId=10196, companyId=10154, createDate=Thu Jul 18 08:56:38 GMT 2013, modifiedDate=Mon Oct 14 12:36:45 GMT 2013, defaultUser=false, contactId=10197, password=qUqP5cyxm6YcTAhz05Hph5gvu9M=, passwordEncrypted=true, passwordReset=false, passwordModifiedDate=null, digest=e5d86c6f3672e52795891c3597f20de0,751da756639bc033b572ba2e7849b589,8f3d267131c99bf7ba6ade3481d748b4, reminderQueryQuestion=what-is-your-father's-middle-name, reminderQueryAnswer=morteza, graceLoginCount=0, screenName=test, emailAddress=test@liferay.com, facebookId=0, openId=, portraitId=20101, languageId=en_US, timeZoneId=Pacific/Midway, greeting=Welcome Test Test!, comments=, firstName=Test, middleName=, lastName=Test, jobTitle=ٍEngineer, loginDate=Thu Dec 12 08:32:42 GMT 2013, loginIP=127.0.0.1, lastLoginDate=Thu Dec 12 08:31:21 GMT 2013, lastLoginIP=127.0.0.1, lastFailedLoginDate=null, failedLoginAttempts=0, lockout=false, lockoutDate=null, agreedToTermsOfUse=false, emailAddressVerified=true, status=0}": 4,
                "{uuid=0f7b92ee-1952-4f0d-8ef8-0f67cd208239, userId=11628, companyId=10154, createDate=2013-07-20 13:43:24.066, modifiedDate=2013-10-14 12:37:18.069, defaultUser=false, contactId=11629, password=+ofL3uffq7A+dTce954S9l5Uaao=, passwordEncrypted=true, passwordReset=false, passwordModifiedDate=2013-07-20 14:24:22.932, digest=c73ee2f1fff5fa93048c16306c28b387,7a5d0aafcbf057f6f83d6d8a09c434a4,39b877062b528d9d519240773854b6ed, reminderQueryQuestion=what-is-your-father's-middle-name, reminderQueryAnswer=a, graceLoginCount=0, screenName=parian66, emailAddress=hamiri@armansoft.local, facebookId=0, openId=, portraitId=20102, languageId=en_US, timeZoneId=Pacific/Midway, greeting=Welcome حسین امیری!, comments=, firstName=حسین, middleName=, lastName=امیری, jobTitle=, loginDate=2013-08-06 11:27:53.699, loginIP=127.0.0.1, lastLoginDate=2013-07-29 07:19:15.294, lastLoginIP=127.0.0.1, lastFailedLoginDate=null, failedLoginAttempts=0, lockout=false, lockoutDate=null, agreedToTermsOfUse=false, emailAddressVerified=false, status=0}": 2,
                "{uuid=ae4f7614-d82a-4263-87b2-0d08b102ebb6, userId=11617, companyId=10154, createDate=2013-07-20 13:42:22.687, modifiedDate=2013-09-01 12:24:16.756, defaultUser=false, contactId=11618, password=+ofL3uffq7A+dTce954S9l5Uaao=, passwordEncrypted=true, passwordReset=false, passwordModifiedDate=2013-07-20 14:12:29.574, digest=812d4509f851662d9a3bddd9f32e77fc,929c893a67b002ab725eb6b97cc43a86,ac3869fa4ce5f58d972f054c6b6115ad, reminderQueryQuestion=what-is-your-father's-middle-name, reminderQueryAnswer=a, graceLoginCount=0, screenName=safairon, emailAddress=ssafaeian@armansoft.local, facebookId=0, openId=, portraitId=19001, languageId=fa_IR, timeZoneId=Pacific/Midway, greeting=Welcome سجاد صفاییان!, comments=, firstName=سجاد, middleName=, lastName=صفاییان, jobTitle=, loginDate=2013-09-01 14:57:17.133, loginIP=192.168.0.133, lastLoginDate=2013-09-01 12:20:55.333, lastLoginIP=192.168.0.133, lastFailedLoginDate=null, failedLoginAttempts=0, lockout=false, lockoutDate=null, agreedToTermsOfUse=false, emailAddressVerified=false, status=0}": 3
            };
            return callBack(data, options);
        },
        // Date in ResolvedTask and createdTask is createDate
        //get-map-by-g_-s that status is 6 for resolved task
        getResolvedTask: function (groupId, options) {
            var data = {
                "2013-09-07 00:00:00.0": 1,
                "2013-10-07 00:00:00.0": 2,
                "2011-11-07 00:00:00.0": 1,
                "2013-05-07 00:00:00.0": 2
            };
            return callBack(data, options);
        },
        //get-created-map-by-group-id
        //startDate and EndDate time is 0 to 1000...000
        getCreatedTask: function (groupId, startDate, endDate, options) {
            var data = {
                "2013-10-03 00:00:00.0": 1,
                "2013-06-03 00:00:00.0": 1,
                "2013-02-03 00:00:00.0": 2,
                "2013-09-03 00:00:00.0": 1,
                "2013-07-03 00:00:00.0": 1,
                "2013-01-03 00:00:00.0": 1,
                "2012-11-05 00:00:00.0": 1,
                "2010-11-09 00:00:00.0": 1
            };
            return callBack(data, options);
        },
        updateTaskSliderStatus: function (task, options) {
            console.log("updateTaskSliderStatus");
            return callBack(task.attributes, options);
        },
        updateTasksEntry: function (task, options) {
            console.log("updateTaskContentStatus");
            return callBack(task.attributes, options);
        },
        addTasksEntry: function (model, options) {
            console.log("addTasksEntry");
            return callBack(model.attributes, options);
        },
        getCountTask: function (date, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success(Math.floor((Math.random() * 10)) + 1);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        Search: {
            search: function (query, start, end, options) {
                var defer = $.Deferred();
                createDateIdSeq = createDateIdSeq - 1000;
                setTimeout(function () {
                    options.success([
                        { "assigneeUserId": 11617, "companyId": 10154, "createDate": createDateIdSeq, "dueDate": 1386002700000, "finishDate": 1320657852661, "groupId": 11503, "modifiedDate": 1290158652661, "priority": 2, "resolverUserId": 10196, "status": 2, "tasksEntryId": ++taskEntryIdSeq, "title": "search-" + taskEntryIdSeq, "type": 4, "userId": 1000, "userName": "Test Test1" },
                        { "assigneeUserId": 11617, "companyId": 10154, "createDate": createDateIdSeq - 10, "dueDate": 1386002700000, "finishDate": 1367918653337, "groupId": 11503, "modifiedDate": 1352280253337, "priority": 3, "resolverUserId": 10196, "status": 6, "tasksEntryId": ++taskEntryIdSeq, "title": "search-" + taskEntryIdSeq, "type": 1, "userId": 1000, "userName": "Test Test" },
                        { "assigneeUserId": 11617, "companyId": 10154, "createDate": createDateIdSeq - 20, "dueDate": 1386002700000, "finishDate": 1373189051286, "groupId": 11503, "modifiedDate": 1371461051286, "priority": 1, "resolverUserId": 10196, "status": 4, "tasksEntryId": ++taskEntryIdSeq, "title": "search-" + taskEntryIdSeq, "type": 3, "userId": 10196, "userName": "Test Test" }
                    ]);
                    defer.resolve();
                }, delay);
                return defer.promise();
            }
        }
    },
    Meeting: {
        get: function (meetingId, options) {
            console.log("get meeting#" + meetingId)
            meeting = _.find(meetingList, function (meeting) {
                return meeting.meetingId == meetingId;
            });
            return callBack(meeting, options);
        },
        getUsers: function (meetingId, options) {
            console.log("call getUsers(" + meetingId + ").");
            return callBack(_.filter(userList, function (user) {
                return _.contains(meetingMembership[meetingId], user.userId)
            }), options);
        },
        getLoginUserIds: function (meetingId, options) {
            console.log("call getLoginUsers(" + meetingId + ").");
            return callBack(_.sample(meetingMembership[meetingId], 3), options);
        },
        findByU_S: function (userId, statuses, start, end, options) {
            console.log("call findByUserId(" + userId + "," + start + "," + end + ").");
            var search = _.filter(meetingList, function (meeting) {
                return _.contains(statuses, meeting.status)
            });
            var result = search.slice(start, end);
            result.push(search.length);
            return callBack(result, options);
        },
        add: function (meeting, options) {
            console.log("add meeting '" + meeting.attributes.meetingName + "'");
            meeting.attributes.status = MeetingMembershipConstants.STATUS_NOT_START;
            meeting.attributes.ownerId = userId;
            meeting.attributes.meetingId = ++sequence;
            meetingList.push(meeting.attributes);
            meetingMembership[sequence] = meeting.attributes.members;
            return callBack(meeting.attributes, options);
        },
        edit: function (meeting, options) {
            console.log("edit meeting#" + meeting.attributes.meetingId)
            storeMeeting = _.find(meetingList, function (item) {
                return item.meetingId == meeting.attributes.meetingId;
            });
            storeMeeting.meetingName = meeting.attributes.meetingName;
            storeMeeting.welcomeMessage = meeting.attributes.welcomeMessage;
            storeMeeting.duration = meeting.attributes.duration;
            storeMeeting.startDate = meeting.attributes.startDate;
            storeMeeting.recording = meeting.attributes.recording;
            meetingMembership[storeMeeting.meetingId] = meeting.attributes.members;
            return callBack(storeMeeting, options);
        },
        start: function (meetingId) {
            console.log("start meeting#" + meetingId)
            meeting = _.find(meetingList, function (meeting) {
                return meeting.meetingId == meetingId;
            });
            meeting.status = MeetingMembershipConstants.STATUS_START;
            return callBack({});
        },
        stop: function (meetingId) {
            console.log("stop meeting#" + meetingId)
            meeting = _.find(meetingList, function (meeting) {
                return meeting.meetingId == meetingId;
            });
            meeting.status = MeetingMembershipConstants.STATUS_STOP;
            return callBack({});
        },
        getJoinLink: function (meetingId) {
            console.log("get join link of meeting#" + meetingId)
            return callBack("http://demo.bigbluebutton.org/bigbluebutton/api/join?meetingID=Demo+Meeting&fullName=Test&password=mp&checksum=348adb8ebac01cc82f9f618a46ba0b42b32b55ae");
        },
        join: function (meetingId) {
            console.log("join to meeting#" + meetingId)
            return callBack({});
        },
        delete: function (meetingId) {
            console.log("delete to meeting#" + meetingId)
            meetingMembership.splice(meetingId, 1);
            meeting = _.find(meetingList, function (meeting) {
                return meeting.meetingId == meetingId;
            });
            meetingList.splice(meetingList.indexOf(meeting), 1);
            recordingList.splice(meetingId, 1);
            return callBack({});
        },
        toggle: function (meetingId) {
            console.log("publish meeting#" + meetingId)
            meeting = _.find(meetingList, function (meeting) {
                return meeting.meetingId == meetingId;
            });
            meeting.published = !meeting.published;
            return callBack({});
        }
    },
    System: {
        Language: {
            get: function (key, options) {
//                console.log("call System.Language.get(" + key + ")");
                var res = _.findWhere(messageList, {key: key}) || {value: key};
                return callBack(res.value, options);
            }
        },
        User: {
            searchOutsideGroup: function (query, start, end, options) {
                console.log("call System.User.searchOutsideGroup(" + query + ", " + start + ", " + end + ")");
                var userids = _.pluck(_.filter(membershipList, function (request) {
                    return request.groupId == groupId
                }), "followerId");
                userids.push(userId);
                return callBack(_.filter(userList,
                    function (user) {
                        return !_.contains(userids, user.userId) &&
                            (user.screenName.indexOf(query) !== -1 ||
                                user.firstName.indexOf(query) !== -1 ||
                                user.lastName.indexOf(query) !== -1 ||
                                user.emailaddress.indexOf(query) !== -1)
                    }).slice(start, end), options);
            },
            searchInsideGroup: function (query, start, end, options) {
                console.log("simpleSearch by query" + query)
                var userids = _.pluck(_.filter(membershipList, function (request) {
                    return request.groupId == groupId && request.followerId != userId
                }), "followerId");

                return callBack(_.filter(userList,
                    function (user) {
                        return _.contains(userids, user.userId) &&
                            (user.screenName.indexOf(query) !== -1 ||
                                user.firstName.indexOf(query) !== -1 ||
                                user.lastName.indexOf(query) !== -1 ||
                                user.emailaddress.indexOf(query) !== -1)
                    }).slice(start, end), options);
            },
            get: function (userId, options) {
//                console.log("call System.User.get" + userId);
                return callBack(_.findWhere(userList, {userId: userId}), options);
            }
        },
        Group: {
            get: function (groupId, options) {
                console.log("call System.Group.get(" + groupId + ")");
                return callBack(_.findWhere(groupList, {groupId: groupId}), options);
            },
            add: function (model, options) {
                console.log("add association '" + model.attributes.title + "'");
                var group = _.clone(model.attributes);
                group.groupId = ++sequence;
                _.each(model.attributes.users, function (userId) {
                    membershipList.push({
                        membershipId: ++sequence,
                        groupId: group.id,
                        createDate: new Date().getTime(),
                        followerId: userId,
                        status: MembershipConstants.STATUS_INVITED,
                        type: MembershipConstants.TYPE_FOLLOWER
                    });
                });
                groupList.push(group);
                groupSetting.push({
                    groupId: group.groupId,
                    ownerId: userId,
                    enable: true,
                    membershipType: GroupSettingConstants.TYPE_PUBLIC,
                    confirmPublishing: true
                });
                return callBack(group, options);
            },
            edit: function (group, options) {
                console.log("edit association#" + group.id)
                var storeGroup = _.findWhere(groupList, {groupId: group.id});
                storeGroup.title = group.attribute.title;
                storeGroup.description = group.attribute.description;
                storeGroup.tags = group.attributes.tags;
                storeGroup.categories = group.attributes.categories;
                return callBack(storeGroup, options);
            },
            delete: function (groupId) {
                console.log("delete to association#" + groupId)
                //membership.splice(meetingId, 1);
                var storeGroup = _.findWhere(groupList, {groupId: groupId});
                groupList.splice(groupList.indexOf(storeGroup), 1);
                //recordingList.splice(meetingId, 1);
                return callBack({});
            },
            findByTags: function (tags, start, end, options) {
                console.log("call findByTags([" + tags + "," + start + "," + end + ").");
                var search = _.filter(groupList, function (group) {
                    return _.isEmpty(tags) || !_.isEmpty(_.intersection(tags, group.tags))
                });
                var result = search.slice(start, end);
                result.push(search.length);
                return callBack(result, options);
            },
            findBold: function (options) {
                console.log("call findBoldAssociation ");
                return callBack(_.sample(groupList, 1), options);
            },
            findRecentActivity: function (options) {
                console.log("call findRecentAssociation ");
                return callBack(_.sample(groupList, 5), options);
            },
            findRecentCreated: function (options) {
                console.log(" call findRecentCreatedAssociation ");
                return callBack(_.sample(groupList, 5), options);
            },
            findByOwnerId: function (ownerId, options) {
                console.log("call System.Group.findByOwnerId(" + ownerId + ")");
                return callBack(_.findWhere(groupList, {groupId: groupId}), options);
            },
            findByU_M: function (userId, membershipType, options) {
                console.log("call System.Group.findByU_M(" + userId + ", " + membershipType + ")");
                var groupIds;
                if (membershipType == MembershipConstants.TYPE_OWNER) {
                    groupIds = _.pluck(_.where(groupSettingList, {ownerId: userId}), "groupId");
                } else {
                    groupIds = _.pluck(_.where(membershipList, {followerId: userId, type: membershipType}), "groupId");
                }
                var result = _.filter(groupList, function (group) {
                    return _.contains(groupIds, group.groupId);
                });
                return callBack(result, options);
            }

        },
        GroupSetting: {
            get: function (groupId, options) {
                console.log("call System.GroupSetting.get(" + groupId + ")");
                return callBack(_.findWhere(groupSettingList, {groupId: groupId}), options);
            },
            edit: function (model, options) {
                console.log("call System.GroupSetting.edit(" + model.attributes + ")");
                var groupSetting = _.findWhere(groupSettingList, {groupId: groupId});
                groupSetting.enable = model.get('enable');
                groupSetting.membershipMethod = model.get('membershipMethod');
                groupSetting.confirmPublishing = model.get('confirmPublishing');
                return callBack(groupSetting, options);
            }
        },
        Membership: {
            get: function (membershipId, options) {
                console.log("call System.Membership.get(" + membershipId + ").");
                return callBack(_.findWhere(membershipList, {membershipId: membershipId}), options);
            },
            add: function (groupId, options) {
                console.log("call System.Membership.join(" + groupId + ").");
                var groupSetting = _.findWhere(groupSettingList, {groupId: groupId});
                var request = {
                    membershipId: ++sequence,
                    groupId: groupId,
                    createDate: new Date(),
                    followerId: userId,
                    status: groupSetting.membershipType == GroupSettingConstants.TYPE_PRIVATE ? MembershipConstants.STATUS_REQUESTED : MembershipConstants.STATUS_ACCEPTED,
                    type: MembershipConstants.TYPE_FOLLOWER
                };
                membershipList.push(request)
                return callBack(request, options);
            },
            findByG_F: function (groupId, followerId, options) {
                console.log("call findByG_F(" + groupId + "," + followerId + ")");
                var search = _.find(membershipList, function (request) {
                    return request.groupId == groupId && request.followerId == followerId;
                })

                return search;
            },
            findByG_T_S: function (groupId, type, statuses, start, end, options) {
                console.log("call System.Membership.findByG_T_S(" + groupId + "," + type + ",[" + statuses + "]," + start + "," + end + ").");
                var search = _.filter(membershipList, function (request) {
                    return request.groupId == groupId && request.type == type && _.contains(statuses, request.status)
                });
                var result = search.slice(start, end);
                result.push(search.length);
                return callBack(result, options);
            },
            findByF_S: function (followerId, statuses, start, end, options) {
                console.log("call System.Membership.findByF_S(" + followerId + ",[" + statuses + "]," + start + "," + end + ").");
                var search = _.filter(membershipList, function (request) {
                    return request.followerId == followerId && _.contains(statuses, request.status)
                });
                var result = search.slice(start, end);
                result.push(search.length);
                return callBack(result, options);
            },
            reject: function (membershipId, options) {
                console.log("call System.Membership.reject(" + membershipId + ").");
                var request = _.findWhere(membershipList, {membershipId: membershipId});
                request.status = MembershipConstants.STATUS_REJECTED;
                return callBack(request, options);
            },
            accept: function (membershipId, options) {
                console.log("call System.Membership.accept(" + membershipId + ").");
                var request = _.findWhere(membershipList, {membershipId: membershipId});
                request.status = MembershipConstants.STATUS_ACCEPTED;
                return callBack(request, options);
            },
            join: function (options) {
                console.log("call System.Membership.join().");
                var groupSetting = _.findWhere(groupSettingList, {groupId: groupId});
                var request = {
                    membershipId: ++sequence,
                    groupId: groupId,
                    createDate: new Date(),
                    followerId: userId,
                    status: groupSetting.membershipType == GroupSettingConstants.TYPE_PRIVATE ? MembershipConstants.STATUS_REQUESTED : MembershipConstants.STATUS_ACCEPTED,
                    status: GroupSettingConstants.METHOD_PRIVATE ? MembershipConstants.STATUS_REQUESTED : MembershipConstants.STATUS_APPROVED,
                    type: MembershipConstants.TYPE_FOLLOWER
                };
                membershipList.push(request)
                return callBack(request, options);
            },
            joinByGroupId: function (groupId, options) {
                console.log("call System.Membership.joinByGroupId().");
                var groupSetting = _.findWhere(groupSettingList, {groupId: groupId});
                var request = {
                    membershipId: ++sequence,
                    groupId: groupId,
                    createDate: new Date(),
                    followerId: userId,
                    status: groupSetting.membershipType == GroupSettingConstants.TYPE_PRIVATE ? MembershipConstants.STATUS_REQUESTED : MembershipConstants.STATUS_ACCEPTED,
                    type: MembershipConstants.TYPE_FOLLOWER
                };
                membershipList.push(request)
                return callBack(request, options);
            },
            changeType: function (membershipId, type, options) {
                console.log("call System.Membership.changeType(" + type + ").");
                var request = _.findWhere(membershipList, {membershipId: membershipId});
                request.type = type;
                return callBack(request, options);
            },
            invite: function (userIds, type, options) {
                console.log("call System.Membership.invite(" + userIds + "," + userId + ").");
                _.each(userIds, function (userId) {
                    membershipList.push({
                        membershipId: ++sequence,
                        groupId: themeDisplay.getScopeGroupId(),
                        createDate: new Date(),
                        followerId: userId,
                        status: MembershipConstants.STATUS_INVITED,
                        isMember: type
                    });
                });
                return callBack({}, options);
            },
            delete: function (model, options) {
                console.log("call System.Membership.delete(" + model + ").");
                var request = _.findWhere(membershipList, {membershipId: model.id});
                membershipList.splice(membershipList.indexOf(request), 1);
                return callBack({}, options);
            }
        },
        Tag: {
            simpleSearch: function (query, start, end, options) {
                console.log("tag simpleSearch by query" + query)
                return callBack(_.filter(tagList, function (tag) {
                    return tag.name.indexOf(query) !== -1
                }), options);
            }
        }
    },
    Association: {
        get: function (groupId, options) {
            console.log("get association#" + groupId)
            association = _.find(groupList, function (association) {
                return association.groupId == groupId;
            });
            return callBack(association, options);
        }

    },
    User: {
        simpleSearch: function (userId, query, start, end, options) {
            console.log("simpleSearch by query" + query)
            return callBack(_.filter(userList, function (user) {
                return user.screenName.indexOf(query) !== -1 ||
                    user.firstName.indexOf(query) !== -1 ||
                    user.lastName.indexOf(query) !== -1 ||
                    user.emailaddress.indexOf(query) !== -1
            }), options);
        }
    },
    Category: {
        simpleSearch: function (query, start, end, options) {
            console.log("category simpleSearch by query" + query)
            return callBack(_.filter(categoryList, function (category) {
                return category.title.indexOf(query) !== -1
            }), options);
        }
    },
    Email: {
        simpleSearch: function (query, start, end, options) {
            console.log("email simpleSearch by query" + query)
            return callBack(_.filter(emailList, function (email) {
                return email.address.indexOf(query) !== -1
            }), options);
        }
    },
    //related to table
    getTableForGraph: function (tableId, options) {
        var defer = $.Deferred();
        setTimeout(function () {
            defer.resolve([
                { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 11629, "createDate": 1374327804066, "defaultUser": false, "emailAddress": "", "emailAddressVerified": false, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "حسین", "graceLoginCount": 0, "greeting": "Welcome حسین امیری!", "jobTitle": "", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1375082355294, "lastLoginIP": "127.0.0.1", "lastName": "امیری", "lockout": false, "lockoutDate": null, "loginDate": 1375788473699, "loginIP": "127.0.0.1", "middleName": "", "modifiedDate": 1381754238069, "openId": "", "portraitId": 20102, "reminderQueryAnswer": "", "reminderQueryQuestion": "", "screenName": "parian66", "status": 0, "timeZoneId": null, "userId": 11628, "uuid": "0f7b92ee-1952-4f0d-8ef8-0f67cd208239" },
                { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 10197, "createDate": 1374137798954, "defaultUser": false, "emailAddress": "test@liferay.com", "emailAddressVerified": true, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "Test", "graceLoginCount": 0, "greeting": "Welcome Test Test!", "jobTitle": "ٍEngineer", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1384181006455, "lastLoginIP": "127.0.0.1", "lastName": "Test", "lockout": false, "lockoutDate": null, "loginDate": 1384946666236, "loginIP": "127.0.0.1", "middleName": "", "modifiedDate": 1381754205095, "openId": "", "portraitId": 20101, "reminderQueryAnswer": "morteza", "reminderQueryQuestion": "what-is-your-father's-middle-name", "screenName": "test", "status": 0, "timeZoneId": null, "userId": 10196, "uuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 11618, "createDate": 1374327742687, "defaultUser": false, "emailAddress": "", "emailAddressVerified": false, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "سجاد", "graceLoginCount": 0, "greeting": "Welcome سجاد صفاییان!", "jobTitle": "", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1378038055333, "lastLoginIP": "192.168.0.133", "lastName": "صفاییان", "lockout": false, "lockoutDate": null, "loginDate": 1378047437133, "loginIP": "192.168.0.133", "middleName": "", "modifiedDate": 1378038256756, "openId": "", "portraitId": 19001, "reminderQueryAnswer": "", "reminderQueryQuestion": "", "screenName": "safairon", "status": 0, "timeZoneId": null, "userId": 1, "uuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" }
            ]);
            defer.resolve();
        }, delay);
        return defer.promise();
    },

    getPublishTagsForGraph: function (tableId, options) {
        var defer = $.Deferred();
        setTimeout(function () {
            defer.resolve({
                "{uuid=ef010c3d-faa0-4476-aac3-9d2430fc7a49, publishId=501, groupId=11503, tableId=301, ownerId=10196, itemId=102, companyId=10154, userId=10196, userName=Test Test, createDate=Tue Oct 08 10:34:13 GMT 2013, modifiedDate=Tue Oct 08 10:34:13 GMT 2013, accessLevel=1}": 3,
                "{uuid=f26a3564-9b97-4b9e-a34d-9b17a7e17757, publishId=301, groupId=11503, tableId=301, ownerId=10196, itemId=101, companyId=10154, userId=10196, userName=Test Test, createDate=Thu Oct 03 12:11:43 GMT 2013, modifiedDate=Thu Oct 03 12:11:43 GMT 2013, accessLevel=1}": 4,
                "{uuid=ba1cb12f-cf3a-4dc7-9c75-c6995d7d29ff, publishId=302, groupId=11503, tableId=301, ownerId=10196, itemId=101, companyId=10154, userId=10196, userName=Test Test, createDate=Thu Oct 03 12:13:09 GMT 2013, modifiedDate=Thu Oct 03 12:13:09 GMT 2013, accessLevel=1}": 2
            });
            defer.resolve();
        }, delay);
        return defer.promise();
    },

    getUserConnectedToPublish: function (publishId, options) {
        var defer = $.Deferred();
        setTimeout(function () {
            defer.resolve([
                { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 10197, "createDate": 1374137798954, "defaultUser": false, "emailAddress": "test@liferay.com", "emailAddressVerified": true, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "Test", "graceLoginCount": 0, "greeting": "Welcome Test Test!", "jobTitle": "ٍEngineer", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1384946666236, "lastLoginIP": "127.0.0.1", "lastName": "Test", "lockout": false, "lockoutDate": null, "loginDate": 1384950646138, "loginIP": "127.0.0.1", "middleName": "", "modifiedDate": 1381754205095, "openId": "", "portraitId": 20101, "reminderQueryAnswer": "morteza", "reminderQueryQuestion": "what-is-your-father's-middle-name", "screenName": "test", "status": 0, "timeZoneId": null, "userId": 10196, "uuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
            ]);
            defer.resolve();
        }, delay);
        return defer.promise();
    },

    getDocumentConnectedToUser: function (userId, options) {
        var defer = $.Deferred();
        setTimeout(function () {
            defer.resolve([
                { "accessLevel": 1, "companyId": 10154, "createDate": 1380802303000, "groupId": 11503, "itemId": 101, "modifiedDate": 1380802303000, "ownerId": 10196, "publishId": 301, "tableId": 301, "title": "Note - 1 Title", "userId": 10196, "userName": "Test Test", "uuid": "f26a3564-9b97-4b9e-a34d-9b17a7e17757" },
                { "accessLevel": 1, "companyId": 10154, "createDate": 1380802389000, "groupId": 11503, "itemId": 101, "modifiedDate": 1380802389000, "ownerId": 10196, "publishId": 302, "tableId": 301, "title": "Note - 1 Title", "userId": 10196, "userName": "Test Test", "uuid": "ba1cb12f-cf3a-4dc7-9c75-c6995d7d29ff" }
            ]);
            defer.resolve();
        }, delay);
        return defer.promise();
    },
    getPublishItemById: function (classPK, options) {
        var defer = $.Deferred();
        setTimeout(function () {
            defer.resolve([
                { "accessLevel": 1, "companyId": 10154, "createDate": 1381228453000, "groupId": 11503, "itemId": 102, "modifiedDate": 1381228453000, "ownerId": 10196, "publishId": 501, "tableId": 301, "title": "Note - 2 Title", "userId": 10196, "userName": "Test Test", "uuid": "ef010c3d-faa0-4476-aac3-9d2430fc7a49" }
            ]);
            defer.resolve();
        }, delay);
        return defer.promise();
    },
    getUserById: function (userId) {
        var defer = $.Deferred();
        setTimeout(function () {
            defer.resolve(
                { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 11629, "createDate": 1374327804066, "defaultUser": false, "emailAddress": "", "emailAddressVerified": false, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "حسین", "graceLoginCount": 0, "greeting": "Welcome حسین امیری!", "jobTitle": "", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1375082355294, "lastLoginIP": "127.0.0.1", "lastName": "امیری", "lockout": false, "lockoutDate": null, "loginDate": 1375788473699, "loginIP": "127.0.0.1", "middleName": "", "modifiedDate": 1381754238069, "openId": "", "portraitId": 20102, "reminderQueryAnswer": "", "reminderQueryQuestion": "", "screenName": "parian66", "status": 0, "timeZoneId": null, "userId": 11628, "uuid": "0f7b92ee-1952-4f0d-8ef8-0f67cd208239" }
            );
            defer.resolve();
        }, delay);
        return defer.promise();

    },
    Activity: {
        findByClassNameId: function (className, date, start, end, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                if (_.isEqual(className, ArmanJsManager.Entities.Activity.findClassNameByType('table'))) {
                    options.success([
                        { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.table.model.Message", "classNameId": 18403, "classPK": 201, "columnBitmask": -1, "companyId": 10154, "createDate": 1380788753571, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 3302, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"body\":\"سلام\",\"title\":\"Note 01 - Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 3302, "groupId": 11503, "classNameId": 18403, "userId": 10196, "extraData": "{\"body\":\"سلام\",\"title\":\"Note 01 - Title\"}", "mirrorActivityId": 0, "classPK": 201, "companyId": 10154, "type": 1, "createDate": 1380788753571, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 3302, "primaryKeyObj": 3302, "receiverUserId": 0, "receiverUserUuid": "", "type": 1, "userId": 100, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                        { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.table.model.Publish", "classNameId": 18404, "classPK": 501, "columnBitmask": -1, "companyId": 10154, "createDate": 1380788588472, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 3301, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"Note 01 - Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 3301, "groupId": 11503, "classNameId": 18404, "userId": 10196, "extraData": "{\"title\":\"Note 01 - Title\"}", "mirrorActivityId": 0, "classPK": 501, "companyId": 10154, "type": 3, "createDate": 1380788588472, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 3301, "primaryKeyObj": 3301, "receiverUserId": 0, "receiverUserUuid": "", "type": 3, "userId": 101, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                    ]);
                } else if (_.isEqual(className, ArmanJsManager.Entities.Activity.findClassNameByType('virtualclass'))) {
                    if (options.afterOrBefore == 0) {
                        options.success([
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.virtualclass.model.Meeting", "classNameId": 14203, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1390397390242, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 8702, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"test\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 8702, "groupId": 10180, "classNameId": 14203, "userId": 10196, "extraData": "{\"title\":\"test\"}", "mirrorActivityId": 0, "classPK": 10180, "companyId": 10154, "type": 1, "createDate": 1390397390242, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 8702, "primaryKeyObj": 8702, "receiverUserId": 0, "receiverUserUuid": "", "type": 1, "userId": 99, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.virtualclass.model.Meeting", "classNameId": 14203, "classPK": 11503, "columnBitmask": -1, "companyId": 10154, "createDate": 1383311051178, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 4002, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"test class\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 4002, "groupId": 11503, "classNameId": 14203, "userId": 10196, "extraData": "{\"title\":\"test class\"}", "mirrorActivityId": 0, "classPK": 11503, "companyId": 10154, "type": 1, "createDate": 1383311051178, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 4002, "primaryKeyObj": 4002, "receiverUserId": 0, "receiverUserUuid": "", "type": 1, "userId": 98, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.virtualclass.model.Meeting", "classNameId": 14203, "classPK": 11503, "columnBitmask": -1, "companyId": 10154, "createDate": 1383309830728, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 3801, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"test class\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 3801, "groupId": 11503, "classNameId": 14203, "userId": 10196, "extraData": "{\"title\":\"test class\"}", "mirrorActivityId": 0, "classPK": 11503, "companyId": 10154, "type": 1, "createDate": 1383309830728, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 3801, "primaryKeyObj": 3801, "receiverUserId": 0, "receiverUserUuid": "", "type": 1, "userId": 96, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.virtualclass.model.Meeting", "classNameId": 14203, "classPK": 11503, "columnBitmask": -1, "companyId": 10154, "createDate": 1381308571542, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 3502, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"my meeting\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 3502, "groupId": 11503, "classNameId": 14203, "userId": 10196, "extraData": "{\"title\":\"my meeting\"}", "mirrorActivityId": 0, "classPK": 11503, "companyId": 10154, "type": 1, "createDate": 1381308571542, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 3502, "primaryKeyObj": 3502, "receiverUserId": 0, "receiverUserUuid": "", "type": 1, "userId": 97, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.virtualclass.model.Meeting", "classNameId": 14203, "classPK": 11503, "columnBitmask": -1, "companyId": 10154, "createDate": 1381308446230, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 3501, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"test class\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 3501, "groupId": 11503, "classNameId": 14203, "userId": 10196, "extraData": "{\"title\":\"test class\"}", "mirrorActivityId": 0, "classPK": 11503, "companyId": 10154, "type": 1, "createDate": 1381308446230, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 3501, "primaryKeyObj": 3501, "receiverUserId": 0, "receiverUserUuid": "", "type": 1, "userId": 99, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                        ]);
                    } else if (options.afterOrBefore == 1) {
                        options.success([
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.virtualclass.model.Meeting", "classNameId": 14203, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1390397391691, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 8704, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"test\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 8704, "groupId": 10180, "classNameId": 14203, "userId": 10196, "extraData": "{\"title\":\"test\"}", "mirrorActivityId": 0, "classPK": 10180, "companyId": 10154, "type": 4, "createDate": 1390397391691, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 8704, "primaryKeyObj": 8704, "receiverUserId": 0, "receiverUserUuid": "", "type": 4, "userId": 100, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.virtualclass.model.Meeting", "classNameId": 14203, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1390397391599, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 8703, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"test\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 8703, "groupId": 10180, "classNameId": 14203, "userId": 10196, "extraData": "{\"title\":\"test\"}", "mirrorActivityId": 0, "classPK": 10180, "companyId": 10154, "type": 2, "createDate": 1390397391599, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 8703, "primaryKeyObj": 8703, "receiverUserId": 0, "receiverUserUuid": "", "type": 2, "userId": 100, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                        ]);
                    }
                } else if (_.isEqual(className, ArmanJsManager.Entities.Activity.findClassNameByType('tasks'))) {
                    options.success([
                        { "activityId": ++sequence, "assetEntry": { "classNameId": 11003, "classPK": 26602, "classTypeId": 0, "classUuid": "", "companyId": 10154, "createDate": 1387968257920, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 26603, "expirationDate": null, "groupId": 60, "height": 0, "layoutUuid": "", "mimeType": "", "modifiedDate": 1387968257920, "priority": 0, "publishDate": null, "startDate": null, "summary": "", "summaryCurrentValue": "", "title": "", "titleCurrentValue": "", "url": "", "userId": 10196, "userName": "Test Test", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.tasks.model.TasksEntry", "classNameId": 11003, "classPK": 26602, "columnBitmask": -1, "companyId": 10154, "createDate": 1387968257984, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 8601, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"1\"}", "groupId": 11503, "mirrorActivityId": 0, "modelAttributes": { "activityId": 8601, "groupId": 11503, "classNameId": 11003, "userId": 10196, "extraData": "{\"title\":\"1\"}", "mirrorActivityId": 0, "classPK": 26602, "companyId": 10154, "type": 1, "createDate": 1387968257984, "receiverUserId": 10196 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 8601, "primaryKeyObj": 8601, "receiverUserId": 99, "receiverUserUuid": "64f2a63c-2181-4475-a627-d3645bc2670f", "type": 1, "userId": 98, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                    ]);
                } else if (_.isEqual(className, ArmanJsManager.Entities.Activity.findClassNameByType('shareboard'))) {
                    if (options.afterOrBefore == 0) {
                        options.success([
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.shareboard.model.ShareBoardMessage", "classNameId": 19801, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1392019818453, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9915, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"text\":\"333-:11:41\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9915, "groupId": 10180, "classNameId": 19801, "userId": 11617, "extraData": "{\"text\":\"333-:11:41\"}", "mirrorActivityId": 0, "classPK": 10180, "companyId": 10154, "type": 1, "createDate": 1392019818453, "receiverUserId": 11617 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9915, "primaryKeyObj": 9915, "receiverUserId": 96, "receiverUserUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6", "type": 1, "userId": 99, "userUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.shareboard.model.ShareBoardMessage", "classNameId": 19801, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1392019793911, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9914, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"text\":\"222-11:40\"}", "groupId": 60, "mirrorActivityId": 9913, "modelAttributes": { "activityId": 9914, "groupId": 10180, "classNameId": 19801, "userId": 10196, "extraData": "{\"text\":\"222-11:40\"}", "mirrorActivityId": 9913, "classPK": 10180, "companyId": 10154, "type": 1, "createDate": 1392019793911, "receiverUserId": 11617 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9914, "primaryKeyObj": 9914, "receiverUserId": 97, "receiverUserUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6", "type": 1, "userId": 98, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.shareboard.model.ShareBoardMessage", "classNameId": 19801, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1392019793911, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9913, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"text\":\"222-11:40\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9913, "groupId": 10180, "classNameId": 19801, "userId": 11617, "extraData": "{\"text\":\"222-11:40\"}", "mirrorActivityId": 0, "classPK": 10180, "companyId": 10154, "type": 1, "createDate": 1392019793911, "receiverUserId": 10196 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9913, "primaryKeyObj": 9913, "receiverUserId": 98, "receiverUserUuid": "64f2a63c-2181-4475-a627-d3645bc2670f", "type": 1, "userId": 97, "userUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.shareboard.model.ShareBoardMessage", "classNameId": 19801, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1392019782222, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9911, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"text\":\"111-11:39\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9911, "groupId": 10180, "classNameId": 19801, "userId": 11617, "extraData": "{\"text\":\"111-11:39\"}", "mirrorActivityId": 0, "classPK": 10180, "companyId": 10154, "type": 1, "createDate": 1392019782222, "receiverUserId": 10196 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9911, "primaryKeyObj": 9911, "receiverUserId": 99, "receiverUserUuid": "64f2a63c-2181-4475-a627-d3645bc2670f", "type": 1, "userId": 99, "userUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.shareboard.model.ShareBoardMessage", "classNameId": 19801, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1392019782222, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9912, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"text\":\"111-11:39\"}", "groupId": 61, "mirrorActivityId": 9911, "modelAttributes": { "activityId": 9912, "groupId": 10180, "classNameId": 19801, "userId": 10196, "extraData": "{\"text\":\"111-11:39\"}", "mirrorActivityId": 9911, "classPK": 10180, "companyId": 10154, "type": 1, "createDate": 1392019782222, "receiverUserId": 11617 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9912, "primaryKeyObj": 9912, "receiverUserId": 96, "receiverUserUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6", "type": 1, "userId": 96, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                        ]);
                    } else if (options.afterOrBefore == 1) {
                        options.success([
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.shareboard.model.ShareBoardMessage", "classNameId": 19801, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1392030417719, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 10001, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"text\":\"123\"}", "groupId": 61, "mirrorActivityId": 0, "modelAttributes": { "activityId": 10001, "groupId": 10180, "classNameId": 19801, "userId": 11617, "extraData": "{\"text\":\"123\"}", "mirrorActivityId": 0, "classPK": 10180, "companyId": 10154, "type": 1, "createDate": 1392030417719, "receiverUserId": 10196 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 10001, "primaryKeyObj": 10001, "receiverUserId": 97, "receiverUserUuid": "64f2a63c-2181-4475-a627-d3645bc2670f", "type": 1, "userId": 98, "userUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" },
                            { "activityId": ++sequence, "assetEntry": null, "cachedModel": false, "className": "ir.armansoft.portal.shareboard.model.ShareBoardMessage", "classNameId": 19801, "classPK": 10180, "columnBitmask": -1, "companyId": 10154, "createDate": 1392030417719, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 10002, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"text\":\"123\"}", "groupId": 61, "mirrorActivityId": 10001, "modelAttributes": { "activityId": 10002, "groupId": 10180, "classNameId": 19801, "userId": 10196, "extraData": "{\"text\":\"123\"}", "mirrorActivityId": 10001, "classPK": 10180, "companyId": 10154, "type": 1, "createDate": 1392030417719, "receiverUserId": 11617 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 10002, "primaryKeyObj": 10002, "receiverUserId": 100, "receiverUserUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6", "type": 1, "userId": 99, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                        ]);
                    }
                } else if (_.isEqual(className, ArmanJsManager.Entities.Activity.findClassNameByType('cabinet'))) {
                    options.success([
                        { "activityId": ++sequence, "assetEntry": { "classNameId": 10013, "classPK": 27789, "classTypeId": 0, "classUuid": "aca63d3a-ad7f-4b2e-906c-450d87c8e6e9", "companyId": 10154, "createDate": 1391078206241, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 27790, "expirationDate": null, "groupId": 10180, "height": 0, "layoutUuid": "", "mimeType": "text/html", "modifiedDate": 1391078206241, "priority": 0, "publishDate": null, "startDate": null, "summary": "", "summaryCurrentValue": "", "title": "12345667", "titleCurrentValue": "12345667", "url": "", "userId": 10196, "userName": "Test Test", "viewCount": 2, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.wiki.model.WikiPage", "classNameId": 10013, "classPK": 27789, "columnBitmask": -1, "companyId": 10154, "createDate": 1391078206266, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9006, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "", "groupId": 61, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9006, "groupId": 10180, "classNameId": 10013, "userId": 10196, "extraData": "", "mirrorActivityId": 0, "classPK": 27789, "companyId": 10154, "type": 1, "createDate": 1391078206266, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9006, "primaryKeyObj": 9006, "receiverUserId": 0, "receiverUserUuid": "", "type": 1, "userId": 98, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                        { "activityId": ++sequence, "assetEntry": { "classNameId": 10010, "classPK": 19306, "classTypeId": 0, "classUuid": "f64533be-659e-469e-9208-2fde066c2f23", "companyId": 10154, "createDate": 1380800649452, "description": "this is test", "descriptionCurrentValue": "this is test", "endDate": null, "entryId": 19308, "expirationDate": null, "groupId": 10198, "height": 0, "layoutUuid": "", "mimeType": "image/jpeg", "modifiedDate": 1380800649452, "priority": 0, "publishDate": null, "startDate": null, "summary": "", "summaryCurrentValue": "", "title": "test1", "titleCurrentValue": "test1", "url": "", "userId": 10196, "userName": "Test Test", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.documentlibrary.model.DLFileEntry", "classNameId": 10010, "classPK": 19306, "columnBitmask": -1, "companyId": 10154, "createDate": 1380800649266, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 3401, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"test1\"}", "groupId": 61, "mirrorActivityId": 0, "modelAttributes": { "activityId": 3401, "groupId": 10198, "classNameId": 10010, "userId": 10196, "extraData": "{\"title\":\"test1\"}", "mirrorActivityId": 0, "classPK": 19306, "companyId": 10154, "type": 1, "createDate": 1380800649266, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 3401, "primaryKeyObj": 3401, "receiverUserId": 0, "receiverUserUuid": "", "type": 1, "userId": 99, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                    ]);
                } else if (_.isEqual(className, ArmanJsManager.Entities.Activity.findClassNameByType('last'))) {
                    if (options.afterOrBefore == 0) {
                        options.success([
                            { "activityId": ++sequence, "assetEntry": { "classNameId": 10007, "classPK": 28452, "classTypeId": 0, "classUuid": "f5d6c531-b25e-401b-971e-029de7fbaee7", "companyId": 10154, "createDate": 1391527376898, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 28454, "expirationDate": null, "groupId": 60, "height": 0, "layoutUuid": "", "mimeType": "text/html", "modifiedDate": 1391527376898, "priority": 0, "publishDate": 1391527320000, "startDate": null, "summary": "2121212", "summaryCurrentValue": "2121212", "title": "No Title", "titleCurrentValue": "No Title", "url": "", "userId": 10196, "userName": "Test Test", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.blogs.model.BlogsEntry", "classNameId": 10007, "classPK": 28452, "columnBitmask": -1, "companyId": 10154, "createDate": 1391527376943, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9507, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"No Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9507, "groupId": 60, "classNameId": 10007, "userId": 10196, "extraData": "{\"title\":\"No Title\"}", "mirrorActivityId": 0, "classPK": 28452, "companyId": 10154, "type": 2, "createDate": 1391527376943, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9507, "primaryKeyObj": 9507, "receiverUserId": 0, "receiverUserUuid": "", "type": 2, "userId": 100, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": { "classNameId": 10007, "classPK": 28443, "classTypeId": 0, "classUuid": "7e13957f-8da6-4013-8b86-76e34bf423ca", "companyId": 10154, "createDate": 1391527376521, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 28445, "expirationDate": null, "groupId": 60, "height": 0, "layoutUuid": "", "mimeType": "text/html", "modifiedDate": 1391527376521, "priority": 0, "publishDate": 1391527320000, "startDate": null, "summary": "2121212", "summaryCurrentValue": "2121212", "title": "No Title", "titleCurrentValue": "No Title", "url": "", "userId": 10196, "userName": "Test Test", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.blogs.model.BlogsEntry", "classNameId": 10007, "classPK": 28443, "columnBitmask": -1, "companyId": 10154, "createDate": 1391527376562, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9506, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"No Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9506, "groupId": 60, "classNameId": 10007, "userId": 10196, "extraData": "{\"title\":\"No Title\"}", "mirrorActivityId": 0, "classPK": 28443, "companyId": 10154, "type": 2, "createDate": 1391527376562, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9506, "primaryKeyObj": 9506, "receiverUserId": 0, "receiverUserUuid": "", "type": 2, "userId": 101, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": { "classNameId": 10007, "classPK": 28435, "classTypeId": 0, "classUuid": "bc0524bc-0822-4b9f-ad52-f4d915b42235", "companyId": 10154, "createDate": 1391527303397, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 28437, "expirationDate": null, "groupId": 60, "height": 0, "layoutUuid": "", "mimeType": "text/html", "modifiedDate": 1391527303397, "priority": 0, "publishDate": 1391523900000, "startDate": null, "summary": "121212", "summaryCurrentValue": "121212", "title": "No Title", "titleCurrentValue": "No Title", "url": "", "userId": 11617, "userName": "سجاد صفاییان", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.blogs.model.BlogsEntry", "classNameId": 10007, "classPK": 28435, "columnBitmask": -1, "companyId": 10154, "createDate": 1391527303444, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9505, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"No Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9505, "groupId": 60, "classNameId": 10007, "userId": 11617, "extraData": "{\"title\":\"No Title\"}", "mirrorActivityId": 0, "classPK": 28435, "companyId": 10154, "type": 2, "createDate": 1391527303444, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9505, "primaryKeyObj": 9505, "receiverUserId": 0, "receiverUserUuid": "", "type": 2, "userId": 102, "userUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" },
                            { "activityId": ++sequence, "assetEntry": { "classNameId": 10007, "classPK": 28427, "classTypeId": 0, "classUuid": "f7caf7d7-d36f-41e4-9ad5-8a61b3b1126d", "companyId": 10154, "createDate": 1391527302951, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 28429, "expirationDate": null, "groupId": 60, "height": 0, "layoutUuid": "", "mimeType": "text/html", "modifiedDate": 1391527302951, "priority": 0, "publishDate": 1391523900000, "startDate": null, "summary": "121212", "summaryCurrentValue": "121212", "title": "No Title", "titleCurrentValue": "No Title", "url": "", "userId": 11617, "userName": "سجاد صفاییان", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.blogs.model.BlogsEntry", "classNameId": 10007, "classPK": 28427, "columnBitmask": -1, "companyId": 10154, "createDate": 1391527302981, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9504, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"No Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9504, "groupId": 60, "classNameId": 10007, "userId": 11617, "extraData": "{\"title\":\"No Title\"}", "mirrorActivityId": 0, "classPK": 28427, "companyId": 10154, "type": 2, "createDate": 1391527302981, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9504, "primaryKeyObj": 9504, "receiverUserId": 0, "receiverUserUuid": "", "type": 2, "userId": 103, "userUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" },
                            { "activityId": ++sequence, "assetEntry": { "classNameId": 10007, "classPK": 28419, "classTypeId": 0, "classUuid": "16ec317b-44bc-40c8-94e6-94d1bc1b7f67", "companyId": 10154, "createDate": 1391527302540, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 28421, "expirationDate": null, "groupId": 60, "height": 0, "layoutUuid": "", "mimeType": "text/html", "modifiedDate": 1391527302540, "priority": 0, "publishDate": 1391523900000, "startDate": null, "summary": "121212", "summaryCurrentValue": "121212", "title": "No Title", "titleCurrentValue": "No Title", "url": "", "userId": 11617, "userName": "سجاد صفاییان", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.blogs.model.BlogsEntry", "classNameId": 10007, "classPK": 28419, "columnBitmask": -1, "companyId": 10154, "createDate": 1391527302575, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9503, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"No Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9503, "groupId": 60, "classNameId": 10007, "userId": 11617, "extraData": "{\"title\":\"No Title\"}", "mirrorActivityId": 0, "classPK": 28419, "companyId": 10154, "type": 2, "createDate": 1391527302575, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9503, "primaryKeyObj": 9503, "receiverUserId": 0, "receiverUserUuid": "", "type": 2, "userId": 104, "userUuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" }
                        ]);
                    } else if (options.afterOrBefore == 1) {
                        options.success([
                            { "activityId": ++sequence, "assetEntry": { "classNameId": 10007, "classPK": 28510, "classTypeId": 0, "classUuid": "58e0d52c-c140-4e7c-ac22-8854e172c269", "companyId": 10154, "createDate": 1391692727442, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 28512, "expirationDate": null, "groupId": 60, "height": 0, "layoutUuid": "", "mimeType": "text/html", "modifiedDate": 1391692727442, "priority": 0, "publishDate": 1391692680000, "startDate": null, "summary": "456", "summaryCurrentValue": "456", "title": "No Title", "titleCurrentValue": "No Title", "url": "", "userId": 10196, "userName": "Test Test", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.blogs.model.BlogsEntry", "classNameId": 10007, "classPK": 28510, "columnBitmask": -1, "companyId": 10154, "createDate": 1391692727483, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9602, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"No Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9602, "groupId": 60, "classNameId": 10007, "userId": 10196, "extraData": "{\"title\":\"No Title\"}", "mirrorActivityId": 0, "classPK": 28510, "companyId": 10154, "type": 2, "createDate": 1391692727483, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9602, "primaryKeyObj": 9602, "receiverUserId": 0, "receiverUserUuid": "", "type": 2, "userId": 99, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" },
                            { "activityId": ++sequence, "assetEntry": { "classNameId": 10007, "classPK": 28501, "classTypeId": 0, "classUuid": "5df9c06b-3c4b-4a75-bae8-a7fafe670cd6", "companyId": 10154, "createDate": 1391692721028, "description": "", "descriptionCurrentValue": "", "endDate": null, "entryId": 28503, "expirationDate": null, "groupId": 60, "height": 0, "layoutUuid": "", "mimeType": "text/html", "modifiedDate": 1391692721028, "priority": 0, "publishDate": 1391692680000, "startDate": null, "summary": "123", "summaryCurrentValue": "123", "title": "No Title", "titleCurrentValue": "No Title", "url": "", "userId": 10196, "userName": "Test Test", "viewCount": 0, "visible": true, "width": 0 }, "cachedModel": false, "className": "com.liferay.portlet.blogs.model.BlogsEntry", "classNameId": 10007, "classPK": 28501, "columnBitmask": -1, "companyId": 10154, "createDate": 1391692722026, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.social.model.SocialActivity", "classPK": 9601, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "extraData": "{\"title\":\"No Title\"}", "groupId": 60, "mirrorActivityId": 0, "modelAttributes": { "activityId": 9601, "groupId": 60, "classNameId": 10007, "userId": 10196, "extraData": "{\"title\":\"No Title\"}", "mirrorActivityId": 0, "classPK": 28501, "companyId": 10154, "type": 2, "createDate": 1391692722026, "receiverUserId": 0 }, "modelClass": "com.liferay.portlet.social.model.SocialActivity", "modelClassName": "com.liferay.portlet.social.model.SocialActivity", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "originalCompanyId": 0, "originalCreateDate": 0, "originalGroupId": 0, "originalMirrorActivityId": 0, "originalReceiverUserId": 0, "originalType": 0, "originalUserId": 0, "primaryKey": 9601, "primaryKeyObj": 9601, "receiverUserId": 0, "receiverUserUuid": "", "type": 2, "userId": 98, "userUuid": "64f2a63c-2181-4475-a627-d3645bc2670f" }
                        ]);
                    }
                }
                defer.resolve();
            }, delay);
            return defer.promise();
        },

        getUserById: function (userId, options) {
            var defer = $.Deferred();
            if (userId != 0) {
                setTimeout(function () {
                    options.success(
                        { "agreedToTermsOfUse": false, "comments": "", "companyId": 10154, "contactId": 11618, "createDate": 1374327742687, "defaultUser": false, "emailAddress": "", "emailAddressVerified": false, "facebookId": 0, "failedLoginAttempts": 0, "firstName": "سجاد", "graceLoginCount": 0, "greeting": "Welcome سجاد صفاییان!", "jobTitle": "", "languageId": null, "lastFailedLoginDate": null, "lastLoginDate": 1378038055333, "lastLoginIP": "192.168.0.133", "lastName": "صفاییان", "lockout": false, "lockoutDate": null, "loginDate": 1378047437133, "loginIP": "192.168.0.133", "middleName": "", "modifiedDate": 1378038256756, "openId": "", "portraitId": 18201, "reminderQueryAnswer": "", "reminderQueryQuestion": "", "screenName": "safairon", "status": 0, "timeZoneId": null, "userId": 11617, "uuid": "ae4f7614-d82a-4263-87b2-0d08b102ebb6" }
                    );
                    defer.resolve();
                }, delay);
            } else {
                options.success(undefined);
                defer.resolve();
            }
            return defer.promise();
        },

        getGroupById: function (groupId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve({ "active": true, "classNameId": 10001, "classPK": 11503, "companyId": 10154, "creatorUserId": 10196, "description": "", "friendlyURL": "/arman-social-office", "groupId": 11503, "liveGroupId": 0, "name": "Arman Social Office", "parentGroupId": 0, "site": true, "type": 1, "typeSettings": "mergeGuestPublicPages=false\n" });
            }, delay);
            return defer.promise();
        },

        getTaskEntryById: function (classPK, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success({ "assigneeUserId": 10196, "companyId": 10154, "createDate": 1375800038000, "dueDate": 1372978800000, "finishDate": null, "groupId": 10198, "modifiedDate": 1375800068000, "priority": 2, "resolverUserId": 0, "status": 3, "tasksEntryId": 16106, "title": "test", "type": 0, "userId": 10196, "userName": "Test Test" });
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        getCountActivity: function (classNames, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success(
                    Math.floor((Math.random() * 10) + 1)
                );
                defer.resolve();
            }, delay);
            return defer.promise();
        }
    },
    ShareBoard: {
        Post: {
            add: function (blogPost, options) {
                var defer = $.Deferred();
                setTimeout(function () {
                    blogPost.attributes.createDate = +new Date() * 2;
                    blogPost.attributes.entryId = ++newsIdSeq;
                    blogPost.attributes.userId = 101;
                    blogPost.attributes.userName = "Test Test";
                    options.success(blogPost.toJSON());
                    defer.resolve();
                }, delay * 2);
                return defer.promise();
            },
            findByG_S: function (groupId, statuses, start, end, options) {
                console.log("call System.Post.findByG_S(" + groupId + "," + statuses + "," + start + "," + end + ").");
                var search = _.filter(blogEntryList, function (entry) {
                    return entry.groupId == groupId && _.contains(statuses, entry.status)
                });
                var result = search.slice(start, end);
                result.push(search.length);
                return callBack(result, options);
            },
            approve: function (entryId, options) {
                console.log("call System.Post.approve(" + entryId + ").");
                var entry = _.findWhere(blogEntryList, {entryId: entryId});
                entry.status = BlogEntryConstants.STATUS_APPROVED;
                return callBack(entry, options);
            },
            deny: function (entryId, options) {
                console.log("call System.Post.deny(" + entryId + ").");
                var entry = _.findWhere(blogEntryList, {entryId: entryId});
                entry.status = BlogEntryConstants.STATUS_DENIED;
                return callBack(entry, options);
            },
            delete: function (entryId, options) {
                console.log("call System.Post.delete(" + entryId + ").");
                var entry = _.findWhere(blogEntryList, {entryId: entryId});
                blogEntryList.splice(blogEntryList.indexOf(entry), 1);
                return callBack({}, options);
            }
        },
        Search: {
            find: function (query, start, end, options) {
                var defer = $.Deferred();
                setTimeout(function () {
                    options.success([
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "12345456546", "createDate": +new Date(), "description": "---", "displayDate": 1393314840000, "entryId": ++newsIdSeq, "groupId": 10180, "modifiedDate": 1393327442824, "smallImage": false, "smallImageId": 30512, "smallImageURL": "", "status": 0, "statusByUserId": 11617, "statusByUserName": "سجاد صفاییان", "statusDate": 1393327442824, "title": "---", "trackbacks": "", "urlTitle": "--9-27", "userId": 97, "userName": "سجاد صفاییان", "uuid": "2a9e6e5a-005c-469d-a52b-ed3dc1c0e209" },
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "123", "createDate": +new Date() + 100, "description": "---", "displayDate": 1392849600000, "entryId": ++newsIdSeq, "groupId": 10180, "modifiedDate": 1392905450769, "smallImage": false, "smallImageId": 30102, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1392905450769, "title": "---", "trackbacks": "", "urlTitle": "--9", "userId": 96, "userName": "Test Test", "uuid": "22bbb1a6-53ab-4729-b54c-51f9c0d202d9" },
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "12345", "createDate": +new Date() + 10000000000, "description": "No Description", "displayDate": 1391016180000, "entryId": ++newsIdSeq, "groupId": 10180, "modifiedDate": 1391016300349, "smallImage": false, "smallImageId": 27648, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1391016300349, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-16", "userId": 96, "userName": "Test Test", "uuid": "628c4213-8642-4020-adde-95fe268fd828" }
                    ]);
                    defer.resolve();
                }, delay);
                return defer.promise();
            }
        },
        getTitleOfPage: function (url) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve('خوش آمدیدی//////');
//                defer.resolve('welcome to this site | farsnews /');
            }, delay * 2);
            return defer.promise();
        },
        getBlogEntriesByGroupId: function (date, start, end, options) {
            var defer = $.Deferred();
            if (options.afterOrBefore == 0) {
                setTimeout(function () {
                    options.success([
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "normal " + newsIdSeq, "createDate": +new Date() + 3000, "description": "No Description", "displayDate": 1385578080000, "entryId": ++newsIdSeq, "groupId": 11503, "modifiedDate": 1385578113284, "smallImage": false, "smallImageId": 25475, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1385578113284, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-29", "userId": 99, "userName": "Mahdi davoodi", "uuid": "729ba88f-ce59-4962-8ca1-fe565d55242f" },
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "normal " + newsIdSeq, "createDate": +new Date() + 2000, "description": "No Description", "displayDate": 1385578080000, "entryId": ++newsIdSeq, "groupId": 11503, "modifiedDate": 1385578190758, "smallImage": false, "smallImageId": 25483, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1385578190758, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-30", "userId": 100, "userName": "sajjad safaeian", "uuid": "ed46493f-7f99-45a9-839e-bf54b85ae8c4" },
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "نرمال " + newsIdSeq, "createDate": +new Date() + 1000, "description": "No Description", "displayDate": 1385580120000, "entryId": ++newsIdSeq, "groupId": 11503, "modifiedDate": 1385580206905, "smallImage": false, "smallImageId": 25491, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1385580206905, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-31", "userId": 101, "userName": "Test Test", "uuid": "a262930a-4471-424b-8c1b-b980f5eeb9b2" },
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "!!!!!!!!!!@@@@@@@@@؟؟؟؟؟؟؟؟؟؟ نرمال " + newsIdSeq, "createDate": +new Date(), "description": "No Description", "displayDate": 1387902240000, "entryId": ++newsIdSeq, "groupId": 11503, "modifiedDate": 1387902384955, "smallImage": false, "smallImageId": 26402, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1387902384955, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-40", "userId": 102, "userName": "Test Test", "uuid": "5cd053c4-14cd-4a60-985c-0af51d1007ec" }
                        /*
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383383642702 - 100000000 * meetingIdSeq, content:"alternatively you could have your subject looking at something (or someone) within the frame. A child looking at a ball, a woman looking at her new baby, a man looking hungrily at a big plate of pasta…. When you give your subject something to look at that is inside the frame you create a second point of interest and a relationship between it and your primary subject. It also helps create ‘story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"Mahdi Davoodi", date:1375099243926},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"amore at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"Mahdi", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"‘story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"reza maloom", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"new baby, a man looking hungrily at a graphy-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"Mahdi Davoodi", date:1375099243926 + 1000000 * meetingIdSeq}
                         */
                    ]);
                    defer.resolve();
                }, delay);
            } else if (options.afterOrBefore == 1) {
                setTimeout(function () {
                    options.success([
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "update " + newsIdSeq, "createDate": +new Date() + 3000, "description": "No Description", "displayDate": 1385577840000, "entryId": ++newsIdSeq, "groupId": 11503, "modifiedDate": 1385577955829, "smallImage": false, "smallImageId": 25467, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1385577955829, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-28", "userId": 103, "userName": "Test Test", "uuid": "bbc44757-ab81-440f-b2ca-cae1b082dee1" },
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "update " + newsIdSeq, "createDate": +new Date() + 2000, "description": "No Description", "displayDate": 1385577600000, "entryId": ++newsIdSeq, "groupId": 11503, "modifiedDate": 1385577694366, "smallImage": false, "smallImageId": 25459, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1385577694366, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-27", "userId": 104, "userName": "Test Test", "uuid": "7a2e0163-fd96-4cb5-ac0f-b53841e19aca" },
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "update " + newsIdSeq, "createDate": +new Date() + 1000, "description": "No Description", "displayDate": 1385577600000, "entryId": ++newsIdSeq, "groupId": 11503, "modifiedDate": 1385577683217, "smallImage": false, "smallImageId": 25451, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1385577683217, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-26", "userId": 101, "userName": "Test Test", "uuid": "18b45299-c770-4ad6-a20d-e1f682f67700" },
                        { "allowPingbacks": false, "allowTrackbacks": false, "companyId": 10154, "content": "update " + newsIdSeq, "createDate": +new Date(), "description": "No Description", "displayDate": 1385577600000, "entryId": ++newsIdSeq, "groupId": 11503, "modifiedDate": 1385577651330, "smallImage": false, "smallImageId": 25443, "smallImageURL": "", "status": 0, "statusByUserId": 10196, "statusByUserName": "Test Test", "statusDate": 1385577651330, "title": "No Title", "trackbacks": "", "urlTitle": "no-ti-25", "userId": 100, "userName": "Test Test", "uuid": "1f7af08d-d378-4668-a9e0-d54ec1aee5e5" }

                        /*{userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"it and your primary subject. It also helps create ‘story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"Davoodi", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"alternatively you could have your subject looking at something (or someone) within the a story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"sajjad", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"frame. A child looking at a ball, a woman looking at her new baby, a man looking hungrily at a big plate of pasta…. When you give your subject something to look at that is inside the frame you create a second point of interest and a relationship between it and your primary subject. It also helps create ‘story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"mojtaba", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"ball, a woman looking at her new baby, a man looking hungrily at a big plate of pasta…. When you give your subject something to look at that is inside the frame you create a second point of interest and a relationship between it and your primary subject. It also helps create ‘story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"hossein", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"ooking at a ball, a woman looking at her new baby, a man looking hungrily at a big plate of pasta…. When you give your subject something to look at that is inside the frame you create a second point of interest and a relationship between it and your primary subject. It also helps create ‘story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"masoud", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"sthash.kuNMQgr9.dpuf", userName:"ahmad", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"alternatively you baby, a man looking hungrily at a big plate of pasta…. When you give your subject something to look at that is inside the frame you create a second point of interest and a relationship between it and your primary subject. It also helps create ‘story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"mohammad", date:1375099243926 + 1000000 * meetingIdSeq},
                         {userId:0, entryId:++meetingIdSeq, groupId:0, createDate:1383312642702 - 100000000 * meetingIdSeq, content:"alternatively you baby, a man looking hungrily at a big plate of pasta…. When you give your subject something to look at that is inside the frame you create a second point of interest and a relationship between it and your primary subject. It also helps create ‘story’ within the image. See more at: http://digital-photography-school.com/10-ways-to-take-stunning-portraits#sthash.kuNMQgr9.dpuf", userName:"mohammad", date:1375099243926 + 1000000 * meetingIdSeq}*/
                    ]);
                    defer.resolve();
                }, delay);
            }
            return defer.promise();
        },
        getMessageByEntryId: function (entryId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success([
//                    { "companyId": 10154, "creationDate": +new Date() + 2000, "entryId": entryId, "groupId": 11503, "messageId": ++messageIdSeq, "text": "cm" + messageIdSeq, "userId": 100 },
//                    { "companyId": 10154, "creationDate": +new Date() + 1000, "entryId": entryId, "groupId": 11503, "messageId": ++messageIdSeq, "text": "cm" + messageIdSeq, "userId": 98 },
                    { "companyId": 10154, "creationDate": +new Date(), "entryId": entryId, "groupId": 11503, "messageId": ++messageIdSeq, "text": "cm " + messageIdSeq, "userId": 99 }
                ]);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        getMoreMessageByEntryId: function (entriesId, creationDate, start, end, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                if (entriesId.length) {
                    options.success([
                        { "companyId": 10154, "creationDate": +new Date() + 5000, "entryId": newsIdSeq - 4, "groupId": 11503, "messageId": ++messageIdSeq, "text": "cm " + messageIdSeq, "userId": 100 },
                        { "companyId": 10154, "creationDate": +new Date() + 4000, "entryId": newsIdSeq - 3, "groupId": 11503, "messageId": ++messageIdSeq, "text": "cm " + messageIdSeq, "userId": 101 },
                        { "companyId": 10154, "creationDate": +new Date() + 3000, "entryId": newsIdSeq - 2, "groupId": 11503, "messageId": ++messageIdSeq, "text": "cm " + messageIdSeq, "userId": 102 },
                        { "companyId": 10154, "creationDate": +new Date() + 2000, "entryId": newsIdSeq - 1, "groupId": 11503, "messageId": ++messageIdSeq, "text": "cm " + messageIdSeq, "userId": 103 },
                        { "companyId": 10154, "creationDate": +new Date() + 1000, "entryId": newsIdSeq, "groupId": 11503, "messageId": ++messageIdSeq, "text": "cm " + messageIdSeq, "userId": 104 }
                    ]);
                } else {
                    options.success([]);
                }
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        getCountMessageByEntryId: function (entryId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success(Math.floor((Math.random() * 10)) + 1);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        addComment: function (comment, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                comment.attributes.messageId = ++messageIdSeq;
                comment.attributes.creationDate = +new Date();
                comment.attributes.userId = 10196;

                options.success(comment.toJSON());
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        getCountPost: function (date, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success(Math.floor((Math.random() * 10)) + 1);
//                defer.resolve(Math.floor((Math.random() * 10))+1);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        getCountComment: function (options) {
            var defer = $.Deferred();
            setTimeout(function () {
//                options.success(3);
                defer.resolve(Math.floor((Math.random() * 10)) + 1);
            }, delay);
            return defer.promise();
        },
        getCountCommentsOfPosts: function (entriesId, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success([
                    1, 2, 3, 4, 5, 6, 7, 8, 9
                ]);
                defer.resolve();
            }, delay);
            return defer.promise();
        },
        getScoreOfPost: function (postId) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve([
                    { "averageScore": 1, "cachedModel": false, "className": "com.liferay.portlet.blogs.model.BlogsEntry", "classNameId": 10007, "classPK": 26401, "columnBitmask": 3, "escapedModel": false, "expandoBridge": { "attributeNames": {}, "attributes": {}, "className": "com.liferay.portlet.ratings.model.RatingsStats", "classPK": 26408, "companyId": 10154, "indexEnabled": true }, "expandoBridgeAttributes": null, "modelAttributes": { "totalScore": 1, "averageScore": 1, "classNameId": 10007, "classPK": 26401, "totalEntries": 1, "statsId": 26408 }, "modelClass": "com.liferay.portlet.ratings.model.RatingsStats", "modelClassName": "com.liferay.portlet.ratings.model.RatingsStats", "new": false, "originalClassNameId": 0, "originalClassPK": 0, "primaryKey": 26408, "primaryKeyObj": 26408, "statsId": 26408, "totalEntries": 7, "totalScore": 10 }
                ]);
            }, delay);
            return defer.promise();
        },
        getUserVote: function (userId, postId) {
            var defer = $.Deferred();
            setTimeout(function () {
                defer.resolve(
                    {}
//                    { "classNameId": 10007, "classPK": 26401, "companyId": 10154, "createDate": 1389093152007, "entryId": 26802, "modifiedDate": 1389272763508, "score": -1, "userId": 10196, "userName": "Test Test" }
                );
            }, delay);
            return defer.promise();
        },
        setUserVote: function (postId, score, options) {
            var defer = $.Deferred();
            setTimeout(function () {
                options.success(
                    { "classNameId": 10007, "classPK": 26401, "companyId": 10154, "createDate": 1389093152007, "entryId": 26802, "modifiedDate": 1391415880449, "score": 0, "userId": 10196, "userName": "Test Test" }
                );
                defer.resolve();
            }, delay);
            return defer.promise();
        }
    }
};
