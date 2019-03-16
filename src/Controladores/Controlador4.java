
package Controladores;

import Main.Singleton;
import Modelo.Aportante;
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
            
            String nombre = view.getNombreAT().getText();
            String valorc = view.getValorcAT().getText();
            String valoro = view.getValoroAT().getText();
            String tasao = view.getTasaoAT().getText();
            String tiempo = view.getTiempooAT().getText();
         
            view.getNombreAT().setText("");
            view.getValorcAT().setText("");
            view.getValoroAT().setText("");
            view.getTasaoAT().setText("");
            view.getTiempooAT().setText("");
            
            if(nombre.isEmpty()||valorc.isEmpty()||valoro.isEmpty()||tasao.isEmpty()||tiempo.isEmpty()){
                view.getMensajeFinal().setText("Ingrese la información completa!");
            return;
            }

            double valorcu = Double.parseDouble(valorc);
            double valorof = Double.parseDouble(valoro);
            double tasaof = Double.parseDouble(tasao);
            
            Aportante oferta = new Aportante(nombre,valorcu);
            oferta.setValoroferta(valorof);
            oferta.setTasadeinteres(tasaof);
            oferta.setTiempo(tiempo);
  
            Boolean erg = false;
            erg = crowd.getSubasta(Controlador2.getNombreP()).addOferta(oferta);
          
            if(erg){
                view.getMensajeFinal().setText("Oferta registrada existosamente");
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
