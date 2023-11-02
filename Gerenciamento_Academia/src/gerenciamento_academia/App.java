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
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 
 * @author steli 
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
            Image imagem = new Image("/img/icone.png"); 
        
        
      Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Login.fxml"));
     //  Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Func_Pagamentos_.fxml"));
     //Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Admin_Registrar.fxml"));
        
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
        launch(args);
        System.out.println("Banana");
    }
    
}
