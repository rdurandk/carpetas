package org.rdurandk.hilos.ejemplos;

import org.rdurandk.hilos.ejemplos.runnable.Viaje;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();
        //Thread con expression lambda
        Runnable viaje = ()-> {
                for(int i=0;i<10;i++){
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Me voy de viaje a: " + Thread.currentThread().getName());
                System.out.println(main.getState());
        };



        Thread v1 = new Thread(viaje, "Isla de Pascua");
        Thread v2 = new Thread(viaje,"Robinson Crusoe");
        Thread v3 = new Thread(viaje,"Juan Fernandez");
        Thread v4 = new Thread(viaje,"Rio de Janeiro");

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        //join quiere decir que no saltara el codigo que se encuentra abajo hasta que termine el proceso
        v1.join();
        v2.join();
        v3.join();
        v4.join();

        //Thread.sleep(5000);

        System.out.println("Continuando con la ejecucion del metodo main: " + main.getName());
    }
}
