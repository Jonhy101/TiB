/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;


/**
 *
 * @author THR-1
 */
public class ControladorEventos {
    /*Este evento hace que se realicen los cálculos de la conversión y 
    se pasen al myTextField
    */
    /*prexOrigin y  prexTarjet pueden tener los siguientes valores
      según sea el item seleccionado en ellos:
        null: -1
        B: 0            
        KB:1    KiB:9
        MB:2    MiB:10
        GB:3    GiB:11
        TB:4    TiB:12
        PB:5    PiB:13
        EB:6    EiB:14
        ZB:7    ZiB:15
        YB:8    YiB:16
    */
    public void manejarBotonConvertir(TextField myTextFieldIn, 
                                        TextField myTextField, 
                                        String[] prexlist, 
                                        int prexOrigin, 
                                        int prexTarjet){   
        //Ajustar para facilitar conversión:
        double res;
        double valorIn;
        if(!myTextFieldIn.getText().isEmpty()){                   //Se realizan cálculos sólo cuando hay un valor ingresado 
            valorIn=Double.parseDouble(myTextFieldIn.getText());                                                       
            //Caso 1: Mismo Sistema *B->*B
            if(prexOrigin>=0 && prexOrigin<9 && prexTarjet>=0 && prexTarjet<9){
                res=valorIn*Math.pow(1000, (prexOrigin-prexTarjet));                         
            }
            //Caso 2: Mismo Sistema *iB->*iB
            else if(prexOrigin>8 && prexTarjet>8){
                res=valorIn*Math.pow(1024, (prexOrigin-prexTarjet));                           
            }
            //Caso 3: Diferente Sistema *B->*iB: 
            else if(prexOrigin<9 && prexTarjet>8){
                res=valorIn*Math.pow(1000.0/1024.0,prexOrigin)*Math.pow(1024, (prexOrigin-(prexTarjet-8)));                           
            }
            //Caso 4: Diferente Sistema *iB->*B
            else{
                res=valorIn*Math.pow(1.024,(prexOrigin-8))*Math.pow(1000, ((prexOrigin-8)-prexTarjet));                      
            }
            myTextField.setText(Double.toString(res));            
        }      
    }
    
    /*Con este evento se pasa el contenido del campo de texto donde está el 
    resultado al portapapeles, esto si hay contenido en el campo de texto, de 
    lo contraio no se realiza la acción.
    */
    public void manejarBtnCopiar(TextField myTextField){
        String text= myTextField.getText();
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        if(!text.isEmpty()){            //Si text no está vacío
            content.putString(text);
            clipboard.setContent(content);
        }                
    }
}
