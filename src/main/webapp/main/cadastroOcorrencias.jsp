
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="br">

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

                    <div class="pcoded-inner-content">
                        <!-- PAGINA PRINCIPAL -->
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- Page-body start -->
                                <div class="page-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="card">
                                                <div class="card-header">
                                                    <h5>Controle de Talões.</h5>
                                                    <h4 class="sub-title">Nova Ocorrência.</h4>
                                                    <form action="<%=request.getContextPath()%>/servletOcorrencia" method="post" id="formOcorrencia">
                                                        <div class="form-row">

                                                            <input type="hidden" name="acao" id="acao" value="">
                                                            <input type="hidden" name="idOcorrencia" id="idOcorrencia" readonly="readonly" value="${modelOcorrencia.id}">

                                                            <div>
                                                                <input type="text" name="nTalao" id="nTalao" required="required" value="${modelOcorrencia.numeroTalao}"
                                                                       class="form-control ntalao" placeholder="NºTalão:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="endereco" id="endereco" required="required" value="${modelOcorrencia.endereco}"
                                                                       class="form-control formend" placeholder="Endereço:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="municipio" id="municipio" required="required" value="${modelOcorrencia.cidade}"
                                                                       class="form-control formmun" placeholder="Município:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="horaInicial" id="horaInicial" required="required" value="${modelOcorrencia.horarioInicial}"
                                                                       class="form-control formhora" placeholder="HI:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="horaFinal" id="horaFinal" required="required" value="${modelOcorrencia.horarioFinal}"
                                                                       class="form-control formhora" placeholder="HF:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="comandante" id="comandante" required="required" value="${modelOcorrencia.comandante}"
                                                                       class="form-control formmun" placeholder="Comandante:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="motorista" id="motorista" required="required" value="${modelOcorrencia.motorista}"
                                                                       class="form-control formmun" placeholder="Motorista:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="cecom" id="cecom" required="required" value="${modelOcorrencia.cecom}"
                                                                       class="form-control formmun" placeholder="Cecom:">
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <div>
                                                                <input type="text" name="viatura" id="viatura" required="required" value="${modelOcorrencia.vtr}"
                                                                       class="form-control formvtr" placeholder="Viatura:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="kmInicial" id="kmInicial" required="required" value="${modelOcorrencia.kmInicial}"
                                                                       class="form-control formkm" placeholder="KM Inicial:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="kmLocal" id="kmLocal" required="required" value="${modelOcorrencia.kmLocal}"
                                                                       class="form-control formkm" placeholder="KM Local:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="kmFinal" id="kmFinal" required="required" value="${modelOcorrencia.kmFinal}"
                                                                       class="form-control formkm" placeholder="KM Final:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="qru" id="qru" required="required" value="${modelOcorrencia.qru}"
                                                                       class="form-control formtipo" placeholder="Tipo Ocorrência:"> <!--CAMPO QRU DA PLANILHA && TIPO OCORRENCIA TELA -->
                                                            </div>
                                                            <div>
                                                                <input type="text" name="codigo" id="codigo" required="required" value="${modelOcorrencia.codigo}"
                                                                       class="form-control formcod" placeholder="Código:">
                                                            </div>
                                                            <select name="tipoOcorrencia" id="tipoOcorrencia" required="required" class="formmun select" value="${modelOcorrencia.tipoOcorrencia}">
                                                                <option value="RESGATE">RESGATE</option>
                                                                <option value="SALVAMENTO">SALVAMENTO</option>
                                                                <option value="INCENDIO">INCÊNDIO</option>
                                                            </select>
                                                            <div>
                                                                <input type="text" name="vitimasVivas" id="vitimasVivas" required="required" value="${modelOcorrencia.qtdVitimasVivas}"
                                                                       class="form-control formv" placeholder="VV:">
                                                            </div>
                                                            <div>
                                                                <input type="text" name="vitimasFatais" id="vitimasFatais" required="required" value="${modelOcorrencia.qtdVitimasFatais}"
                                                                       class="form-control formv" placeholder="VF:">
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <div>
                                                                <input type="text" name="observacoes" id="observacoes" required="required" value="${modelOcorrencia.observacao}"
                                                                       class="form-control formobs" placeholder="Observações:">
                                                            </div>
                                                        </div>
                                                        <button class="btn waves-effect waves-light btn-success btnsalvar"><i class="ti-check-box"></i>Salvar</button>
                                                        <button type="button" class="btn btn-primary waves-effect waves-light btnnovo" onclick="limparForm();"><i class="ti-file"></i>Novo</button>
                                                    </form>

                                                    <span id="msg" style="color: green;">${msg}</span>


                                                    <div class="card-header-right">
                                                        <ul class="list-unstyled card-option">
                                                            <li><i class="fa fa-window-maximize full-card"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <div class="card-block table-border-style">
                                                    <div class="table-responsive" style="overflow: scroll; height: 350px">
                                                        <table class="table table-hover tableOcorrencia" id="tabelaOcorrencias">
                                                            <thead style="background: #A9A9A9; position: sticky; top: 0; z-index: 1;">
                                                            <tr>
                                                                <th scope="col">ID</th>
                                                                <th scope="col">Dia</th>
                                                                <th scope="col" id="numTalao">Nº Talão</th>
                                                                <th scope="col">Viatura</th>
                                                                <th scope="col">Endereço</th>
                                                                <th scope="col">Cidade</th>
                                                                <th scope="col">Tipo de Ocorrência</th>
                                                                <th scope="col">Ver/Excluir</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>

                                                            <c:forEach items="${modelOcorrencias}" var="mo">

                                                                <tr>
                                                                    <td><c:out value="${mo.id}"></c:out></td>
                                                                    <td><c:out value="${mo.dataOcorrencia}"></c:out> </td>
                                                                    <td><c:out value="${mo.numeroTalao}"></c:out> </td>
                                                                    <td><c:out value="${mo.vtr}"></c:out> </td>
                                                                    <td><c:out value="${mo.endereco}"></c:out> </td>
                                                                    <td><c:out value="${mo.cidade}"></c:out> </td>
                                                                    <td><c:out value="${mo.qru}"></c:out> </td>
                                                                    <td> <a class="btn waves-effect waves-light btn-inverse btnview"
                                                                    href="servletOcorrencia?acao=verDetalhesOcorrencias&idOcorrencia=${mo.id}">
                                                                        <i class="ti-eye"></i></a>

                                                                        <a class="btn waves-effect waves-light btn-danger btnview" onclick=""
                                                                           href="servletOcorrencia?acao=deletarOcorrencias&idOcorrencia=${mo.id}">
                                                                            <i class="ti-trash"></i></a>

                                                                    </td>
                                                                </tr>

                                                            </c:forEach>

                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="styleSelector"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    function exibirUltimasOcorrencias() {

        let table = document.querySelector('.table-responsive');

        if (table) {
            table.scrollTop = table.scrollHeight;
        }
    }
    exibirUltimasOcorrencias();

    function alertSucesso() {

        let msgElement = document.getElementById("msg");

        setTimeout(function () {
            msgElement.textContent = "";
        }, 3000);
    }
    window.onload = alertSucesso();

    function limparForm() {

        let element = document.getElementById("formOcorrencia").elements;

        for (p = 0; p < element.length; p++) {
            element[p].value = '';
        }
    }

</script>

<jsp:include page="javascriptfile.jsp"></jsp:include>

</body>
</html>
