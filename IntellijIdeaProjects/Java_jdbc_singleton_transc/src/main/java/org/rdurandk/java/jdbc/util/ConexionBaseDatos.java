package org.rdurandk.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso";
    private static String user = "root";
    private static String password = "";
    private static Connection connection;

    //conection si lo cerramos sera un recurso cerrado y al volver a llamarlo
    //no tendra la conexion activa por eso no se cerrara en esta clase
    public static Connection getInstance() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url,user,password);
        }
        return connection;
    }
}
