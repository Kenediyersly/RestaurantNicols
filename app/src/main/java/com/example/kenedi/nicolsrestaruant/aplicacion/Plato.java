package com.example.kenedi.nicolsrestaruant.aplicacion;

public class Plato {

    String nombre;
    String descripcion;
    String estado;
    double presio;

    public Plato(){

    }

    public Plato(String nombre, String descripcion, String estado, double presio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.presio = presio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPresio() {
        return presio;
    }

    public void setPresio(double presio) {
        this.presio = presio;
    }
}
