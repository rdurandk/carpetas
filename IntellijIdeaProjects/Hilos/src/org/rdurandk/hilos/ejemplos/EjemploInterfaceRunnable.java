package org.rdurandk.hilos.ejemplos;

import org.rdurandk.hilos.ejemplos.runnable.Viaje;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {
        new Thread(new Viaje("Isla de Pascua")).start();
        new Thread(new Viaje("Robinson Crusoe")).start();
        new Thread(new Viaje("Juan Fernandez")).start();
        new Thread(new Viaje("Rio de Janeiro")).start();
    }
}
