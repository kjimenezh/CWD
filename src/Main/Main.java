package Main;

import Controladores.Controlador1;
import Database.GestionArchivo;
import Modelo.Crowdfounding;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class Main extends Application{
/**
 *
* @author kjime
 */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Singleton singleton = Singleton.getSingleton();
        singleton.setStage(primaryStage);
        
        //GestionArchivo archivo = new GestionArchivo("datos.txt");

        Crowdfounding crowd= new Crowdfounding();
        //crowd.setUsers(archivo.loadUsers());
        //invocar el controlador de la vista que quiero visualizar
        Controlador1 controlador1 = new Controlador1(crowd);
        controlador1.mostrarVista();
        System.out.println("ver");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
