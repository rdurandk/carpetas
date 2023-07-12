package org.rdurandk.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static  void main(String[] args) {


       Stream<String> nombres =  Stream.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia", "Paco Gonzales", "Paco Gonzales")
                .distinct();//los repeidos no se incluyen

        String resultado = nombres.reduce("resultado = ", (a,b) -> a+ ", " + b);
        System.out.println(resultado);
    }
}
