package org.rdurand.ejemplos.set;

import org.rdurand.ejemplos.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {
        //Treeset actua de manera ordenada, por lo tanto si queremos trabajar con objetos
        //deberiamos implementar la interfaz Comparable o comparator en Alumnos
        //Set<Alumno> sa = new TreeSet<>((a,b)->b.getNota().compareTo(a.getNota()));
        Set<Alumno> sa = new TreeSet<>(Comparator.comparing(Alumno::getNota));
        sa.add(new Alumno("Pao", 5.0));
        sa.add(new Alumno("Cata", 6.0));
        sa.add(new Alumno("Luci", 6.0));
        sa.add(new Alumno("Jano", 7.0));
        sa.add(new Alumno("Andres", 3.0));
        sa.add(new Alumno("Zeus", 2.0));

        System.out.println(sa);
    }
}
