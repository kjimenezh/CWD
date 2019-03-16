
package Controladores;

import Main.Singleton;
import Modelo.Crowdfounding;
import Vistas.Vista1;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author kjime
 */
public class Controlador1 {
    private Crowdfounding crowd;
    private Vista1 view;
    
    public Controlador1(Crowdfounding crowd) {
        this.crowd = crowd;
        this.view = new Vista1();
       
        view.getIniciar().setOnAction(new iniciarEvento()); 
        //view.getSubastas().setOnAction(new subastasEvento());
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();       
        view.mostrar(singleton.getStage());
    }
    
    class iniciarEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            Controlador2 controlador2 = new Controlador2(crowd);
            controlador2.mostrarVista();
        }
    }
    
    /*class subastasEvento implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            PuntajeController controladorpuntaje = new PuntajeController(modelo);
            controladorpuntaje.mostrarVista();
        }
    }*/
}

