package org.rdurandk.tarea.clases;

import org.rdurandk.tarea.abstractas.Felino;

public class Tigre extends Felino {

    private String especie_tigre;

    public Tigre(String habitad, double altura, double largo, double peso, String nombre_cientifico,
                 double tamanio_garras, int velocidad, String especie_tigre) {
        super(habitad, altura, largo, peso, nombre_cientifico, tamanio_garras, velocidad);
        this.especie_tigre = especie_tigre;
    }

    @Override
    public String comer() {
        return "El tigre de la especie"+ especie_tigre + " caza con sus garras de "+ tamanio_garras;

    }

    @Override
    public String dormir() {
        return "El tigre  se ubica en " + habitad + " y duerme en una caverna";
    }

    @Override
    public String correr() {
        return "El tigre para cazar corre hasta " + velocidad+  "K/H";
    }

    @Override
    public String comunicarse() {
        return "Los "+ especie_tigre + " se comunica con señales olfativos y visuales";
    }
}
