package org.rdurandk.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static  void main(String[] args) {

        //Stream una secuencia de elementos que soportan operaciones agregadas secuenciales y paralelas
        //metodo of tendra los valores de string y convertira en un arreglo para poder ser iterado
        //mapa siempre retornada un dato modificado
        //peek es como foreach una funcion consumer
        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepe")
                .map(nombre->{
                    return nombre.toUpperCase();
                })
                .map(String::toLowerCase)//optimizando con map
                .peek(System.out::println)
                .map(String::toUpperCase);//optimizando con peek

        /*EJEMPLOS
        Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());
         */

        //collect servira como operador terminal de un Iterator a una lista
        List<String> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);

    }
}
