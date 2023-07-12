package org.rdurandk.datetatime.tarea;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class EjemploEdad {
    public static void main(String[] args) {
        //Para esta tarea se pide ingresar una fecha de nacimiento en formato string,
        //convertirla a una fecha del tipo LocalDate y calcular la edad de la persona de acuerdo a la fecha actual.
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una fecha en formato(yyyy-MM-dd)");
        String fecha = sc.nextLine();
        LocalDate fString = LocalDate.parse(fecha);
        LocalDate fActual = LocalDate.now();
        Period periodo = Period.between(fString, fActual);
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Usted tiene: " + periodo.getYears() + " años");
    }
}
