package org.rdurandk.api.stream.ejemplos;

import org.rdurandk.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFlatmap {
    public static  void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia")
                .map(nombre-> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                //.filter(u -> u.getNombre().equals("Pepe"))
                .flatMap(u -> {
                    if(u.getNombre().equalsIgnoreCase("pepe")){
                        return Stream.of(u);
                    }
                    return Stream.empty();
                })//flatmap retornara un stream del objeto creado en este caso usuario
                .peek(System.out::println);

        nombres.forEach((u)-> System.out.println("lista: " + u.getNombre() + " " + u.getApellido()));


    }
}
