package org.rdurandk.tarea.clases;

import org.rdurandk.tarea.abstractas.Felino;

public class Leon extends Felino {
    private int num_manada;
    private double potencia_rugido;

    public Leon(String habitad, double altura, double largo, double peso, String nombre_cientifico, double tamanio_garras,
                int velocidad, int num_manada, double potencia_rugido) {
        super(habitad, altura, largo, peso, nombre_cientifico, tamanio_garras, velocidad);
        this.num_manada = num_manada;
        this.potencia_rugido = potencia_rugido;
    }

    @Override
    public String comer() {
        return "El leon caza con sus garras de "+ tamanio_garras+
                " y come juntos con " + num_manada + " leones mas de su manada";
    }

    @Override
    public String dormir() {
        return "El leon y su manada habitan en " + habitad+ " y duermen todos juntos";
    }

    @Override
    public String correr() {
        return "El leon para cazar corre hasta " + velocidad+  "K/H";
    }

    @Override
    public String comunicarse() {
        return "El leon para comunicarse hace un rugido de " +potencia_rugido;
    }
}
