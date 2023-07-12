package org.rdurandk.api.stream.ejemplos.tarea;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class tarea1 {
    /*Como desafió consiste en un arreglo de 100 elementos del 1 al 100, del tipo int, utilizando el api stream se pide
     eliminar los divisibles en 10, luego convertir los elementos restante del flujo en tipo double y dividirlos en 2,
     para finalmente devolver la suma total de todos ellos usando el operador terminal reduce. El resultado debería ser 2250.0
     **/
    public static void main(String[] args) {

        double resultado = IntStream.range(1,100)
                .filter(num -> (num%10)!=0)
                .peek(System.out::println)
                .mapToDouble(num -> (double)num/2)
                .reduce(0.0, (a,b)-> a+b);

        System.out.println(resultado);

    }
}
