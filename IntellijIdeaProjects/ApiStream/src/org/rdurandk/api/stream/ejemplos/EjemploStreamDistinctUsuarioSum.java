package org.rdurandk.api.stream.ejemplos;

import org.rdurandk.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {
    public static  void main(String[] args) {

        IntStream largoNombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia", "Pato Guzman", "Pato Guzman")
                .map(nombre-> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()//son instancias distintas a un obj; evaluara por medio de equals y hash code
                .mapToInt(u -> u.toString().length())//Devuelve un IntStream que consta
                // de los resultados de aplicar la función dada a los elementos de este flujo
                .peek(System.out::println);

        //largoNombres.forEach(System.out::println);
        //System.out.println("total: " + largoNombres.sum());  //solo acepta un operador terminal
        //para esta solucion es bueno utilizar intsumarystatistics
        IntSummaryStatistics statics = largoNombres.summaryStatistics();
        System.out.println("Total: "+ statics.getSum());
        System.out.println("Maximo: " + statics.getMax());
        System.out.println("Minimo: "  + statics.getMin());
        System.out.println("Promedio: " + statics.getAverage());

    }
}
