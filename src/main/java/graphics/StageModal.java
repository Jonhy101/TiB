/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author THR-1
 */
public class StageModal {
      
    public void creaStageAyuda(Stage parentStage, String title){
        //Layout principal de este parentStage
        VBox root=creaVbox();
        
        //Imagen del logo principal
        ImageView imgLogo=creaImageView("/images/logo512.png", 50, 50);        
        root.getChildren().add(imgLogo);
        
        //TextArea con información relevante
        String text="TiB convierte valores de unidades de información entre los "
                + "sistemas binario y decimal. Los dispositivos de almacenamiento "
                + "utilizan el sistema decimal, por ejemplo, en su etiqueta especifican "
                + "1000GB (decimal), pero el sistema operativo muestra aprox. 931GiB "
                + "(binario). Cabe resaltar que aunque los sistemas operativos muestran "
                + "la capacidad en sistema binario, la unidades que muestran son del "
                + "sistema decimal, esto es: 931GB. Los prefijos disponibles para "
                + "la conversión son los siguientes: \n"                                                                
                + "  Sist. Decimal      Sist. Binario\n"
                + "    B  (Byte)              B (Byte)\n"
                + "    KB (Kilobyte)       KiB (Kibibyte)\n"
                + "    MB (Megabyte)   MiB (Mebibyte)\n"
                + "    GB (Gigabyte)     GiB (Gibibyte)\n"
                + "    TB (Terabyte)      TiB (Tebibyte)\n"
                + "    PB (Petabyte)      PiB (Pebibyte)\n"
                + "    EB (Exabyte)        EiB (Exbibyte)\n"
                + "    ZB (Zettabyte)     ZiB (Zebibyte)\n"
                + "    YB (Yottabyte)     YiB (Yobibyte)\n"                
                + "Botones: Convertir: Encuentra el equivalente al \n"
                + "                      valor ingresado\n"
                + "               Copiar (imagen de portapapeles):    Copia el\n "
                + "                      resultado al portapapeles";                
                                                
        TextArea textAreaInfo= customTextArea(text);  
        VBox.setMargin(textAreaInfo, new Insets(10,0,0,0));     //margen superior de 10px        
        textAreaInfo.setPrefHeight(470);        
        root.getChildren().add(textAreaInfo);
        
        //Crear el StageModal con lo creado hasta aquí
        creaStageModal(parentStage, title, root, 430, 600);                 
    }
    
    public void creaStageAcerca(Stage parentStage, String title){        
        //Layout principal de este parentStage
        VBox root=creaVbox();
        
        //Imagen del logo principal
        ImageView imgLogo=creaImageView("/images/logo512.png", 150, 150);      
        root.getChildren().add(imgLogo);
        
        //Labels con el título y su traducción
        Label lblTitulo=new Label("TiB Converter info unities");
        lblTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-fond-weight: bold; -fx-padding: 10px 0 2px 0");
        Label lblTrad=new Label("TiB convertidor de unidades de información");
        lblTrad.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 0 0 10px 0");
        root.getChildren().addAll(lblTitulo, lblTrad);
        
        //TextArea con información relevante
        String text="Este programa es una herramienta dirigida al mentenimiento y configuración de computadores, "
                + "su función es la conversión de valores de información con prefijos en binario o decimal.\n"
                + "\nTiB\n"
                + "Versión: 1.0.0\n"
                + "Publicación: Marzo de 2025\n"
                + "Licencia: MIT License\n"
                + "Autor: Jonhy M.\n"
                + "Correo electrónico: eljonyal101@gmail.com";                        
        TextArea textAreaInfo= customTextArea(text);    
        textAreaInfo.setPrefHeight(230);
        root.getChildren().add(textAreaInfo);
        //tamaño de ventna 400*500
        creaStageModal(parentStage, title, root, 400, 514);                 
    }
     
    private void creaStageModal(Stage parentStage, String title, VBox root, int width, int height){
        Stage myModalStage;
        myModalStage=new Stage();
        myModalStage.initModality(Modality.APPLICATION_MODAL);  //Bloquear acciones en la ventan principal
        myModalStage.initOwner(parentStage);                   //Esta ventana es la propietaria
        myModalStage.setTitle(title);
        myModalStage.getIcons().addAll(
            new Image(getClass().getResourceAsStream("/images/logo32.png"))
        );
        myModalStage.setWidth(width);
        myModalStage.setHeight(height);  
        myModalStage.setResizable(false);
        myModalStage.setScene(new Scene(root));
        myModalStage.showAndWait();     //Bloquear ventana padre o principal hasta que se cierre                
    }
    
    private VBox creaVbox(){
        VBox myVBox=new VBox();
        myVBox.setStyle("-fx-background: "+Colors.BACKGROUND_COLOR+"; -fx-padding: 15px 5px 5px 5px;");
        myVBox.setAlignment(Pos.TOP_CENTER);
        return myVBox;
    }
    
    private TextArea customTextArea(String text){
        TextArea myTextArea=new TextArea(text);     
        myTextArea.setStyle("-fx-text-fill: white; "
                + "-fx-font-size: 14px; "
                + "-fx-control-inner-background: "+Colors.BACKGROUND_B_COLOR+";"
                + "-fx-background-color: "+Colors.BACKGROUND_B_COLOR+";"
                + "-fx-focus-color: transparent; "
                + "-fx-faint-focus-color: transparent; "
                + "-fx-highlight-fill: "+Colors.HOVER_COLOR+"; "
        );              
        myTextArea.setContextMenu(new ContextMenu());   //Esto evita mostarar menú contextual al hacer clic derecho sobre el
        myTextArea.setEditable(false);
        myTextArea.setWrapText(true);
        return myTextArea;        
    }
    
    private ImageView creaImageView(String path, int width, int height){
        ImageView myImageView;                
        Image img= new Image(getClass().getResourceAsStream(path));
        myImageView=new ImageView(img);
        myImageView.setFitWidth(width);
        myImageView.setFitHeight(height);
        return myImageView;
    }
}
