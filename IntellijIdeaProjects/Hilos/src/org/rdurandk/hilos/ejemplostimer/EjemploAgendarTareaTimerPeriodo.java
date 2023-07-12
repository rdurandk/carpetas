package org.rdurandk.hilos.ejemplostimer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import static javax.sound.sampled.FloatControl.Type.SAMPLE_RATE;

public class EjemploAgendarTareaTimerPeriodo {
    public static float SAMPLE_RATE = 8000f;
    public static void main(String[] args) throws LineUnavailableException {

        //AtomicInteger sirve como un contador automaticamente y puede ser
        //empleado en otra clase como timer task
        AtomicInteger contadorAtomic = new AtomicInteger(3);
        Toolkit toolkit = Toolkit.getDefaultToolkit();//para detonar un sonido beep
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            //private int contador = 3;
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if(i>0){
                toolkit.beep();
                System.out.println("Tarea " +i +" periodica en: "
                        + new Date() + " nombre del Thread: "
                        + Thread.currentThread().getName());
                //contador--;
                }else{
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        },500,1000);

        System.out.println("Aprendamos un tarea cada segundo ");
    }
}
