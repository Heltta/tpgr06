<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>consultaOferta</title>
  <script src="js/consultaOferta.js"></script>
  <script src="js/jsGenerico.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
  <link rel="stylesheet" href="css/estilosGenericos.css">
  <link rel="stylesheet" href="css/consultaOferta.css">

</head>

<body class="bg-primary-subtle body-center">
  <jsp:include page="/WEB-INF/template/header.jsp" />
  <jsp:include page="/WEB-INF/template/sideBar.jsp" />
  <nav id="sidebarMenu" class="custom-sidebar collapse d-lg-block sidebar collapse .bg-info.bg-gradient custom-shadow"
    style="padding-top: 10%;">
    <div class="position-sticky">
      <div class="list-group list-group-flush mx-3 mt-4 ">
        <div class="sidebarGroup ">
          <div class="border border-primary rounded-2">
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Ofertas
                Laborales</span></a>
            <a href="consultaUsuario.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Usuarios</span></a>
            <a href="consultaTipoPublicacionVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Tipos de
                Publicación</span></a>
            <a href="consultaPaqueteVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Paquetes de Tipo de
                Publicación</span></a>
          </div>
        </div>
        <div class="sidebarGroup">
          <div class="border border-primary rounded-2">
            <span class="list-group-item py-2 ripple"><b>Keywords</b></span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Tiempo Completo</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Medio Tiempo</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Remoto</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Freelance</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Temporal</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Permanente</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Computacion</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Administración</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Logística</span></a>
            <a href="consultaOfertaVisitante.html"
              class="list-group-item list-group-item-action py-2 ripple"><span>Contabilidad</span></a>
          </div>
        </div>
      </div>
    </div>
  </nav>
  <div class="container mainContainer mt-3 " id="">
    <div class="rounded-1 p-4 job-list-title">
      Ofertas Laborales
    </div>
    <div class="scrolling-section container mt-1 user-profile">
      <div class="job-list">
        <ul class="job-list">
          <a class="text-reset" href="consultaOfertaDetallesVisitante.html" class="link-dark ">
            <li class="job-list-item" onclick="mostrarOcultarDatos()">
              <img src="https://tinyurl.com/45nsf34m" alt="Oferta1" style="height: 400px; width: 600;">
              <div>
                <h2>Desarrollador Frontend</h3>
                  <h4>Empresa: EcoTech</h4>
                  <h5>Tiempo Completo, Medio tiempo, Remoto, Freelance, Temporal, Permanente</h5>
              </div>
          </a>
          </li>
          <a href="consultaOfertaDetallesVisitante.html" class="link-dark ">
            <li class="job-list-item" onclick="mostrarOcultarDatos()">
              <img src="https://tinyurl.com/4n2vpurk" alt="Oferta2" style="height: 400px; width: 600;">
              <div>
                <h2> A. de Marketing Digital</h2>
                <h4>Empresa: EcoTech</h4>
              </div>
            </li>
          </a>
        </ul>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>