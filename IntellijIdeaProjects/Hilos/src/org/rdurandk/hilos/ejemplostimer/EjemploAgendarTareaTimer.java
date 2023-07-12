package org.rdurandk.hilos.ejemplostimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //timer permite ejecutar tareas y programarlas
        //schedule - Programa la tarea especificada
        //timer task Una tarea que se puede programar para una ejecución única o repetida por un temporizador.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en: " + new Date() + " nombre del Thread: "
                + Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                timer.cancel();
            }
        },5000);

        System.out.println("Aprendamos una tarea en 5 segundos...");
    }
}
