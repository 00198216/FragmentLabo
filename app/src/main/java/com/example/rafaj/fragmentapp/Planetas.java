package com.example.rafaj.fragmentapp;

/**
 * Created by charl on 13/4/2018.
 */

public class Planetas {
    String Nombre;
    String Color;
    String Poblacion;
    int Imagen;

// Clase para planetas

    // Construtor

    public Planetas(String nombre,String color,String poblacion,int imagen) {
        Nombre = nombre;
        Color = color;
        Poblacion = poblacion;
        Imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(String poblacion) {
        Poblacion = poblacion;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}

