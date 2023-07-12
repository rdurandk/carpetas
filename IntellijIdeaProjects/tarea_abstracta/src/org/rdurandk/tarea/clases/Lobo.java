package org.rdurandk.tarea.clases;

import org.rdurandk.tarea.abstractas.Canino;

public class Lobo extends Canino {
    private int num_camadas;

    public Lobo(String habitad, double altura, double largo, double peso, String nombre_cientifico, String color,
                double tamanio_colmillo, int num_camadas) {
        super(habitad, altura, largo, peso, nombre_cientifico, color, tamanio_colmillo);
        this.num_camadas = num_camadas;
    }

    @Override
    public String comer() {
        return "El lobo caza con sus colmillos de un tamaño de "+ tamanio_colmillo +
                " y luego come con sus " +num_camadas;
    }

    @Override
    public String dormir() {
        return "El Lobo " + color + " duerme en las cavernas de " + habitad;
    }

    @Override
    public String correr() {
        return "El lobo de la familia "+ nombre_cientifico+" corre juntos con sus " +num_camadas;
    }

    @Override
    public String comunicarse() {
        return "El lobo de la familia " +nombre_cientifico+ " se comunica con señales olfativos y visuales";
    }
}
