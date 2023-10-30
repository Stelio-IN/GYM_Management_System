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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author $umeid_ibr
 */
public class Tela_Func_Pagamentos_Controller implements Initializable {

     @FXML
    private ImageView emola;

    @FXML
    private ToggleGroup metodoPagamento;

    @FXML
    private ImageView mkesh;

    @FXML
    private ImageView mpesa;

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
    
    @FXML
    private AnchorPane CartaoDeCredito;
    
      @FXML
    private Label lblData;

    @FXML
    private Label lblNumeroCartao;

    @FXML
    private Label lblTitular;
    
     @FXML
    private Label lblCvv;
    
     @FXML
    private Button btnPagamento;
    
    public void EscritaSimultanea(){
        // NOME
             txtNome.textProperty().addListener((observable, oldValue, newValue) -> {
            if ( newValue.length() < 7 && !newValue.matches(".*\\d.*")) {
               txtNome.setStyle("-fx-text-fill: red;");
            }else{
            txtNome.setStyle("");    
            }
        });
             
            // primaryStage.setTitle("Real-Time TextField Synchronization Example");
             // Crie um binding bidirecional entre as TextFields
        Bindings.bindBidirectional(txtNumeroCartao.textProperty(), txtNumberCard.textProperty());
        Bindings.bindBidirectional(txtDataExpiracao.textProperty(), txtExpireDate.textProperty());
        Bindings.bindBidirectional(txtCvv.textProperty(), txtCvvCard.textProperty());
        
        
        // Inicializando com o mpesa selecionado
        mkesh.setVisible(false);
        emola.setVisible(false);
        
        lblData.setVisible(false);
        lblTitular.setVisible(false);
        lblNumeroCartao.setVisible(false);
        lblCvv.setVisible(false);
        
        txtDataExpiracao.setVisible(false);
        txtNumeroCartao.setVisible(false);
        txtTitular.setVisible(false);
        txtCvv.setVisible(false);
        CartaoDeCredito.setVisible(true);
         mkesh.setVisible(false);
        emola.setVisible(false);
        mpesa.setVisible(false);
        
    }
    
     @FXML
    void AtivarCartao(ActionEvent event) {
        CartaoDeCredito.setVisible(true);
        mkesh.setVisible(false);
        emola.setVisible(false);
        mpesa.setVisible(false);
        
        
        lblData.setVisible(true);
        lblTitular.setVisible(true);
        lblNumeroCartao.setVisible(true);
        lblCvv.setVisible(true);
        
        txtDataExpiracao.setVisible(true);
        txtNumeroCartao.setVisible(true);
        txtTitular.setVisible(true);
        txtCvv.setVisible(true);
        
         btnPagamento.setStyle(" -fx-background-color: linear-gradient(to right,  #0ac1758f, #055c36bb);");
    }

    @FXML
    void AtivarEmola(ActionEvent event) {
        emola.setVisible(true);
         mkesh.setVisible(false);
        mpesa.setVisible(false);
        CartaoDeCredito.setVisible(false);
        
        lblData.setVisible(false);
        lblTitular.setVisible(false);
        lblNumeroCartao.setVisible(false);
        lblCvv.setVisible(false);
        
        txtDataExpiracao.setVisible(false);
        txtNumeroCartao.setVisible(false);
        txtTitular.setVisible(false);
        txtCvv.setVisible(false);
        
        btnPagamento.setStyle(" -fx-background-color: linear-gradient(to right,  #fa7f45, #ae410e);");
    }

    @FXML
    void AtivarMkesh(ActionEvent event) {
        mkesh.setVisible(true);
         mpesa.setVisible(false);
        emola.setVisible(false);
        CartaoDeCredito.setVisible(false);
        
        lblData.setVisible(false);
        lblTitular.setVisible(false);
        lblNumeroCartao.setVisible(false);
        lblCvv.setVisible(false);
        
        txtDataExpiracao.setVisible(false);
        txtNumeroCartao.setVisible(false);
        txtTitular.setVisible(false);
        txtCvv.setVisible(false);
        
         btnPagamento.setStyle(" -fx-background-color: linear-gradient(to right,  #ffe95c, #8b7903e0);");
    }

    @FXML
    void AtivarMpesa(ActionEvent event) {
        mpesa.setVisible(true);
        mkesh.setVisible(false);
        emola.setVisible(false);
        CartaoDeCredito.setVisible(false);
        
        lblData.setVisible(false);
        lblTitular.setVisible(false);
        lblNumeroCartao.setVisible(false);
        lblCvv.setVisible(false);
        
        txtDataExpiracao.setVisible(false);
        txtNumeroCartao.setVisible(false);
        txtTitular.setVisible(false);
        txtCvv.setVisible(false);
                    btnPagamento.setStyle("-fx-background-color: linear-gradient(to right,  #ff5c61, #8f060b);");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EscritaSimultanea();
    }
}