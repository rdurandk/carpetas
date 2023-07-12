package org.rdurandk.datetatime.ejemplos;

import java.time.Duration;
import java.time.LocalDateTime;

public class EjemploDuration {
    public static void main(String[] args) {
        LocalDateTime fecha1 = LocalDateTime.now();
        LocalDateTime fecha2 = LocalDateTime.now().plusHours(3).plusMinutes(20).plusDays(1);
        Duration lapsus = Duration.between(fecha1, fecha2);
        System.out.println("fecha1 = " + fecha1);
        System.out.println("fecha2 = " + fecha2);
        System.out.println("lapsus = " + lapsus);//calcula el tiempo entre horas
        System.out.println("lapsus en segundos = " + lapsus.getSeconds());
        System.out.println("lapsus en horas = " + lapsus.toHours());
        System.out.println("lapsus en segundos = " + lapsus.toMinutes());
    }
}
