package com.example.servlet;

import com.example.model.Usuario;
import com.example.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UsuarioService usuarioService;

    public void init() {
        usuarioService = new UsuarioService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombre_usuario");
        String password = request.getParameter("password");

        Usuario usuario = usuarioService.getUsuarioByNombreUsuario(nombreUsuario);

        if (usuario != null && usuario.getPassword().equals(password)) {
            response.sendRedirect("home.html"); // Redirige a la página del menu
        } else {
            response.sendRedirect("login.html"); // Redirige a la página de inicio de sesión
        }
    }
}