package org.rdurandk.java.jdbc;

import org.rdurandk.java.jdbc.modelo.Categoria;
import org.rdurandk.java.jdbc.modelo.Producto;
import org.rdurandk.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rdurandk.java.jdbc.repositorio.Repositorio;
import org.rdurandk.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()){
             //Statement stm = conn.createStatement();
             //ResultSet resultado = stm.executeQuery("SELECT * FROM productos")){//para consultas
             //parentesis en try añadiremos los recursos y cerraran(close) de forma automatica(autoclose)
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(System.out::println);
            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(1L));
            System.out.println("=========== editar producto ===========");
            Producto producto = new Producto();
            producto.setId(11L);
            producto.setNombre("Teclado Corsair Mecanico");
            producto.setPrecio(550);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto actualizado con exito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
