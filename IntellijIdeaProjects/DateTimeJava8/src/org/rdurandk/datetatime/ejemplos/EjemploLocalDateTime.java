package org.rdurandk.datetatime.ejemplos;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaTiempo = LocalDateTime.now();
        System.out.println("fechaTiempo = " + fechaTiempo);
        
        fechaTiempo = LocalDateTime.of(2020, Month.DECEMBER, 24, 20, 45, 59);
        System.out.println("fechaTiempo = " + fechaTiempo);

        fechaTiempo = LocalDateTime.parse("2020-12-24T16:25:30");
        System.out.println("fechaTiempo = " + fechaTiempo);

        System.out.println();
        LocalDateTime fechaTiempo2  = fechaTiempo.plusDays(1).plusHours(8);
        //si la hora pasa las 11:59pm entonces se agregara otro dia
        System.out.println("fechaTiempo2 = " + fechaTiempo2);
        System.out.println("fechaTiempo = " + fechaTiempo);
        
        Month mes = fechaTiempo.getMonth();
        System.out.println("mes = " + mes);
        int day = fechaTiempo.getDayOfMonth();
        System.out.println("day = " + day);

        int anio = fechaTiempo.getYear();
        System.out.println("anio = " + anio);

        String formato1 = fechaTiempo.format(DateTimeFormatter.ISO_DATE);
        System.out.println("formato1 = " + formato1);
        formato1 = fechaTiempo.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a"));
        System.out.println("formato2 = " + formato1);
    }
}
