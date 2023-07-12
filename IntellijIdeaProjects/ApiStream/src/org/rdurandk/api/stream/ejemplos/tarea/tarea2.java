package org.rdurandk.api.stream.ejemplos.tarea;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class tarea2 {
    /*El siguiente ejercicio es obtener el numero mayor de un arreglo pero utilizando programación funcional,
     implementando la expresión lambda Function<T,R> (que viene predefinida) con el api stream y operador reduce.
    */
    public static void main(String[] args) {
        Function<Integer[], Integer> lambda = (arreglo) -> Arrays.stream(arreglo).reduce(20,(num,max)-> max= num>max ? num : max);
        Integer [] arregloNums = {30,95,20,65,40,90};
        System.out.println(lambda.apply(arregloNums));
    }
}
