<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
    // Verificar si hay una sesión activa
    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("LoginServlet");
        return;
    }
    
    // Obtener el usuario logueado
    com.untec.modelo.Usuario usuarioLogueado = (com.untec.modelo.Usuario) session.getAttribute("usuario");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catálogo de Libros - Biblioteca UNTEC</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-primary text-center">
            📚 Catálogo de Libros - Bienvenido, <%= usuarioLogueado.getNombre() %>
        </h1>
        <h5 class="text-muted text-center mb-4">
            Rol: <%= usuarioLogueado.getRol() %>
        </h5>
        
        <div class="text-end mb-3">
            <a href="LibroServlet?accion=insertar" class="btn btn-success">+ Nuevo Libro</a>
            <a href="LogoutServlet" class="btn btn-danger">Cerrar Sesión</a>
        </div>
        
        <table class="table table-striped table-hover bg-white shadow-sm">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Editorial</th>
                    <th>Páginas</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="libro" items="${listaLibros}">
                    <tr>
                        <td>${libro.id}</td>
                        <td>${libro.titulo}</td>
                        <td>${libro.autor}</td>
                        <td>${libro.editorial}</td>
                        <td>${libro.paginas}</td>
                        <td>
                            <c:choose>
                                <c:when test="${libro.prestado}">
                                    <span class="badge bg-danger">Prestado</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-success">Disponible</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:if test="${!libro.prestado}">
                                <a href="LibroServlet?accion=cambiarEstado&id=${libro.id}&prestado=true" class="btn btn-sm btn-warning">Prestar</a>
                            </c:if>
                            <c:if test="${libro.prestado}">
                                <a href="LibroServlet?accion=cambiarEstado&id=${libro.id}&prestado=false" class="btn btn-sm btn-info">Devolver</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="text-center mt-4">
            <a href="LoginServlet" class="btn btn-secondary">Volver al Inicio</a>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>