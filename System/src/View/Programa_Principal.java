/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package View;

import DAO_Generic.GenericDAO;
import DTO.Administrador;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author steli
 */
public class Programa_Principal extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            close(stage);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Administrador admin = new Administrador();
        admin.setNome("gymm");
        admin.setEmail("gymm@gmail.com");
        admin.setPassword("123456");
        GenericDAO obj = new GenericDAO();
        obj.add(admin);
        
        launch(args);
    }

    void close(Stage stage) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("FECHAR");
        alerta.setHeaderText("Quer realment Fechar");
        alerta.setContentText("Deseja salvar antes de Fechar");
        if (alerta.showAndWait().get() == ButtonType.OK) {

            System.out.println("Exit exito");
            System.out.println("bla bla bla");
            System.out.println("De volta ksksk");
            stage.close();
        }
    }

}
