package org.rdurandk.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException, TimeoutException {
        //FRAMEWORK
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //single thread executor se ejecutara de manera ordenada o sincronizada

        Callable<String> tarea = () ->{
            System.out.println("Inicio de la tarea...");
            //Thread.sleep(10);
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);//igual que el sleep pero con conversion
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
            return "Algun resultado importante de la tarea";
        };

        //Future para saber los resultados de la tarea que se esta procesando en un futuro
        Future<String> future = executor.submit(tarea);
        executor.shutdown();//apaga la ejecucion una vez que finalize
        System.out.println("Continuamos con la ejecucion del metodo main 1");
        //System.out.println(future.isDone());//preguntamos si esta hecho la tarea
        //System.out.println(future.get());//lanza 2 errores- parecido al join bloquea o espera una tarea ademas obtenemos la tarea
        while(!future.isDone()){
            System.out.println("ejecutando tarea...");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Obtenemos resultado de la tarea: " + future.get(2, TimeUnit.SECONDS));//si ejecuta 2 segundos antes que la tarea lanzara error
        System.out.println("Finalizo la tarea?: " + future.isDone());

    }
}
