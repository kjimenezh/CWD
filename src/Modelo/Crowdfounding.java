
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author kjime
 */
public class Crowdfounding {
    private ArrayList<Subasta> subastas;

    public Crowdfounding() {
        this.subastas = new ArrayList<>();
    }
    
    public boolean addSubasta(double precioReserva, Promotor demanda){
        return this.subastas.add(new Subasta(precioReserva,demanda));
    }

    public ArrayList<Subasta> getSubastas() {
        return subastas;
    }
    
    public Subasta getSubasta(String nombre){
        Subasta subasta = null;
        for(Subasta s : subastas){
            if(s.getDemanda().getNombre().equals(nombre)){
                subasta = s;
            }
        }
        return subasta;
    }

    public void setSubastas(ArrayList<Subasta> subastas) {
        this.subastas = subastas;
    }
    
    
}
