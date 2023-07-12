package org.rdurand.ejemplos.set;

import org.rdurand.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {
        //Hashset actua de manera desordenada y trabaja con equals y con hashcode
        //para evaluar objetos unicos y no admitir duplicados
        Set<Alumno> sa = new HashSet<>();
        sa.add(new Alumno("Pao", 5.0));
        sa.add(new Alumno("Cata", 6.0));
        sa.add(new Alumno("Luci", 4.0));
        sa.add(new Alumno("Jano", 7.0));
        sa.add(new Alumno("Andres", 3.0));
        sa.add(new Alumno("Zeus", 2.0));
        sa.add(new Alumno("Zeus", 2.0));
        sa.add(new Alumno("Zeus", 3.0));
        sa.add(new Alumno("Zeus2", 2.0));

        System.out.println(sa);
        System.out.println("Iterando usando for");
        for(Alumno a:sa){
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando usando Iterator");
        Iterator<Alumno> it = sa.iterator();
        while(it.hasNext()){
            Alumno a = it.next();
            System.out.println(a);
        }

        System.out.println("Iterando usando Stream foreach");
        sa.forEach(el-> System.out.println(el.getNombre()));
    }
}
