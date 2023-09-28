/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public boolean verificarCredenciales(Connection connection, String nombreUsuario, String contraseñaUsuario) {
        if (connection != null) {
            String consulta = "SELECT * FROM usuarios WHERE nombre = ? AND password = ?";
            
            try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
                pstmt.setString(1, nombreUsuario);
                pstmt.setString(2, contraseñaUsuario);

                try (ResultSet resultSet = pstmt.executeQuery()) {
                                       // while (resultSet.next()) {
                   ///     String id = resultSet.getString("identificador"); // Assuming "id" is the column name
                        
                   // }
                    return resultSet.next(); 
                }
            } catch (SQLException e) {
                System.err.println("Error al verificar credenciales: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        return false;
    }
}

