package org.rdurandk.datetatime.ejemplos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {

        //LocalTime representa año,mes,dia,hora,etc
        //sus metodos of y parse  son los mismos
        LocalTime ahora = LocalTime.now();
        System.out.println(ahora);
        System.out.println("Hora: " + ahora.getHour());
        System.out.println("Minutos: " + ahora.getMinute());
        System.out.println("Seg: " + ahora.getSecond());

        LocalTime seisConTreinta = LocalTime.of(6,30);
        System.out.println("seisConTreinta = " + seisConTreinta);
        seisConTreinta = LocalTime.parse("18:30:45");
        System.out.println("seisConTreinta = " + seisConTreinta);
        //los segundos puede entrar como tercer parametro en localtime
        LocalTime sieteConTreinta = LocalTime.of(6,30).plus(1, ChronoUnit.HOURS);
        System.out.println("sieteConTreinta = " + sieteConTreinta);
        boolean esAnterior = LocalTime.of(6,30).isBefore(LocalTime.parse("07:30"));
        System.out.println("esAnterior = " + esAnterior);

        //HH formato de 24 horas y hh am o pm
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String horaFormateado = df.format(seisConTreinta);//ahi 2 formas de formatear
        System.out.println("formateado: " +horaFormateado);

        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
