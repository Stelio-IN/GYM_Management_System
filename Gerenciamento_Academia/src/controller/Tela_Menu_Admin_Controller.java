/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Menu_Admin_Controller implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private AnchorPane panelGeral;

    @FXML
    private VBox vbox;

    @FXML
    void tela_Admin_Menu_Clientes(MouseEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Clientes");
    }

    @FXML
    void tela_Admin_Menu_Funcionarios(MouseEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Funcionarios");
    }

    @FXML
    void tela_Admin_Menu_Geral(MouseEvent event) {
        borderPane.setCenter(panelGeral);
    }

    @FXML
    void tela_Admin_Menu_Instrutores(MouseEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Instrutores");
    }

    @FXML
    void tela_Admin_Menu_Maquinas(MouseEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Maquinas");    
    }

    private void carregarTela(String tela) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(tela + ".fxml"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu_Admin_Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        borderPane.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
