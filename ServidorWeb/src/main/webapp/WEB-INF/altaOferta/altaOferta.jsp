<!DOCTYPE html>
<html>
<%@page import="java.util.Set"%>
<%@page import="com.trabajouy.model.IUsuario"%>
<%@page import="com.trabajouy.model.ITipos"%>
<%@page import="com.trabajouy.model.Fabrica"%>
<%
	Fabrica fabrica= Fabrica.getInstance();
	IUsuario ctrlUsuario= fabrica.getIUsuario();
	ITipos ctrlTipos= fabrica.getITipos();
	Set<String> listaTipos= ctrlUsuario.listarTiposDePublicacion();
	Set<String> listaKeywords= ctrlUsuario.listarKeywords();
	Set<String> listaPaquetes= ctrlTipos.listarPaquetes();
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>altaOferta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/estilosGenericos.css">
    <link rel="stylesheet" href="css/altaOferta.css">
</head>

<body class="bg-primary-subtle body-center">
  <jsp:include page="/WEB-INF/template/header.jsp" />
  <jsp:include page="/WEB-INF/template/sideBar.jsp" />
    <div class="container mt-5" style="width: 25rem;">
        <div class="rounded-5 p-4 text-white bg-primary">
            <form class="form" method="POST">
                <div class="form-group">
                    <label for="tipoOferta">Elegir tipo de oferta laboral</label>
                    <select name="tipoOferta" class="form-control" id="tipoOferta">
                    <%for(String tipo :listaTipos){ %>
                        <option value="<%= tipo %>"><%= tipo %></option>
                    <%}%>
                    </select>
                    
                </div>
                <div class="form-group">
                    <label for="inputNombre">Nombre</label>
                    <input type="Text" class="form-control" id="inputNombre" name="nombre" placeholder="Nombre">
                </div>
                <div class="form-group">
                    <label for="inputDescripcion">Descripcion</label>
                    <textarea name="descripcion" rows="2" cols="30" class="form-control" id="inputDescripcion"
                        placeholder="Descripcion"></textarea>
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
                    <input type="number" class="form-control" id="inputRenumeracion" placeholder="Remuneracion" min="0" name="remuneracion"
                        oninput="validity.valid||(value='');">
                </div>
                <div class="form-group">
                    <label for="inputDepartamento">Departamento</label>
                    <input type="text" class="form-control" id="inputDepartamento" placeholder="Departamento" name="departamento">
                </div>
                <div class="form-group">
                    <label for="inputCiudad">Ciudad</label>
                    <input type="text" class="form-control" id="inputCiudad" placeholder="Ciudad" name="ciudad">
                </div>
                <div class="form-group">
                    <label for="inputImagen">Imagen</label>
                    <input type="url" class="form-control" id="inputImagen" placeholder="Url" name="imagen">
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
	                    <%for(String paquete :listaPaquetes){ %>
	                        <option value="<%= paquete %>"><%= paquete %></option>
	                    <%}%>
                    </select>
                </div>
                
                <div class="form-group btn-pad">
                	<input type="submit" class="btn btn-light btn-lg" value="Confirmar" >
                </div>
            </form>
        </div>
    </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
    <script src="../js/multiSelectScripts/jquery.min.js"></script>
    <script src="../js/multiSelectScripts/popper.js"></script>
    <script src="../js/multiSelectScripts/bootstrap.min.js"></script>
    <script src="../js/multiSelectScripts/bootstrap-multiselect.js"></script>
    <script src="../js/multiSelectScripts/main.js"></script>
    <script src="../js/jsGenerico.js"></script>
</body>

</html>
<!-- fondo borroso de color mas claro y bien centrado -->