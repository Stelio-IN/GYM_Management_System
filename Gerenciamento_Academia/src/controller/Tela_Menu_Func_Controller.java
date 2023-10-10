/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import gerenciamento_academia.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Menu_Func_Controller implements Initializable {

    @FXML
    void tela_Admin_Menu_Clientes(ActionEvent event) {
        carregarTela("/view/Tela_Cadastrar_Cliente");
    }

    @FXML
    void Tela_Geral(ActionEvent event) {
        borderPane.setRight(panelGeral);
    }
    
     @FXML
    void plano_Associa(ActionEvent event) {
          carregarTela("/view/Tela_Func_PlanoAss");
    }
    
    @FXML
    void Tela_Instrutores(ActionEvent event) {
         carregarTela("/view/Tela_Func_Instrutores");
    }

    @FXML
    void Tela_Maquinas(ActionEvent event) {
        carregarTela("/view/Tela_Func_Maquinas");
    }
    
    
      @FXML
    void Tela_gestao_cliente(ActionEvent event) {
        carregarTela("/view/Tela_Func_Gestao_Cliente");
    }
    
     @FXML
    void BtnSair(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("FECHAR");
         alerta.setHeaderText("Deseja sair?");
        alerta.setContentText("Deseja realmente fechar");
        if (alerta.showAndWait().get() == ButtonType.OK) {

            System.out.println("Logout efetuado com sucesso!");
        
    }
    }
    
//     void close(Stage stage) {
//        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
//        alerta.setTitle("FECHAR");
//        alerta.setHeaderText("Quer realment Fechar");
//        alerta.setContentText("Deseja salvar antes de Fechar");
//        if (alerta.showAndWait().get() == ButtonType.OK) {
//
//            System.out.println("Exit exito");
//  
//            stage.close();
//        }
//    }

    @FXML
    private AnchorPane panelGeral;
    @FXML
    private BorderPane borderPane = new BorderPane();

    public void carregarTela(String tela) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(tela + ".fxml"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu_Admin_Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        borderPane.setRight(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
