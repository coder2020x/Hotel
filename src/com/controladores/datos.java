/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controladores;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author braya
 */
public class datos {

    public class reserva {

        private final SimpleStringProperty id;
        private final SimpleStringProperty in;
        private final SimpleStringProperty sale;
        private final SimpleStringProperty valor;
        private final SimpleStringProperty pago;

        public reserva(String id, String in, String sale, String valor, String pago) {
            this.id = new SimpleStringProperty(id);
            this.in = new SimpleStringProperty(in);
            this.sale = new SimpleStringProperty(sale);
            this.valor = new SimpleStringProperty(valor);
            this.pago = new SimpleStringProperty(pago);
        }

        public String getId() {
            return id.get();
        }

        public void setId(String newValue) {
            id.set(newValue);
        }

        public String getIn() {
            return in.get();
        }

        public void setIn(String newValue) {
            in.set(newValue);
        }

        public String getSale() {
            return sale.get();
        }

        public void setSale(String newValue) {
            sale.set(newValue);
        }

        public String getValor() {
            return valor.get();
        }

        public void setValor(String newValue) {
            valor.set(newValue);
        }

        public String getPago() {
            return pago.get();
        }

        public void setPago(String newValue) {
            pago.set(newValue);
        }
    }

    public class huesped {

        private final SimpleStringProperty nreserva;
        private final SimpleStringProperty nombre;
        private final SimpleStringProperty apellido;
        private final SimpleStringProperty nacimiento;
        private final SimpleStringProperty nacionalidad;
        private final SimpleStringProperty telefono;

        public huesped(String nreserva, String nombre, String apellido, String nacimiento, String nacionalidad, String telefono) {
            this.nreserva = new SimpleStringProperty(nreserva);
            this.nombre = new SimpleStringProperty(nombre);
            this.apellido = new SimpleStringProperty(apellido);
            this.nacimiento = new SimpleStringProperty(nacimiento);
            this.nacionalidad = new SimpleStringProperty(nacionalidad);
            this.telefono = new SimpleStringProperty(telefono);
        }

        public String getNreserva() {
            return nreserva.get();
        }

        public void setNreserva(String newValue) {
            nreserva.set(newValue);
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

    }
}
