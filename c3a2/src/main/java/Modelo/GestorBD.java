package Modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorBD {
    Connection con;
    Statement st;
    ResultSet rs;
    
    Producto prod;
    private int cve;
    private String nom;
    private double prec;
    private int cant;
    
    public boolean registrar(int clave, String nombre, double precio, int cantidad) {
        con = null;
        int resultUpdate = 0;
        String SQL = "INSERT INTO productos(clave,nombre,precio,cantidad) " +
                    "VALUES(" + clave + ",'"+nombre+"',"+precio+","+cantidad+")";
        System.out.println(SQL);        
        try {            
            con = ConectarBD.abrir();
            st = con.createStatement();
            resultUpdate = st.executeUpdate(SQL);
            if (resultUpdate != 0) {
                ConectarBD.cerrar();
                return true;
            }
            else {
                ConectarBD.cerrar();
                return false;
            }                                                            
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
            ex.printStackTrace();
            return false;
        }                      
    }
    
    public Producto consulta(int clave, String nombre){
        con = ConectarBD.abrir();
        String SQL = "SELECT * FROM productos " +
                    "WHERE clave=" + clave + " AND nombre='"+nombre+"'";        
        try {
            st = con.createStatement();            
            rs = st.executeQuery(SQL);
            if (!rs.next()){
                System.out.println("No se encontro el registro");
                ConectarBD.cerrar();
            }
            else {
                cve = rs.getInt("clave");
                nom = rs.getString("nombre");
                prec = rs.getDouble("precio");
                cant = rs.getInt("cantidad");
                prod = new Producto(cve, nom, prec, cant);
                ConectarBD.cerrar();
                return prod;
                        
            }
        } catch (SQLException e) {            
            e.printStackTrace();            
        }
        return null;
    }
    
    public ArrayList<Producto> leerTodos() {
        ArrayList<Producto> lista = new ArrayList<>();
        try{
            con = ConectarBD.abrir();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM productos");
            
            if (!rs.next()) {
                System.out.println("No se encontraron registros");
                ConectarBD.cerrar();
                return null;
            }
            else {
                do{
                    cve = rs.getInt("clave");
                    nom = rs.getString("nombre");
                    prec = rs.getDouble("precio");
                    cant = rs.getInt("cantidad");
                    prod = new Producto(cve, nom, prec, cant);
                    lista.add(prod);
                } while (rs.next());
                ConectarBD.cerrar();
                return lista;
            }            
        } catch (SQLException ex) { 
            ex.printStackTrace();         
        }
        return null;
    }
}

