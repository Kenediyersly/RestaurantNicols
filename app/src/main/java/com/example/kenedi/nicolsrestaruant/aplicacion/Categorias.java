package com.example.kenedi.nicolsrestaruant.aplicacion;

public class Categorias extends Plato{

    String nombre;
    Plato plato;

   public Categorias(){

   }

    public Categorias(String nombre, Plato plato) {
        this.nombre = nombre;
        this.plato = plato;
    }

    public Categorias(String nombre, String descripcion, String estado, double presio, String nombre1, Plato plato) {
        super(nombre, descripcion, estado, presio);
        this.nombre = nombre1;
        this.plato = plato;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}
