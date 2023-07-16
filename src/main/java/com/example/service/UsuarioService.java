package com.example.service;

import com.example.dao.UsuarioDAO;
import com.example.model.Usuario;

public class UsuarioService {
    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        usuarioDAO = new UsuarioDAO();
    }

    public Usuario getUsuarioByNombreUsuario(String nombreUsuario) {
        return usuarioDAO.getUsuarioByNombreUsuario(nombreUsuario);
    }
    public void insertUsuario(Usuario usuario) {
        usuarioDAO.insertUsuario(usuario);
    }
}