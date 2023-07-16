package com.example.servlet;

import com.example.model.CtaCorriente;
import com.example.model.Persona;
import com.example.model.Usuario;
import com.example.service.CtaCorrienteService;
import com.example.service.PersonaService;
import com.example.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistroServlet extends HttpServlet {
    private UsuarioService usuarioService;
    private PersonaService personaService;
    private CtaCorrienteService ctaCorrienteService;

    public void init() {
        usuarioService = new UsuarioService();
        personaService = new PersonaService();
        ctaCorrienteService = new CtaCorrienteService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombre_usuario");
        String password = request.getParameter("password");
        String rutPersona = request.getParameter("rut_persona");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String nombreMascota = request.getParameter("nombre_mascota");
        double montoInicial = Double.parseDouble(request.getParameter("monto_inicial"));
        String rutEjecutivo = request.getParameter("rut_ejecutivo");

        // Registra el usuario en la base de datos
        Usuario usuario = new Usuario();
        usuario.setNombre_usuario(nombreUsuario);
        usuario.setPassword(password);
        usuarioService.insertUsuario(usuario);

        // Registra la persona en la base de datos
        Persona persona = new Persona();
        persona.setRut(rutPersona);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setDireccion(direccion);
        persona.setCorreo(correo);
        persona.setTelefono(telefono);
        persona.setNombre_mascota(nombreMascota);
       personaService.insertPersona(persona);

        // Crea una cuenta corriente y la registra en la base de datos
        CtaCorriente ctaCorriente = new CtaCorriente();
        ctaCorriente.setRut_cliente(rutPersona);
        ctaCorriente.setMonto(montoInicial);
        ctaCorriente.setEjecutivo(rutEjecutivo);
        ctaCorrienteService.insertCtaCorriente(ctaCorriente);

        response.sendRedirect("login.html"); // Redirige a la página de inicio de sesión
    }
}