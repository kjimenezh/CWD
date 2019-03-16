
package Modelo;

/**
 *
 * @author kjime
 */
public class Promotor extends Persona{
    private double inversionRequerida;
    private Iniciativa iniciativa;
    private Transaccion transaccion;
    
    public Promotor(int cedula, String nombre, int telefono, String email,double inversionRequerida) {
        super(cedula, nombre, telefono, email);
        this.inversionRequerida = inversionRequerida;
    }
    
    public Promotor(String nombre, double inversionRequerida){
        super(nombre);
        this.inversionRequerida = inversionRequerida;
    }
    
    public double getInversionRequerida() {
        return inversionRequerida;
    }
    
    public void setIniciativa(String nombre,String descripcion){
        this.iniciativa = new Iniciativa(nombre,descripcion);
    }

    public Iniciativa getIniciativa() {
        return iniciativa;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
  
    
}
