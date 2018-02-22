/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrodepersonas;

import Persona.Persona;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 *
 * @author Ferchitoo
 */
public class FXMLDocumentController implements Initializable {
    ObservableList<Persona>personas;
    @FXML
    private TableView<Persona> tablapersonas;
    @FXML
    private TableColumn nombrecl;
    @FXML
    private TableColumn apellidocl;
    @FXML
    private TableColumn sexocl;
    @FXML
    private TableColumn edadcl;
    @FXML
    private TableColumn telefonocl;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField apellidoTF;
    @FXML
    private TextField sexoTF;
    @FXML
    private TextField edadTF;
    @FXML
    private TextField telefonoTF;
    @FXML
    private Button añadirBT;
    @FXML
    private Button modificarBT;
    @FXML
    private Button eliminarBT;
    @FXML
    private Button nuevoBT;
    
    private int posicionPersonaenTabla;
    @FXML
    private Button representacion;
   
    private void inicializarTablaPersonas(){
        nombrecl.setCellValueFactory(new PropertyValueFactory<Persona,String>("nombre"));
        apellidocl.setCellValueFactory(new PropertyValueFactory<Persona,String>("apellido"));
        sexocl.setCellValueFactory(new PropertyValueFactory<Persona,String>("sexo"));
        edadcl.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("edad"));
        telefonocl.setCellValueFactory(new PropertyValueFactory<Persona,String>("telefono"));
        
        personas=FXCollections.observableArrayList();
        tablapersonas.setItems(personas);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.inicializarTablaPersonas();
       
       modificarBT.setDisable(true);
       eliminarBT.setDisable(true);
       
       final ObservableList<Persona>tablaPersonaSel=tablapersonas.getSelectionModel().getSelectedItems();
       tablaPersonaSel.addListener(seleccionarTablaPersona);
    }    

    @FXML
    private void ALañadir(ActionEvent event) {
        Persona pers=new Persona();
        pers.nombre.set(nombreTF.getText());
        pers.apellido.set(apellidoTF.getText());
        pers.sexo.set(sexoTF.getText());
        pers.edad.set(Integer.parseInt(edadTF.getText()));
        pers.telefono.set(telefonoTF.getText());
        personas.add(pers);
    }

    @FXML
    private void ALmodificar(ActionEvent event) {
        Persona pers=new Persona();
        pers.nombre.set(nombreTF.getText());
        pers.apellido.set(apellidoTF.getText());
        pers.sexo.set(sexoTF.getText());
        pers.edad.set(Integer.parseInt(edadTF.getText()));
        pers.telefono.set(telefonoTF.getText());
        personas.set(posicionPersonaenTabla, pers);
    }

    @FXML
    private void ALeliminar(ActionEvent event) {
        personas.remove(posicionPersonaenTabla);
    }

    @FXML
    private void ALnuevo(ActionEvent event) {
        nombreTF.setText("");
        apellidoTF.setText("");
        sexoTF.setText("");
        edadTF.setText("");
        telefonoTF.setText("");
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
        añadirBT.setDisable(false);
    }
    //PARA SELECCIONAR UNA CELDA DE LA TABLA
    private final ListChangeListener<Persona>seleccionarTablaPersona=new ListChangeListener<Persona>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Persona> c) {
           ponerPersonaSeleccionada();
        }
    };
    public Persona getTablaPersonsSeleccionadas(){
        if(tablapersonas!=null){
            List<Persona>tabla=tablapersonas.getSelectionModel().getSelectedItems();
            if(tabla.size()==1){
                final Persona competicionSeleccionada=tabla.get(0);
                return competicionSeleccionada;
            }
        }return null;
    }
    public void ponerPersonaSeleccionada(){
        final Persona persona=getTablaPersonsSeleccionadas();
        posicionPersonaenTabla=personas.indexOf(persona);
        
        if(persona!=null){
            nombreTF.setText(persona.getNombre());
            apellidoTF.setText(persona.getApellido());
            sexoTF.setText(persona.getSexo());
            edadTF.setText(persona.getEdad().toString());
            telefonoTF.setText(persona.getTelefono());
            
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            añadirBT.setDisable(true);
        }
    }
}
