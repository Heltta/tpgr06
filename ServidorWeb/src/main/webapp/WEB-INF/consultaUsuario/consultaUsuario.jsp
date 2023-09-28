<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>consultaUsuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/estilosGenericos.css">
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
                <li>
                    <a href="perfilPostulanteVisitante.html" class="sinEstilo">
                        <div class="user-card">
                            <img src="img/lgarcia.png" alt="Usuario1">
                            <div class="user-info">
                                <h3>lgarcia</h3>
                                <ul>
                                    <li>Lucía García</li>
                                    <li>lgarcia85@example.com</li>
                                </ul>
                            </div>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="perfilEmpresaVisitante.html" class="sinEstilo">
                        <div class="user-card">
                            <img src="img/EcoTech.png" alt="Usuario2">
                            <div class="user-info">
                                <h3>EcoTech</h3>
                                <ul>
                                    <li>Sophia Johnson</li>
                                    <li>info@EcoTech.com</li>
                                </ul>
                            </div>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</body>

</html>