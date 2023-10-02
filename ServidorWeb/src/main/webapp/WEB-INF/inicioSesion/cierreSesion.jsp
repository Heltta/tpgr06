<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/estilosGenericos.css">
    <title>Cerrar Sesion</title>
</head>

<body class="bg-primary-subtle body-center">
    <jsp:include page="/WEB-INF/template/header.jsp" />
  	<jsp:include page="/WEB-INF/template/sideBar.jsp" />
  	
    <div class="container mt-5" style="width: 25rem;">
        <div class="rounded-5 p-4 text-white bg-primary">
            <label>Se ha cerrado correctamente la sesion</label>
            <button onclick="location.href ='Home'" class="btn btn-light btn-lg asd">Volver a la pagina
                principal</button>
        </div>
    </div>
</body>

</html>