<!DOCTYPE html>
<html>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%
List<String> listaTipos= (List<String>) request.getAttribute("listaTipos");
Set<String> listaKeywords= (Set<String>) request.getAttribute("listaKeywords");
Set<String> listaPaquetes= (Set<String>) request.getAttribute("listaPaquetes");
String nombre= request.getAttribute("nombre")==null ?  "": (String)request.getAttribute("nombre");
String descripcion= request.getAttribute("descripcion")==null ?  "": (String)request.getAttribute("descripcion");
int remuneracion= request.getAttribute("remuneracion")==null ?  -1 : (int)request.getAttribute("remuneracion");
String departamento= request.getAttribute("departamento")==null ?  "": (String)request.getAttribute("departamento");
String ciudad= request.getAttribute("ciudad")==null ?  "": (String)request.getAttribute("ciudad");
String imagen= request.getAttribute("imagen")==null ?  "": (String)request.getAttribute("imagen");
%>

<head>
	<jsp:include page="/WEB-INF/template/commonHeadElements.jsp" />
    <title>altaOferta</title>
    <link rel="stylesheet" href="css/altaOferta.css">
    <script src="js/altaOferta.js"></script>
</head>

<body class="bg-primary-subtle body-center">
  <jsp:include page="/WEB-INF/template/header.jsp" />
  <jsp:include page="/WEB-INF/template/sideBar.jsp" />
  <div class="container mt-5" style="width: 25rem;">
      <div class="rounded-5 p-4 text-white bg-primary">
          <form class="form" method="POST" id="elform">
              <div class="form-group">
                  <label for="tipoOferta">Elegir tipo de oferta laboral</label>
                  <select name="tipoOferta" class="form-control" id="tipoOferta" onInput="getPaquetes()">
                  <%for(String tipo : listaTipos){ %>
                      <option value="<%= tipo %>"><%= tipo %></option>
                  <%}%>
                  </select>
              </div>
              <div class="form-group">
                  <label for="inputNombre">Nombre</label>
                  <input type="Text" class="form-control" id="inputNombre" name="nombre" placeholder="Nombre" value="<%=nombre%>">
              </div>
              <div class="form-group">
                  <label for="inputDescripcion">Descripcion</label>
                  <textarea name="descripcion" rows="2" cols="30" class="form-control" id="inputDescripcion"
                      placeholder="Descripcion"><%=descripcion%></textarea>
              </div>
              <div class="form-group">
                  <label for="inputInicio">Horario inicio</label>
                  <input type="time" class="form-control" id="inputInicio" name="horarioInicio">
              </div>
              <div class="form-group">
                  <label for="inputFin">Horario fin</label>
                  <input type="time" class="form-control" id="inputFin" name="horarioFin">
              </div>
              <div class="form-group">
                  <label for="inputRenumeracion">Remuneracion</label>
                  <input type="number" class="form-control" id="inputRenumeracion" placeholder="Remuneracion" min="0" name="remuneracion" value="<%=remuneracion%>"
                      oninput="validity.valid||(value='');">
              </div>
              <div class="form-group">
                  <label for="inputDepartamento">Departamento</label>
                  <input type="text" class="form-control" id="inputDepartamento" placeholder="Departamento" name="departamento" value="<%=departamento%>">
              </div>
              <div class="form-group">
                  <label for="inputCiudad">Ciudad</label>
                  <input type="text" class="form-control" id="inputCiudad" placeholder="Ciudad" name="ciudad" value="<%=ciudad%>">
              </div>
              <div class="form-group">
                  <label for="inputImagen">Imagen</label>
                  <input type="file" class="form-control" id="inputImagen" placeholder="Url" name="imagen" value="<%=imagen%>">
              </div>
              <div class="form-group">
                  <label for="multiple-checkboxes">Keywords</label>
                  <div id="elcheckbox" style="padding-top: 2px; width: 100%;">
                      <select name="keywords" id="multiple-checkboxes" class="form-control dropdown" multiple="multiple">
                   <%for(String keyword :listaKeywords){ %>
                       <option value="<%= keyword %>"><%= keyword %></option>
                   <%}%>
                      </select>
                  </div>
              </div>
              <div class="form-group">
                  <label for="paquete" class="">Elegir paquete </label>
                  <select name="paquete" id="paquete" class="form-control dropdown">
                  	<option value="sinPaquete">Sin paquete</option>
                   <%for(String nombrePaquete: listaPaquetes){%>
                       <option value="<%=nombrePaquete %>"><%=nombrePaquete%></option>
                   <%}%>
                  </select>
              </div>
              
              <div class="form-group btn-pad">
              	<input type="submit" class="btn btn-light btn-lg" value="Confirmar" >
              </div>
          </form>
      </div>
  </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
    <script src="js/jsGenerico.js"></script>
</body>

</html>
<!-- fondo borroso de color mas claro y bien centrado -->