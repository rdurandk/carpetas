package org.rdurandk.java.jdbc.repositorio;

import org.rdurandk.java.jdbc.modelo.Categoria;
import org.rdurandk.java.jdbc.modelo.Producto;
import org.rdurandk.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {//llamo la conexion por un metodo
        return ConexionBaseDatos.getConexion();
        //En Java, un "pool de conexiones" se utiliza para administrar y reutilizar conexiones a una base de datos.
        //Cuando una aplicación se conecta a una base de datos, normalmente se crea una nueva conexión a través de un
        // objeto java.sql.Connection. Establecer una conexión a una base de datos puede ser un proceso costoso en
        // términos de tiempo y recursos. Además, las bases de datos a menudo tienen límites en la cantidad de
        // conexiones simultáneas que pueden manejar, Un pool de conexiones resuelve estos problemas al mantener un
        // conjunto de conexiones previamente creadas y listas para su uso.
    }
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();//obtengo la conexion por statement
            ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as nom_categoria FROM productos as p " +
                    "inner join categorias as c ON(p.categoria_id=c.id)")){
            //consulta .- que traiga todos los campos productos y el nombre de categorias y hacemos un inner join
            //si son iguales: "ON(p.categoria_id=c.id)" juntara las tablas
            while(rs.next()){
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto p = null;
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombre as nom_categoria FROM productos as p "+
                        "inner join categorias as c ON(p.categoria_id=c.id) WHERE p.id = ?")){
            //preparamos consulta que pasaremos por parametro mediante sets...
            stmt.setLong(1, id);//segundo parametro representa el valor
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {//no aplicamos while porq estamos haciendo solo 1 consulta
                    p = crearProducto(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if (producto.getId() != null && producto.getId()>0) {
            sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES(?,?,?,?)";
        }
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setLong(3, producto.getCategoria().getId());
            //el otro parametro va a variar si es un update o insert
            if(sql.contains("UPDATE")){//si es update
                ps.setLong(4, producto.getId());
            }else{//sera un insert
                ps.setDate(4, new Date(producto.getFechaRegistro().getTime()));
                //estamos haciendo la conversion de javautil a javasql en el date
            }
            ps.executeUpdate();//porque manipulamos los datos(DML)
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Long id) {
        try(Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM productos WHERE id=?")){
            ps.setLong(1, id);
            ps.executeUpdate();//porque manipulamos los datos(DML)
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private  Producto crearProducto(ResultSet rs) throws SQLException {
        //metodo para mapear los campos de nuestra tabla producto
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("nom_categoria"));
        //nombre de categoria hace referencia al alias cuando hacemos la consulta en un PreparedStatement
        p.setCategoria(categoria);
        return p;
    }
}
