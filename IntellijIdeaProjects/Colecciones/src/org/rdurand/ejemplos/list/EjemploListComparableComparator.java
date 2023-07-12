package org.rdurand.ejemplos.list;

import org.rdurand.ejemplos.modelo.Alumno;

import java.util.*;


public class EjemploListComparableComparator {
    public static void main(String[] args) {
        List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Pao", 5.0));
        sa.add(new Alumno("Cata", 6.0));
        sa.add(new Alumno("Luci", 4.0));
        sa.add(new Alumno("Jano", 7.0));
        sa.add(new Alumno("Andres", 3.0));
        sa.add(new Alumno("Zeus", 2.0));
        sa.add(new Alumno("Zeus", 2.0));
        sa.add(new Alumno("Zeus", 3.0));
        sa.add(new Alumno("Zeus2", 2.0));
        //Collections.sort(sa, (a, b) ->  a.getNombre().compareTo(b.getNombre()));
        sa.sort((a, b) ->  a.getNombre().compareTo(b.getNombre()));
        sa.sort(Comparator.comparing(Alumno::getNombre).reversed());
        System.out.println(sa);
        System.out.println("Iterando usando Stream foreach");
        sa.forEach(el-> System.out.println(el.getNombre()));
    }
}
