var serverAPI = serverAPI || {};
serverAPI.System = {
    Language: {
        get: function (key, options) {
            var defer = $.Deferred();
            $.get("/language/" + themeDisplay.getLanguageId() + "/" + key + "/").then(function (message) {
                if (options && options.success) {
                    options.success(message);
                }
                defer.resolve(message);
            });
            return defer.promise();
        }
    },
    User: {
        searchInsideGroup: function (query, start, end, options) {
            return callService(Liferay.Service.SYS.User2.searchInsideGroup, {
                query: query,
                start: start,
                end: end,
                serviceContext: createServiceContext()
            }, options);
        },
        searchOutsideGroup: function (query, start, end, options) {
            return callService(Liferay.Service.SYS.User2.searchOutsideGroup, {
                query: query,
                start: start,
                end: end,
                serviceContext: createServiceContext()
            }, options);
        },
        get: function (userId, options) {
            return callService(Liferay.Service.SYS.User2.getUserById, {
                userId: userId,
                serviceContext: createServiceContext()
            }, options);
        }

    },
    GroupSetting: {
        get: function (groupId, options) {
            return callService(Liferay.Service.SYS.GroupSetting.get, {
                groupId: groupId,
                serviceContext: createServiceContext()
            }, options);
        },
        edit: function (model, options) {
            return callService(Liferay.Service.SYS.GroupSetting.edit, {
                groupId: model.id,
                enable: model.get('enable'),
                membershipMethod: model.get('membershipMethod'),
                confirmPublishing: model.get('confirmPublishing'),
                serviceContext: createServiceContext()
            }, options);
        }
    },
    Group: {
        get: function (groupId, options) {
            return callService(Liferay.Service.SYS.Group2.get, {
                groupId: groupId,
                serviceContext: createServiceContext()
            }, options);
        },
        findByU_M: function (userId, membershipType, options) {
            return callService(Liferay.Service.SYS.Group2.findByU_M, {
                userId: userId,
                membershipType: membershipType,
                serviceContext: createServiceContext()
            }, options);
        },
        add: function (model, options) {
            return callService(Liferay.Service.SYS.Group2.addGroup, {
                name: model.get('name'),
                description: model.get('description'),
                userIds: JSON.stringify(model.get('users')),
                emails: JSON.stringify(model.get('emails')),
                serviceContext: createServiceContext()
            }, options)
        },
        findByTags: function (tags, start, end, options) {
            return callService(Liferay.Service.SYS.Group2.findByTag, {
                query: tags[0],
                start: start,
                end: end,
                serviceContext: createServiceContext()
            }, options)
        },
        findBold: function (options) {
            return callService(Liferay.Service.SYS.Group2.getTop, {
                serviceContext: createServiceContext()
            }, options)
        },
        findRecentActivity: function (options) {
            return callService(Liferay.Service.SYS.Group2.getActiveGroups, {
                count: 5,
                serviceContext: createServiceContext()
            }, options)
        },
        findRecentCreated: function (options) {
            return callService(Liferay.Service.SYS.Group2.getLastGroups, {
                count: 5,
                serviceContext: createServiceContext()
            }, options)
        },
        findByOwnerId: function (ownerId, start, end, options) {
            return callService(Liferay.Service.SYS.Group2.getByOwnerId, {
                ownerId: ownerId,
                start: start,
                end: end,
                serviceContext: createServiceContext()
            }, options)
        }
    },
    Membership: {
        get: function (options) {
            return callService(Liferay.Service.SYS.Membership.get, {
                serviceContext: createServiceContext()
            }, options);
        },
        findByMembershipId: function (membershipId, options) {
            return callService(Liferay.Service.SYS.Membership.findByMembershipId, {
                membershipId: membershipId,
                serviceContext: createServiceContext()
            }, options);
        },
        findByG_F: function (groupId, followerId, options) {
            return callService(Liferay.Service.SYS.Membership.findByG_F, {
                groupId: groupId,
                followerId: followerId,
                serviceContext: createServiceContext()
            }, options);
        },
        join: function (options) {
            return callService(Liferay.Service.SYS.Membership.join, {
                serviceContext: createServiceContext()
            }, options);
        },
        joinByGroupId: function (groupId, options) {
            return callService(Liferay.Service.SYS.Membership.joinByGroupId, {
                groupId: groupId,
                serviceContext: createServiceContext()
            }, options);
        },
        findByG_T_S: function (groupId, type, statuses, start, end, options) {
            return callService(Liferay.Service.SYS.Membership.findByG_T_S, {
                groupId: groupId,
                type: type,
                statuses: statuses,
                start: start,
                end: end,
                serviceContext: createServiceContext()
            }, options);
        },
        findByF_S: function (followerId, statuses, start, end, options) {
            return callService(Liferay.Service.SYS.Membership.findByF_S, {
                followerId: followerId,
                statuses: statuses,
                start: start,
                end: end,
                serviceContext: createServiceContext()
            }, options);
        },
        reject: function (membershipId, options) {
            return callService(Liferay.Service.SYS.Membership.reject, {
                membershipId: membershipId,
                serviceContext: createServiceContext()
            }, options);
        },
        accept: function (membershipId, options) {
            return callService(Liferay.Service.SYS.Membership.accept, {
                membershipId: membershipId,
                serviceContext: createServiceContext()
            }, options);
        },
        changeType: function (membershipId, type, options) {
            return callService(Liferay.Service.SYS.Membership.changeType, {
                membershipId: membershipId,
                type: type,
                serviceContext: createServiceContext()
            }, options);
        },
        invite: function (followerIds, type, options) {
            return callService(Liferay.Service.SYS.Membership.invite, {
                followerIds: followerIds,
                type: type,
                serviceContext: createServiceContext()
            }, options);
        },
        delete: function (model, options) {
            return callService(Liferay.Service.SYS.Membership.delete, {
                membershipId: model.id,
                serviceContext: createServiceContext()
            }, options);
        }
    },
    Tag: {
        simpleSearch: function (query, start, end, options) {
            return callService(Liferay.Service.SYS.Tag.findByName, {
                query: query,
                start: start,
                end: end
            }, options)
        }
    }
};