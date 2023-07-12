package org.rdurandk.java.jdbc;

import org.rdurandk.java.jdbc.modelo.Categoria;
import org.rdurandk.java.jdbc.modelo.Producto;
import org.rdurandk.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.rdurandk.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rdurandk.java.jdbc.repositorio.Repositorio;
import org.rdurandk.java.jdbc.servicio.CatalogoServicio;
import org.rdurandk.java.jdbc.servicio.Servicio;
import org.rdurandk.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("=========== listar ===========");
        servicio.listar().forEach(System.out::println);
        System.out.println("=========== Insertar nueva categoria ===========");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");

        System.out.println("=========== insertar nuevo producto ===========");
        Producto producto = new Producto();
        producto.setNombre("Lampara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefgh12");
        servicio.guardarProductoConCategoria(producto, categoria);//maneja transacciones
        System.out.println("Producto guardado con exito:" + producto.getId());
        servicio.listar().forEach(System.out::println);
    }
}

