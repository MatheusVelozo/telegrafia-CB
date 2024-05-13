<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <jsp:include page="main/head.jsp"></jsp:include>
</head>

<body>

<jsp:include page="main/theme-loader.jsp"></jsp:include>

<!-- Pre-loader end -->
<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">

        <jsp:include page="main/navbar.jsp"></jsp:include>

        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">

                <jsp:include page="main/navbarmainmenu.jsp"></jsp:include>

                <div class="pcoded-content">
                    <!-- Page-header start -->
                    <div class="page-header">
                        <div class="page-block">
                            <div class="row align-items-center">
                                <div class="col-md-8">
                                    <div class="page-header-title">
                                        <p class="m-b-10" id="dataHoraAtual"></p>

                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <ul class="breadcrumb-title">
                                        <li class="breadcrumb-item">
                                            <a href="index.html"> <i class="fa fa-home"></i> </a>
                                        </li>
                                        <li class="breadcrumb-item"><a href="#!">Dashboard</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Page-header end -->
                    <div class="pcoded-inner-content">
                        <!-- PAGINA PRINCIPAL -->
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- Page-body start -->
                                <div class="page-body">
                                    <div class="row">
                                        <!-- task, page, download counter  start -->

                                        <div class="col-xl-3 col-md-6">
                                            <div class="card">
                                                <div class="card-block">
                                                    <div class="row align-items-center">
                                                        <div class="col-8">
                                                            <h4 class="text-c-purple">Controle de Ocorrências</h4>
                                                        </div>
                                                        <div class="col-4 text-right">
                                                            <i class="fa fa-bar-chart f-28"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-footer bg-c-purple">
                                                    <div class="row align-items-center">
                                                        <div class="col-9">
                                                            <a href="<%=request.getContextPath()%>/servletOcorrencia?acao=listarOcorrencias" class="button-cards">Cadastrar ocorrência</a>
                                                        </div>
                                                        <div class="col-3 text-right">
                                                            <i class="fa fa-bar-chart f-16"></i>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xl-3 col-md-6">
                                            <div class="card">
                                                <div class="card-block">
                                                    <div class="row align-items-center">
                                                        <div class="col-8">
                                                            <h4 class="text-c-green">Mapa de Ocorrências</h4>
                                                        </div>
                                                        <div class="col-4 text-right">
                                                            <i class="ti-map f-28"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-footer bg-c-green">
                                                    <div class="row align-items-center">
                                                        <div class="col-9">
                                                            <a href="<%=request.getContextPath()%>/servletMapa?acao=coordenadas" class="button-cards">Visualizar Dados</a>
                                                        </div>
                                                        <div class="col-3 text-right">
                                                            <i class="ti-map f-16"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xl-3 col-md-6">
                                            <div class="card">
                                                <div class="card-block">
                                                    <div class="row align-items-center">
                                                        <div class="col-8">
                                                            <h4 class="text-c-red">Documentos Administração</h4>
                                                        </div>
                                                        <div class="col-4 text-right">
                                                            <i class="fa fa-calendar-check-o f-28"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-footer bg-c-red">
                                                    <div class="row align-items-center">
                                                        <div class="col-9">
                                                            <a class="button-cards">Enviar documentos</a>
                                                        </div>
                                                        <div class="col-3 text-right">
                                                            <i class="fa fa-calendar-check-o f-16"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!--
                                        <div class="col-xl-3 col-md-6">
                                            <div class="card">
                                                <div class="card-block">
                                                    <div class="row align-items-center">
                                                        <div class="col-8">
                                                            <h4 class="text-c-blue">Mapa Força    16º GB</h4>
                                                        </div>
                                                        <div class="col-4 text-right">
                                                            <i class="fa fa-hand-o-down f-28"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-footer bg-c-blue">
                                                    <div class="row align-items-center">
                                                        <div class="col-9">
                                                            <a class="button-cards">Inserir Dados</a>
                                                        </div>
                                                        <div class="col-3 text-right">
                                                            <i class="fa fa-hand-o-down f-16"></i>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        -->

                                    </div>
                                </div>
                                <!-- Page-body end -->
                            </div>
                            <div id="styleSelector"> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    function exibirDataHoraAtual() {
        let dataHora = new Date();
        let dataHoraFormatada = dataHora.toLocaleString();
        let elementoDataHora = document.getElementById("dataHoraAtual");

        elementoDataHora.innerHTML = "Bem Vindo! <br>" + dataHoraFormatada;
    }
    setInterval(exibirDataHoraAtual, 1000);

</script>

<!-- Required Jquery -->
<script type="text/javascript" src="assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/jquery-ui/jquery-ui.min.js "></script>
<script type="text/javascript" src="assets/js/popper.js/popper.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap/js/bootstrap.min.js "></script>
<script type="text/javascript" src="assets/pages/widget/excanvas.js "></script>
<!-- waves js -->
<script src="assets/pages/waves/js/waves.min.js"></script>
<!-- jquery slimscroll js -->
<script type="text/javascript" src="assets/js/jquery-slimscroll/jquery.slimscroll.js "></script>
<!-- modernizr js -->
<script type="text/javascript" src="assets/js/modernizr/modernizr.js "></script>
<!-- slimscroll js -->
<script type="text/javascript" src="assets/js/SmoothScroll.js"></script>
<script src="assets/js/jquery.mCustomScrollbar.concat.min.js "></script>
<!-- Chart js -->
<script type="text/javascript" src="assets/js/chart.js/Chart.js"></script>
<!-- amchart js -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="assets/pages/widget/amchart/gauge.js"></script>
<script src="assets/pages/widget/amchart/serial.js"></script>
<script src="assets/pages/widget/amchart/light.js"></script>
<script src="assets/pages/widget/amchart/pie.min.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<!-- menu js -->
<script src="assets/js/pcoded.min.js"></script>
<script src="assets/js/vertical-layout.min.js "></script>
<!-- custom js -->
<script type="text/javascript" src="assets/pages/dashboard/custom-dashboard.js"></script>
<script type="text/javascript" src="assets/js/script.js "></script>
</body>

</html>
