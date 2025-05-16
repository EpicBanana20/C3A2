package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {
    public static Connection con;
    private static String bd = "tienda";
    public static String usuario = "root";
    public static String passw = "root";
    public static String url = "jdbc:mysql://localhost:3306/" + bd;
    
    public static Connection abrir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,usuario,passw);
        } catch (Exception e) {
            System.out.println("Error en la conexion...");
            e.printStackTrace();
        }
        return con;
    }
    
    public static void cerrar() {
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {
            System.out.println("Error: No se logro cerrar conexion: \n" + e);
        }
    }
}

