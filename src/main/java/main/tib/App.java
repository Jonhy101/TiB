/*Este app sirve para la conversión de unidades de información entre los sistemas
de unidades en base decimal y con base binaria.
*/ 

package main.tib;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import graphics.*;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       stage.getIcons().addAll(
            new Image(getClass().getResourceAsStream("/images/logo32.png"))                    
        );
        stage.setScene(new MainScene().createMainScene());
        stage.setHeight(300);
        stage.setWidth(425);
        stage.setResizable(false);
        stage.setTitle("TiB Converter info unities");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}