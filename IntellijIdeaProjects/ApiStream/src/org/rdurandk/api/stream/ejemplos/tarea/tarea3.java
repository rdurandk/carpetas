package org.rdurandk.api.stream.ejemplos.tarea;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class tarea3 {
    public static void main(String[] args) {

/*
El siguiente ejercicio es aplanar un arreglo bidimensional en un nivel y eliminar repetidos usando el api stream.

Aplanar un arreglo significa quitar los elementos del arreglo anidado y dejarlos en el arreglo de primer nivel.

Por ejemplo, para el arreglo:

String[][] lenguajes = {{"java", "groovy"}, {"php"}, {"c#", "python", "groovy"}, {"java", "javascript", "kotlin"}, {"javascript"}, {}};

debería quedar:

{"java", "groovy", "php", "c#", "python", "javascript", "kotlin"}; */

        String[][] lenguajes = {{"java", "groovy"}, {"php"}, {"c#", "python", "groovy"}, {"java", "javascript", "kotlin"}, {"javascript"}, {}};
        /*Arrays.stream(lenguajes)
                .flatMap(el-> Arrays.stream(el))
                .distinct()
                .forEach(System.out::println);*/

        Function<String[][], List<String>> lambda = (arreglo) -> Arrays.stream(arreglo)
                .flatMap(el -> Arrays.stream(el))
                .distinct()
                .collect(Collectors.toList());
        lambda.apply(lenguajes).forEach(System.out::println);
    }
}
