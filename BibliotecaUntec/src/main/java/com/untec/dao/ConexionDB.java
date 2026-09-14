package com.untec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_untc?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1234"; 

    public static Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Crea una conexión NUEVA cada vez que se llama, evitando que se cierre para todos
            Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el driver de MySQL");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}