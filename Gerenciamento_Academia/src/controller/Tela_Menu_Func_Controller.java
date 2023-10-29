/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Pessoa;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Menu_Func_Controller implements Initializable {

    @FXML
    void tela_Admin_Menu_Clientes(ActionEvent event) {
        carregarTela("/view/Tela_Cadastrar_Cliente_1", pessoa);

        btnClientes.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    void Tela_Geral(ActionEvent event) {
        borderPane.setRight(panelGeral);

        btnDashboard.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
        btnClientes.setStyle("-fx-background-color: transparent;");

    }

    @FXML
    void plano_Associa(ActionEvent event) {
        carregarTela("/view/Tela_Func_PlanoAss", pessoa);
        btnPacotes.setStyle("-fx-background-color: #00ff001e;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
        btnClientes.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    void Tela_Instrutores(ActionEvent event) {
        carregarTela("/view/Tela_Func_Instrutores", pessoa);
        btnInstrutor.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
        btnClientes.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    void Tela_Maquinas(ActionEvent event) {
        carregarTela("/view/Tela_Func_Maquinas", pessoa);
        btnMaquinas.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
        btnClientes.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    void Tela_gestao_cliente(ActionEvent event) {
        carregarTela("/view/Tela_Func_Gestao_Cliente", pessoa);
        btnGestaoCliente.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
        btnClientes.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    void BtnSair(ActionEvent event) throws IOException {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("LogOut");
        alerta.setHeaderText("Quer realmente terminar seccao");
        alerta.setContentText("Fazer backup antes de sair!");
        if (alerta.showAndWait().get() == ButtonType.OK) {

            Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    private AnchorPane panelGeral;
    @FXML
    private BorderPane borderPane = new BorderPane();

    @FXML
    private Label lblDashboard;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnGestaoCliente;

    @FXML
    private Button btnInstrutor;

    @FXML
    private Button btnMaquinas;

    @FXML
    private Button btnPacotes;

    public void carregarTela(String tela, Pessoa pessoa) {
        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(tela + ".fxml"));
            root = loader.load();

            // Verifique se a tela carregada possui um controlador associado
            if (loader.getController() instanceof Tela_Func_Avalicoes_Clientes_Controller) {
                Tela_Func_Avalicoes_Clientes_Controller controller = loader.getController();

                // Passe a pessoa para o controlador da tela
                controller.setPessoa(pessoa);
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu_Admin_Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        borderPane.setRight(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnDashboard.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
        btnClientes.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    private Label txtNomeFunc;
    private Pessoa pessoa;

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        txtNomeFunc.setText(pessoa.getNome());
        System.out.println(pessoa.getNome());
    }

//      @FXML
//    void Tela_Realizar_Testes(ActionEvent event) {
//        carregarTela("/view/Tela_Func_Avalicoes_Clientes");
//    }
    @FXML
    void Tela_Realizar_Testes(ActionEvent event) {
        // Chame o método carregarTela passando a pessoa
        carregarTela("/view/Tela_Func_Avalicoes_Clientes", pessoa);
    }

    @FXML
    void Tela_Func_AddPlano(ActionEvent event) {
        carregarTela("/view/Tela_Func_AddPlano", pessoa);
    }

    @FXML
    void Tela_Func_Associar_Cliente(ActionEvent event) {
        carregarTela("/view/Tela_Func_Associar_Clientes", pessoa);
    }
 
}
