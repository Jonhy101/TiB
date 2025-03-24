/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Tooltip;
import logic.ControladorEventos;

/**
 *
 * @author THR-1
 */
public class Panel {
          
    public BorderPane creaBorderPane(){      
        String pList[]={"B","KB","MB","GB","TB","PT","EB","ZB","YB","KiB","MiB","GiB","TiB","PiB","EiB","ZiB","YiB"};                
        
        BorderPane myBorderPane=new BorderPane();       //Contenedor principal
        myBorderPane.getStylesheets().add(getClass().getResource("/styles/controlStyles.css").toExternalForm());        
        
        /************Lado Izquierdo************/
        VBox leftContainer=new VBox();          
        leftContainer.setPadding(new Insets(20,0,0,20));
        
        //Label con texto convertir
        Label textConv=new Label("Convertir:");
        leftContainer.getChildren().add(textConv);       
        
        //Text Field para recibir la entrada->valor que se desea convertir
        HBox containerDates=new HBox();
        TextField textFieldValor= new TextField();
        //Filtro para admitir sólo números positivos
        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, change -> {
            String newText = change.getControlNewText();
            if (newText.matches("([0-9]*[.])?[0-9]*?([eE][0-9]+)?")) {
                return change;
            }
            return null;
        });
        textFieldValor.setTextFormatter(textFormatter);
        textFieldValor.setText("");
        //ComboBox con la lista de prefijos
        ObservableList<String>listPrefijos= FXCollections.observableArrayList(pList);
        ComboBox prefijos=new ComboBox(listPrefijos);
        prefijos.getSelectionModel().select(1);
        prefijos.setVisibleRowCount(5);
        containerDates.getChildren().addAll(textFieldValor,prefijos);
        leftContainer.getChildren().add(containerDates);
        
        myBorderPane.setLeft(leftContainer);
        /***************************************/
                
        /************Lado Derecho************/
        VBox rightContainer=new VBox();          
        rightContainer.setPadding(new Insets(20,0,0,20));
        
        //Label con con texto "A" para decoración
        Label textA=new Label("A:");
        rightContainer.getChildren().add(textA);        
        
        //Text Field
        HBox containerRes=new HBox();
        TextField textFieldRes= new TextField();   
        textFieldRes.setEditable(false);
        ComboBox prefijosRes=new ComboBox(listPrefijos);
        prefijosRes.getSelectionModel().select(1);
        prefijosRes.setVisibleRowCount(5);
        containerRes.getChildren().addAll(textFieldRes,prefijosRes);
        rightContainer.getChildren().add(containerRes);
        
        myBorderPane.setRight(rightContainer);
        /***************************************/
        
        /*********Botón Convertir***************/              
        Button btnConvierte=creaBotonIcono("/images/convierte2.png", "Convertir");        
        
        /**********Botón Copiar****************/
        Button btnCopy= creaBotonIcono("/images/clipboard.png", "");
        btnCopy.setTooltip(new Tooltip("Copiar resultado al portapapeles"));
        
        //Agregar controles al buttonsContainer
        HBox buttonsContainer=new HBox();
        buttonsContainer.setAlignment(Pos.CENTER);
        buttonsContainer.setSpacing(20);
        buttonsContainer.setPadding(new Insets(0,0,80,20));
        buttonsContainer.getChildren().addAll(btnConvierte, btnCopy);
                
        //Eventos de los botones         
        btnConvierte.setOnAction(event->controlador.manejarBotonConvertir(
                textFieldValor, 
                textFieldRes, 
                pList, 
                prefijos.getSelectionModel().getSelectedIndex(), 
                prefijosRes.getSelectionModel().getSelectedIndex()));
        btnCopy.setOnAction(event->controlador.manejarBtnCopiar(textFieldRes));
        
        myBorderPane.setBottom(buttonsContainer);               
        return myBorderPane;
    }      
    
    private ControladorEventos controlador=new ControladorEventos();
    
    private Button creaBotonIcono(String pathIcon, String textButton){        
        ImageView imgConvierte=new ImageView(new Image(getClass().getResourceAsStream(pathIcon)));         
        imgConvierte.setFitWidth(25);           // Ancho en píxeles
        imgConvierte.setFitHeight(25);          // Alto en píxeles
        imgConvierte.setPreserveRatio(true);    // Mantener relación de aspecto       
        return new Button(textButton, imgConvierte);           
    }
}
