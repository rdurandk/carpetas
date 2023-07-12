package org.rdurandk.optional.ejemplos.prueba.models;

public class Compu {
    private String nombre;
    private String modelo;

    public Compu(String nombre, String modelo){
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return nombre  + " " + modelo;
    }
}
