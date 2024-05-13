<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<jsp:include page="head.jsp"></jsp:include>

<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"
      integrity="sha256-p4NxAoJBhIIN+hmNHrzRCf9tD/miZyoHS5obTRR9BMY="
      crossorigin=""/>

<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"
        integrity="sha256-20nQCchB9co0qIjJZRGuk2/Z9VM+kNiyxNV1lvTlZBo="
        crossorigin=""></script>

<link rel="stylesheet" href="main/Leaflet.markercluster-1.4.1/dist/MarkerCluster.css">
<link rel="stylesheet" href="main/Leaflet.markercluster-1.4.1/dist/MarkerCluster.Default.css">
<script src="main/Leaflet.markercluster-1.4.1/dist/leaflet.markercluster-src.js"></script>

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

                    <div class="page-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h5>Mapa de Ocorrências</h5>
                                        <div id="map" style="height: 600px; width: 1200px"></div>

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
<script type="text/javascript">

    let coordenadas = JSON.parse('${coordenadasJSON}');
    console.log(coordenadas);

    let map = L.map('map').setView([-22.78007, -47.29829], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    //Quartel Nova Odessa
    let quartelMarker = L.marker([-22.805871, -47.310474], {
        icon: L.icon({
            iconUrl: 'main/Imagens/quartel1.png',
            iconSize: [41,41],
            iconAnchor: [12, 41]
        })
    }).addTo(map);
    quartelMarker.bindPopup("Quartel Bombeiros.");

    let markerCluster = L.markerClusterGroup();

    // Adiciona um marcador ao mapa
    coordenadas.forEach(coordenada => {
        //let marker = L.marker(coordenada);
        let lat = coordenada[0];
        let lon = coordenada[1];
        let qru = coordenada[2];

        let marker = L.marker([lat, lon]).bindPopup("Tipo de Ocorrência: " + qru);
        
        markerCluster.addLayer(marker);
    });

    map.addLayer(markerCluster);

</script>

<jsp:include page="javascriptfile.jsp"></jsp:include>

</body>
</html>
