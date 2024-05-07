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
import javafx.scene.Node;
import javafx.scene.Parent;
<<<<<<< HEAD
=======
import javafx.scene.Scene;
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
<<<<<<< HEAD
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
=======
import javafx.stage.Stage;
import model.Pessoa;
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Menu_Func_Controller implements Initializable {

    @FXML
    void tela_Admin_Menu_Clientes(ActionEvent event) {
<<<<<<< HEAD
        carregarTela("/view/Tela_Cadastrar_Cliente_1");
        
         btnClientes.setStyle("-fx-background-color: #00ff001e;");
=======
        carregarTela("/view/Tela_Cadastrar_Cliente_1", pessoa);

        btnClientes.setStyle("-fx-background-color: #00ff001e;");
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    void Tela_Geral(ActionEvent event) {
        borderPane.setRight(panelGeral);
<<<<<<< HEAD
        
        
=======

>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
        btnDashboard.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
        btnClientes.setStyle("-fx-background-color: transparent;");
<<<<<<< HEAD
        

       
=======

>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
    }

    @FXML
    void plano_Associa(ActionEvent event) {
<<<<<<< HEAD
          carregarTela("/view/Tela_Func_PlanoAss");
=======
        carregarTela("/view/Tela_Func_PlanoAss", pessoa);
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
        btnPacotes.setStyle("-fx-background-color: #00ff001e;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
<<<<<<< HEAD
         btnClientes.setStyle("-fx-background-color: transparent;");
=======
        btnClientes.setStyle("-fx-background-color: transparent;");
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
    }

    @FXML
    void Tela_Instrutores(ActionEvent event) {
<<<<<<< HEAD
         carregarTela("/view/Tela_Func_Instrutores");
=======
        carregarTela("/view/Tela_Func_Instrutores", pessoa);
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
        btnInstrutor.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
<<<<<<< HEAD
         btnClientes.setStyle("-fx-background-color: transparent;");
=======
        btnClientes.setStyle("-fx-background-color: transparent;");
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
    }

    @FXML
    void Tela_Maquinas(ActionEvent event) {
<<<<<<< HEAD
        carregarTela("/view/Tela_Func_Maquinas");
=======
        carregarTela("/view/Tela_Func_Maquinas", pessoa);
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
        btnMaquinas.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
<<<<<<< HEAD
         btnClientes.setStyle("-fx-background-color: transparent;");
=======
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

>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
    }
    
    
      @FXML
    void Tela_gestao_cliente(ActionEvent event) {
        carregarTela("/view/Tela_Func_Gestao_Cliente");
        btnGestaoCliente.setStyle("-fx-background-color: #00ff001e;");
        btnPacotes.setStyle("-fx-background-color: transparent;");
        btnInstrutor.setStyle("-fx-background-color: transparent;");
        btnMaquinas.setStyle("-fx-background-color: transparent;");
        btnDashboard.setStyle("-fx-background-color: transparent;");
         btnClientes.setStyle("-fx-background-color: transparent;");
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

<<<<<<< HEAD
        borderPane.setRight(root);
=======
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
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD
//       btnDashboard.setStyle("-fx-background-color: #00ff001e;");
//        btnPacotes.setStyle("-fx-background-color: transparent;");
//        btnInstrutor.setStyle("-fx-background-color: transparent;");
//        btnMaquinas.setStyle("-fx-background-color: transparent;");
//        btnGestaoCliente.setStyle("-fx-background-color: transparent;");
//        btnClientes.setStyle("-fx-background-color: transparent;");
=======
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
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
    }

}
