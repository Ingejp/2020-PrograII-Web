
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import paquete.ConexionBaseDeDatos;

/**
 *
 * @author JP
 */
public class Genero {
    private int ind;
    private String descripcion;
    private ConexionBaseDeDatos conn;
    private Connection cn;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;
   

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public void consultarGenero(StringBuffer respuesta){       
         conn= new ConexionBaseDeDatos();
        cn=conn.conectar();
       
        String sql="select * from universidad.genero";
       
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    
                 System.out.println("prueba");
            if (result!=null){
                while (result.next()){  
                respuesta.append("<option value=\"").append(result.getString("idgenero")).append(" \">").append(result.getString("descripcion")).append("</option>");                
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    
}
