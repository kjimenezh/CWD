
package Modelo;

/**
 *
 * @author kjime
 */
public abstract class Persona {
    protected int cedula;
    protected String nombre;
    protected int telefono;
    protected String email;
    protected Cuentabancaria cuenta;

    public Persona(int cedula, String nombre, int telefono, String email, double valorencuenta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.cuenta = new Cuentabancaria(valorencuenta);
    }
    
    public Persona(String nombre, double valorencuenta){
        this.nombre = nombre;
        this.cuenta = new Cuentabancaria(valorencuenta);
    }
    
    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Cuentabancaria getCuenta() {
        return cuenta;
    }
    
    
}
