<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.trabajouy.model.Usuario"%>
<%@page import="com.trabajouy.model.DTUsuario"%>
    
<header>
	<nav class="navbar-custom navbar navbar-expand-lg navbar-dark custom-shadow sticky-top" id="navbar-text">
		<a class="navbar-brand" href="Home">
			<i class="bi bi-bag-fill" id="logo"></i>
			<strong> Trabajo.uy </strong>
		</a>
		<div class="user-info-2">
			<%
				DTUsuario usr = (DTUsuario) session.getAttribute("usuarioLogueado");
				if (usr == null) {
			%>
			<ul class="nav">
				<li class="nav-item">
			    	<a class="nav-link text-white fw-semibold" href="Sesion">Iniciar Sesión</a>
			    </li>
			    <li class="nav-item">
			    	<a class="nav-link text-white fw-semibold" href="AltaUsuario">Registrarse</a>
			    </li>
			</ul>
			<%
				} else {
			%>
		    <div id="user-dropdown-toggle" class="user-toggle">
				<img src="<%= usr.getImagen() %>" alt="Avatar" class="user-avatar" id="perfil">
		        <div class="user-name"><%= usr.getNickname() %></div>
		    </div>
		   	<ul class="user-menu" id="user-dropdown">
		    	<li><a href="perfilPropioPostulante.html">Mi Perfil</a></li>
		        <li><a href="cerrarSesion.html">Cerrar Sesión</a></li>
		    </ul>
		    <%
				}
			%>
         </div>
	</nav>
</header>