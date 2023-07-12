package org.rdurandk.api.stream.ejemplos;

import org.rdurandk.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static  void main(String[] args) {


        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia", "Pato Guzman", "Pato Guzman")
                .map(nombre-> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();//son instancias distintas a un obj asi que evaluara por medio de equals y hash code


        nombres.forEach(System.out::println);

    }
}
