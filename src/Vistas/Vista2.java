
package Vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kjime
 */
public class Vista2 {
    private Scene scene;

    private GridPane grid;
    private StackPane pane; 
    
    private Image image;
    private Text mensajeInicial;
    private Text mensajeFinal;
    private Label precioBase;
    private TextField precioBaseS;
    private Label nombreP;
    private TextField nombrePT;
    private Label inversionP;
    private TextField inversionPT;
    private Button registrar;

    public Vista2(){
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
        
        precioBase = new Label("Precio de reserva: ");
        grid.add(precioBase, 0, 0);
        precioBaseS = new TextField();
        grid.add(precioBaseS, 1, 0);
        mensajeInicial = new Text("Ingrese los datos del promotor");
        grid.add(mensajeInicial, 0, 1);
        nombreP = new Label("Nombre: ");
        grid.add(nombreP, 0, 2);
        nombrePT = new TextField();
        grid.add(nombrePT, 1, 2);
        inversionP = new Label("Inversion Requerida: ");
        grid.add(inversionP, 0, 3);
        inversionPT = new TextField();
        grid.add(inversionPT, 1, 3);
        registrar = new Button("Registrar");
        grid.add(registrar, 0, 5);
        mensajeFinal = new Text();
        grid.add(mensajeFinal, 0, 6);
        
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(grid);
        scene = new Scene(pane, 600, 450);
    }

    public void mostrar(Stage stage) {
        stage.setTitle("Registrar Promotor");
        stage.setScene(scene);
        stage.show();
    }

    public Text getMensajeFinal() {
        return mensajeFinal;
    }

    public TextField getNombrePT() {
        return nombrePT;
    }

    public TextField getInversionPT() {
        return inversionPT;
    }

    public Button getRegistrar() {
        return registrar;
    }

    public TextField getPrecioBaseS() {
        return precioBaseS;
    }
    
}
