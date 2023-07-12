package org.rdurandk.java.jdbc.repositorio;
import org.rdurandk.java.jdbc.modelo.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio<Categoria> {

    private Connection conn;

    public CategoriaRepositorioImpl() {
    }

    public CategoriaRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categorias")){
            while(rs.next()){
                Categoria c = crearCategoria(rs);
                categorias.add(c);
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try(PreparedStatement ps = conn.prepareStatement("SELECT * FROM categorias WHERE id=?")){
            ps.setLong(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    categoria = crearCategoria(rs);
                }
            }
        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sql;
        if(categoria.getId() != null && categoria.getId()>0){
            sql = "UPDATE categorias SET nombre=? WHERE id=?";
        }else{
            sql = "INSERT INTO categorias(nombre) VALUES(?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            //segundo parametro para devolver la llave primaria que se genera automaticamente
            stmt.setString(1, categoria.getNombre());
            if(sql.contains("UPDATE")){//update
                stmt.setLong(2, categoria.getId());
            }
            stmt.executeUpdate();

            //con el objetivo de traer el id generado el insertar
            if(categoria.getId()==null){//insert
                try(ResultSet rs = stmt.getGeneratedKeys()){//obtenemos el key
                    if(rs.next()){
                        categoria.setId(rs.getLong(1));
                        //en este caso 1 porque solo tiene una columna que es el id
                    }
                }
            }
        }
        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement ps = conn.prepareStatement("DELETE FROM categorias WHERE id=?")){
            ps.setLong(1,id);
            ps.executeUpdate();
        }
    }
    private static Categoria crearCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        return c;
    }
}
