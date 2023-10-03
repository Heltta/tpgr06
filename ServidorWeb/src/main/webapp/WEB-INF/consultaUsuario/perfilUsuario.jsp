<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<%@page import="java.util.Date"%>
<%@page import="com.trabajouy.model.DTUsuario"%>
<%@page import="com.trabajouy.model.DTPostulante"%>
<%@page import="com.trabajouy.model.DTEmpresa"%>
<% DTUsuario user = (DTUsuario) request.getAttribute("detalleUsuario");
	enum Conexion{Postulante, Empresa, PropioEmpresa, PropioPostulante};
	Conexion estadoConexion = Conexion.Postulante;
	String nickname = user.getNickname();
	String nombre = user.getNombre();
	String apellido = user.getApellido();
	String mail = user.getMail();
	String imagen = user.getImagen();
	Date fechaNac;
	String nacionalidad = "";
	String descripcion = "";
	String link = "";
	DTUsuario usuarioLogueado = (DTUsuario) request.getSession().getAttribute("usuarioLogueado");
	if(user instanceof DTPostulante){
		fechaNac = ((DTPostulante)user).getFechaNacimiento();
		nacionalidad = ((DTPostulante)user).getNacionalidad();
		if(usuarioLogueado != null){
			estadoConexion = (usuarioLogueado.getNickname().equals(nickname))?Conexion.PropioPostulante:Conexion.Postulante;
		}else{
			estadoConexion = Conexion.Postulante;
		}
	}else if(user instanceof DTEmpresa){
		descripcion = ((DTEmpresa)user).getDescripcion();
		link = ((DTEmpresa)user).getLink();
		if(usuarioLogueado != null){
			estadoConexion = (usuarioLogueado.getNickname().equals(nickname))?Conexion.PropioEmpresa:Conexion.Empresa;
		}else{
			estadoConexion = Conexion.Empresa;
		}
	}
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>perfilPropioEmpresa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="../css/estilosGenericos.css">
    <link rel="stylesheet" href="../css/perfilUsuario.css">
    <script src="../js/jsGenerico.js"></script>
    <script src="../js/perfilUsuario.js"></script>
    <jsp:include page="/WEB-INF/template/commonHeadElements.jsp" />
</head>

<body class="bg-primary-subtle body-center">
    <jsp:include page="/WEB-INF/template/header.jsp" />
    <jsp:include page="/WEB-INF/template/sideBar.jsp" />
    <div class="profile">
        <div class="profile-header">
            <img src="img/<%=nickname%>.png" alt="Avatar" class="u-avatar">
            <div class="u-info">
                <h1><%=nombre + " " + apellido%></h1>
                <p><%=nickname%></p>
                <p><%=mail%></p>
            </div>
        </div>
        <div class="profile-tabs">
        	<button class="tablink" onclick="openTab('perfil')">Perfil</button>
        	<%
        	switch(estadoConexion){
        		case Empresa :%>
            		<button class="tablink" onclick="openTab('ofertas')">Publicaciones</button>
            	<%break;%>
        		<%case PropioPostulante :%>
        			<button class="tablink" onclick="openTab('ofertas')">Postulaciones</button>
        		<%break;%>
           		<%case PropioEmpresa :%>  
           			<button class="tablink" onclick="openTab('ofertas')">Publicaciones</button>
            		<button class="tablink" onclick="openTab('paquetes')">Compras de Paquetes</button>
            	<%break;%>
            <%}%>
        </div>
        <div class="tabcontent" id="perfil">
            <div class="profile-form">
                <div class="row">
                    <div class="label">
                        <label for="nickname">Nickname:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="nickname" value="<%=nickname%>" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="email">Email:</label>
                    </div>
                    <div class="info email-info">
                        <input type="email" id="email" value="<%=mail%>" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="name">Nombre:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="name" value="<%=nombre%>" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="lastname">Apellido:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="lastname" value="<%=apellido%>" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="descripcion">Descripción:</label>
                    </div>
                    <div class="info">
                        <textarea id="desc" readonly><%=descripcion%></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="link">Link:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="link" value="<%=link%>" readonly>
                    </div>
                </div>
            </div>
        </div>
        <div class="tabcontent" id="ofertas">
            <div class="container user-profile">
                <div class="job-list-title">
                    Ofertas Laborales
                </div>
                <div class="job-list">
                    <ul class="job-list">
                        <li class="job-list-item">
                            <a href="consultaOfertaDetallesPostulanteMismo.html">
                                <img src="https://tinyurl.com/45nsf34m" alt="Oferta1">
                                <div>
                                    <h3><a href="consultaOfertaDetallesPostulanteMismo.html">Desarrollador Frontend</a>
                                    </h3>
                                </div>
                            </a>
                        </li>
                        <li class="job-list-item">
                            <a href="consultaOfertaDetallesPostulanteMismo.html">
                                <img src="https://tinyurl.com/4n2vpurk" alt="Oferta2">
                                <div>
                                    <h3><a href="consultaOfertaDetallesPostulanteMismo.html">A. de Marketing Digital
                                        </a></h3>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>