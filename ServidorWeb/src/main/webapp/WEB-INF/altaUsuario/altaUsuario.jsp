<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/template/commonHeadElements.jsp" />
    <title>Alta de Usuario</title>
    <link rel="stylesheet" href="css/altaUsuario.css">
    <script src="js/altaUsuario.js"></script>

</head>

<body class="bg-primary-subtle body-center">
    <jsp:include page="/WEB-INF/template/header.jsp" />
    <jsp:include page="/WEB-INF/template/sideBar.jsp" />
    <div class="container mt-5" style="width: 40rem;">
        <div class="rounded-5 p-4 text-white bg-primary">
        <% if(request.getAttribute("exito") != null || request.getParameter("mensaje") != null) {%>
        	<jsp:include page="/WEB-INF/mensajeAviso/Mensaje.jsp" />        	
        <% } %>
            <form id="formAlta" method="POST" enctype= "multipart/form-data">
                <div class="row g-3">
                    <div class="col">
                        <label for="nickname">Nickname:</label><br>
                        <input type="text" id="nickname" name="nickname" class="form-control" required><br>
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <label for="nombre">Nombre:</label><br>
                        <input type="text" id="nombre" name="nombre" class="form-control" required><br>
                    </div>
                    <div class="col">
                        <label for="apellido">Apellido:</label><br>
                        <input type="text" id="apellido" name="apellido" class="form-control" required><br>
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <label for="contraseña">Contraseña:</label><br>
                        <input type="password" id="contraseña" name="contrasenia" class="form-control" required><br>
                    </div>
                    <div class="col">
                        <label for="confirmacion">Confirmación:</label><br>
                        <input type="password" id="confirmacion" name="confirmacion" class="form-control" required><br>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email">Correo Electronico:</label><br>
                    <input type="email" id="email" name="email" class="form-control" required><br>
                </div>
                <div class="form-group">

                </div>
                <div class="form-group">
                    <label for="imagen">Foto de Perfil (Opcional):</label><br>
                    <input name="imagen" type="file" accept="image/*" id="foto" class="form-control"><br>
                </div>
                <div class="form-group" id="tipoUser">
                    <label for="tipoUsuario">Tipo de Usuario:</label><br>
                    <div name="tipoUsuario">
                        <label for="postulante">Postulante:</label>
                        <input type="radio" onchange="postulante()" name="tipoUsuario" value="postulante" checked>
                        <label for="empresa">Empresa:</label>
                        <input type="radio" onchange="empresa()" value="empresa" name="tipoUsuario">
                    </div>
                </div>
                <div name="postulante" id="postulante">
                    <div class="form-group">
                        <label for="fecha">Fecha de Nacimiento:</label><br>
                        <input type="date" id="fecha" name="fecha" class="form-control" required><br>
                    </div>
                    <div class="form-group">
                        <label for="nacionalidad">Nacionalidad:</label><br>
                        <input type="text" id="nacionalidad" name="nacionalidad" class="form-control" required><br>
                    </div>
                </div>
                <div name="empresa" id="empresa">
                    <div class="form-group">
                        <label for="descripcion">Descripcion:</label><br>
                        <textarea id="descripcion" name="descripcion" class="form-control"
                            placeholder="Somos una empresa..."></textarea><br>
                    </div>
                    <div class="form-group">
                        <label for="link">Link:</label><br>
                        <input type="url" id="url" name="url" placeholder="trabajo.uy" class="form-control"><br>
                    </div>
                </div>
                <input type="submit" class="btn btn-light" value="Aceptar">
            </form>
        </div>
    </div>
</body>

</html>