
package Controladores;

import Main.Singleton;
import Modelo.Crowdfounding;
import Modelo.Promotor;
import Modelo.Subasta;
import Vistas.Vista4;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author kjime
 */
public class Controlador4 {
    private Crowdfounding crowd;
    private Vista4 view;
    
    public Controlador4(Crowdfounding crowd) {
        this.crowd = crowd;
        this.view = new Vista4();
       
        view.getRegistrar().setOnAction(new registrarEvento()); 
        view.getRegresar().setOnAction(new regresarEvento());
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();       
        view.mostrar(singleton.getStage());
    }
    
    class registrarEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            view.getMensajeFinal().setText("");
            
            String precioR = view.getPrecioBaseS().getText();
            String nombre = view.getNombrePT().getText();
            String inversionR = view.getInversionPT().getText();
         
            view.getNombrePT().setText("");
            view.getInversionPT().setText("");
            
            if(precioR.isEmpty()){
                view.getMensajeFinal().setText("Ingrese el precio de reserva!");
            return;
            }
            if(nombre.isEmpty()){
                view.getMensajeFinal().setText("Ingrese el nombre!");
            return;
            }
            if(inversionR.isEmpty()){
                view.getMensajeFinal().setText("Ingrese la inversion!");
            return;
            }
            
            double precio = Double.parseDouble(precioR);
            double inversion = Double.parseDouble(inversionR);
            
            Promotor demanda = new Promotor(nombre,inversion);
  
            Boolean erg = false;
            erg = crowd.getSubastas().add(new Subasta(precio,demanda));
          
            if(erg){
                Controlador3 controlador3 = new Controlador3(crowd,nombre);
                controlador3.mostrarVista();
            }else{
                view.getMensajeFinal().setText("No se registro correctamente la información");
            }
        }
    }
    
    class regresarEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            
            Controlador3 controlador3 = new Controlador3(crowd, Controlador2.getNombreP());
            controlador3.mostrarVista();   
        }   
    }
}
