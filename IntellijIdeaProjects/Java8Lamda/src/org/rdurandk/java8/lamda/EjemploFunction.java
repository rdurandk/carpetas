package org.rdurandk.java8.lamda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        //Function requiere  2 parametros
        //el ultimo parametro devolvera el tipo de valor
        Function<String, String> f1 = param -> "Hola que tal! " + param;
        String resultado = f1.apply("Alexander");
        System.out.println(resultado);

        Function<String, String> f2 = param -> param.toUpperCase();
        //Function<String, String> f2 =  String::toUpperCase;
        System.out.println(f2.apply("Alex"));

        //BiFunction como minimo 3 parametros
        BiFunction<String, String, String> f3 = (a,b) -> a.toUpperCase().concat(b.toUpperCase());
        System.out.println(f3.apply("Alexander", "Durand"));

        //BiFunction<String,String,Integer> f4 = (a,b) -> a.compareTo(b);
        BiFunction<String,String,Integer> f4 = String::compareTo;//metodo referencia
        System.out.println(f4.apply("alex2", "alex"));

        BiFunction<String,String,String> f5 = String::concat;//metodo referencia
        System.out.println(f5.apply("alex ", "durand"));
    }
}
