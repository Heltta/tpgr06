<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.trabajouy.model.DTOfertaLaboral"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Postulacion a Oferta Laboral</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
  <link rel="stylesheet" href="css/estilosGenericos.css">
  <link rel="stylesheet" href="css/postulacionAOferta.css">
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/jsGenerico.js"></script>
</head>

<body class="bg-primary-subtle body-center body-postOferta">
<%DTOfertaLaboral oferta = (DTOfertaLaboral) request.getAttribute("oferta");  %>
  <jsp:include page="/WEB-INF/template/header.jsp" />
  <jsp:include page="/WEB-INF/template/sideBar.jsp" />
  <div class="d-flex container mt-5 divPostulacion" style="width: 50rem;">
    <div class="rounded-5 p-4 text-white bg-primary custom-shadow">
      <form class="formOferta" method="POST">
        <div class="form-group card-oferta">
          <div class="card">
            <img src="https://tinyurl.com/45nsf34m" class="card-img-top" alt="Oferta Desarollador FrontEnd" />
            <div class="card-body">
              <h5 class="card-title"> <%=oferta.getNombre() %> </h5>
              <p class="card-text">
                <%=oferta.getDescripcion() %>
              </p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item"> <%=oferta.getNombreEmpresa() %></li>
              <li class="list-group-item"> <%=oferta.getRemuneracion() %> </li>
              <li class="list-group-item"> <%=oferta.getHorario().getInicio() + ":" + oferta.getHorario().getFin() %> </li>
              <li class="list-group-item"> <%= oferta.getCiudad() + ", " + oferta.getDepartamento() %> </li>
            </ul>
          </div>
        </div>
        <div class="form-group">
          <label for="cv">CV:</label>
          <textarea id="cv" class="form-control"
            placeholder="Informacion basica, experiencia laboral..." name="cv"></textarea><br>
        </div>
        <div class="form-group">
          <label for="motivacion">Motivación:</label>
          <textarea id="motivacion" class="form-control" name="motivacion"></textarea>
        </div>
        <div id="submitBtn">
          <input type="submit" class="btn btn-light" value="Aceptar">
          <input type="button" class="btn btn-light" value="Cancelar"
            onclick="document.location='consultaOfertaLoggeado.html'">
        </div>
       </form> 
    </div>
  </div>
</body>
</html>