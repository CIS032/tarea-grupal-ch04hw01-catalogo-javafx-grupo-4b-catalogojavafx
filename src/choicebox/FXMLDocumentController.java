/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choicebox;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import registrodepersonas.*;
/**
 *
 * @author Ferchitoo
 */
public class FXMLDocumentController implements Initializable {
    ObservableList list=FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> series;
    @FXML
    private TextField screen;
    @FXML
    private Label label;
    @FXML
    private Button representa;
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        leerDatos();
    }    
  
    @FXML
    private void displayValue(ActionEvent event) {
        String peli=series.getValue();
        if(peli==null){
            screen.setText("Porfavor elija su peli favorita");
        }else{
            screen.setText("Su serie favorita es:\n"+peli);
        }
    }
    private void leerDatos(){
        list.removeAll(list);
        String a="Flash";
        String b="Mr. Robot";
        String c="Supergirl";
        String d="Malcom";
        String e="Smallville";
        list.addAll(a,b,c,d,e);
        series.getItems().addAll(list);
    }

    
    @FXML private void muestra(ActionEvent event) throws Exception{
       RegistrodePersonas siguiente=new RegistrodePersonas();
        siguiente.start(new Stage());

    }
}