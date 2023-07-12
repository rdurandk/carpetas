package org.rdurand.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        //Tree set - ordena de forma alfabetica o de la tabla unicode y no admite duplicados
        Set<String> ts = new TreeSet<>((a,b)->b.compareTo(a));
        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("tres");
        ts.add("cuatro");
        System.out.println("ts= " + ts);

        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder());//con la api de java
        numeros.add(1);
        numeros.add(5);
        numeros.add(3);
        numeros.add(2);
        numeros.add(4);
        numeros.add(10);
        System.out.println("numeros: " + numeros);

    }
}
