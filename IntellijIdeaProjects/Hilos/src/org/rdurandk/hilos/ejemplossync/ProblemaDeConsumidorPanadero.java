package org.rdurandk.hilos.ejemplossync;

public class ProblemaDeConsumidorPanadero {
    public static void main(String[] args) {

        Panaderia p = new Panaderia();
        new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println("Panadero hornea pan nª: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println("Consumidor come el pan nª: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
