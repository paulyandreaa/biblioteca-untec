package com.untec.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.untec.dao.UsuarioDAO;
import com.untec.modelo.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Mostrar la página de login
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String accion = request.getParameter("accion");
        
        // Si la acción es "registrar", redirigir al formulario de registro
        if ("registrar".equals(accion)) {
            response.sendRedirect("registroUsuario.jsp");
            return;
        }
        
        // Validar el login
        Usuario usuario = usuarioDAO.validarLogin(nombre, password);
        
        if (usuario != null) {
            // Login exitoso: crear sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            
            // Redirigir al listado de libros
            response.sendRedirect("LibroServlet?accion=listar");
        } else {
            // Login fallido: volver al login con mensaje de error
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}