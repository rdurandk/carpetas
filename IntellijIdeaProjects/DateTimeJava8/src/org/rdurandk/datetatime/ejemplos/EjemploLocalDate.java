package org.rdurandk.datetatime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {

        //LocalDate representa año,mes,dia
        //sus metodos of y parse en LocalDate son los mismos
        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Dia = " + fechaActual.getDayOfMonth());
        Month mes = fechaActual.getMonth();
        System.out.println("Mes = " + mes);
        System.out.println("Numero del Mes = " + mes.getValue());
        System.out.println("Mes español = " + mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Numero de dia = " + diaSemana.getValue());
        System.out.println("Nombre de dia = " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        System.out.println("Era = " + fechaActual.getEra());

        fechaActual = LocalDate.of(2020,12,25);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.of(2020, Month.NOVEMBER, 11);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2020-02-01");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate diaDeManiana = LocalDate.now().plusDays(1);
        System.out.println("diaDeManiana = " + diaDeManiana);

        LocalDate diaMesAnterior = LocalDate.now().minusMonths(1);
        System.out.println("diaDeMes = " + diaMesAnterior);

        DayOfWeek dayOfWeek = LocalDate.parse("2020-11-11").getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek.getValue());

        int once1 = LocalDate.of(2020,11,11).getDayOfMonth();
        System.out.println("once1 = " + once1);

        int once2 = LocalDate.parse("2020-11-11").getDayOfMonth();
        System.out.println("once2 = " + once2);

        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        boolean esAntes = LocalDate.of(2020,11,10).isBefore(LocalDate.parse("2020-11-11"));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.parse("2020-11-11").isAfter(LocalDate.of(2020,11,10));
        System.out.println("esDespues = " + esDespues);

        esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(1));
        System.out.println("esDespues = " + esDespues);


    }
}
