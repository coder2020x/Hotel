/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author braya
 */
public class crud {

    private int id;

    public boolean Elimina(Connection connection, String ident) {
        if (connection != null) {
            String consulta = "DELETE reserva, huesped\n"
                    + "FROM reserva\n"
                    + "INNER JOIN huesped ON reserva.id = huesped.nreserva\n"
                    + "WHERE reserva.id = ?;";
            try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
                pstmt.setString(1, ident);
                int filasEliminadas = pstmt.executeUpdate();
                return filasEliminadas > 0;
            } catch (SQLException e) {
                System.err.println("Error al eliminar registro: " + e.getMessage());
            }

        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        return false;
    }

    public boolean update(Connection connection, String table, String ident, String columna, String newData) {
        if (connection != null) {
            String consulta = "UPDATE " + table + " SET " + columna + " = ? WHERE identificador = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
                pstmt.setString(1, newData);
                pstmt.setString(2, ident);

                int filasActualizadas = pstmt.executeUpdate();

                return filasActualizadas > 0;
            } catch (SQLException e) {
                System.err.println("Error al actualizar registro: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        return false;
    }

    public ResultSet fetch(Connection connection, String where, String kbusca) {
        if (connection != null) {
            String like;
            if ("buscador".equals(where)) {
                like = "WHERE huesped.nombre LIKE '%" + kbusca + "%' OR huesped.apellido LIKE '%" + kbusca + "%'";
            } else {
                like = "";
            }
            String consulta = "SELECT * FROM huesped INNER JOIN reserva ON huesped.nreserva = reserva.id " + like;
           
            try {
                PreparedStatement pstmt = connection.prepareStatement(consulta);
                ResultSet resultSet = pstmt.executeQuery();
                return resultSet;
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
                return null;
            }

        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        return null;
    }

    public int reserva(Connection connection, String table, String ingresa, String sale, String Tpago, double val) throws ParseException {
        if (connection != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date in = dateFormat.parse(ingresa);
            Date out = dateFormat.parse(sale);
            java.sql.Date ing = new java.sql.Date(in.getTime());
            java.sql.Date oute = new java.sql.Date(out.getTime());
            String consulta = "INSERT INTO " + table + " (ingresa,sale,valor,Formapago) VALUES (?,?,?,?)";
            try (PreparedStatement pstmt = connection.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmt.setDate(1, ing);
                pstmt.setDate(2, oute);
                pstmt.setDouble(3, val);
                pstmt.setString(4, Tpago);
                int filasInsertadas = pstmt.executeUpdate();
                if (filasInsertadas > 0) {
                    ResultSet generatedKeys = pstmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        id = generatedKeys.getInt(1);
                        return generatedKeys.getInt(1);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al insertar registro: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        return -1;
    }

    public boolean huesped(Connection connection, String table, String nombre, String apellidos, String nacido, String nacionalidad, String movil, int Nreserva) throws ParseException {
        if (connection != null) {
            String consulta = "INSERT INTO " + table + " (nombre,apellido,nacimiento,nacionalidad,telefono,nreserva) VALUES (?,?,?,?,?,?)";
            System.out.println("teseo " + Nreserva);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date n = dateFormat.parse(nacido);
            java.sql.Date nn = new java.sql.Date(n.getTime());
            try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, apellidos);
                pstmt.setDate(3, nn);
                pstmt.setString(4, nacionalidad);
                pstmt.setString(5, movil);
                pstmt.setInt(6, Nreserva);
                int filasInsertadas = pstmt.executeUpdate();

                return filasInsertadas > 0;
            } catch (SQLException e) {
                System.err.println("Error al insertar registro: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        return false;
    }

    public int getid() {
        return id;
    }
}
