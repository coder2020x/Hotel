/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controladores;

import java.sql.Connection;

//import com.sun.jdi.connect.spi.Connection;


public class tester {
    public static void main(String[] args) {
      //  String url = "jdbc:mysql://localhost:3306/hotel";
       // String usuario = "root";
       // String contraseña = "";

        // Crear una instancia de DBConnection para obtener la conexión
        //db dbConnection = new db(url, usuario, contraseña);
       // Connection connection = dbConnection.getConnection();
         db dbConnection = new db();
         Connection connection = dbConnection.getConnection();
        if (connection != null) {
            // Crear una instancia de Login
            Login login = new Login();

            // Verificar las credenciales
            String nombreUsuario = "nemo"; // Reemplaza con un nombre de usuario real
            String contraseñaUsuario = "nene"; // Reemplaza con una contraseña real
            boolean autenticado = login.verificarCredenciales(connection, nombreUsuario, contraseñaUsuario);

            if (autenticado) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
            } else {
                System.out.println("Inicio de sesión fallido. Nombre de usuario o contraseña incorrectos.");
            }

            // Cerrar la conexión a la base de datos
            dbConnection.closeConnection();
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }
}

