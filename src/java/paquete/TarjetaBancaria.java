package paquete;


import java.util.Date;
/**
 *
 * @author JP
 */
public abstract class TarjetaBancaria {
    private String nombreDeTarjeta;
    private String numeroDeTarjeta;
    private String cvv;
    private Date fechaEmision;
    private Date fechaVencimiento;
    
    public TarjetaBancaria(){
        this.crearNumeroDeTarjeta();
    }
    
    protected void crearNumeroDeTarjeta(){
        int bloque3=(int)(Math.random()*9000)+1000;
        int bloque4=(int)(Math.random()*9000)+1000;
        this.numeroDeTarjeta="0909-2020-";
        this.numeroDeTarjeta=this.numeroDeTarjeta+bloque3+"-"+bloque4;
    }
    
    public abstract void comprar();
    
    public String getNombreDeTarjeta() {
        return nombreDeTarjeta;
    }
    
    public boolean ifExist(){
        //consultar a la base de datos
        return true;
    }

    public void setNombreDeTarjeta(String nombreDeTarjeta) {
       if(!this.ifExist()){
           this.nombreDeTarjeta = nombreDeTarjeta;
       }else{
           this.nombreDeTarjeta="";
       }    
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    
    
    
    
}
