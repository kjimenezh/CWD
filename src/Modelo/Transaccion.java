
package Modelo;

/**
 *
 * @author kjime
 */
class Transaccion {
    private double precio;
    private Promotor socioA;
    private Aportante socioB;

    public Transaccion(double precio, Promotor socioA, Aportante socioB) {
        this.precio = precio;
        this.socioA = socioA;
        this.socioB = socioB;
    }

    public double getPrecio() {
        return precio;
    }

    public Promotor getSocioA() {
        return socioA;
    }

    public Aportante getSocioB() {
        return socioB;
    }
    
    
}
