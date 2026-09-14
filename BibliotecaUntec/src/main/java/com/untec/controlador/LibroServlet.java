package com.untec.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.untec.dao.LibroDAO;
import com.untec.modelo.Libro;

@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LibroDAO libroDAO;

    @Override
    public void init() throws ServletException {
        libroDAO = new LibroDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        if (accion == null) {
            accion = "listar";
        }
        
        System.out.println("📌 Acción recibida: " + accion);
        
        switch (accion) {
            case "listar":
                listarLibros(request, response);
                break;
            case "insertar":
                mostrarFormularioInsertar(request, response);
                break;
            case "cambiarEstado":
                cambiarEstado(request, response);
                break;
            default:
                listarLibros(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        if ("guardar".equals(accion)) {
            guardarLibro(request, response);
        }
    }

    private void listarLibros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Libro> listaLibros = libroDAO.listarLibros();
        System.out.println("📚 Libros encontrados: " + listaLibros.size());
        request.setAttribute("listaLibros", listaLibros);
        request.getRequestDispatcher("/libros.jsp").forward(request, response);
    }

    private void mostrarFormularioInsertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/formLibro.jsp").forward(request, response);
    }

    private void guardarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String titulo = request.getParameter("titulo");
            String idioma = request.getParameter("idioma");
            String autor = request.getParameter("autor");
            String editorial = request.getParameter("editorial");
            int paginas = Integer.parseInt(request.getParameter("paginas"));
            boolean prestado = Boolean.parseBoolean(request.getParameter("prestado"));
            
            Libro libro = new Libro(0, titulo, idioma, autor, editorial, paginas, prestado);
            boolean exito = libroDAO.insertarLibro(libro);
            
            if (exito) {
                System.out.println("✅ Libro insertado: " + titulo);
            } else {
                System.out.println("❌ No se pudo insertar el libro");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al guardar libro: " + e.getMessage());
            e.printStackTrace();
        }
        
        response.sendRedirect("LibroServlet?accion=listar");
    }

    private void cambiarEstado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String idStr = request.getParameter("id");
            String prestadoStr = request.getParameter("prestado");
            
            System.out.println("🔄 Cambiando estado - ID: " + idStr + ", Prestado: " + prestadoStr);
            
            if (idStr == null || prestadoStr == null) {
                System.out.println("❌ Parámetros nulos");
                response.sendRedirect("LibroServlet?accion=listar");
                return;
            }
            
            int id = Integer.parseInt(idStr);
            boolean prestado = Boolean.parseBoolean(prestadoStr);
            
            boolean exito = libroDAO.cambiarEstadoPrestamo(id, prestado);
            
            if (exito) {
                System.out.println("✅ Estado cambiado exitosamente");
            } else {
                System.out.println("❌ No se pudo cambiar el estado");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al cambiar estado: " + e.getMessage());
            e.printStackTrace();
        }
        
        response.sendRedirect("LibroServlet?accion=listar");
    }
}