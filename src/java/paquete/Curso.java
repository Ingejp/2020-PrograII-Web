package paquete;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Curso {
    private ConexionBaseDeDatos conn;
    private Connection cn;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;

    
    public Curso(int id, String nombre){//constructor
       
    }
    
    public Curso(){
    
    }
    public void consultarCursos(StringBuffer respuesta){  
         conn= new ConexionBaseDeDatos();
        cn=conn.conectar();
       
        String sql="select * from universidad.curso";
       
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    
                 System.out.println("prueba");
            if (result!=null){
                while (result.next()){
               int id = result.getInt("codigo_curso");
               String name = result.getString("nombre");   
                respuesta.append("<option id=\"").append(result.getString("codigo_curso")).append(" \">").append(result.getString("nombre")).append("</option>");                
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
