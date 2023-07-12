package org.rdurandk.api.stream.ejemplos;

import org.rdurandk.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static  void main(String[] args) {

        Usuario usuario = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia")
                .map(nombre-> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(u -> System.out.println(u.getNombre()))
                .filter(u -> u.getId().equals(7))
                .findFirst().orElseGet(()-> new Usuario("Alex", "Durand"));
                 //argunento de un supplier; retornara este en caso de que no encuentre o que no sea present
        System.out.println(usuario.getNombre() + ", " + usuario.getApellido());

    }
}
