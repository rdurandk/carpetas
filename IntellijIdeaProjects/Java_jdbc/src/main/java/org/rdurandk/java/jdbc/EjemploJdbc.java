package org.rdurandk.java.jdbc;

import org.rdurandk.java.jdbc.modelo.Categoria;
import org.rdurandk.java.jdbc.modelo.Producto;
import org.rdurandk.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rdurandk.java.jdbc.repositorio.Repositorio;
import org.rdurandk.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()){//se cerrara automaticamente
             //Statement stm = conn.createStatement();
             //ResultSet resultado = stm.executeQuery("SELECT * FROM productos")){//para consultas
             //parentesis en try añadiremos los recursos y cerraran(close) de forma automatica(autoclose)
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(System.out::println);
            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(2L));
            System.out.println("=========== insertar nuevo producto ===========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Red Dragon Mecanico");
            producto.setPrecio(450);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
