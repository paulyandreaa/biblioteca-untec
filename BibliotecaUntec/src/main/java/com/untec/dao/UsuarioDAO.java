package com.untec.dao;

import java.util.ArrayList;
import java.util.List;
import com.untec.modelo.Usuario;

public class UsuarioDAO {
    
    // ArrayList que simula la base de datos de usuarios
    private List<Usuario> listaUsuarios;

    public UsuarioDAO() {
        listaUsuarios = new ArrayList<>();
        
        // Agregamos un usuario bibliotecario por defecto
        listaUsuarios.add(new Usuario(1, "bibliotecario", "123456", "bibliotecario"));
        
        // Puedes agregar más usuarios de prueba si quieres
        listaUsuarios.add(new Usuario(2, "juan", "123456", "estudiante"));
        listaUsuarios.add(new Usuario(3, "maria", "123456", "estudiante"));
    }

    // Método para validar el login
    public Usuario validarLogin(String nombre, String password) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre) && 
                usuario.getPassword().equals(password)) {
                return usuario; // Login exitoso, retornamos el usuario
            }
        }
        return null; // Login fallido
    }

    // Método para agregar un nuevo usuario (lo usa el bibliotecario)
    public boolean agregarUsuario(Usuario usuario) {
        // Verificar si el nombre de usuario ya existe
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equals(usuario.getNombre())) {
                return false; // El usuario ya existe
            }
        }
        
        // Asignar un nuevo ID automático
        int nuevoId = listaUsuarios.size() + 1;
        usuario.setId(nuevoId);
        
        listaUsuarios.add(usuario);
        return true; // Usuario agregado exitosamente
    }

    // Método para listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return listaUsuarios;
    }

    // Método para eliminar un usuario
    public boolean eliminarUsuario(int id) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == id) {
                listaUsuarios.remove(i);
                return true;
            }
        }
        return false;
    }
}