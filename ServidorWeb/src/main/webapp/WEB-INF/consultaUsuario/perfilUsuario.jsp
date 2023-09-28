<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

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
    <script src="js/perfilUsuario.js"></script>
</head>

<body class="bg-primary-subtle body-center">
    <jsp:include page="/WEB-INF/template/header.jsp" />
    <jsp:include page="/WEB-INF/template/sideBar.jsp" />
    <div class="profile">
        <div class="profile-header">
            <img src="https://tinyurl.com/mr2hcufa" alt="Avatar" class="u-avatar">
            <div class="u-info">
                <h1>Sophia Johnson</h1>
                <p>EcoTech</p>
                <p>info@EcoTech.com</p>
            </div>
        </div>
        <div class="profile-tabs">
            <button class="tablink" onclick="openTab('perfil')">Perfil</button>
            <button class="tablink" onclick="openTab('ofertas')">Publicaciones</button>
        </div>
        <div class="tabcontent" id="perfil">
            <div class="profile-form">
                <div class="row">
                    <div class="label">
                        <label for="nickname">Nickname:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="nickname" value="EcoTech" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="email">Email:</label>
                    </div>
                    <div class="info email-info">
                        <input type="email" id="email" value="info@EcoTech.com" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="name">Nombre:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="name" value="Sophia" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="lastname">Apellido:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="lastname" value="Johnson" readonly>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="descripcion">Descripción:</label>
                    </div>
                    <div class="info">
                        <textarea id="desc" readonly>EcoTech Innovations es una empresa líder en soluciones tecnológicas sostenibles. Nuestro enfoque se centra en desarrollar y comercializar productos y servicios que aborden los desafíos ambientales más apremiantes de nuestro tiempo. Desde sistemas de energía renovable y dispositivos de monitorización ambiental hasta soluciones de gestión de residuos inteligentes, nuestra misión es proporcionar herramientas que permitan a las empresas y comunidades adoptar prácticas más ecológicas sin comprometer la eficiencia. Creemos en la convergencia armoniosa entre la tecnología y la naturaleza, y trabajamos incansablemente para impulsar un futuro más limpio y sostenible.
                        </textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <label for="link">Link:</label>
                    </div>
                    <div class="info">
                        <input type="text" id="link" value="http://www.ecotechinnovations.com/" readonly>
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