package com.example.rafaj.fragmentapp;

import java.io.Serializable;

/**
 * Created by charl on 13/4/2018.
 */

public class Planetas implements Serializable {
    String Nombre;
    String Color;
    String Poblacion;
    String Imagen;

// Clase para planetas

    // Construtor

    public Planetas(String nombre,String color,String poblacion,String imagen) {
        Nombre = nombre;
        Color = color;
        Poblacion = poblacion;
        Imagen = imagen;
    }

    // Setters y Getters Nombre

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    // Setters y Getters Color

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    // Setters y Getters Poblacion

    public String getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(String poblacion) {
        Poblacion = poblacion;
    }

    // Setters y Getters Imagen

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}

