package org.rdurandk.tarea.clases;

import org.rdurandk.tarea.abstractas.Felino;

public class Guepardo extends Felino {

    public Guepardo(String habitad, double altura, double largo, double peso, String nombre_cientifico,
                    double tamanio_garras, int velocidad) {
        super(habitad, altura, largo, peso, nombre_cientifico, tamanio_garras, velocidad);
    }

    @Override
    public String comer() {
        return "El guepardo caza con sus garras de "+ tamanio_garras;
    }

    @Override
    public String dormir() {
        return "El guepardo se ubica en " + habitad + " y duerme en una caverna";
    }

    @Override
    public String correr() {
        return "El guepardo para cazar corre hasta " + velocidad+  "K/H";
    }

    @Override
    public String comunicarse() {
        return "El guepardo de la familia " +nombre_cientifico+ " se comunica con señales olfativos y visuales";
    }
}
