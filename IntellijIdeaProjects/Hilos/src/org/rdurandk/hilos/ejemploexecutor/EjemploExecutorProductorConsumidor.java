package org.rdurandk.hilos.ejemploexecutor;

import org.rdurandk.hilos.ejemplossync.Panaderia;
import org.rdurandk.hilos.ejemplossync.runnable.Consumidor;
import org.rdurandk.hilos.ejemplossync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException, TimeoutException {
        //FRAMEWORK
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //fixedthreadpool especificas cuantas tareas ejecutar al mismo tiempo
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);
        Future<?> future1 = executor.submit(productor);
        Future<?> future2 = executor.submit(consumidor);
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        executor.shutdown();//apaga la ejecucion una vez que finalize
        System.out.println("Continuamos con la ejecucion del metodo main 1");
    }
}
