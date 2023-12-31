<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.trabajouy.model.DTPaquete"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<!DOCTYPE html>
<html lang="es">

<head>
	<jsp:include page="/WEB-INF/template/commonHeadElements.jsp" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Consulta de Tipo de Publicaci�n</title>
	<link rel="stylesheet" href="css/consultaPaquete.css">
</head>

<body class="bg-primary-subtle body-center">
    <jsp:include page="/WEB-INF/template/header.jsp" />
    <jsp:include page="/WEB-INF/template/sideBar.jsp" />
	<div class="container mainContainer mt-5 containerPaquetes" id="blur">
		<div class="job-list-title">Paquetes de Tipos de Publicaci�n</div>
		<ul class="job-list">
			<li>	
				<div>
				<% 
					Map<String, DTPaquete> paquetes = (Map<String, DTPaquete>)request.getAttribute("listaPaquetes");
					Set<String> keyPaquetes = paquetes.keySet();
					for(String paquete : keyPaquetes){ %>
				
					<div class="itemPaquete">
					<a href="/DetallesPaquete?paquete=<%=URLEncoder.encode(paquetes.get(paquete).getNombre(), StandardCharsets.UTF_8.toString()) %>" class="sinEstilo">
						<div class="card">
							<div class="row card-body">
								<img class="col-sm-6 imgCardPaquete"
									src="https://shorturl.at/ceCD2" alt="sans" />
								<div class="col-sm-6">
									<h5 class="card-title"> <%=paquetes.get(paquete).getNombre() %> </h5>
									<p class="card-text"><%=paquetes.get(paquete).getDescripcion() %></p>
								</div>
							</div>
						</div>
					</a>
				</div>
				<%	}	%>
				</div>
			</li>
		</ul>
	</div>
</body>

</html>