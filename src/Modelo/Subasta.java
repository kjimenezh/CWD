
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author kjime
 */
public class Subasta {
    private double precioReserva;
    private Promotor demanda;
    private ArrayList<Aportante> ofertas;
    private Transaccion transaccion;

    public Subasta(double precioReserva, Promotor demanda) {
        this.precioReserva = precioReserva;
        this.demanda = demanda;
        this.ofertas = new ArrayList<>();
    }
    
    public boolean addOferta(Aportante oferta){
        return this.ofertas.add(oferta);
    }

    public double getPrecioReserva() {
        return precioReserva;
    }

    public Promotor getDemanda() {
        return demanda;
    }

    public ArrayList<Aportante> getOfertas() {
        return ofertas;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }
    
    public void setTransaccion(double precio,Promotor demanda, Aportante oferta ){
        this.transaccion = new Transaccion(precio,demanda,oferta);
    }
    
    public void iniciarSubasta(){
        System.out.println("Cantidad a subastar: "+this.getDemanda().getInversionRequerida());
        
    }
}
