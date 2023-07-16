package com.example.dao;

import com.example.model.Usuario;
import com.example.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() {
        connection = DBConnection.getConnection();
    }

    public Usuario getUsuarioByNombreUsuario(String nombreUsuario) {
        String query = "SELECT * FROM usuario WHERE nombre_usuario = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombreUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre_usuario(resultSet.getString("nombre_usuario"));
                usuario.setPassword(resultSet.getString("password"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insertUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario (id, nombre_usuario, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.setString(2, usuario.getNombre_usuario());
            preparedStatement.setString(3, usuario.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}