package org.rdurandk.hilos.ejemplossync;

import org.rdurandk.hilos.ejemplossync.runnable.Consumidor;
import org.rdurandk.hilos.ejemplossync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Consumidor(p)).start();
        new Thread(new Panadero(p)).start();
        //new Thread(new Consumidor(p)).start();
    }
}
