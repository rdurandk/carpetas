package prueba.jdbc;

import prueba.jdbc.modelo.Automovil;
import prueba.jdbc.repositorio.AutomovilRepositorio;
import prueba.jdbc.repositorio.Repositorio;

public class EjemploLista {
    public static void main(String[] args) {
        Repositorio<Automovil> repo = new AutomovilRepositorio();
        repo.listar().forEach(System.out::println);
        System.out.println("=============por Id=============");
        System.out.println(repo.porId(4));
    }
}
