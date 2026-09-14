package com.untec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.untec.modelo.Libro;

public class LibroDAO {

    // INSERTAR un nuevo libro
    public boolean insertarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, idioma, autor, editorial, paginas, prestado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIdioma());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setInt(5, libro.getPaginas());
            ps.setBoolean(6, libro.isPrestado());
            
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar libro: " + e.getMessage());
            return false;
        }
    }

    // LISTAR todos los libros
    public List<Libro> listarLibros() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setIdioma(rs.getString("idioma"));
                libro.setAutor(rs.getString("autor"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setPaginas(rs.getInt("paginas"));
                libro.setPrestado(rs.getBoolean("prestado"));
                lista.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar libros: " + e.getMessage());
        }
        return lista;
    }

    // CAMBIAR ESTADO de prestado (true/false)
    public boolean cambiarEstadoPrestamo(int id, boolean prestado) {
        String sql = "UPDATE libros SET prestado = ? WHERE id = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setBoolean(1, prestado);
            ps.setInt(2, id);
            
            int filas = ps.executeUpdate();
            System.out.println("✅ Estado actualizado. Filas afectadas: " + filas);
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al cambiar estado del libro ID " + id + ": " + e.getMessage());
            return false;
        }
    }
}