package org.rdurandk.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso";
    private static String user = "root";
    private static String password = "";
    private static Connection connection;
    private static BasicDataSource pool;

    //para administrar nuestras conexiones con un pool y no tener un cuello de botella(realentizacion)
    //al solicitar otra conexion
    public static BasicDataSource getInstancia() throws SQLException{
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(password);
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);//inactivas o activas
        }
        return pool;
    }
    public static Connection getConexion() throws SQLException {
        return getInstancia().getConnection();
    }
}
