package ProyectoMantenedorUsuariosJDBC.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    private static String url="jdbc:mysql://localhost:3306/mantenedor_usuarios";
    private static String user="root";
    private static String pass="";
    private static Connection con;
    public static Connection getInstancia(){
        if(con == null){
            try {
                con = DriverManager.getConnection(url,user,pass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }
}
