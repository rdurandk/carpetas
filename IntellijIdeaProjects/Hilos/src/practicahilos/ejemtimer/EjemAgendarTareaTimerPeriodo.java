package practicahilos.ejemtimer;

import java.awt.*;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemAgendarTareaTimerPeriodo {
    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(3);
        Toolkit tic = Toolkit.getDefaultToolkit();
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = atomic.getAndDecrement();
                if(i>0){
                    System.out.println("Tarea " +i+ " periodica en: " + new Date() + " nombre del Thread");
                    tic.beep();
                }else{
                    System.out.println("Finalizo el tiempo");
                    time.cancel();
                }
            }
        },2000,1000);
        System.out.println("Agendamos un tarea cada segundo");
    }
}
