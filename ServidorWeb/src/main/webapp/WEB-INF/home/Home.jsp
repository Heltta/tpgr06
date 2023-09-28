<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/estilosGenericos.css">
    <link rel="stylesheet" href="css/index.css">
    <title>Pagina Principal</title>
</head>

<body class="bg-primary-subtle body-center">
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<jsp:include page="/WEB-INF/template/sideBar.jsp" />
    <div class="container mt-5 headerInicio">
        <h1>Bienvenido a Trabajo.uy</h1>
        <div id="loginButtons" class="container mt-3">
            <a href="altaUsuario.html" class="sinEstilo">
                <input type="button" class="btn btn-light" value="Registrarse">
            </a>
            <a href="inicioSesion.html" class="sinEstilo">
                <input type="button" class="btn btn-light" value="Iniciar sesion">
            </a>
        </div>
        <div class="container mt-5">
            <div class="row">
                <div class="col mb-4">
                    <div class="card mb-4">
                        <a href="consultaUsuario.html" class="sinEstilo">
                            <img class="card-img-top" src="https://tinyurl.com/45nsf34m" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Usuarios</h5>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col mb-4">
                    <div class="card mb-4">
                        <a href="consultaOfertaVisitante.html" class="sinEstilo">
                            <img class="card-img-top" src="https://tinyurl.com/4n2vpurk" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Ofertas Laborales</h5>

                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col mb-4">
                    <div class="card mb-4">
                        <a href="consultaPaqueteVisitante.html" class="sinEstilo">
                            <img class="card-img-top" src="https://shorturl.at/ceCD2" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Paquetes de Tipos de Publicacion</h5>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            </button>
        </div>
    </div>
</body>

</html>
