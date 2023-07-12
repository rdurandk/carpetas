package org.rdurandk.patrones.composite2;

public class Responsable {
    private String nombre;
    private Integer telefono;

    public Responsable(String nombre, Integer telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }
}
