package org.rdurandk.hilos.ejemplos;

import org.rdurandk.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo1 = new NombreThread("Pepe");
        hilo1.start();

        //Thread.sleep(2);//pausa en el metodo main
        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();

        new Thread(new NombreThread("Alex Durand")).start();

        //Thread.sleep(100);
        System.out.println(hilo1.getState());
    }
}
