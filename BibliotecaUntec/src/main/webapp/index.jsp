<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca Digital UNTEC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Redirección automática después de 3 segundos -->
    <meta http-equiv="refresh" content="3;url=LoginServlet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8 text-center">
                <div class="card shadow">
                    <div class="card-body p-5">
                        <h1 class="text-primary"> Biblioteca Digital UNTEC</h1>
                        <h4 class="text-muted mt-3">Panel de Gestión para Bibliotecario</h4>
                        <p class="lead mt-3">Sistema de gestión de libros, préstamos y usuarios</p>
                        
                        <div class="alert alert-info mt-4">
                            <strong>Redirigiendo al login en 3 segundos...</strong>
                        </div>
                        
                        <a href="LoginServlet" class="btn btn-primary btn-lg mt-3">
                            Ir al Login ahora
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>