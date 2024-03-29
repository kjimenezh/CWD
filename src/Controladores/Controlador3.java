
package Controladores;

import Database.GestionArchivo;
import Main.Singleton;
import Modelo.Aportante;
import Modelo.Crowdfounding;
import Modelo.Subasta;
import Vistas.Vista3;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author kjime
 */
public class Controlador3 {
    private Crowdfounding crowd;
    private Vista3 view;
    private String nombre;
    
    public Controlador3(Crowdfounding crowd,String nombre) {
        this.crowd = crowd;
        this.nombre = nombre;
        this.view = new Vista3();
       
        view.getRegistrar().setOnAction(new registrarEventHandler());   
        view.getFinalizar().setOnAction(new finalizarEventHandler()); 
        view.getRegresar().setOnAction(new regresarEventHandler());
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        
        Subasta subasta = crowd.getSubasta(nombre);
        view.getMensaje().setText("Valor a subastar: "+subasta.getDemanda().getInversionRequerida());
        view.getList().getItems().add(" : " + "Nombre " + ", " + "Valor de la oferta");
        
        for(int i = 0; i<subasta.getOfertas().size();i++){
            view.getList().getItems().add((i+1)+ ": " + subasta.getOfertas().get(i).getNombre() + ", " + subasta.getOfertas().get(i).getValoroferta());
        }
     
        view.mostrar(singleton.getStage());
    }
    
    class registrarEventHandler implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            
            Controlador4 controlador4 = new Controlador4(crowd);
            controlador4.mostrarVista();   
        }   
    }
   
    class finalizarEventHandler implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) { 
            GestionArchivo archivo = new GestionArchivo("DatosSubastas.txt");
            if(crowd.getSubasta(nombre).getOfertas().get(crowd.getSubasta(nombre).getOfertas().size()-1).getValoroferta()<crowd.getSubasta(nombre).getPrecioReserva()){
                view.getFinish().setText("No se llego el precio minimo aceptado");
                crowd.getSubasta(nombre).getOfertas().get(crowd.getSubasta(nombre).getOfertas().size()-1).setNombre("Ninguno");
                crowd.getSubasta(nombre).getOfertas().get(crowd.getSubasta(nombre).getOfertas().size()-1).setValoroferta(0);
                try {
                    archivo.saveSubasta(crowd.getSubasta(nombre));
                } catch (IOException ex) {
                    Logger.getLogger(Controlador3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                Aportante aportante = crowd.getSubasta(nombre).getOfertas().get(crowd.getSubasta(nombre).getOfertas().size()-1);
                view.getFinish().setText("El ganador fue: "+aportante.getNombre());
            
                crowd.getSubasta(nombre).setTransaccion(50000, crowd.getSubasta(nombre).getDemanda(), aportante);
                crowd.getSubasta(nombre).getDemanda().setTransaccion(crowd.getSubasta(nombre).getTransaccion());
                aportante.setTransaccion(crowd.getSubasta(nombre).getTransaccion()); 
                try {
                    archivo.saveSubasta(crowd.getSubasta(nombre));
                } catch (IOException ex) {
                    Logger.getLogger(Controlador3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    }
    
    class regresarEventHandler implements EventHandler<ActionEvent>{
 
        @Override
        public void handle(ActionEvent e) {   
            Controlador1 controlador1 = new Controlador1(crowd);
            controlador1.mostrarVista();
        }
    }
}
