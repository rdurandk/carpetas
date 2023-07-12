package org.rdurandk.java.jdbc;

import org.rdurandk.java.jdbc.modelo.Categoria;
import org.rdurandk.java.jdbc.modelo.Producto;
import org.rdurandk.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rdurandk.java.jdbc.repositorio.Repositorio;
import org.rdurandk.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTrx {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getInstance()) {//se cerrara automaticamente
            System.out.println(conn.getAutoCommit());
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
                System.out.println("=========== listar ===========");
                repositorio.listar().forEach(System.out::println);
                System.out.println("=========== obtener por id ===========");
                System.out.println(repositorio.porId(2L));
                System.out.println("=========== insertar nuevo producto ===========");
                Producto producto = new Producto();
                producto.setNombre("Teclado Prueba Mecanico");
                producto.setPrecio(1550);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                producto.setSku("abcde12319");
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito");

                System.out.println("=========== editar producto ===========");
                producto = new Producto();
                producto.setId(11L);
                producto.setNombre("Teclado Corsair Mecanico");
                producto.setPrecio(1000);
                producto.setSku("abcde123456");
                categoria = new Categoria();
                categoria.setId(2L);
                producto.setCategoria(categoria);
                repositorio.guardar(producto);
                System.out.println("Producto actualizado con exito");

                repositorio.listar().forEach(System.out::println);
                conn.commit();
                //al estar cerrada la conexion no podemos hacer un rollback por eso otro try
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}
