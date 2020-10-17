package paquete;


public class TarjetaDeCredito extends TarjetaBancaria {
    private double tasaDeInteres;
    private double limiteDeCredito;
    private double saldo;
    
    public TarjetaDeCredito(){//constructor
        this.setLimiteDeCredito();
    }


    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public void setLimiteDeCredito() {
        this.limiteDeCredito = 10000;
        this.setSaldo(10000);
    }
    

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    private void recalcularSaldo(double montoGastado, double montoAbonado){
        
    }

    @Override
    public void comprar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}