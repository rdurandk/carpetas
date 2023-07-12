package org.rdurandk.tarea.abstractas;

abstract public class Canino extends Mamifero{

    protected String color;
    protected double tamanio_colmillo;

    public Canino(String habitad, double altura, double largo, double peso, String nombre_cientifico,
            String color, double tamanio_colmillo){
        super(habitad, altura, largo, peso, nombre_cientifico);
        this.color = color;
        this.tamanio_colmillo = tamanio_colmillo;
    }

    public String getColor() {
        return color;
    }

    public double getTamanio_colmillo() {
        return tamanio_colmillo;
    }

}
