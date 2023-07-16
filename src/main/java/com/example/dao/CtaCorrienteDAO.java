package com.example.dao;

import com.example.model.CtaCorriente;
import com.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CtaCorrienteDAO {
    private Connection connection;

    public CtaCorrienteDAO() {
        connection = DBConnection.getConnection();
    }

    public void insertCtaCorriente(CtaCorriente ctaCorriente) {
        String query = "INSERT INTO ctaCorriente (rut_cliente, monto, ejecutivo) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ctaCorriente.getRut_cliente());
            preparedStatement.setDouble(2, ctaCorriente.getMonto());
            preparedStatement.setString(3, ctaCorriente.getEjecutivo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
