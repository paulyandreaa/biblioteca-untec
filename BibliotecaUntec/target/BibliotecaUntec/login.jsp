<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión - Biblioteca UNTEC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white text-center">
                        <h3 class="mb-0">Biblioteca Digital UNTEC</h3>
                        <p class="mb-0 small">Iniciar Sesión</p>
                    </div>
                    <div class="card-body">
                        
                        <!-- Mostrar mensaje de error si existe -->
                        <% if (request.getAttribute("error") != null) { %>
                            <div class="alert alert-danger text-center">
                                <%= request.getAttribute("error") %>
                            </div>
                        <% } %>
                        
                        <form action="LoginServlet" method="POST">
                            <div class="mb-3">
                                <label class="form-label">Usuario</label>
                                <input type="text" name="nombre" class="form-control" required 
                                       placeholder="Ingrese su nombre de usuario">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Contraseña</label>
                                <input type="password" name="password" class="form-control" required 
                                       placeholder="Ingrese su contraseña">
                            </div>
                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-primary">Ingresar</button>
                            </div>
                        </form>
                        
                        <hr>
                        <div class="text-center">
                            <p class="small text-muted mb-1">Credenciales de prueba:</p>
                            <p class="small mb-0"><strong>Usuario:</strong> bibliotecario</p>
                            <p class="small mb-0"><strong>Contraseña:</strong> 123456</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>