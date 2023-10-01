<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inicioSesion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/estilosGenericos.css">
    <link rel="stylesheet" href="css/inicioSesion.css">
</head>

<body class="bg-primary-subtle body-center">
    <jsp:include page="/WEB-INF/template/header.jsp" />
    <jsp:include page="/WEB-INF/template/sideBar.jsp" />
    <div class="container mt-5">
        <div class="login-container">
            <div class="user-avatar"></div>
            <form method="POST">
            	<b>Usuario y/o contrase�a incorrectos</b>
                <div class="form-group">
                    <input name="nickname" type="text" class="form-control" placeholder="Usuario" required>
                </div>
                <div class="form-group password-toggle">
                    <input name="pass" type="password" class="form-control" id="password-input" placeholder="Contrase�a" required>
                    <span class="toggle-password" onclick="visibilidadClave()"><i class="fas fa-eye-slash"></i></span>
                </div>
                <button type="submit" class="btn btn-primary login-button">Iniciar Sesi�n</button>
            </form>
        </div>
    </div>
    <script>
        let passwordVisible = false;
        const toggleButton = document.querySelector('.toggle-password');

        function visibilidadClave() {
            const passwordInput = document.getElementById('password-input');

            passwordVisible = !passwordVisible;
            if (passwordVisible) {
                passwordInput.type = 'text';
                toggleButton.innerHTML = '<i class="fas fa-eye"></i>';
            } else {
                passwordInput.type = 'password';
                toggleButton.innerHTML = '<i class="fas fa-eye-slash"></i>';
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>