<!DOCTYPE html>
<html>
<%@page import="java.util.Set"%>
<%@page import="com.trabajouy.model.DTOfertaLaboral"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<% Set<DTOfertaLaboral> ofertas= (Set<DTOfertaLaboral>) request.getAttribute("ofertas");
%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>consultaOferta</title>
  <script src="js/consultaOferta.js"></script>
  <script src="js/jsGenerico.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
  <link rel="stylesheet" href="css/estilosGenericos.css">
  <link rel="stylesheet" href="css/consultaOferta.css">

</head>

<body class="bg-primary-subtle body-center">
  <jsp:include page="/WEB-INF/template/header.jsp" />
  <jsp:include page="/WEB-INF/template/sideBar.jsp" />
  <div class="container mainContainer mt-3 " id="">
    <div class="rounded-1 p-4 job-list-title">
      Ofertas Laborales
    </div>
    <div class="scrolling-section container mt-1 user-profile">
      <div class="job-list">
        <ul class="job-list">
        <%for(DTOfertaLaboral oferta:ofertas){
        	String urlImagen="img/placeholder.png";
        	Set<String> keywordsSet= oferta.getKeywords();
        	String keywords="";
        	for (String word: keywordsSet){
        		keywords=keywords.concat( word+ ", ");
        	}
        	keywords = !keywords.isEmpty() ? keywords.substring(0, keywords.length()-2) : "";
        	
        	String urlDetalles= URLEncoder.encode(oferta.getNombre(), StandardCharsets.UTF_8.toString());
        	
        	%>
          <a class="text-reset" href="/ServidorWeb/Oferta?n=<%=urlDetalles%>" class="link-dark ">
            <li class="job-list-item" onclick="mostrarOcultarDatos()">
              <img src="<%=urlImagen%>" alt="<%=oferta.getNombre()%>" style="height: 400px; width: 600;">
              <div>
                <h2><%=oferta.getNombre() %></h3>
                  <h4>Empresa: Empresa</h4>
                  <h5><%=keywords%></h5>
              </div>
          	</li>
          </a>
        <%}%>
        </ul>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>