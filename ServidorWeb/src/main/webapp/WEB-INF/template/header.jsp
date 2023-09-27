<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.trabajouy.model.Usuario"%>
<%@page import="com.trabajouy.model.DTUsuario"%>
    
<header>
	<nav class="navbar-custom navbar navbar-expand-lg navbar-dark custom-shadow sticky-top" id="navbar-text">
		<a class="navbar-brand" href="index.html">
			<i class="bi bi-bag-fill" id="logo"></i>
			<strong> Trabajo.uy </strong>
				<%
				DTUsuario usr = (DTUsuario) session.getAttribute("usuario_logueado");
				
				if (usr == null) {
				%>
			      <ul class="nav">
			        <li class="nav-item">
			          <a class="nav-link text-white fw-semibold" href="inicioSesion.html">Iniciar Sesión</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link text-white fw-semibold" href="altaUsuario.html">Registrarse</a>
			        </li>
			      </ul>
				<%
				} else {
				%>
					<div class="user-info-2">
		                <div id="user-dropdown-toggle" class="user-toggle">
		                    <img src="<% usr.getImagen(); %>" alt="Avatar" class="user-avatar" id="perfil">
		                    <div class="user-name"><% usr.getNickname(); %></div>
		                </div>
		                <ul class="user-menu" id="user-dropdown">
		                    <li><a href="perfilPropioPostulante.html">Mi Perfil</a></li>
		                    <li><a href="cerrarSesion.html">Cerrar Sesión</a></li>
		                </ul>
            		</div>
            	<%
				}
				%>
		</a>
	</nav>
</header>