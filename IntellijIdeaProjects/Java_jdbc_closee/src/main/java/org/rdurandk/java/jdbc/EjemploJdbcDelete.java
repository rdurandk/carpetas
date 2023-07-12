package org.rdurandk.java.jdbc;

import org.rdurandk.java.jdbc.modelo.Producto;
import org.rdurandk.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rdurandk.java.jdbc.repositorio.Repositorio;
import org.rdurandk.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

             //Statement stm = conn.createStatement();
             //ResultSet resultado = stm.executeQuery("SELECT * FROM productos")){//para consultas
             //parentesis en try añadiremos los recursos y cerraran(close) de forma automatica(autoclose)
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(System.out::println);
            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(1L));
            System.out.println("=========== Eliminar producto ===========");
            repositorio.eliminar(6L);
            repositorio.eliminar(7L);
            repositorio.eliminar(8L);
            repositorio.eliminar(9L);
            repositorio.eliminar(10L);
            System.out.println("Producto eliminado con exito");
            repositorio.listar().forEach(System.out::println);

    }
}
