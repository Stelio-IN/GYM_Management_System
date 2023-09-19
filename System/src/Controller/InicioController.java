/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class InicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        @FXML
    private TextField txtInicio;

    @FXML
    void colocarTexto(ActionEvent event) {
    txtInicio.setText("So para Testar!! se Boraaaa!!!!!");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
