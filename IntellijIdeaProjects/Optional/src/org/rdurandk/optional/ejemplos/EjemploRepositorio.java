package org.rdurandk.optional.ejemplos;

import org.rdurandk.optional.ejemplos.models.Computador;
import org.rdurandk.optional.ejemplos.repositorio.ComputadorRepositorio;
import org.rdurandk.optional.ejemplos.repositorio.Repositorio;

import javax.swing.text.html.Option;
import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        /*Optional<Computador> pc = repositorio.filtrar("asus rog");

        if(pc.isPresent()){
            System.out.println(pc.get().getNombre());
        }else{
            System.out.println("No se encontro");
        }*/
        repositorio.filtrar("asus").ifPresentOrElse(System.out::println,
                ()-> System.out.println("no se encontro"));

    }
}
