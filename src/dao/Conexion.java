package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/vacunacion_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1001360493Santi"; 

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println(" Error de conexión: " + e.getMessage());
        }
        return conn;
    }
}
