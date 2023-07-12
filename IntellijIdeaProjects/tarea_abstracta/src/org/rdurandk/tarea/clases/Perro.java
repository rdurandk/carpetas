package org.rdurandk.tarea.clases;

import org.rdurandk.tarea.abstractas.Canino;

public class Perro extends Canino {

    private int fuerza_mordida;

    public Perro(String habitad, double altura, double largo, double peso, String nombre_cientifico, String color,
                 double tamanio_colmillo, int fuerza_mordida) {
        super(habitad, altura, largo, peso, nombre_cientifico, color, tamanio_colmillo);
        this.fuerza_mordida = fuerza_mordida;
    }

    @Override
    public String comer() {
        return "El perro domestico come croquetas o carne con sus colmillos de " +tamanio_colmillo;
    }

    @Override
    public String dormir() {
        return "El perro con altura de "+ altura+ " y peso de "+ peso+ " duerme en el patio o en el hogar";
    }

    @Override
    public String correr() {
        return "El perro de color " +color+ " corre persiguiendo autos o jugando";
    }

    @Override
    public String comunicarse() {
        return "Los perros " + nombre_cientifico+ " ladran para comunicarse";
    }
}
