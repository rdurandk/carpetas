package org.rdurandk.tarea.abstractas;

abstract public class Felino extends Mamifero{
    protected double tamanio_garras;
    protected int velocidad;

    public Felino(String habitad, double altura, double largo, double peso, String nombre_cientifico,
                  double tamanio_garras, int velocidad) {
        super(habitad, altura, largo, peso, nombre_cientifico);
        this.tamanio_garras = tamanio_garras;
        this.velocidad = velocidad;
    }

    public double getTamanio_garras() {
        return tamanio_garras;
    }

    public int getVelocidad() {
        return velocidad;
    }


}
