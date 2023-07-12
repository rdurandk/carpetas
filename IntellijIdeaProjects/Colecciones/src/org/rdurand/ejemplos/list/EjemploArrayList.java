package org.rdurand.ejemplos.list;

import org.rdurand.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class EjemploArrayList {
    public static void main(String[] args) {
        List<Alumno> al = new ArrayList<>();
        System.out.println(al + ", size - " + al.size());
        System.out.println("Esta vacia?: " + al.isEmpty());
        al.add(new Alumno("Pato", 5.0));
        al.add(new Alumno("Cata", 5.0));
        al.add(new Alumno("Luci", 4.0));
        al.add(2, new Alumno("Jano", 7.0));
        al.set(3, new Alumno("Andres", 3.0));

        System.out.println(al + ", size - " + al.size());

        al.remove(new Alumno("Andres", 7.0));//por debajo se evalua en el equals
        //al.remove(2);
        System.out.println(al + ", size - " + al.size());

        boolean b = al.contains(new Alumno("Jano", 7.0));
        System.out.println("La lista contiene a Jano?: " + b);

        Object a [] = al.toArray();
        for(int i=0;i<al.size();i++){
            System.out.println("Desde el  arreglo = " + a[i]);
        }
    }
}
