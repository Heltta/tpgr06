<!DOCTYPE html>
<html lang="es">
<%@page import ="com.trabajouy.model.DTPostulacion" %>
<%@page import ="com.trabajouy.model.DTPostulante" %>
<%@page import="java.util.Date"%>
<%@page import="com.trabajouy.model.DTUsuario"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.text.DateFormat" %>
<%
DTPostulacion postulacion = (DTPostulacion)request.getAttribute("Postulacion");
DTPostulante postulante = (DTPostulante)request.getAttribute("Postulante");
String imagenOferta = (String)request.getAttribute("imagenOferta");
Date fechaAltaDate=postulacion.getFechaPostulacion();
DateFormat formatter = new SimpleDateFormat("dd-MM-yy");
String fechaAlta= formatter.format(fechaAltaDate);

%>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Consulta de Postulacion</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
  <link rel="stylesheet" href="css/estilosGenericos.css" />
  <link rel="stylesheet" href="css/consultaPostulacion.css" />
  <script src="js/jsGenerico.js"></script>
</head>

<body class="bg-primary-subtle body-center">
  	<jsp:include page="/WEB-INF/template/header.jsp" />
  	<jsp:include page="/WEB-INF/template/sideBar.jsp" />
  	
  <div class="container mainContainer mt-5" id="blur">
    <div class="row">
      <div class="container mt-5 user-profile">
        <div class="user-info">
          <img src="<%=postulante.getImagen()%>" alt="Usuario" />
          <div>
            <h2><a href="perfilPropioPostulante.html"><%=postulante.getNickname()%></a></h2>
            <p><%=postulante.getNombre()+' '+ postulante.getApellido()%></p>
            <p><%=postulante.getMail()%></p>
          </div>
        </div>
      </div>
    </div>
   
    <div class="container mainContainer mt-5" id="blur">
      <div class="row">
        <div class="d-flex w-100 flex-column align-items-start" style="width: 30rem">
          <h3>Postulación</h3>
          <div class="d-flex border-top border-bottom border-2 border-info justify-content-between">
            <h4>
              <a class="text-decoration-none text-reset" href="Oferta?n=<%=URLEncoder.encode(postulacion.getNombreOferta(), StandardCharsets.UTF_8.toString()) %>"><%=postulacion.getNombreOferta()%></a>
            </h4>
            <img src="<%=imagenOferta%>" />
          </div>
        </div>
      </div>

      <div class="row text-end">
        <p>
          <span class="fw-bold">Fecha de Postulacion: </span><time><%=fechaAlta%></time>
        </p>
      </div>
      <div class="card">
        <h3 class="fw-bold text-decoration-underline">CV Reducido</h3>
        <p>
         <%=postulacion.getResumenCV()%>
        </p>
        <br />
      </div>
      <div class="card">
        <h3 class="fw-bold text-decoration-underline">Motivacion</h3>
        <p>
          <%=postulacion.getDescripcion()%>
        </p>
        <br />
      </div>
    </div>
  </div>
</body>

</html>