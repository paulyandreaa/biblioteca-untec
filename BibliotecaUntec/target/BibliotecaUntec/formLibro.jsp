<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Libro - Biblioteca UNTEC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white">
                        <h3 class="mb-0">Registrar Nuevo Libro</h3>
                    </div>
                    <div class="card-body">
                        <form action="LibroServlet" method="POST">
                            <input type="hidden" name="accion" value="guardar">
                            
                            <div class="mb-3">
                                <label class="form-label">Título</label>
                                <input type="text" name="titulo" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Idioma</label>
                                <input type="text" name="idioma" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Autor</label>
                                <input type="text" name="autor" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Editorial</label>
                                <input type="text" name="editorial" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Cantidad de Páginas</label>
                                <input type="number" name="paginas" class="form-control" required>
                            </div>
                            <div class="mb-3 form-check">
                                <input type="checkbox" name="prestado" value="true" class="form-check-input" id="prestadoCheck">
                                <label class="form-check-label" for="prestadoCheck">¿Está prestado actualmente?</label>
                            </div>
                            
                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-primary">Guardar Libro</button>
                                <a href="LibroServlet?accion=listar" class="btn btn-secondary">Cancelar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>