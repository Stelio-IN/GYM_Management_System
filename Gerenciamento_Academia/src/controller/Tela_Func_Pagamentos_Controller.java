/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author $umeid_ibr
 */
public class Tela_Func_Pagamentos_Controller implements Initializable {

   @FXML
    private ToggleGroup metodoPagamento;

    @FXML
    private TextField txtContacto;

    @FXML
    private TextField txtCvv;

    @FXML
    private TextField txtCvvCard;

    @FXML
    private TextField txtDataExpiracao;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtExpireDate;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNumberCard;

    @FXML
    private TextField txtNumeroCartao;

    @FXML
    private TextField txtTitular;
    
    
    public void EscritaSimultanea(){
        // NOME
             txtNome.textProperty().addListener((observable, oldValue, newValue) -> {
            if ( newValue.length() < 7 && !newValue.matches(".*\\d.*")) {
               txtNome.setStyle("-fx-text-fill: red;");
            }else{
            txtNome.setStyle("");    
            }
        });
             
             
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}