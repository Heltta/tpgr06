<!DOCTYPE html>
<html>
<%@page import="com.trabajouy.model.DTOfertaLaboral"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="com.trabajouy.model.DTUsuario"%>
<%@page import="com.trabajouy.model.DTPostulante"%>
<%@page import="com.trabajouy.model.DTPostulacion"%>
<%@page import="com.trabajouy.model.DTEmpresa"%>
<%DTOfertaLaboral oferta= (DTOfertaLaboral) request.getAttribute("oferta");  
  String linkImagen="";
  Set<String> keywords= oferta.getKeywords();
  Date fechaAltaDate= oferta.getFecha();
  String fechaAlta="";
  String anio = String.valueOf(fechaAltaDate.getYear());
  String mes = fechaAltaDate.getMonth()<10 ? "0"+String.valueOf(fechaAltaDate.getMonth()) : String.valueOf(fechaAltaDate.getMonth());
  String dia= fechaAltaDate.getDay()<10 ? "0"+String.valueOf(fechaAltaDate.getDay()): String.valueOf(fechaAltaDate.getDay());
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
  
  DTUsuario usuario= (DTUsuario) session.getAttribute("usuario");
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
    <div class="container mt-5" style="width: 25rem;">
        <div class="rounded-5 p-4 text-white bg-primary">
            <form method="post" class="form">
                <div class="form-group">
                    <label for="inputNombre">Nombre</label>
                    <input type="Text" class="form-control" id="inputNombre" value="<%=oferta.getNombre() %>" readonly>
                </div>
                <div class="form-group">
                    <label for="inputDescripcion">Descripcion</label>
                    <textarea name="message" rows="2" cols="30" class="form-control" id="inputDescripcion" readonly><%=oferta.getDescripcion()%></textarea>
                </div>
                <div class="form-group">
                    <label for="inputInicio">Horario inicio</label>
                    <input type="time" class="form-control" id="inputInicio" value="<%=oferta.getHorario().getInicio().toString() %>" readonly>
                </div>
                <div class="form-group">
                    <label for="inputFin">Horario fin</label>
                    <input type="time" class="form-control" value="18:00" id="inputFin" readonly>
                </div>
                <div class="form-group">
                    <label for="inputRenumeracion">Remuneracion</label>
                    <input type="number" class="form-control" id="inputRenumeracion" value="<%=String.valueOf(oferta.getRemuneracion())%>" min="0"
                        oninput="validity.valid||(value='');" readonly>
                </div>
                <div class="form-group">
                    <label for="inputDepartamento">Departamento</label>
                    <input type="text" class="form-control" id="inputDepartamento" value="<%=oferta.getDepartamento() %>" readonly>
                </div>
                <div class="form-group">
                    <label for="inputCiudad">Ciudad</label>
                    <input type="text" class="form-control" id="inputCiudad" value="<%=oferta.getCiudad() %>" readonly>
                </div>
                <div class="form-group">
                    <label for="keywords" class="">Keywords</label>
                    <textarea name="message" rows="2" cols="30" class="form-control" id="inputKeywords"
                        placeholder="keywords" readonly><%=keywordStr%></textarea>
                </div>
                <%if(esEmpresaDuenia){ %>
                <div class="form-group">
                    <label for="selectOption" class="">Postulaciones</label>
                    <select name="selectOption" id="selectOption" class="form-control" oninput="redirect()" multiple="multiple">
                    	<%for(DTPostulacion post:postulaciones){ %>
                        <option value="consultaPostulacion1Empresa.html"><%=post.getPostulante()%></option>
                        <%} %>
                    </select>
                </div>
                <%}%>
                <div class="form-group">
                    <label for="date">Fecha de alta</label>
                    <input type="date" class="form-control" value="<%=fechaAlta%>" id="date" readonly>
                </div>
                <%if(esPostulantePostulado){ %>
                <a class="btn btn-light mt-3" href="consultaPostulacion1Postulante.html">Ver Postulacion</a>
                <%}%>
                <%if(esPostulanteNoPostulado){ %>
				<a class="btn btn-light mt-3" href="consultaPostulacion1Postulante.html">Postularse</a>
				<%}%>
				
                <div class="form-group btn-pad">
                    <a href="Oferta">
                        <button type="button" class="btn btn-light btn-lg">Ok</button>
                    </a>
                </div>
            </form>
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