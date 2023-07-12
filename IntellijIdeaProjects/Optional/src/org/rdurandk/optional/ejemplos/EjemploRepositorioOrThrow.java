package org.rdurandk.optional.ejemplos;

import org.rdurandk.optional.ejemplos.models.Computador;
import org.rdurandk.optional.ejemplos.repositorio.ComputadorRepositorio;
import org.rdurandk.optional.ejemplos.repositorio.Repositorio;

import java.util.NoSuchElementException;
import java.util.Optional;

public class EjemploRepositorioOrThrow {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //Computador defecto = new Computador("HP Omen", "La0001");
        Computador pc = repositorio.filtrar("rog")
                .orElseThrow(() -> new NoSuchElementException());//lanzara un NoShuchElementExeception
        System.out.println(pc);

        String extension = Optional.ofNullable("documento.pdf")
                //.filter(a->a.contains("."))
                .map(ext -> ext.substring(ext.lastIndexOf(".")+1))
                .orElseThrow();
        System.out.println(extension);
    }
}
