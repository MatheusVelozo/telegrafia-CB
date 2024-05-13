<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <jsp:include page="head.jsp"></jsp:include>

<body>

<jsp:include page="theme-loader.jsp"></jsp:include>

<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">

        <jsp:include page="navbar.jsp"></jsp:include>

            <div class="pcoded-main-container">
                <div class="pcoded-wrapper">

                    <jsp:include page="navbarmainmenu.jsp"></jsp:include>

                        <div class="pcoded-content">

                            <jsp:include page="pagehead.jsp"></jsp:include>

                                <div class="pcoded-inner-content">
                                    <!-- PAGINA PRINCIPAL -->
                                    <div class="main-body">
                                        <div class="page-wrapper">
                                            <!-- Page-body start -->
                                            <div class="page-body">
                                                <div class="row">


                                                </div>
                                            </div>
                                            <div id="styleSelector"> </div>
                                        </div>
                                    </div>
                                </div>
                        </div>
                </div>
            </div>
    </div>
</div>

<jsp:include page="javascriptfile.jsp"></jsp:include>

</body>
</html>
