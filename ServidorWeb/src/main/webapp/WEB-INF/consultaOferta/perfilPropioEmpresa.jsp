<!DOCTYPE html>
<html lang="es">

<%@page import="com.trabajouy.model.DTOfertaLaboral"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="com.trabajouy.model.DTUsuario"%>
<%@page import="com.trabajouy.model.DTPostulante"%>
<%@page import="com.trabajouy.model.DTPostulante"%>
<%@page import="com.trabajouy.model.DTPostulacion"%>
<%@page import="com.trabajouy.model.DTEmpresa"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%DTOfertaLaboral oferta= (DTOfertaLaboral) request.getAttribute("oferta");  
  String linkImagen="";
  Set<String> keywords= oferta.getKeywords();
  Date fechaAltaDate= oferta.getFecha();
  String fechaAlta="";
  String anio = String.valueOf(fechaAltaDate.getYear());
  String mes = fechaAltaDate.getMonth()<10 ? "0"+String.valueOf(fechaAltaDate.getMonth()) : String.valueOf(fechaAltaDate.getMonth());
  String dia= fechaAltaDate.getDay()<10 ? "0"+String.valueOf(fechaAltaDate.getDay()+1): String.valueOf(fechaAltaDate.getDay()+1);
  fechaAlta=anio+"-"+mes+"-"+dia;
  fechaAlta=fechaAlta.substring(1);
  
  String keywordStr="";
  for(String key:keywords){
	  keywordStr+=key+ ", ";
  }
  if(keywordStr.length()>0)keywordStr=keywordStr.substring(0, keywordStr.length()-2);
  
  
  boolean esPostulanteNoPostulado=false;
  boolean esPostulantePostulado=false;
  boolean esEmpresaDuenia=false;
  
  DTUsuario usuario= (DTUsuario) session.getAttribute("usuarioLogueado");
  if(usuario!=null){
	  if(usuario.getClass() == DTPostulante.class){
		  DTPostulante postulante= (DTPostulante) usuario;
		  Set<String> ofertasPostuladas=postulante.getNombreOfertas();
		  if(ofertasPostuladas.contains(oferta.getNombre())){
			  esPostulantePostulado=true;
		  }else{
			  esPostulanteNoPostulado=true;
		  }
	  }
	  else{
		  DTEmpresa empresa= (DTEmpresa) usuario;
		  Set<String> ofertasPropias=empresa.getNombreOfertas();
		  esEmpresaDuenia=ofertasPropias.contains(oferta.getNombre());
	  }
  }
  
  Set<DTPostulacion> postulaciones= oferta.getPostulaciones();
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>perfilEmpresa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/estilosGenericos.css">
    <link rel="stylesheet" href="css/perfilUsuario.css">
    <link rel="stylesheet" href="css/ConsultaUsuario.css">
    <script src="js/perfilUsuario.js"></script>
</head>

<body class="bg-primary-subtle body-center">
	<jsp:include page="/WEB-INF/template/header.jsp" />
  	<jsp:include page="/WEB-INF/template/sideBar.jsp" />
    <div class="profile">
        <div class="profile-header">
            <img src="https://tinyurl.com/mr2hcufa" alt="Avatar" class="u-avatar">
            <div class="u-info">
                <h1><%=oferta.getNombre()%></h1> 
                <p><%=oferta.getNombreEmpresa()%></p>
            </div>
        </div>
        
        <div class="profile-tabs">
            <button class="tablink" onclick="openTab('detalles')">Detalles</button>
            <%if(esEmpresaDuenia &&!postulaciones.isEmpty()){ %>
            <button class="tablink" onclick="openTab('postulaciones')">Postulaciones</button>
            <%} %>
        </div>
        <div class="tabcontent" id="perfil">
            <div class="profile-form">
                <div class="row">
                    <div class="label">
                        <label for="inputDescripcion">Descripcion:</label>
                    </div>
                    <div class="info">
                        <textarea name="message" rows="2" cols="30" id="inputDescripcion" readonly><%=oferta.getDescripcion()%></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="inputInicio">Horario inicio:</label>
                    </div>
                    <div class="info">
                        <input type="time" id="inputInicio" value="<%=oferta.getHorario().getInicio().toString() %>" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="inputFin">Horario fin:</label>
                    </div>
                    <div class="info email-info">
                        <input type="time" id="inputFin" value="<%=oferta.getHorario().getFin().toString() %>" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="inputRenumeracion">Remuneracion:</label>
                    </div>
                    <div class="info">
                        <input type="number"  id="inputRenumeracion" value="<%=String.valueOf(oferta.getRemuneracion())%>" min="0"
                        oninput="validity.valid||(value='');" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="inputDepartamento">Departamento:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="inputDepartamento" value="<%=oferta.getDepartamento()%>" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="inputCiudad">Ciudad:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="inputCiudad" value="<%=oferta.getCiudad() %>" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="inputKeywords">Keywords:</label>
                    </div>
                    <div class="info">
                        <textarea name="message" rows="2" cols="30" id="inputKeywords"
                        placeholder="" readonly><%=keywordStr%></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="date">Fecha de alta</label>
                    </div>
                    <div class="info">
                        <input type="date" class="form-control" value="<%=fechaAlta%>" id="date" readonly>
                    </div>
                </div>
                <div class="row">
	                <%if(esPostulantePostulado){ %>
	                <a class="btn bg-primary mt-3" href="Postulacion?n=<%=URLEncoder.encode(oferta.getNombre(), StandardCharsets.UTF_8.toString())%>&p=<%=URLEncoder.encode(usuario.getNickname(), StandardCharsets.UTF_8.toString())%>">Ver Postulacion</a>
	                <%}%>
	                <%if(esPostulanteNoPostulado){ %>
					<a class="btn bg-primary mt-3" href="consultaPostulacion1Postulante.html">Postularse</a>
					<%}%>
				</div>
            </div>
        </div>
        <%if(esEmpresaDuenia && !postulaciones.isEmpty()){ %>
        <div class="tabcontent" id="postulaciones">
            <div class="container user-profile">
                <div class="job-list-title">
                    Postulaciones
                </div>
                <div class="job-list">
                    <ul class="job-list">
                    <%for(DTPostulacion postulacion: postulaciones){ %>
                        <li class="job-list-item">
                            <a href="Postulacion?n=<%=URLEncoder.encode(oferta.getNombre(), StandardCharsets.UTF_8.toString()) %>&p=<%=URLEncoder.encode(postulacion.getPostulante(), StandardCharsets.UTF_8.toString()) %>" class="sinEstilo">
                                <img src="media/placeholder.png" alt="Oferta1">
                                <div>
                                    <h3><%=postulacion.getPostulante() %></h3>
                                </div>
                            </a>
                        </li>
                    <%}%>
                    </ul>
                </div>
            </div>
        </div>
        <%}%>
    </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>