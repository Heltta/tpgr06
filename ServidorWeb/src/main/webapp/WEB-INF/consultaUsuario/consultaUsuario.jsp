<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<%@page import="java.util.Set"%>
<%@page import="com.trabajouy.model.DTUsuario"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<% Set<DTUsuario> usuarios = (Set<DTUsuario>) request.getAttribute("usuarios"); %>
<head>
	<jsp:include page="/WEB-INF/template/commonHeadElements.jsp" />
    <title>consultaUsuario</title>
    <link rel="stylesheet" href="css/consultaUsuario.css">
</head>

<body class="bg-primary-subtle body-center">
    <jsp:include page="/WEB-INF/template/header.jsp" />
    <jsp:include page="/WEB-INF/template/sideBar.jsp" />
    <div class="containerUsers container mt-5">
        <div class="job-list-title mx-5">
            <label>Usuarios</label>
        </div>
        <div class="job-list mx-5">
            <ul class="job-list">
            <%for(DTUsuario usuario : usuarios){
            	String nickname = usuario.getNickname();
            %>
                <li>
                    <a href="perfilPostulanteVisitante.html" class="sinEstilo">
                        <div class="user-card">
                            <img src="img/<%=nickname%>.png" alt="Usuario1">
                            <div class="user-info">
                                <h3><%=nickname%></h3>
                                <ul>
                                    <li><%=usuario.getNombre() + " " + usuario.getApellido() %></li>
                                    <li><%= usuario.getMail()%></li>
                                </ul>
                            </div>
                        </div>
                    </a>
                </li>
			<% } %>
            </ul>
        </div>
    </div>
</body>

</html>