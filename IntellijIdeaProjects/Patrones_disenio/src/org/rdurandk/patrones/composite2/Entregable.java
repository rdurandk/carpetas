package org.rdurandk.patrones.composite2;

public class Entregable implements ItemProyecto{
    private String nombre;

    public Entregable(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getTiempo() {
        return 0;
    }

    @Override
    public void imprimir() {
        System.out.println("\tEntregable: " + this.nombre);
    }
}
