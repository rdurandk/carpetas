package prueba.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    private static String url = "jdbc:mysql://localhost:3306/db_automoviles";
    private static String user = "root";
    private static String pass="";
    private static Connection conexion;

    public static Connection getInstancia() throws SQLException {
        if(conexion == null){
            conexion = DriverManager.getConnection(url,user,pass);
        }
        return conexion;
    }

}
