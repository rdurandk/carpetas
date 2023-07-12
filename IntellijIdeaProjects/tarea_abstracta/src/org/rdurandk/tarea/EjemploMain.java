package org.rdurandk.tarea;

import org.rdurandk.tarea.abstractas.Mamifero;
import org.rdurandk.tarea.clases.*;

import java.util.ArrayList;
import java.util.List;

public class EjemploMain {
    public static void main(String[] args) {
        Mamifero leon = new Leon("Sur Africa", 120, 180, 190,
                "Panthera leo", 1.27, 80, 5, 8);

        Mamifero tigre = new Tigre("Africa", 110, 300, 150,
                "Panthera tigris", 7.5, 62, "Tigre de Bengala");

        Mamifero guepardo = new Guepardo("Desiertos", 80, 110, 90,
                "Acinonyx jubatus", 1.50, 70);

        Mamifero lobo = new Lobo("Bosques de las montañas", 80, 160, 50,
                "Canis lupus", "blanco", 6, 2);

        Mamifero perro = new Perro("Casa", 30, 100, 50,
                "Canis lupus familiaris", "mostaza", 5, 328);


        List<Mamifero> mamiferos= new ArrayList<>();
        mamiferos.add(leon);
        mamiferos.add(tigre);
        mamiferos.add(guepardo);
        mamiferos.add(lobo);
        mamiferos.add(perro);

        for(Mamifero mamifero:mamiferos){
            System.out.println(mamifero.comer());
            System.out.println(mamifero.dormir());
            System.out.println(mamifero.correr());
            System.out.println(mamifero.comunicarse());
            System.out.println();
        }
    }

}
