
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
public class Vista3 {
    private Scene scene;

    private GridPane grid;
    private StackPane pane; 
    
    private Image image;
    private Text mensaje;
    private ListView<String> list;   
    private Button registrar;
    private Button finalizar;
    private Text finish;

    public Vista3(){
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        pane = new StackPane();
        
        image = new Image("Images/Biblioteca.png");
        ImageView imageV = new ImageView();
        imageV.setImage(image);
        imageV.setFitHeight(600);
        imageV.setFitWidth(600);
        pane.getChildren().add(imageV);
        
        mensaje = new Text();
        grid.add(mensaje, 0, 0);
        list = new ListView<>();
        list.setMinWidth(200);     
        grid.add(list, 0, 1);
        HBox hlayout = new HBox();
        registrar = new Button("Agregar Ofertas");
        finalizar = new Button("Finalizar Subasta");
        hlayout.getChildren().add(registrar);
        hlayout.getChildren().add(finalizar);
        grid.add(hlayout, 0, 2);
        finish = new Text();
        grid.add(finish, 0, 3);
        
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(grid);
        scene = new Scene(pane, 600, 600);
    }
        
    public void mostrar(Stage stage) {
        stage.setTitle("Subasta Holandesa");
        stage.setScene(scene);
        stage.show();
    }
    
    public Text getMensaje() {
        return mensaje;
    }

    public ListView<String> getList() {
        return list;
    }

    public Button getRegistrar() {
        return registrar;
    }

    public Button getFinalizar() {
        return finalizar;
    }

    public Text getFinish() {
        return finish;
    }
   
}
