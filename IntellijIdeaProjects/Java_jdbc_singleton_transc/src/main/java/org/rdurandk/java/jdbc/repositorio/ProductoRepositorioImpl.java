package org.rdurandk.java.jdbc.repositorio;

import org.rdurandk.java.jdbc.modelo.Categoria;
import org.rdurandk.java.jdbc.modelo.Producto;
import org.rdurandk.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {//llamo la conexion por un metodo
        return ConexionBaseDatos.getInstance();
    }
    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try(Statement stmt = getConnection().createStatement();//obtengo la conexion por statement
            ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as nom_categoria FROM productos as p " +
                    "inner join categorias as c ON(p.categoria_id=c.id)")){
            //consulta .- que traiga todos los campos productos y el nombre de categorias y hacemos un inner join
            //si son iguales: "ON(p.categoria_id=c.id)" juntara las tablas
            while(rs.next()){
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto p = null;
        try(PreparedStatement stmt = getConnection().
                prepareStatement("SELECT p.*, c.nombre as nom_categoria FROM productos as p "+
                        "inner join categorias as c ON(p.categoria_id=c.id) WHERE p.id = ?")){
            //preparamos consulta que pasaremos por parametro mediante sets...
            stmt.setLong(1, id);//segundo parametro representa el valor
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {//no aplicamos while porq estamos haciendo solo 1 consulta
                    p = crearProducto(rs);
                }
            }
        }
        return p;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId()>0) {
            sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=?, sku=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, sku, fecha_registro) VALUES(?,?,?,?,?)";
        }
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setLong(3, producto.getCategoria().getId());
            ps.setString(4, producto.getSku());
            //el otro parametro va a variar si es un update o insert
            if(sql.contains("UPDATE")){//si es update
                ps.setLong(5, producto.getId());
            }else{//sera un insert
                ps.setDate(5, new Date(producto.getFechaRegistro().getTime()));
                //estamos haciendo la conversion de javautil a javasql en el date
            }
            ps.executeUpdate();//porque manipulamos los datos(DML)
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement ps = getConnection().prepareStatement("DELETE FROM productos WHERE id=?")){
            ps.setLong(1, id);
            ps.executeUpdate();//porque manipulamos los datos(DML)
        }
    }

    private  Producto crearProducto(ResultSet rs) throws SQLException {
        //metodo para mapear los campos de nuestra tabla producto
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        p.setSku(rs.getString("sku"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("nom_categoria"));
        //nombre de categoria hace referencia al alias cuando hacemos la consulta en un PreparedStatement
        p.setCategoria(categoria);
        return p;
    }
}
