package com.example.dao;

import com.example.model.Ejecutivo;
import com.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjecutivoDAO {
    private Connection connection;

    public EjecutivoDAO() {
        connection = DBConnection.getConnection();
    }

    public Ejecutivo getEjecutivoByRut(String rut) {
        String query = "SELECT * FROM ejecutivo WHERE rut = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rut);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Ejecutivo ejecutivo = new Ejecutivo();
                ejecutivo.setRut(resultSet.getString("rut"));
                ejecutivo.setNombre(resultSet.getString("nombre"));
                ejecutivo.setDepartamento(resultSet.getString("departamento"));
                return ejecutivo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

