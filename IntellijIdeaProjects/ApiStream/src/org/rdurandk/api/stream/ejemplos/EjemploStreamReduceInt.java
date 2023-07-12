package org.rdurandk.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduceInt {
    public static  void main(String[] args) {

       Stream<Integer> nombres =  Stream.of(5,10,15,20);

       //Integer resultado = nombres.reduce(0, (a,b) -> a+b);
        Integer resultado = nombres.reduce(0, Integer::sum);//referencia al metodo estatico
        System.out.println(resultado);
    }
}
