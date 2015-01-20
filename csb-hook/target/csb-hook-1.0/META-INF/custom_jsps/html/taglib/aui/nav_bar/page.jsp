<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/taglib/aui/nav_bar/init.jsp" %>


<%
    String themeName = themeDisplay.getLayout().getTheme().getName();
    String portletId = themeDisplay.getPortletDisplay().getId();
    if((null != themeName && (!themeName.equals("csb-admin-theme"))) ||  (!portletId.equals("145"))){

        %>
<liferay-util:buffer var="html">
    <liferay-util:include

        page="/html/taglib/aui/nav_bar/page.portal.jsp"
        useCustomPage="<%= false %>"
    />
</liferay-util:buffer>

<%
        out.print(html);
    } else {
%>













<div class="aui">




<div  id="<%= id %>"  <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %> class="page-header navbar navbar-fixed-top">
<!-- BEGIN HEADER INNER -->
<div class="page-header-inner"> <!-- BEGIN LOGO -->
<div class="page-logo"><a href="index.html"> <img src="/html/metronic/assets/rtl/admin/layout2/img/logo-default.png"
                                                  alt="logo" class="logo-default"> </a>

    <div class="menu-toggler sidebar-toggler">
        <!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header --> </div>
</div>
<!-- END LOGO --> <!-- BEGIN RESPONSIVE MENU TOGGLER -->
<a href="javascript:;"
   class="menu-toggler responsive-toggler"
   data-toggle="collapse"
   data-target=".navbar-collapse">
</a>
<!-- END RESPONSIVE MENU TOGGLER --> <!-- BEGIN PAGE ACTIONS -->
<!-- DOC: Remove "hide" class to enable the page header actions -->

<%--<div class="page-actions">
    <div class="btn-group hide">
        <button type="button" class="btn btn-circle red-pink dropdown-toggle" data-toggle="dropdown"><i
                class="icon-bar-chart"></i>&nbsp;<span class="hidden-sm hidden-xs">New&nbsp;</span>&nbsp;<i
                class="fa fa-angle-down"></i></button>
        <ul class="dropdown-menu" role="menu">
            <li><a href="#"> <i class="icon-user"></i> New User </a></li>
            <li><a href="#"> <i class="icon-present"></i> New Event <span class="badge badge-success">4</span>
            </a></li>
            <li><a href="#"> <i class="icon-basket"></i> New order </a></li>
            <li class="divider"></li>
            <li><a href="#"> <i class="icon-flag"></i> Pending Orders <span class="badge badge-danger">4</span>
            </a></li>
            <li><a href="#"> <i class="icon-users"></i> Pending Users <span
                    class="badge badge-warning">12</span> </a></li>
        </ul>
    </div>
    <div class="btn-group open">
        <button type="button" class="btn btn-circle green-haze dropdown-toggle" data-toggle="dropdown"
                ><i class="fa fa-plus"></i>&nbsp;<span
                class="hidden-sm hidden-xs">options&nbsp;</span>&nbsp;<i
                class="fa fa-angle-down"></i></button>
        <ul class="dropdown-menu" role="menu">
            <li><a href="#"> <i class="icon-docs"></i> New Post </a></li>
            <li><a href="#"> <i class="icon-tag"></i> New Comment </a></li>
            <li><a href="#"> <i class="icon-share"></i> Share </a></li>
            <li class="divider"></li>
            <li><a href="#"> <i class="icon-flag"></i> Comments <span class="badge badge-success">4</span> </a>
            </li>
            <li><a href="#"> <i class="icon-users"></i> Feedbacks <span class="badge badge-danger">2</span> </a>
            </li>
        </ul>
    </div>
</div>

--%>
<!-- END PAGE ACTIONS --> <!-- BEGIN PAGE TOP -->
<div class="page-top"> <!-- BEGIN HEADER SEARCH BOX -->
<!-- DOC: Apply "search-form-expanded" right after the "search-form" class to have half expanded search box -->
<%--<form class="search-form search-form-expanded" action="extra_search.html" method="GET">
    <div class="input-group"><input type="text"
                                    class="form-control"
                                    placeholder="Search..."
                                    name="query">
					<span class="input-group-btn">
					<a href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></a>
					</span>
    </div>
</form>
<!-- END HEADER SEARCH BOX -->
<!-- BEGIN TOP NAVIGATION MENU -->
<div class="top-menu">
<ul class="nav navbar-nav pull-right">
<!-- BEGIN NOTIFICATION DROPDOWN -->
<li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
       data-close-others="true">
        <i class="icon-bell"></i>
						<span class="badge badge-danger">
						7 </span>
    </a>
    <ul class="dropdown-menu">
        <li>
            <p>
                You have 14 new notifications
            </p>
        </li>
        <li>
            <div class="slimScrollDiv"
                 style="position: relative; overflow: hidden; width: auto; height: 250px;">
                <ul class="dropdown-menu-list scroller"
                    style="height: 250px; overflow: hidden; width: auto;" data-initialized="1">
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-success">
										<i class="fa fa-plus"></i>
										</span>
                            New user registered. <span class="time">
										Just now </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
                            Server #12 overloaded. <span class="time">
										15 mins </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
                            Server #2 not responding. <span class="time">
										22 mins </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
                            Application error. <span class="time">
										40 mins </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
                            Database overloaded 68%. <span class="time">
										2 hrs </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
                            2 user IP blocked. <span class="time">
										5 hrs </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
                            Storage Server #4 not responding. <span class="time">
										45 mins </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
                            System Error. <span class="time">
										55 mins </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
                            Database overloaded 68%. <span class="time">
										2 hrs </span>
                        </a>
                    </li>
                </ul>
                <div class="slimScrollBar"
                     style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-top-left-radius: 7px; border-top-right-radius: 7px; border-bottom-right-radius: 7px; border-bottom-left-radius: 7px; z-index: 99; right: 1px; height: 127.811860940695px; background: rgb(187, 187, 187);"></div>
                <div class="slimScrollRail"
                     style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-top-left-radius: 7px; border-top-right-radius: 7px; border-bottom-right-radius: 7px; border-bottom-left-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(234, 234, 234);"></div>
            </div>
        </li>
        <li class="external">
            <a href="#">
                See all notifications <i class="icon-arrow-right"></i>
            </a>
        </li>
    </ul>
</li>
<!-- END NOTIFICATION DROPDOWN -->
<!-- BEGIN INBOX DROPDOWN -->
<li class="dropdown dropdown-extended dropdown-inbox" id="header_inbox_bar">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
       data-close-others="true">
        <i class="icon-envelope-open"></i>
						<span class="badge badge-primary">
						4 </span>
    </a>
    <ul class="dropdown-menu">
        <li>
            <p>
                You have 12 new messages
            </p>
        </li>
        <li>
            <div class="slimScrollDiv"
                 style="position: relative; overflow: hidden; width: auto; height: 250px;">
                <ul class="dropdown-menu-list scroller"
                    style="height: 250px; overflow: hidden; width: auto;" data-initialized="1">
                    <li>
                        <a href="inbox.html?a=view">
										<span class="photo">
										<img src="../../assets/admin/layout2/img/avatar2.jpg" alt=""> </span> <span
                                class="subject"> <span class="from"> Lisa Wong </span> <span
                                class="time"> Just Now </span> </span> <span class="message"> Vivamus sed auctor nibh congue nibh. auctor nibh auctor nibh... </span>
                        </a></li>
                    <li><a href="inbox.html?a=view"> <span class="photo"> <img
                            src="../../assets/admin/layout2/img/avatar3.jpg" alt=""> </span> <span
                            class="subject"> <span class="from"> Richard Doe </span> <span
                            class="time"> 16 mins </span> </span> <span class="message"> Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
                    </a></li>
                    <li><a href="inbox.html?a=view"> <span class="photo"> <img
                            src="../../assets/admin/layout2/img/avatar1.jpg" alt=""> </span> <span
                            class="subject"> <span class="from"> Bob Nilson </span> <span
                            class="time"> 2 hrs </span> </span> <span class="message"> Vivamus sed nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
                    </a></li>
                    <li><a href="inbox.html?a=view"> <span class="photo"> <img
                            src="../../assets/admin/layout2/img/avatar2.jpg" alt=""> </span> <span
                            class="subject"> <span class="from"> Lisa Wong </span> <span
                            class="time"> 40 mins </span> </span> <span class="message"> Vivamus sed auctor 40% nibh congue nibh... </span>
                    </a></li>
                    <li><a href="inbox.html?a=view"> <span class="photo"> <img
                            src="../../assets/admin/layout2/img/avatar3.jpg" alt=""> </span> <span
                            class="subject"> <span class="from"> Richard Doe </span> <span
                            class="time"> 46 mins </span> </span> <span class="message"> Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
                    </a></li>
                </ul>
                <div class="slimScrollBar"
                     style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-top-left-radius: 7px; border-top-right-radius: 7px; border-bottom-right-radius: 7px; border-bottom-left-radius: 7px; z-index: 99; right: 1px; height: 127.551020408163px; background: rgb(187, 187, 187);"></div>
                <div class="slimScrollRail"
                     style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-top-left-radius: 7px; border-top-right-radius: 7px; border-bottom-right-radius: 7px; border-bottom-left-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(234, 234, 234);"></div>
            </div>
        </li>
        <li class="external"><a href="inbox.html"> See all messages <i class="icon-arrow-right"></i>
        </a></li>
    </ul>
</li>
<!-- END INBOX DROPDOWN --> <!-- BEGIN TODO DROPDOWN -->
<li class="dropdown dropdown-extended dropdown-tasks" id="header_task_bar"><a href="#"
                                                                              class="dropdown-toggle"
                                                                              data-toggle="dropdown"
                                                                              data-hover="dropdown"
                                                                              data-close-others="true">
    <i class="icon-calendar"></i> <span class="badge badge-success"> 3 </span> </a>
    <ul class="dropdown-menu extended tasks">
        <li><p> You have 12 pending tasks </p></li>
        <li>
            <div class="slimScrollDiv"
                 style="position: relative; overflow: hidden; width: auto; height: 250px;">
                <ul class="dropdown-menu-list scroller"
                    style="height: 250px; overflow: hidden; width: auto;" data-initialized="1">
                    <li><a href="page_todo.html"> <span class="task"> <span class="desc"> New release v1.2 </span> <span
                            class="percent"> 30% </span> </span>

                        <div class="progress">
                            <div style="width: 40%;" class="progress-bar progress-bar-success"
                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100">
                                <div class="sr-only"> 40% Complete</div>
                            </div>
                        </div>
                    </a></li>
                    <li><a href="page_todo.html"> <span class="task"> <span class="desc"> Application deployment </span> <span
                            class="percent"> 65% </span> </span>

                        <div class="progress progress-striped">
                            <div style="width: 65%;" class="progress-bar progress-bar-danger"
                                 aria-valuenow="65" aria-valuemin="0" aria-valuemax="100">
                                <div class="sr-only"> 65% Complete</div>
                            </div>
                        </div>
                    </a></li>
                    <li><a href="page_todo.html"> <span class="task"> <span
                            class="desc"> Mobile app release </span> <span
                            class="percent"> 98% </span> </span>

                        <div class="progress">
                            <div style="width: 98%;" class="progress-bar progress-bar-success"
                                 aria-valuenow="98" aria-valuemin="0" aria-valuemax="100">
                                <div class="sr-only"> 98% Complete</div>
                            </div>
                        </div>
                    </a></li>
                    <li><a href="page_todo.html"> <span class="task"> <span
                            class="desc"> Database migration </span> <span
                            class="percent"> 10% </span> </span>

                        <div class="progress progress-striped">
                            <div style="width: 10%;" class="progress-bar progress-bar-warning"
                                 aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">
                                <div class="sr-only"> 10% Complete</div>
                            </div>
                        </div>
                    </a></li>
                    <li><a href="page_todo.html"> <span class="task"> <span
                            class="desc"> Web server upgrade </span> <span
                            class="percent"> 58% </span> </span>

                        <div class="progress progress-striped">
                            <div style="width: 58%;" class="progress-bar progress-bar-info"
                                 aria-valuenow="58" aria-valuemin="0" aria-valuemax="100">
                                <div class="sr-only"> 58% Complete</div>
                            </div>
                        </div>
                    </a></li>
                    <li><a href="page_todo.html"> <span class="task"> <span
                            class="desc"> Mobile development </span> <span
                            class="percent"> 85% </span> </span>

                        <div class="progress progress-striped">
                            <div style="width: 85%;" class="progress-bar progress-bar-success"
                                 aria-valuenow="85" aria-valuemin="0" aria-valuemax="100">
                                <div class="sr-only"> 85% Complete</div>
                            </div>
                        </div>
                    </a></li>
                    <li><a href="page_todo.html"> <span class="task"> <span class="desc"> New UI release </span> <span
                            class="percent"> 18% </span> </span>

                        <div class="progress progress-striped">
                            <div style="width: 18%;" class="progress-bar progress-bar-important"
                                 aria-valuenow="18" aria-valuemin="0" aria-valuemax="100">
                                <div class="sr-only"> 18% Complete</div>
                            </div>
                        </div>
                    </a></li>
                </ul>
                <div class="slimScrollBar"
                     style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: block; border-top-left-radius: 7px; border-top-right-radius: 7px; border-bottom-right-radius: 7px; border-bottom-left-radius: 7px; z-index: 99; right: 1px; background: rgb(187, 187, 187);"></div>
                <div class="slimScrollRail"
                     style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-top-left-radius: 7px; border-top-right-radius: 7px; border-bottom-right-radius: 7px; border-bottom-left-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(234, 234, 234);"></div>
            </div>
        </li>
        <li class="external"><a href="page_todo.html"> See all tasks <i
                class="icon-arrow-right"></i> </a></li>
    </ul>
</li>
<!-- END TODO DROPDOWN --> <!-- BEGIN QUICK SIDEBAR TOGGLER -->
<li class="dropdown dropdown-quick-sidebar-toggler hide"><a href="javascript:;"
                                                            class="dropdown-toggle"> <i
        class="icon-logout"></i> </a></li>
<!-- END QUICK SIDEBAR TOGGLER --> <!-- BEGIN USER LOGIN DROPDOWN -->
<li class="dropdown dropdown-user"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                      data-hover="dropdown" data-close-others="true"> <img alt=""
                                                                                           class="img-circle hide1"
                                                                                           src="../../assets/admin/layout/img/avatar3_small.jpg">
    <span class="username username-hide-on-mobile"> Bob </span> <i class="fa fa-angle-down"></i>
</a>
    <ul class="dropdown-menu">
        <li><a href="extra_profile.html"> <i class="icon-user"></i> My Profile </a></li>
        <li><a href="page_calendar.html"> <i class="icon-calendar"></i> My Calendar </a></li>
        <li><a href="inbox.html"> <i class="icon-envelope-open"></i> My Inbox <span
                class="badge badge-danger"> 3 </span> </a></li>
        <li><a href="page_todo.html"> <i class="icon-rocket"></i> My Tasks <span
                class="badge badge-success"> 7 </span> </a></li>
        <li class="divider"></li>
        <li><a href="extra_lock.html"> <i class="icon-lock"></i> Lock Screen </a></li>
        <li><a href="login.html"> <i class="icon-key"></i> Log Out </a></li>
    </ul>
</li>
<!-- END USER LOGIN DROPDOWN -->
</ul>
</div>--%>
<!-- END TOP NAVIGATION MENU -->
     <%= responsiveButtons %>

       <%= bodyContentString %>

       <aui:script use="aui-base,event-outside">
           A.one('#<%= id %>').delegate(
           'click',
           function(event) {
           var btnNavbar = event.currentTarget;

           var navId = btnNavbar.attr('data-navId');

           var navbarCollapse = A.one('#' + navId + 'NavbarCollapse');

           if (navbarCollapse) {
           var handle = Liferay.Data['<%= id %>Handle'];

           if (navbarCollapse.hasClass('open') && handle) {
           handle.detach();

           handle = null;
           }
           else {
           handle = navbarCollapse.on(
           'mousedownoutside',
           function(event) {
           if (!btnNavbar.contains(event.target)) {
           Liferay.Data['<%= id %>Handle'] = null;

           handle.detach();

           navbarCollapse.removeClass('open');
           }
           }
           );
           }

           navbarCollapse.toggleClass('open');

           Liferay.Data['<%= id %>Handle'] = handle;
           }
           },
           '.btn-navbar'
           );
       </aui:script>
</div>




<!-- END PAGE TOP -->
</div>
<!-- END HEADER INNER -->
</div>


</div>

<%--

<div class="navbar <%= cssClass %>" id="<%= id %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
    <div class="navbar-inner">
        <div class="container">
            <%= responsiveButtons %>

            <%= bodyContentString %>

            <aui:script use="aui-base,event-outside">
                A.one('#<%= id %>').delegate(
                'click',
                function(event) {
                var btnNavbar = event.currentTarget;

                var navId = btnNavbar.attr('data-navId');

                var navbarCollapse = A.one('#' + navId + 'NavbarCollapse');

                if (navbarCollapse) {
                var handle = Liferay.Data['<%= id %>Handle'];

                if (navbarCollapse.hasClass('open') && handle) {
                handle.detach();

                handle = null;
                }
                else {
                handle = navbarCollapse.on(
                'mousedownoutside',
                function(event) {
                if (!btnNavbar.contains(event.target)) {
                Liferay.Data['<%= id %>Handle'] = null;

                handle.detach();

                navbarCollapse.removeClass('open');
                }
                }
                );
                }

                navbarCollapse.toggleClass('open');

                Liferay.Data['<%= id %>Handle'] = handle;
                }
                },
                '.btn-navbar'
                );
            </aui:script>
        </div>
    </div>
</div>--%>
<%}%>