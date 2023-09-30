/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package gerenciamento_academia;

import javafx.application.Application;
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
public class App extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Cadastrar_Cliente.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Admin_Registrar.fxml"));
        
        Scene scene = new Scene(root);
        
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
        alerta.setHeaderText("Quer realment Fechar");
        alerta.setContentText("Deseja salvar antes de Fechar");
        if (alerta.showAndWait().get() == ButtonType.OK) {

            System.out.println("Exit exito");
  
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
