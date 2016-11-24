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

                <li class="openable bg-palette2">
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
                    <ul class="submenu bg-palette3">
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
                        <#--<li><a href="button.html"><span class="submenu-label">积分充值</span></a></li>-->
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
                        <li><a href="/commodity/orderList"><span class="submenu-label">交易记录</span></a></li>
                        <li><a href="/user/activeAll"><span class="submenu-label">活动管理</span></a></li>
                        <li><a href="nestable_list.html"><span class="submenu-label">Nestable Lists</span></a></li>
                    </ul>
                </li>
                <li class="openable bg-palette3">
                <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-gift fa-lg"></i></span>
										<span class="text m-left-sm">活动管理</span>
										<span class="submenu-icon"></span>
									</span>
                    <span class="menu-content-hover block">
										Pages
									</span>
                </a>
                <ul class="submenu">
                    <li><a href="/activity/list"><span class="submenu-label">活动中心</span></a></li>
                </ul>
            </li>

                <li class="openable bg-palette3">
                    <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-bell fa-lg"></i></span>
										<span class="text m-left-sm">新闻管理</span>
										<span class="submenu-icon"></span>
									</span>
                        <span class="menu-content-hover block">
										Pages
									</span>
                    </a>
                    <ul class="submenu">
                        <li><a href="/news/list"><span class="submenu-label">新闻中心</span></a></li>
                    </ul>
                </li>

                <li class="openable bg-palette3">
                    <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-arrows-h fa-lg"></i></span>
										<span class="text m-left-sm">线路管理</span>
										<span class="submenu-icon"></span>
									</span>
                        <span class="menu-content-hover block">
										Pages
									</span>
                    </a>
                    <ul class="submenu">
                        <li><a href="/line/list"><span class="submenu-label">线路中心</span></a></li>
                    </ul>
                </li>
                <li class="openable bg-palette4">
                    <a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-anchor fa-lg" aria-hidden="true"></i></span>
										<span class="text m-left-sm">车辆管理</span>
										<span class="submenu-icon"></span>
									</span>
                    </a>
                    <ul class="submenu">
                        <li class="openable">
                            <a href="signin.html">
                                <span class="submenu-label">车辆线路</span>
                                <small class="badge badge-success badge-square bounceIn animation-delay2 m-left-xs pull-right">3</small>
                            </a>
                            <ul class="submenu third-level">
                                <li><a href="/line/list"><span class="submenu-label">城市线路</span></a></li>
                                <li><a href="/station/listAll"><span class="submenu-label">站点管理</span></a></li>
                                <li class="openable">
                                    <a href="#">
                                        <span class="submenu-label">线路管理</span>
                                        <small class="badge badge-danger badge-square bounceIn animation-delay2 m-left-xs pull-right">2</small>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li><a href="/bus/list"><span class="submenu-label">车辆管理</span></a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- sidebar-inner -->
</aside>
</#macro>