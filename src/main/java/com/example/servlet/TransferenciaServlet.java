package com.example.servlet;

import com.example.model.Transaccion;
import com.example.service.TransaccionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransferenciaServlet extends HttpServlet {
    private TransaccionService transaccionService;

    public void init() {
        transaccionService = new TransaccionService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rutCliente = request.getParameter("rut_cliente");
        String rutDueno = request.getParameter("rut_dueno");
        int idCuenta = Integer.parseInt(request.getParameter("id_cuenta"));
        double montoTransferencia = Double.parseDouble(request.getParameter("monto_transferencia"));
        String cuentaTransferencia = request.getParameter("cuenta_transferencia");
        String tipoCuenta = request.getParameter("tipo_cuenta");

        Transaccion transaccion = new Transaccion();
        transaccion.setRut_cliente(rutCliente);
        transaccion.setRut_dueno(rutDueno);
        transaccion.setId_cuenta(idCuenta);
        transaccion.setMonto_transferencia(montoTransferencia);
        transaccion.setCuenta_transferencia(cuentaTransferencia);
        transaccion.setTipo_cuenta(tipoCuenta);
        transaccionService.insertTransaccion(transaccion);

        response.sendRedirect("home.html"); // Redirige a la página de inicio
    }
}

