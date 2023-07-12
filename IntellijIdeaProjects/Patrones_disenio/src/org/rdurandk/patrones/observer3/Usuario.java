package org.rdurandk.patrones.observer3;

public class Usuario implements Observador{//observador
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String nuevaEstacion) {
        System.out.println(this.nombre + " el nuevo Clima ha cambiado a: " + nuevaEstacion);
    }
}
