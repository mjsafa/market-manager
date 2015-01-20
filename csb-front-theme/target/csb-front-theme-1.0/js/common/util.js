/**
 * Created with IntelliJ IDEA.
 * User: hamiri
 * Date: 10/27/13
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
function isRTL() {
    return document.body.className == "rtl";
}
function getDateType() {
    return document.body.className == "rtl" ? 'jalali' : 'gregorian';
}
function getTimeZoneOffset() {
    return 3600000 * 3.5;
}
function getLocalDate() {
    return toLocalDate(new Date());
}
function toLocalDate(date) {
    return new Date(date.getTime() + getTimeZoneOffset());
}
function toUTCDate(localDate) {
    return new Date(localDate.getTime() - getTimeZoneOffset());
}
function getYMD(date) {
    var year, month, day;
    if (getDateType() == 'jalali') {
        year = date.getJalaliFullYear();
        month = Calendar._JSMN[date.getJalaliMonth()];
        day = date.getJalaliDate();
    } else {
        year = date.getFullYear();
        month = Calendar._SMN[date.getMonth()];
        day = date.getDate();
    }
    return {year:year, month:month, day:day};
}
function printDate(date) {
    return toLocalDate(date).print("%Y-%m-%d", getDateType());
}
function printDateAndTime(date) {
    return toLocalDate(date).print("%Y-%m-%d %H:%M", getDateType());
}
function printMembershipType(type) {
    switch (type) {
        case MembershipConstants.TYPE_FOLLOWER:
            return 'follower';
        case MembershipConstants.TYPE_MEMBER:
            return 'member';
    }
}
function printMembershipStatus(status) {
    switch (status) {
        case MembershipConstants.STATUS_ACCEPTED:
            return 'accepted';
        case MembershipConstants.STATUS_REJECTED:
            return 'rejected';
        case MembershipConstants.STATUS_REQUESTED:
            return "requested";
        case MembershipConstants.STATUS_INVITED:
            return 'invited';
    }
}
function printPostStatus(status) {
    switch (status) {
        case BlogEntryConstants.STATUS_APPROVED:
            return 'approved';
        case BlogEntryConstants.STATUS_DENIED:
            return 'denied';
        case BlogEntryConstants.STATUS_DRAFT:
            return 'draft';
    }
}
function dateTimeToString(date) {
    return $.datepicker.formatDate('mm/dd/yy', date) + ' ' + $.datepicker.formatTime('HH:mm', {hour:date.getHours(), minute:date.getMinutes()});
}
/*function dateToString(date) {
 return $.datepicker.formatDate('mm/dd/yy', date);
 }*/
function stringToDateTime(date) {

}
function formatName(user) {
    return $.trim((user.firstName || '') + ' ' + (user.lastName || ''));
}

function printNameFromModel(user) {
    return $.trim((user.get('firstName') || '') + ' ' + (user.get('lastName') || ''));
}

function formatTag(tag) {
    return $.trim(tag.name);
}

function formatCategory(category) {
    return $.trim(category.title);
}

function formatEmail(email) {
    return $.trim(email.address);
}

function printItem(name, escape) {
    return '<div>' + (name ? '<span class="name">' + escape(name) + '</span>' : '') + '</div>';
}

function printOption(label, caption, escape) {
    return '<div>' + '<span class="label">' + escape(label) + '</span>'
        + (caption ? '<span class="caption">'
        + escape(caption) + '</span>' : '') + '</div>';
}

function dateToString(date) {
    return toLocalDate(date).print("%d %b %Y", getDateType());
}

function dateToStringArray(timestamp) {
    var date = new Date(timestamp);
    return [$.datepicker.formatDate('dd', date), $.datepicker.formatDate('M', date), $.datepicker.formatDate('yy', date)];
}
function timeToString(timestamp) {
    var date = new Date(timestamp);
    return date.getHours() + ":" + date.getMinutes();
}

function isEnglishLetter(c){
    /*var n = c.charCodeAt(0);
    return (n >= 65 && n <= 90 ) || (n >= 97 && n <= 122 );*/
    return c.match('[A-Za-z]');
}

function isPersianLetter(c){
    return c.match('[آ-ی]');
}