
package Modelo;

/**
 *
 * @author kjime
 */
public class Aportante extends Persona{
    private double valoroferta;
    private double tasadeinteres;
    private String tiempo;
    private Transaccion transaccion;

    public Aportante(int cedula, String nombre, int telefono, String email) {
        super(cedula, nombre, telefono, email);
    }
    
    public Aportante(String nombre,double valorencuenta){
        super(nombre);
        this.cuenta.setValorencuenta(valorencuenta);
    }

    public Aportante(int cedula, String nombre, int telefono, String email, double valorEnCuenta) {
        super(cedula, nombre, telefono, email, valorEnCuenta);
    }
    
    public double getValoroferta() {
        return valoroferta;
    }

    public void setValoroferta(double valoroferta) {
        this.valoroferta = valoroferta;
    }

    public double getTasadeinteres() {
        return tasadeinteres;
    }

    public void setTasadeinteres(double tasadeinteres) {
        this.tasadeinteres = tasadeinteres;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    
}
