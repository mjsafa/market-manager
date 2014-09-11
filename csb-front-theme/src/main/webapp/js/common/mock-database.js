var i, sec = 1000, min = sec * 60, hour = min * 60, day = hour * 24,
    userId = 1000, groupId = 1001,
    delay = 0.5 * sec, sequence = 50,
    meetingMembership = [], meetingList = [], recordingList = [],
    Liferay = {
        Language:{
            get:function (msg) {
                return msg == "lang.dir" ? "rtl" : msg;
            }
        }
    },
    groupSettingList = [],
    groupList = [],
    userList = [],
    messageList = [],
    MeetingMembershipConstants = {
        STATUS_NOT_START:0,
        STATUS_STOP:1,
        STATUS_FINISH:2,
        STATUS_START:3
    },
    membershipList = [],
    associationData = {
        users:[],
        tags:[],
        categories:[]
    },
    GroupSettingConstants = {
        METHOD_NONE:0,
        METHOD_PRIVATE:1,
        METHOD_PUBLIC:2
    },
    MembershipConstants = {
        TYPE_FOLLOWER:0,
        TYPE_MEMBER:1,
        TYPE_OWNER:2,

        STATUS_REQUESTED:0,
        STATUS_INVITED:1,
        STATUS_ACCEPTED:2,
        STATUS_REJECTED:3
    },
    BlogEntryConstants = {
        STATUS_APPROVED:0,
        STATUS_DENIED:4,
        STATUS_DRAFT:2
    },
    blogEntryList = [],
    themeDisplay = {
        getUserId:function () {
            return userId
        },
        getScopeGroupId:function () {
            return groupId
//            return userId
            return groupId
        },
        getLanguageId:function () {
            return "fa_IR"
        },
        pageIsUser:function () {
//            return true;
            return false;
        },
        getPageOwnerId:function () {
            return this.groupSetting.ownerId;
        },
        groupSetting:{
            groupId:groupId,
            ownerId:userId,
            enable:true,
            membershipMethod:GroupSettingConstants.METHOD_PUBLIC,
            confirmPublishing:true
        },
        user:{
            userId:userId,
            screenName:'hamiri',
            firstName:'حسین',
            lastName:'امیری',
            emailaddress:'hamiri@armansoft.ir'
        },
        page:{
            name:"پرسپولیس",
            description:"پرسپولیس زلزله محبوب هرچی دله",
            logo:"images/armano/group/g (1).jpg"
        },
        membership:{
            /*requestId: ++sequence,
             groupId: groupId,
             createDate: new Date().getTime() + ((Math.floor((Math.random() * 3) + 1)) * day),
             followerId: userId,
             status: MembershipConstants.STATUS_REQUESTED,
             type: MembershipConstants.TYPE_OWNER*/
            /*membershipId: ++sequence,
             groupId: groupId,
             createDate: new Date().getTime() + ((Math.floor((Math.random() * 3) + 1)) * day),
             followerId: userId,
             status: MembershipConstants.STATUS_REQUESTED,
             type: MembershipConstants.TYPE_OWNER*/
        }
    };
tagList = [
    {tagId:++sequence, name:'ایران'},
    {tagId:++sequence, name:'تهران'},
    {tagId:++sequence, name:'اصفهان'},
    {tagId:++sequence, name:'صفاییان'}
],
    categoryList = [
        {categoryId:++sequence, title:'اقتصاد'},
        {categoryId:++sequence, title:'توسعه همه جانبه'},
        {categoryId:++sequence, title:'غرب شناسی'},
        {categoryId:++sequence, title:'تاریخ معاصر'}
    ],
    emailList = [
        {emailId:++sequence, address:'ssafaeian@armansoft.local'},
        {emailId:++sequence, address:'msafaeian@armansoft.local'},
        {emailId:++sequence, address:'mtoosi@armansoft.local'},
        {emailId:++sequence, address:'hamiri@armansoft.local'}
    ];
for (var i = 1; i < 20; i++) {
    groupList.push({groupId:++sequence, name:"Group_" + sequence, description:"Description_" + sequence});
    groupList.push({groupId:groupId, name:themeDisplay.page.name, description:themeDisplay.page.description});
}
for (i = 1; i < 20; i++) {
    groupList.push({groupId:++sequence, name:"Group_" + i, description:i % 3 == 0 ? "" : "Description_" + i});
}

for (var i = 0; i < 10; i++) {
    var association = {
        groupId:sequence++,
        name:"Islamic Movement" + "-" + sequence,
        createDate:new Date() - (i),
        tags:[tagList[i % 4].name],
        description:"Islamic ovement is the international community which includes members all over the world with islamic concerns and ideas"}
    groupList.push(association);
}

for (i = 1; i < 5; i++) {
    userList.push({userId:++sequence, portraitId:sequence, screenName:'hamiri_' + i, firstName:'حسین - ' + i, lastName:'امیری - ' + i, emailaddress:'hamiri_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'mafa_' + i, firstName:'مجتبی - ' + i, lastName:'صفاییان - ' + i, emailaddress:'mafa_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'safa_' + i, firstName:'سجاد - ' + i, lastName:'صفاییان - ' + i, emailaddress:'safa_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'toosi_' + i, firstName:'مسعود - ' + i, lastName:'طوسی - ' + i, emailaddress:'toosi_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'hrasekhi_' + i, firstName:'حسین - ' + i, lastName:'راسخی - ' + i, emailaddress:'hrasekhi_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'mdavodi_' + i, firstName:'مهدی - ' + i, lastName:'داوود آبادی - ' + i, emailaddress:'mdavodi_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'rmazloom_' + i, firstName:'رضا - ' + i, lastName:'مظلوم - ' + i, emailaddress:'rmazloom_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'hqodmanan_' + i, firstName:'حمید رضا - ' + i, lastName:'قدمنان - ' + i, emailaddress:'hqodmanan_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'acholmaghani_' + i, firstName:'علی - ' + i, lastName:'چلمقانی - ' + i, emailaddress:'acholmaghani_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'aakbari_' + i, firstName:'احمد - ' + i, lastName:'اکبری - ' + i, emailaddress:'aakbari_' + i + '@armansoft.ir'});
    userList.push({userId:++sequence, portraitId:sequence, screenName:'rjahande_' + i, firstName:'روح الله - ' + i, lastName:'جهنده - ' + i, emailaddress:'rjahande_' + i + '@armansoft.ir'});
}
_.each(groupList, function (group) {
    groupSettingList.push({
        groupId:group.groupId,
        ownerId:group.groupId % 5 == 0 ? userId : group.groupId,
        ownerId:_.sample(userList, 1)[0].userId,
        enable:true,
        membershipMethod:GroupSettingConstants.METHOD_PUBLIC,
        confirmPublishing:true
    });
});

userList.push(_.clone(themeDisplay.user));
_.each(_.sample(groupList, groupList.length * 2 / 3), function (group) {
    _.each(userList, function (user, index) {
        var groupSetting = _.findWhere(groupSettingList, {groupId:group.groupId});
        if (groupSetting.ownerId != user.userId) {
            membershipList.push({
                membershipId:++sequence,
                groupId:group.groupId,
                createDate:new Date().getTime() + ((Math.floor((Math.random() * 3) + 1)) * day),
                followerId:user.userId,
                status:Math.floor((Math.random() * 4)),
                type:index % 2 == 0
            });
        }
    });
});

userList.push(_.clone(themeDisplay.user));
_.each(groupList, function (group) {
    var groupSetting = _.findWhere(groupSettingList, {groupId:group.groupId});
    _.each(userList, function (user, index) {
        if (groupSetting.ownerId != user.userId) {
            membershipList.push({
                membershipId:++sequence,
                groupId:group.groupId,
                createDate:new Date().getTime() + ((Math.floor((Math.random() * 3) + 1)) * day),
                followerId:user.userId,
                status:Math.floor((Math.random() * 4)),
                type:sequence % 2
            });
        }
    });
});
_.each(_.where(membershipList, {status:MembershipConstants.STATUS_ACCEPTED}), function (request) {
    var user = _.findWhere(userList, {userId:request.followerId});
    blogEntryList.push({authorId:user.userId, author:user.firstName + " " + user.lastName, entryId:++sequence, groupId:groupId, createDate:new Date() - 2 * day, content:"دبیرکل جمعیت رهپویان انقلاب اسلامی گفت: برخی خودی‌ها خطرناک‌تر از غیرخودی‌ها عمل می‌کنند اما لازم است به خود بیایند و با حفظ وحدت ملازم و همراه رهبری باشند. " + sequence, status:BlogEntryConstants.STATUS_DRAFT});
    blogEntryList.push({authorId:user.userId, author:user.firstName + " " + user.lastName, entryId:++sequence, groupId:groupId, createDate:new Date() - 2 * day, content:"دبیرکل جمعیت رهپویان انقلاب اسلامی گفت: برخی خودی‌ها خطرناک‌تر از غیرخودی‌ها عمل می‌کنند اما لازم است به خود بیایند و با حفظ وحدت ملازم و همراه رهبری باشند.        " + sequence, status:BlogEntryConstants.STATUS_DENIED});
    blogEntryList.push({authorId:user.userId, author:user.firstName + " " + user.lastName, entryId:++sequence, groupId:groupId, createDate:new Date() - 2 * day, content:"دبیرکل جمعیت رهپویان انقلاب اسلامی گفت: برخی خودی‌ها خطرناک‌تر از غیرخودی‌ها عمل می‌کنند اما لازم است به خود بیایند و با حفظ وحدت ملازم و همراه رهبری باشند.        " + sequence, status:BlogEntryConstants.STATUS_APPROVED});
})
for (i = 1; i < 10; i++) {
    blogEntryList.push({authorId:userId, entryId:++sequence, groupId:userId, createDate:new Date() - 2 * day, content:"user-content " + sequence, status:BlogEntryConstants.STATUS_APPROVED});
}
for (i = 0; i < 30; i++) {
    var meeting = {ownerId:userId,
        meetingId:++sequence,
        meetingName:'Meeting ' + sequence,
        welcomeMessage:'Welcome Message ' + sequence,
        startDate:new Date().getTime() + (4 * day),
        duration:100 + (i % 3) * 10,
        status:i % 10 == 0 ? MeetingMembershipConstants.STATUS_START : i % 3,
        recording:i % 2 == 0}
    if (meeting.status == MeetingMembershipConstants.STATUS_FINISH) {
        meeting.recordId = ++sequence;
        meeting.published = i % 2 == 0;
        meeting.recordUrl = "http://google.com/" + i;
    }
    meetingList.push(meeting);
    meetingMembership[sequence] = _.pluck(_.sample(userList, userList.length * 2 / 3), 'userId');
}

messageList.push({key:'activity-shareboards-add-comment-in', value:'{1} commented on {2}\'s Share Board entry, {0}'});
messageList.push({key:'activity-shareboards-add-comment', value:'{1} commented on {2}\'s Share Board entry'});
messageList.push({key:'activity-shareboards-add-entry-in', value:'{1} wrote a new Share Board entry, {0}'});
messageList.push({key:'activity-shareboards-add-entry', value:'{1} wrote a new Share Board entry'});
messageList.push({key:'activity-shareboards-update-entry-in', value:'{1} updated a Share Board entry, {0}'});
messageList.push({key:'activity-shareboards-update-entry', value:'{1} updated a Share Board entry'});

messageList.push({key:'activity-virtualclass-create-meeting-in', value:'{1} create a meeting, {3}, {0}'});
messageList.push({key:'activity-virtualclass-create-meeting', value:'{1} create a meeting, {3}'});
messageList.push({key:'activity-virtualclass-start-meeting-in', value:'{1} start a meeting, {3}, {0}'});
messageList.push({key:'activity-virtualclass-start-meeting', value:'{1} start a meeting, {3}'});
messageList.push({key:'activity-virtualclass-stop-meeting-in', value:'{1} stop a meeting, {3}, {0}'});
messageList.push({key:'activity-virtualclass-stop-meeting', value:'{1} stop a meeting, {3}'});
messageList.push({key:'activity-virtualclass-join-meeting-in', value:'{1} join to meeting, {3}, {0}'});
messageList.push({key:'activity-virtualclass-join-meeting', value:'{1} join to meeting, {3}'});

messageList.push({key:'activity-headers-name', value:'{\"last\": \"LAST\", \"table\": \"TABLE\", \"virtualclass\": \"ROOM\", \"tasks\": \"TASK\", \"shareboard\": \"BOARD\", \"cabinet\": \"CABINET\"}'});
messageList.push({key:'activity-last-activities-in-x', value:'last activity on <em>{0}</em> in <em>{1}</em>'});
messageList.push({key:'group-setting', value:'Group Setting'});
messageList.push({key:'invite-member', value:'Invite Member'});
messageList.push({key:'edit-meeting', value:'Edit metting {0}'});
messageList.push({key:'start-meeting', value:'Start meeting'});
messageList.push({key:'plan-meeting', value:'Plan meeting'});
messageList.push({key:'x-minutes', value:'{0} minutes'});

messageList.push({key:'task-create', value:'New Task'});
messageList.push({key:'task-edit', value:'Edit Task'});
messageList.push({key:'task-headers-name', value:'{\"assignee\": \"ASSIGNEE\", \"reporter\": \"REPORTER\", \"diagrams\": \"DIAGRAMS\"}'});
messageList.push({key:'task-priority', value:'{\"high\": \"High\", \"normal\": \"Normal\", \"low\": \"Low\"}'});

messageList.push({key:'cabinet-headers-name', value:'{\"recent\": \"RECENT\", \"favourite\": \"FAVOURITE\"}'});