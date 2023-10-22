/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package gerenciamento_academia;

import controller.GenericDAO;
import controller.Tela_Menu_Func_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Cliente;

/**
 *
 * @author steli
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image imagem = new Image("/img/icone.png");

        Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Func_AddPlano.fxml"));
       //   Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Admin_Registrar.fxml"));
       //      Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Login.fxml"));

        Scene scene = new Scene(root);
        stage.getIcons().add(imagem);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            close(stage);
        });
    }

    void close(Stage stage) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("FECHAR");
        alerta.setHeaderText("Deseja sair?");
        alerta.setContentText("Deseja realmente fechar");
        if (alerta.showAndWait().get() == ButtonType.OK) {

            System.out.println("Logout efetuado com sucesso!");

            stage.close();
        }
    }

    public static void main(String[] args) {
        teste();
        launch(args);

    }

    static void teste() {
//        Cliente cli1Associado = new Cliente();
//        Cliente cli1 = new Cliente();
//        GenericDAO dao = new GenericDAO();
//
//        cli1.setNome("MondlaneTestado");
//        cli1.setAltura(1.30);
//        cli1.setEmail("123@gmail.com");
//        cli1.setGenero("Masculino");
//
//      cli1Associado = (Cliente) dao.buscaId(Cliente.class, 1L);
//        cli1.setClinteAssociado(cli1Associado);
//       // dao.add(cli1);
//        System.out.println(cli1Associado.toString());

    }

}
