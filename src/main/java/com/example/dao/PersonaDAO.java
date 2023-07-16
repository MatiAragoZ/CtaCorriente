package com.example.dao;


import com.example.model.Persona;
import com.example.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
    private Connection connection;

    public PersonaDAO() {
        connection = DBConnection.getConnection();
    }

    public Persona getPersonaByRut(String rut) {
        String query = "SELECT * FROM persona WHERE rut = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rut);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Persona persona = new Persona();
                persona.setRut(resultSet.getString("rut"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setDireccion(resultSet.getString("direccion"));
                persona.setCorreo(resultSet.getString("correo"));
                persona.setTelefono(resultSet.getString("telefono"));
                persona.setNombre_mascota(resultSet.getString("nombre_mascota"));
                return persona;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void insertPersona(Persona persona) {
        String query = "INSERT INTO persona (rut, nombre, apellido, direccion, correo, telefono, nombre_mascota) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, persona.getRut());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getApellido());
            preparedStatement.setString(4, persona.getDireccion());
            preparedStatement.setString(5, persona.getCorreo());
            preparedStatement.setString(6, persona.getTelefono());
            preparedStatement.setString(7, persona.getNombre_mascota());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}