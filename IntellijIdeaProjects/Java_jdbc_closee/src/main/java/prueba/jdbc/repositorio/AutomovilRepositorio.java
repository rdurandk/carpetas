package prueba.jdbc.repositorio;

import prueba.jdbc.modelo.Automovil;
import prueba.jdbc.modelo.Sucursal;
import prueba.jdbc.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutomovilRepositorio implements Repositorio<Automovil>{

    public Connection conexion() throws SQLException {
       return ConnexionBD.getInstancia();
    }
    @Override
    public List<Automovil> listar() {
        List<Automovil> automoviles = new ArrayList<>();
        try(Statement st = conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT a.*, s.nombre as nom_sucursal FROM automovil as a" +
                    " inner join sucursal as s on(a.sucursal_id=s.id)")){
            while(rs.next()){
                Automovil auto = crearAuto(rs);
                automoviles.add(auto);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return automoviles;
    }

    @Override
    public Automovil porId(int id) {
        Automovil auto = null;
        try(PreparedStatement ps = conexion().prepareStatement("SELECT a.*, s.nombre as nom_sucursal FROM automovil as a " +
                "inner join sucursal as s on(a.sucursal_id=s.id) WHERE a.id=?")) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                auto = crearAuto(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auto;
    }

    @Override
    public void guardar(Automovil auto){
        String sql;
        if(auto.getId()!=null && auto.getId()>0){//es un update
            sql="UPDATE automovil SET nombre=?, precio=? WHERE id=?";
        }else{//es un insert
            sql="INSERT INTO automovil (nombre, precio, fecha) VALUES(?,?,?)";
        }
        try(PreparedStatement ps = conexion().prepareStatement(sql)){
            ps.setString(1, auto.getNombre());
            ps.setDouble(2, auto.getPrecio());
            if(sql.contains("UPDATE")){
                ps.setInt(3,auto.getId());
            }else{
                ps.setDate(3, new Date(auto.getFecha().getTime()));
            }
            ps.executeUpdate();//porque manipulamos los datos(DML)
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try(PreparedStatement ps = conexion().prepareStatement("DELETE FROM automovil WHERE id=?")){
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Automovil crearAuto(ResultSet rs) throws SQLException {
        Automovil auto = new Automovil();
        auto.setId(rs.getInt("id"));
        auto.setNombre(rs.getString("nombre"));
        auto.setPrecio(rs.getDouble("precio"));
        auto.setFecha(rs.getDate("fecha"));
        Sucursal sucursal = new Sucursal();
        sucursal.setId(rs.getInt("sucursal_id"));
        sucursal.setNombre(rs.getString("nom_sucursal"));
        auto.setSucursal(sucursal);
        return auto;
    }

}
