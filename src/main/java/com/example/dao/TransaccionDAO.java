package com.example.dao;

import com.example.model.Transaccion;
import com.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaccionDAO {
    private Connection connection;

    public TransaccionDAO() {
        connection = DBConnection.getConnection();
    }

    public void insertTransaccion(Transaccion transaccion) {
        String query = "INSERT INTO transaccion (rut_cliente, rut_dueno, id_cuenta, monto_transferencia, cuenta_transferencia, tipo_cuenta) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, transaccion.getRut_cliente());
            preparedStatement.setString(2, transaccion.getRut_dueno());
            preparedStatement.setInt(3, transaccion.getId_cuenta());
            preparedStatement.setDouble(4, transaccion.getMonto_transferencia());
            preparedStatement.setString(5, transaccion.getCuenta_transferencia());
            preparedStatement.setString(6, transaccion.getTipo_cuenta());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}