/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author anfibio
 */
public class MainScene {
    private Stage primaryStage;         //Referencia a la ventana principal
    public Scene createMainScene(){
        Label lblMensaje=new Label(" TiB Tebibytes to Terabytes and more prex converter");
        lblMensaje.setTextFill(Color.WHITE);
        //Layout principal
        BorderPane root=new BorderPane();
        root.setBottom(lblMensaje);
        root.setStyle("-fx-background-color: "+Colors.BACKGROUND_COLOR+"; -fx-padding: 0;");
        
        /*********Menu Principal**********/
        MenuBar mainMenu=new MenuBar();
        //items del menú
        Menu menuArchivo=new Menu("Archivo");
        Menu menuAyuda=new Menu("Ayuda");
        
        //MenuItems
        MenuItem itemSalir= new MenuItem("Salir");
        MenuItem itemAyuda=new MenuItem("Notas de ayuda");
        MenuItem itemAcerca=new MenuItem("Acerca de...");
        //Agregar  menuItems al Menu
        menuArchivo.getItems().add(itemSalir);
        menuAyuda.getItems().addAll(itemAyuda, itemAcerca);
        //Agregar menus al MenuBar
        mainMenu.getMenus().addAll(menuArchivo, menuAyuda);
        //Agregar Menu Principal al BorderPane (norte)
        root.setTop(mainMenu);
        /*********************************/

        /*********Panel principal de operaciones*********/
        BorderPane containerOperaciones=new Panel().creaBorderPane();
        root.setLeft(containerOperaciones);
        /************************************************/
        
        /************Eventos de los botones del menú********/
        //itemSalir cierra la ventana
        itemSalir.setOnAction(event ->{
            Stage stage= (Stage) itemSalir.getParentPopup().getOwnerWindow();
            stage.close();
        });
        
        itemAyuda.setOnAction(event ->{           
            new StageModal().creaStageAyuda(this.primaryStage, "Temas de ayuda...");
                    
        });
        
        itemAcerca.setOnAction(event->{
            new StageModal().creaStageAcerca(this.primaryStage, "Acerca de TiB");
        });
        
        //Agregar elemento raíz al scene
        Scene scene=new Scene(root);  
        
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        return scene;
    }           
}
//https://forums.oracle.com/ords/apexds/post/issue-with-styling-a-menubar-s-background-color-8099