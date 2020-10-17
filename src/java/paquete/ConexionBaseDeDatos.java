package paquete;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    //private String url="jdbc:oracle:thin:@localhost:1521:XE";//Oracle 
    private String url="jdbc:mysql://localhost:3306";//url de MySQL
    private String usuario="root";
    private String clave=""; 
    private Connection conexion=null;    
    
    public Connection conectar(){   
        try{
            //Class.forName("oracle.jdbc.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection( url, usuario,clave);
        }  catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {   
           ex.printStackTrace();
        }         
        return conexion;        
    }
    
}
