<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.trabajouy.model.DTUsuario"%>
<%@page import="com.trabajouy.model.DTEmpresa"%>

<%@page import="java.util.Set"%>
<%@page import="com.trabajouy.model.IUsuario"%>
<%@page import="com.trabajouy.model.Fabrica"%>

<%
	Set<String> listaKeywords= (Set<String>) request.getAttribute("listaKeywords");
%>


<nav id="sidebarMenu" class="custom-sidebar collapse d-lg-block sidebar collapse .bg-info.bg-gradient custom-shadow" style="padding-top: 10%;">
        <div class="position-sticky">
          <div class="list-group list-group-flush mx-3 mt-4 ">
            <div class="sidebarGroup ">
              <div class="border border-primary rounded-2">
              	<%
					DTUsuario usr = (DTUsuario) session.getAttribute("usuario_logueado");
					if (usr != null) {
				%>
                <a href="perfilPropioEmpresa.html" class="list-group-item list-group-item-action py-2 ripple"></i><span>Mi Perfil</span></a>
                <% 
                	} 
                %>
                <a href="consultaOfertaEmpresa.html"
                class="list-group-item list-group-item-action py-2 ripple"><span>Ofertas
                    Laborales</span></a>
                <%
					if (usr instanceof DTEmpresa) {
				%>
                <a href="altaOferta.html" class="list-group-item list-group-item-action py-2 ripple"><span>Crear
                                Oferta</span></a>
                <% 
                	} 
                %>
                <a href="consultaUsuarioEmpresa.html"
                    class="list-group-item list-group-item-action py-2 ripple"><span>Usuarios</span></a>
                <a href="consultaTipoPublicacionEmpresa.html" class="list-group-item list-group-item-action py-2 ripple"><span>Tipos de
                    Publicación</span></a>
                <a href="consultaPaqueteEmpresa.html" class="list-group-item list-group-item-action py-2 ripple"><span>Paquetes de Tipo de
                    Publicación</span></a>
              </div>
            </div>
            <div class="sidebarGroup">
              <div class="border border-primary rounded-2">
                <span class="list-group-item py-2 ripple"><b>Keywords</b></span>
                <%for(String keyword :listaKeywords){ %>
                    <a href="consultaOfertaEmpresa.html" class="list-group-item list-group-item-action py-2 ripple"><span><%=keyword %></span></a>
                <%}%>
              </div>
            </div>
          </div>
        </div>
    </nav>