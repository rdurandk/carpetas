package org.rdurandk.hilos.ejemploexecutor;


import java.util.concurrent.*;

public class EjemploScheduleExecutorServicePeriodo {
    public static void main(String[] args)  throws InterruptedException{
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        CountDownLatch lock = new CountDownLatch(5);//un conteo de tareas
        System.out.println("Alguna tarea en el main...");

        Future<?> future = executor.scheduleAtFixedRate(()->{
            //scheduleAtFixedRate es como schedule pero puede ejecutar en un periodo
            System.out.println("Hola mundo tarea...");

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza tarea");
            lock.countDown();//descuenta cada vez que se ejecuta una tarea
            //executor.shutdown();
        },1000, 2000,TimeUnit.MILLISECONDS);

        //TimeUnit.SECONDS.sleep(10);
        lock.await();//espera a que llege a 0 tareas
        future.cancel(true);
        System.out.println("Alguna otra tarea en el main....");
        executor.shutdown();
    }
}
