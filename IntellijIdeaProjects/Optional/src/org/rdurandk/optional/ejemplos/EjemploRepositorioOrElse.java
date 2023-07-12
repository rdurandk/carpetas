package org.rdurandk.optional.ejemplos;

import org.rdurandk.optional.ejemplos.models.Computador;
import org.rdurandk.optional.ejemplos.repositorio.ComputadorRepositorio;
import org.rdurandk.optional.ejemplos.repositorio.Repositorio;

public class EjemploRepositorioOrElse {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //Computador defecto = new Computador("HP Omen", "La0001");
        Computador pc = repositorio.filtrar("rog")
                .orElse(valorDefecto());
        System.out.println(pc);

        pc = repositorio.filtrar("macbook pro")
                .orElseGet(()-> valorDefecto());//EjemploRepositorioOrElse::valorDefecto
        System.out.println(pc);
    }
    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto!!!");
        return new Computador("HP Omen", "LA0001");
    }
}
