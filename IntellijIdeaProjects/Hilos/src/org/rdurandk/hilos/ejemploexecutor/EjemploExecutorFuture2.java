package org.rdurandk.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException, TimeoutException {

        //FRAMEWORK
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        //fixedthreadpool especificas cuantas tareas ejecutar al mismo tiempo
        //Threadpoolexecutor para saber el tamaño del pool(tareas) y cantidad de tareas en cola
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        Callable<String> tarea = () ->{
            System.out.println("Inicio de la tarea...");
            //Thread.sleep(10);
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);//igual que el sleep pero con conversion
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
            return "Algun resultado importante de la tarea";
        };

        Callable<Integer> tarea2 = ()->{
            System.out.println("Iniciando tarea 3...");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Finalizo la tarea 3...");
            return 10;
        };
        //Future para saber los resultados de la tarea que se esta procesando en un futuro
        Future<String> future = executor.submit(tarea);
        Future<String> future2 = executor.submit(tarea);
        Future<Integer> future3 = executor.submit(tarea2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();//apaga la ejecucion una vez que finalize
        System.out.println("Continuamos con la ejecucion del metodo main 1");

        while(!(future.isDone()&&future2.isDone()&&future3.isDone())){
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    future.isDone()? "finalizo": "en proceso",
                    future2.isDone()? "finalizo": "en proceso",
                    future3.isDone()? "finalizo": "en proceso"));
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Obtenemos resultado de la tarea1: " + future.get(2, TimeUnit.SECONDS));
        System.out.println("Finalizo la tarea1: " + future.isDone());

        System.out.println("Obtenemos resultado de la tarea2: " + future2.get(2, TimeUnit.SECONDS));
        System.out.println("Finalizo la tarea2: " + future2.isDone());

        System.out.println("Obtenemos resultado de la tarea3: " + future3.get(2, TimeUnit.SECONDS));
        System.out.println("Finalizo la tarea3: " + future3.isDone());
    }
}
