<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
  <jsp:include page="/WEB-INF/template/header.jsp" />
  <jsp:include page="/WEB-INF/template/sideBar.jsp" />
  <div class="d-flex container mt-5 divPostulacion" style="width: 50rem;">
    <div class="rounded-5 p-4 text-white bg-primary custom-shadow">
      <form class="formOferta">
        <div class="form-group card-oferta">
          <div class="card">
            <img src="https://tinyurl.com/45nsf34m" class="card-img-top" alt="Oferta Desarollador FrontEnd" />
            <div class="card-body">
              <h5 class="card-title">Desarollador FrontEnd</h5>
              <p class="card-text">
                Unete a nuestro equipo de desarrollo frontend y crea
                experiencias de usuario excepcionales.
              </p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Echo Tech</li>
              <li class="list-group-item">$90.000</li>
              <li class="list-group-item">09:00-18:00</li>
              <li class="list-group-item">Montevideo, Montevideo</li>
            </ul>
          </div>
        </div>
        <div class="form-group">
          <label for="cv">CV:</label>
          <textarea id="cv" class="form-control"
            placeholder="Informacion basica, experiencia laboral..."></textarea><br>
        </div>
        <div class="form-group">
          <label for="motivaion">Motivacion:</label>
          <textarea id="motivacion" class="form-control"></textarea>
        </div>
        <div id="submitBtn">
          <input type="submit" class="btn btn-light" value="Aceptar">
          <input type="button" class="btn btn-light" value="Cancelar"
            onclick="document.location='consultaOfertaLoggeado.html'">
        </div>
    </div>
    </form>
  </div>
  </div>
</body>
</html>