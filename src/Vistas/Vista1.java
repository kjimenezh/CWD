
package Vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author kjime
 */
public class Vista1 {
    private Scene scene;

    private GridPane grid;
    private StackPane pane; 

    private Button iniciar;
    private Button subastas;
    private Button salir;
    private Image image;

    public Vista1(){
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        pane = new StackPane();

        image = new Image("Images/Subasta.jpg");
        ImageView imageV = new ImageView();
        imageV.setImage(image);
        imageV.setFitHeight(450);
        imageV.setFitWidth(600);
        pane.getChildren().add(imageV);


        iniciar = new Button("Iniciar Subasta");
        subastas = new Button("Subastas Realizadas");
        salir = new Button("Salir");
        grid.add(iniciar, 0, 0);
        grid.add(subastas, 0, 2);
        grid.add(salir, 0, 4);
        
        
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(grid);
        scene = new Scene(pane, 600, 450);
    }

    public void mostrar(Stage stage) {
        stage.setTitle("CrowdFounding");
        stage.setScene(scene);
        stage.show();
    }

    public Button getIniciar() {
        return iniciar;
    }

    public Button getSubastas() {
        return subastas;
    }

    public Button getSalir() {
        return salir;
    }
    
}
