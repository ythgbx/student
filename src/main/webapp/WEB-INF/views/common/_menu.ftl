<#macro menu >
<aside class="sidebar-menu fixed">
    <div class="sidebar-inner scrollable-sidebar">
        <div class="main-menu">
            <ul class="accordion">
                <li class="menu-header">
                    Main Menu
                </li>
                <li class="bg-palette1">
                    <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-home fa-lg"></i></span>
										<span class="text m-left-sm">管理中心</span>
									</span>
									<span class="menu-content-hover block">
										Home
									</span>
                    </a>
                </li>
                <li class="bg-palette2">
                    <a href="landing/landing.html">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-desktop fa-lg"></i></span>
										<span class="text m-left-sm">Landing</span>
									</span>
									<span class="menu-content-hover block">
										Landing
									</span>
                    </a>
                </li>
                <li class="openable bg-palette3">
                    <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
										<span class="text m-left-sm">商品管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										Form
									</span>
                    </a>
                    <ul class="submenu bg-palette4">
                        <li><a href="/commodity/list"><span class="submenu-label">商品管理</span></a></li>
                        <li><a href="/commodity/orderList"><span class="submenu-label">用户订单查询</span></a></li>
                        <#--<li><a href="form_wizard.html"><span class="submenu-label">Form Wizard</span></a></li>-->
                        <#--<li><a href="dropzone.html"><span class="submenu-label">Dropzone</span></a></li>-->
                    </ul>
                </li>
                <li class="openable bg-palette4">
                    <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-tags fa-lg"></i></span>
										<span class="text m-left-sm">用户管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										UI Kits
									</span>
                    </a>
                    <ul class="submenu">
                        <li><a href="/user/list"><span class="submenu-label">用户详情信息</span></a></li>
                        <li><a href="button.html"><span class="submenu-label">积分充值</span></a></li>
                        <li class="openable">
                            <a href="#">
                                <small class="badge badge-success badge-square bounceIn animation-delay2 m-left-xs pull-right">2</small>
                                <span class="submenu-label">Tables</span>
                            </a>
                            <ul class="submenu third-level">
                                <li><a href="static_table.html"><span class="submenu-label">Static Table</span></a></li>
                                <li><a href="datatable.html"><span class="submenu-label">DataTables</span></a></li>
                            </ul>
                        </li>
                        <li><a href="widget.html"><span class="submenu-label">用户反馈信息</span></a></li>
                        <li><a href="/ticket/userList?id=110"><span class="submenu-label">乘车记录</span></a></li>
                        <li><a href="calendar.html"><span class="submenu-label">交易记录</span></a></li>
                        <li><a href="treeview.html"><span class="submenu-label">Treeview</span></a></li>
                        <li><a href="nestable_list.html"><span class="submenu-label">Nestable Lists</span></a></li>
                    </ul>
                </li>
                <li class="bg-palette1">
                    <a href="inbox.html">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-envelope fa-lg"></i></span>
										<span class="text m-left-sm">Inboxs</span>
										<small class="badge badge-danger badge-square bounceIn animation-delay5 m-left-xs">5</small>
									</span>
									<span class="menu-content-hover block">
										Inboxs
									</span>
                    </a>
                </li>
                <li class="bg-palette2">
                    <a href="timeline.html">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-clock-o fa-lg"></i></span>
										<span class="text m-left-sm">Timeline</span>
										<small class="badge badge-warning badge-square bounceIn animation-delay6 m-left-xs pull-right">7</small>
									</span>
									<span class="menu-content-hover block">
										Timeline
									</span>
                    </a>
                </li>
                <li class="menu-header">
                    Others
                </li>
                <li class="openable bg-palette3">
                    <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-gift fa-lg"></i></span>
										<span class="text m-left-sm">临时界面</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										Pages
									</span>
                    </a>
                    <ul class="submenu">
                        <li><a href="signin.html"><span class="submenu-label">Sign in</span></a></li>
                        <li><a href="signup.html"><span class="submenu-label">Sign Up</span></a></li>
                        <li><a href="lockscreen.html"><span class="submenu-label">Lock Screen</span></a></li>
                        <li><a href="profile.html"><span class="submenu-label">Profile</span></a></li>
                        <li><a href="gallery.html"><span class="submenu-label">Gallery</span></a></li>
                        <li><a href="blog.html"><span class="submenu-label">Blog</span></a></li>
                        <li><a href="single_post.html"><span class="submenu-label">Single Post</span></a></li>
                        <li><a href="pricing.html"><span class="submenu-label">Pricing</span></a></li>
                        <li><a href="invoice.html"><span class="submenu-label">Invoice</span></a></li>
                        <li><a href="error404.html"><span class="submenu-label">Error404</span></a></li>
                        <li><a href="blank.html"><span class="submenu-label">Blank</span></a></li>
                        <li><a href="/activity/list"><span class="submenu-label">活动中心</span></a></li>
                        <li><a href="/news/list"><span class="submenu-label">新闻中心</span></a></li>
                        <li><a href="/line/list"><span class="submenu-label">线路中心</span></a></li>
                    </ul>
                </li>
                <li class="openable bg-palette4">
                    <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
										<span class="text m-left-sm">车辆管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										Menu
									</span>
                    </a>
                    <ul class="submenu">
                        <li class="openable">
                            <a href="signin.html">
                                <span class="submenu-label">车辆线路</span>
                                <small class="badge badge-success badge-square bounceIn animation-delay2 m-left-xs pull-right">3</small>
                            </a>
                            <ul class="submenu third-level">
                                <li><a href="#"><span class="submenu-label">城市线路</span></a></li>
                                <li><a href="/station/listAll"><span class="submenu-label">站点管理</span></a></li>
                                <li class="openable">
                                    <a href="#">
                                        <span class="submenu-label">线路管理</span>
                                        <small class="badge badge-danger badge-square bounceIn animation-delay2 m-left-xs pull-right">2</small>
                                    </a>
                                    <ul class="submenu fourth-level">
                                        <li><a href="#"><span class="submenu-label">menu 4.1</span></a></li>
                                        <li><a href="#"><span class="submenu-label">menu 4.2</span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="#"><span class="submenu-label">添加车辆</span></a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="sidebar-fix-bottom clearfix">
            <div class="user-dropdown dropup pull-left">
                <a href="#" class="dropdwon-toggle font-18" data-toggle="dropdown"><i class="ion-person-add"></i>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="inbox.html">
                            Inbox
                            <span class="badge badge-danger bounceIn animation-delay2 pull-right">1</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            Notification
                            <span class="badge badge-purple bounceIn animation-delay3 pull-right">2</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="sidebarRight-toggle">
                            Message
                            <span class="badge badge-success bounceIn animation-delay4 pull-right">7</span>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">Setting</a>
                    </li>
                </ul>
            </div>
            <a href="lockscreen.html" class="pull-right font-18"><i class="ion-log-out"></i></a>
        </div>
    </div><!-- sidebar-inner -->
</aside>
</#macro>