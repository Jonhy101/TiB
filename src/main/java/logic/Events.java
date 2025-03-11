/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author THR-1
 */
public class Events implements EventHandler<ActionEvent>{
    
    private TextField texto;
    
    public Events(TextField texto){
        this.texto=texto;
    }
    
    @Override
    public void handle(ActionEvent event){
        if(event.getSource() instanceof Button){
            Button clickedButton= (Button) event.getSource();
            
            switch(clickedButton.getText()){
                case "Convertir":
                    texto.setText("930");
                    System.out.println("Se presiono el boton convertir, se lleno el field de resultado");
                    break;
                default:
                    System.out.println("Otro boton fue presionado");
            }
        }
    }
}
