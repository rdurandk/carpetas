package org.rdurandk.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static  void main(String[] args) {

        //Stream una secuencia de elementos que soportan operaciones agregadas secuenciales y paralelas
        //metodo of tendra los valores de string y convertira en un arreglo para poder ser iterado
        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepe");
        nombres.forEach(System.out::println);
        System.out.println();

        String[] arr = {"Pato", "Paco", "Pepa", "Pepe"};
        Stream<String> nombres2 = Arrays.stream(arr);
        nombres2.forEach(System.out::println);
        System.out.println();

        Stream<String> nombres3 = Stream.<String>builder()
                .add("Pato")
                .add("Paco")
                .add("Pepa")
                .add("Pepe")
                .build();//build para construir los string builder
        nombres3.forEach(System.out::println);
        System.out.println();

        List<String> lista = new ArrayList<>();
        lista.add("Alex");
        lista.add("Mafer");
        lista.add("Alvaro");
        lista.add("Jazmin");
        Stream<String> nombres4 = lista.stream();
        nombres4.forEach(System.out::println);

        //lista.stream().forEach(System.out::println);

    }
}
