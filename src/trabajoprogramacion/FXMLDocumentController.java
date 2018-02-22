/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoprogramacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import choicebox.*;
import javafx.stage.Stage;
/**
 *
 * @author OrixStranger
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private TextField txtNotaA;
    @FXML private TextField txtNotaB;
    @FXML private TextField txtNotaC;
    @FXML private TextField txtPromedio;
    @FXML private Button btnSalir;
    

    @FXML private void accionCalcular(ActionEvent event){
        String situacion = "";
        double notaA = Double.parseDouble(txtNotaA.getText());
        double notaB = Double.parseDouble(txtNotaB.getText());
        double notaC = Double.parseDouble(txtNotaC.getText());
        double prom = ((notaA * 3) + (notaB * 4) + (notaC * 3)) / 10;
        if (prom >= 14) {
            situacion = "Aprobada";
        }else{
            situacion = "Reprobada";
        }
        txtPromedio.setText(Double.toString(prom));
        JOptionPane.showMessageDialog(null, "Usted esta " + situacion, "PROMEDIO", JOptionPane.INFORMATION_MESSAGE);
    }
    @FXML private void next(ActionEvent event) throws Exception{
        ChoiceBox siguiente=new ChoiceBox();
        siguiente.start(new Stage());

    }
    @FXML private void accionLimpiar(ActionEvent event){
        txtNotaA.setText(null);
        txtNotaB.setText(null);
        txtNotaC.setText(null);
        txtPromedio.setText(null);
    }
    
    @FXML private void accionSalir(ActionEvent event){
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
