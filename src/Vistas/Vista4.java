
package Vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kjime
 */
public class Vista4 {
    private Scene scene;

    private GridPane grid;
    private StackPane pane; 
    
    private Image image;
    private Text mensajeInicial;
    private Text mensajeFinal;
    private Label nombreA;
    private TextField nombreAT;
    private Label valorcA;
    private TextField valorcAT;
    private Label valoroA;
    private TextField valoroAT;
    private Label tasaoA;
    private TextField tasaoAT;
    private Label tiempooA;
    private TextField tiempooAT;
    private Button registrar;
    private Button regresar;

    public Vista4(){
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
        
        mensajeInicial = new Text("Ingrese los datos del aportante y su oferta");
        grid.add(mensajeInicial, 0, 0);
        nombreA = new Label("Nombre: ");
        grid.add(nombreA, 0, 1);
        nombreAT = new TextField();
        grid.add(nombreAT, 1, 1);
        valorcA = new Label("Valor en cuenta: ");
        grid.add(valorcA, 0, 2);
        valorcAT = new TextField();
        grid.add(valorcAT, 1, 2);
        valoroA = new Label("Valor de oferta: ");
        grid.add(valoroA, 0, 3);
        valoroAT = new TextField();
        grid.add(valoroAT, 1, 3);
        tasaoA = new Label("Tasa de interés: ");
        grid.add(tasaoA, 0, 4);
        tasaoAT = new TextField();
        grid.add(tasaoAT, 1, 4);
        tiempooA = new Label("Tiempo: ");
        grid.add(tiempooA, 0, 5);
        tiempooAT = new TextField();
        grid.add(tiempooAT, 1, 5);
        
        HBox hlayout = new HBox();
        registrar = new Button("Registrar");
        regresar = new Button("Regresar");
        hlayout.getChildren().add(registrar);
        hlayout.getChildren().add(regresar);
        grid.add(hlayout, 0, 6);
        mensajeFinal = new Text();
        grid.add(mensajeFinal, 0, 7);
        
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(grid);
        scene = new Scene(pane, 600, 450);
    }
    
    public void mostrar(Stage stage) {
        stage.setTitle("Registrar Promotor");
        stage.getIcons().add(new Image("Images/icon.png")); 
        stage.setScene(scene);
        stage.show();
    }

    public Text getMensajeInicial() {
        return mensajeInicial;
    }

    public Text getMensajeFinal() {
        return mensajeFinal;
    }

    public TextField getNombreAT() {
        return nombreAT;
    }

    public TextField getValorcAT() {
        return valorcAT;
    }

    public TextField getValoroAT() {
        return valoroAT;
    }

    public TextField getTasaoAT() {
        return tasaoAT;
    }

    public TextField getTiempooAT() {
        return tiempooAT;
    }

    public Button getRegistrar() {
        return registrar;
    }

    public Button getRegresar() {
        return regresar;
    }
    
    
}
