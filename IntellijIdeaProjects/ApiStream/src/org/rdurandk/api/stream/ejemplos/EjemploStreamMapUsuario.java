package org.rdurandk.api.stream.ejemplos;

import org.rdurandk.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMapUsuario {
    public static  void main(String[] args) {

        //Stream una secuencia de elementos que soportan operaciones agregadas secuenciales y paralelas
        //metodo of tendra los valores de string y convertira en un arreglo para poder ser iterado
        //mapa siempre retornada un dato modificado
        //peek es como foreach una funcion consumer
        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena")
                .map(nombre-> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(u -> System.out.println(u.getNombre() + ", "  + u.getApellido()))
                .map(usuario -> {
                    String nombre =  usuario.getNombre().toLowerCase();
                    String apellido =  usuario.getApellido().toLowerCase();
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    return usuario;
                });

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(usuario -> System.out.println(usuario.getNombre() + ", " + usuario.getApellido()));
        //nombres.forEach(System.out::println);

        /*List<String> lista2= Arrays.asList("hola","que" ,"tal", "estas","tu");
        lista2.stream()
                .filter((cadena)->cadena.length()>3)
                .map((cadena)->cadena.toUpperCase())
                .forEach(System.out::println);*/
    }
}
