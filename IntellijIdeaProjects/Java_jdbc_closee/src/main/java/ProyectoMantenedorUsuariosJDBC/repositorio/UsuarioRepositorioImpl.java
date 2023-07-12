package ProyectoMantenedorUsuariosJDBC.repositorio;

import ProyectoMantenedorUsuariosJDBC.modelo.Usuario;
import ProyectoMantenedorUsuariosJDBC.util.ConexionBaseDeDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements Repositorio<Usuario>{

    public Connection getConexion(){
        return ConexionBaseDeDatos.getInstancia();
    }
    @Override
    public void actualizar(Usuario usuario) {
        String sql="UPDATE usuarios SET username=?,password=?,email=? WHERE id=?";
        try(PreparedStatement ps = getConexion().prepareStatement(sql)){
            ps.setString(1,usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());
            if(usuario.getId()==0){
                System.err.println("Ingrese un id al usuario, no sea mascota");
            }else{
                ps.setInt(4, usuario.getId());
                ps.executeUpdate();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Integer id) {
        String sql="DELETE FROM usuarios WHERE id=?";
        try(PreparedStatement ps = getConexion().prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(Usuario usuario) {
        String sql="INSERT INTO usuarios(username,password,email)VALUES(?,?,?)";
        try(PreparedStatement ps = getConexion().prepareStatement(sql)){
            ps.setString(1,usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> listUsuario = new ArrayList<>();
        try(Statement st = getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios")){
            while(rs.next()){
                Usuario u = getModeloUsuario(rs);
                listUsuario.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUsuario;
    }

    private Usuario getModeloUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));

        return u;
    }
}
