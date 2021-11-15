<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>FirmasDigitales</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
<section class="login-dark">
    <nav class="navbar navbar-light navbar-expand-lg navigation-clean">
        <div class="container"><a class="navbar-brand" href="#">Yaniz Sanchez Diego Nathan 5IV8</a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link active" href="index.jsp">Firmar</a></li>
                    <li class="nav-item"><a class="nav-link" href="VerificarFirma.jsp">Verificar Firma</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <form method="post" action="${pageContext.request.contextPath}/Firmar" enctype="multipart/form-data">
        <h2 class="visually-hidden">Login Form</h2>
        <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>
        <div class="mb-3"><small>Documento a Firmar</small><input class="form-control" type="file" name="dataFile" placeholder="Archivo a firmar"></div>
        <div class="mb-3"><small>Clave Privada</small><input class="form-control" type="file" name="key" placeholder="FirmaDigital"></div>
        <div class="mb-3"><button class="btn btn-primary d-block w-100" type="submit">Firmar</button></div>
    </form>
</section>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>