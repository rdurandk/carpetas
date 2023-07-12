package org.rdurandk.api.stream.ejemplos;

import org.rdurandk.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static  void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia")
                .map(nombre-> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek((u)-> System.out.println(u.getNombre() + ", " + u.getApellido()));


        //findFirst Devuelve un Opcional que describe el primer elemento de esta secuencia(stream).
        //optional tiene distintos metodos
        Optional<Usuario> usuario = nombres.findFirst();
        //System.out.println(usuario.get());
        //System.out.println(usuario.orElse(new Usuario("Jon", "Doe")).getNombre());
        //System.out.println(usuario.orElseGet(()-> new Usuario("Alexander", "Durand")).getNombre());
        //System.out.println(usuario.orElseThrow());//es lo mismo que el get
        if(usuario.isPresent()){
            System.out.println(usuario.get().getApellido());
        }else{
            System.out.println("No se encontro el objeto");
        }
    }
}
