package org.rdurandk.optional.ejemplos;

import org.rdurandk.optional.ejemplos.models.Computador;
import org.rdurandk.optional.ejemplos.models.Fabricante;
import org.rdurandk.optional.ejemplos.repositorio.ComputadorRepositorio;
import org.rdurandk.optional.ejemplos.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //Computador defecto = new Computador("HP Omen", "La0001");
        /*Fabricante f = repositorio.filtrar("rog")
                .map(c -> c.getProcesador())
                .map(p -> p.getFabricante())
                .orElseThrow();*/

        String nombre = repositorio.filtrar("asus")
                .flatMap(c -> c.getProcesador())
                .flatMap(p -> p.getFabricante())
                .filter(fab -> fab.getNombre().equalsIgnoreCase("amd"))
                .map(f -> f.getNombre())
                .orElse("Desconocido");
        System.out.println(nombre);

    }
}
