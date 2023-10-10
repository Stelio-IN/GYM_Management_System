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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Administrador;
import model.Cliente;
import model.Funcionario;
import model.Pessoa;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Login_Controller implements Initializable {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private AnchorPane PainelTelaLogin;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    void close(ActionEvent event) {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("FECHAR");
        alerta.setHeaderText("Quer realment Fechar");
        alerta.setContentText("Deseja salvar antes de Fechar");
        if (alerta.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) PainelTelaLogin.getScene().getWindow();
            System.out.println("Exit exito");
            stage.close();
        }
    }

//    @FXML
//    public void Tela_Principal(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Menu_Admin.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
   /* @FXML
    public void Tela_de_Entrada(ActionEvent event, String caminho) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(caminho));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/
    
    public void Tela_de_Entrada(ActionEvent event, String caminho, Pessoa pessoa) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
    Parent root = loader.load();
    
    // Acessa o controlador da próxima tela
    Tela_Menu_Admin_Controller controller = loader.getController();
    
    // Passa os dados da pessoa para o controlador
    controller.setPessoa(pessoa);
    
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

    @FXML
void btnLogar(ActionEvent event) {
    GenericDAO bb = new GenericDAO();

    Pessoa pessoa = (Pessoa) bb.logarEmailOuCodigo(txtEmail.getText());

    if (pessoa != null && pessoa.getPassword().equals(txtPassword.getText())) {
        try {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Login");
            alerta.setHeaderText("Login efetuado com sucesso!!!!");

            if (alerta.showAndWait().get() == ButtonType.OK) {
                if (pessoa instanceof Administrador) {
                    Tela_de_Entrada(event, "/view/Tela_Menu_Admin.fxml", pessoa);
                } else if (pessoa instanceof Cliente) {
                    Tela_de_Entrada(event, "/view/Tela_Menu_Cliente.fxml", pessoa);
                } else if (pessoa instanceof Funcionario) {
                    Tela_de_Entrada(event, "/view/Tela_Menu_Func.fxml", pessoa);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Trate ou registre erros adequadamente
        }

    } else {
        JOptionPane.showMessageDialog(null, "Credenciais erradas");
    }
}

    

//    @FXML
//    void btnLogar(ActionEvent event) {
//        GenericDAO bb = new GenericDAO();
//
//        Pessoa pessoa = (Pessoa) bb.logarEmailOuCodigo(txtEmail.getText());
//
//        if (pessoa != null && pessoa.getPassword().equals(txtPassword.getText())) {
//            try {
//                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
//                alerta.setTitle("Login");
//                alerta.setHeaderText("Login efetuado com sucesso!!!!");
//                // alerta.setContentText("Deseja salvar antes de Fechar");
//                if (alerta.showAndWait().get() == ButtonType.OK) {
//
//                    if (pessoa instanceof Administrador) {
//                        Tela_de_Entrada(event, "/view/Tela_Menu_Admin.fxml");
//                    } else if (pessoa instanceof Cliente) {
//                        Tela_de_Entrada(event, "/view/Tela_Menu_Cliente.fxml");
//                    } else if (pessoa instanceof Funcionario) {
//                        Tela_de_Entrada(event, "/view/Tela_Menu_Func.fxml");
//                    }
//
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace(); // Trate ou registre erros adequadamente
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Credencias erradas");
//
//        }
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
