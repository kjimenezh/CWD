
package Controladores;

import Main.Singleton;
import Modelo.Crowdfounding;
import Vistas.Vistalista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author kjime
 */
public class Controladorlista {
    private Crowdfounding crowd;
    private Vistalista view;
    
    public Controladorlista(Crowdfounding crowd) {
        this.crowd = crowd;
        this.view = new Vistalista();
       
        view.getRegresar().setOnAction(new regresarEventHandler());     
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        
        view.getList().getItems().add("# Subasta : Promotor, Aportante ganador");
        
        for(int i = 0; i<crowd.getSubastas().size();i++){
            view.getList().getItems().add((i+1)+ ": " + crowd.getSubastas().get(i).getDemanda().getNombre()
                    +", "+crowd.getSubastas().get(i).getOfertas().get(crowd.getSubastas().get(i).getOfertas().size()-1).getNombre());
        }
     
        view.mostrar(singleton.getStage());
    }
    
    class regresarEventHandler implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            
            Controlador1 controlador1 = new Controlador1(crowd);
            controlador1.mostrarVista();   
        }   
    }
   
}
