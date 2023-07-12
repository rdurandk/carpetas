package prueba.jdbc;

import prueba.jdbc.modelo.Automovil;
import prueba.jdbc.repositorio.AutomovilRepositorio;
import prueba.jdbc.repositorio.Repositorio;
import prueba.jdbc.util.ConnexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) {
            Repositorio<Automovil> repo = new AutomovilRepositorio();
            System.out.println("=======list========");
            repo.listar().forEach(System.out::println);
            System.out.println("=======por id========");
            System.out.println(repo.porId(1));
            System.out.println("=======insert into========");
            Automovil auto = new Automovil();
            auto.setNombre("susuki");
            auto.setPrecio(600000D);
            auto.setFecha(new Date());
            repo.guardar(auto);
            System.out.println("Creado con exito");
            repo.listar().forEach(System.out::println);

    }
}
