<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="pcoded-navbar">
    <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
    <div class="pcoded-inner-navbar main-menu">
        <div class="p-15 p-b-0">

        </div>
        <div class="pcoded-navigation-label" data-i18n="nav.category.navigation">Main Menu</div>
        <ul class="pcoded-item pcoded-left-item">
            <li class="active">
                <a href="<%=request.getContextPath()%>/index.jsp" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-home"></i><b></b></span>
                    <span class="pcoded-mtext" data-i18n="nav.dash.main">Home</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li class="pcoded-hasmenu">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                    <span class="pcoded-mtext"  data-i18n="nav.basic-components.main">Menu</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <!--INICIO DO MENU -->
                <ul class="pcoded-submenu">
                    <li class=" ">
                        <a href="accordion.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Accordion</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="breadcrumb.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">Breadcrumbs</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="button.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Button</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="tabs.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">Tabs</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="color.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Color</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="label-badge.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">Label Badge</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="tooltip.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Tooltip</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="typography.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">Typography</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="notification.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Notification</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="icon-themify.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">Themify</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>

                </ul>
                <!--FIM DO MENU -->
            </li>
        </ul>
        <!-- DEMAIS ITENS DO MENU LATERAL
        <div class="pcoded-navigation-label" data-i18n="nav.category.forms">Forms &amp; Tables</div>
        <ul class="pcoded-item pcoded-left-item">
            <li>
                <a href="form-elements-component.html" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Form Components</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li>
                <a href="bs-basic-table.html" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Basic Table</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>

        </ul>

        <div class="pcoded-navigation-label" data-i18n="nav.category.forms">Chart &amp; Maps</div>
        <ul class="pcoded-item pcoded-left-item">
            <li>
                <a href="chart.html" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Chart</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li>
                <a href="map-google.html" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.form-components.main">Maps</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
            <li class="pcoded-hasmenu">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                    <span class="pcoded-mtext"  data-i18n="nav.basic-components.main">Pages</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class=" ">
                        <a href="auth-normal-sign-in.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Login</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="auth-sign-up.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">Register</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="sample-page.html" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">Sample Page</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                </ul>
            </li>

        </ul>

        <div class="pcoded-navigation-label" data-i18n="nav.category.other">Other</div>
        <ul class="pcoded-item pcoded-left-item">
            <li class="pcoded-hasmenu ">
                <a href="javascript:void(0)" class="waves-effect waves-dark">
                    <span class="pcoded-micon"><i class="ti-direction-alt"></i><b>M</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.menu-levels.main">Menu Levels</span>
                    <span class="pcoded-mcaret"></span>
                </a>
                <ul class="pcoded-submenu">
                    <li class="">
                        <a href="javascript:void(0)" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.menu-levels.menu-level-21">Menu Level 2.1</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>
                    <li class="pcoded-hasmenu ">
                        <a href="javascript:void(0)" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-direction-alt"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.menu-levels.menu-level-22.main">Menu Level 2.2</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                        <ul class="pcoded-submenu">
                            <li class="">
                                <a href="javascript:void(0)" class="waves-effect waves-dark">
                                    <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                    <span class="pcoded-mtext" data-i18n="nav.menu-levels.menu-level-22.menu-level-31">Menu Level 3.1</span>
                                    <span class="pcoded-mcaret"></span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="">
                        <a href="javascript:void(0)" class="waves-effect waves-dark">
                            <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                            <span class="pcoded-mtext" data-i18n="nav.menu-levels.menu-level-23">Menu Level 2.3</span>
                            <span class="pcoded-mcaret"></span>
                        </a>
                    </li>

                </ul>
            </li>
        </ul>
    </div>
    -->
</nav>
