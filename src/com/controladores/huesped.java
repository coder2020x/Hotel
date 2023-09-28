/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controladores;

import javafx.beans.property.SimpleStringProperty;

public class huesped {

    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellido;
    private final SimpleStringProperty nacimiento;
    private final SimpleStringProperty nacionalidad;
    private final SimpleStringProperty telefono;
    private final SimpleStringProperty nreserva;

    public huesped(String nombre, String apellido, String nacimiento, String nacionalidad, String telefono, String nreserva) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.nacimiento = new SimpleStringProperty(nacimiento);
        this.nacionalidad = new SimpleStringProperty(nacionalidad);
        this.telefono = new SimpleStringProperty(telefono);
        this.nreserva = new SimpleStringProperty(nreserva);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String newValue) {
        nombre.set(newValue);
    }

    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String newValue) {
        apellido.set(newValue);
    }

    public String getNacimiento() {
        return nacimiento.get();
    }

    public void setNacimiento(String newValue) {
        nacimiento.set(newValue);
    }

    public String getNacionalidad() {
        return nacionalidad.get();
    }

    public void setNacionalidad(String newValue) {
        nacionalidad.set(newValue);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String newValue) {
        telefono.set(newValue);
    }

    public String getNreserva() {
        return nreserva.get();
    }

    public void setNreserva(String newValue) {
        nreserva.set(newValue);
    }
}
