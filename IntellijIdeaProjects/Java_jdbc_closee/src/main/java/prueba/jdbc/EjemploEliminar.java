package prueba.jdbc;

import prueba.jdbc.modelo.Automovil;
import prueba.jdbc.repositorio.AutomovilRepositorio;
import prueba.jdbc.repositorio.Repositorio;

public class EjemploEliminar {
    public static void main(String[] args) {
        Repositorio<Automovil> repo = new AutomovilRepositorio();
        System.out.println("=======list========");
        repo.listar().forEach(System.out::println);
        System.out.println("=======eliminar========");
        repo.eliminar(3);
        repo.listar().forEach(System.out::println);
    }
}
