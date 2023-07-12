package org.rdurandk.hilos.ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

        //FRAMEWORK
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ////executor es un hilo(Thread) y podremos entregar un runnable o callable
        //para implementar una tarea, la unica diferencia entre ellos 2 es que el callable
        //retornara un valor mientras el otro no retorna nada
        Runnable tarea = () ->{
            System.out.println("Inicio de la tarea...");
            //Thread.sleep(10);
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);//igual que el sleep pero con conversion
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
        };
        executor.submit(tarea);
        executor.shutdown();//apaga la ejecucion una vez que finalize
        System.out.println("Continuamos con la ejecucion del metodo main 1");
        executor.awaitTermination(5, TimeUnit.SECONDS);//espera a que finalice todas las tareas como un join
        System.out.println("Continuamos con la ejecucion del metodo main 2");
    }
}
