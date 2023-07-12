package prueba.jdbc;

import prueba.jdbc.modelo.Automovil;
import prueba.jdbc.repositorio.AutomovilRepositorio;
import prueba.jdbc.repositorio.Repositorio;

import java.util.Date;

public class EjemploJDBCUpdate {
    public static void main(String[] args) {
            Repositorio<Automovil> repo = new AutomovilRepositorio();
            System.out.println("=======list========");
            repo.listar().forEach(System.out::println);
            System.out.println("=======update========");
            Automovil auto = new Automovil();
            auto.setId(4);
            auto.setNombre("cherrolet");
            auto.setPrecio(100000D);
            auto.setFecha(new Date());
            repo.guardar(auto);
            System.out.println("Actualizado con exito");
            repo.listar().forEach(System.out::println);
            System.out.println("=======por id========");
            System.out.println(repo.porId(4));
    }
}
