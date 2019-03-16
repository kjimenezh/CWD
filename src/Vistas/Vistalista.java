
package Vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
public class Vistalista {
    private Scene scene;

    private GridPane grid;
    private StackPane pane; 
    
    private Image image;
    private ListView<String> list;   
    private Button regresar;


    public Vistalista(){
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
        
        list = new ListView<>();
        list.setMinWidth(200);     
        grid.add(list, 0, 0);
        regresar = new Button("Regresar");
        grid.add(regresar, 0, 1);
        
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(grid);
        scene = new Scene(pane, 600, 600);
    }
        
    public void mostrar(Stage stage) {
        stage.setTitle("Subastas Realizadas");
        stage.setScene(scene);
        stage.show();
    }

    public ListView<String> getList() {
        return list;
    }

    public Button getRegresar() {
        return regresar;
    }
    
    
   
}
