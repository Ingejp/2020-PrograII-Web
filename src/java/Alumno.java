
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Alumno {
    private ConexionBaseDeDatos conn;
    private Connection cn;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;
    
    public Alumno(){//constructor
        conn= new ConexionBaseDeDatos();
        cn=conn.conectar();
    }
    
    public void insert(String numero_carne, String nombre, String apellido, String correo, String genero, StringBuffer salida){
        String sql = "INSERT INTO universidad.alumno(numero_carne, nombre, apellido, correo, genero_idgenero) ";
             sql += " VALUES( ?,?,?,?,?)"; 
        try{
            prstmt = cn.prepareStatement(sql); 
            prstmt.setString(1, numero_carne);
            prstmt.setString(2, nombre);
            prstmt.setString(3, apellido);
            prstmt.setString(4, correo);
            prstmt.setString(5, genero);
             int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                    salida.append("1");
                }else{
                    salida.append("0");
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.indexOf("ORA-00001") != -1){
                salida.append("ORA-00001");
            }else{
                salida.append(error);
            }
        }    
    }
    
    public void consultarRegistros(StringBuffer respuesta){  
        //base de datos: universidad
        //tabla: alumno   
        
        //String sql="select * from alumno"; ORACLE
        String sql="select * from universidad.alumno";
        
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();    

            if (result!=null){
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("numero_carne")).append("</td>");
                respuesta.append("<td >").append(result.getString("nombre")).append("</td>");
                respuesta.append("<td>").append(result.getString("apellido")).append("</td>");
                respuesta.append("<td>").append(result.getString("correo")).append("</td>");
                respuesta.append("<td id=\"").append(result.getString("numero_carne")).append("ondblclick=\"edit(this.id);\">").append("<a class=btn btn-outline-danger role=button> Eliminar</a> </td>");
                respuesta.append("<td><button type=\"button\" id=\"btnEditar\" class=\"btn btn-warning\" > Editar </button> ");
                respuesta.append("</tr>");
                }
            }else{
                respuesta.append("No hay registros para mostrar");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
