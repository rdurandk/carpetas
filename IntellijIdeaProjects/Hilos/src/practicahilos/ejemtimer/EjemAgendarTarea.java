package practicahilos.ejemtimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class EjemAgendarTarea {
    public static void main(String[] args) {
        Timer time = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en: " + new Date() + " nombre del hilo: " + Thread.currentThread().getName());
                try{
                    TimeUnit.SECONDS.sleep(2);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println("Finaliza la tarea");
                time.cancel();
            }
        };

        time.schedule(tarea, 5000);
        System.out.println("Aprendamos una tarea en 5 segundos...");

    }
}
