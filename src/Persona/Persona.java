/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Ferchitoo
 */
public class Persona {
    public SimpleStringProperty nombre=new SimpleStringProperty();
    public SimpleStringProperty apellido=new SimpleStringProperty();
    public SimpleStringProperty sexo=new SimpleStringProperty();
    public SimpleIntegerProperty edad=new SimpleIntegerProperty();
    public SimpleStringProperty telefono=new SimpleStringProperty();

    public String getNombre() {
        return nombre.get();
    }

    public String getApellido() {
        return apellido.get();
    }


    public String getSexo() {
        return sexo.get();
    }


    public Integer getEdad() {
        return edad.get();
    }


    public String getTelefono() {
        return telefono.get();
    }   
}
