/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Administrador;
import model.Equipamento;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Admin_Menu_Maquinas_Controller implements Initializable {

    
    @FXML
    private TableView<Equipamento> tabela;

    @FXML
    private TableColumn<Equipamento, String> tabela_Marca;

    @FXML
    private TableColumn<Equipamento, String> tabela_Modelo;

    @FXML
    private TableColumn<Equipamento, String> tabela_Nome;
    
        @FXML
    private TableColumn<Equipamento, Byte> tabela_Imagem;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPesquisa;
    
      @FXML
    private ImageView imageCamera;
    
     String caminhoDoArquivo;
     
     @FXML
    void carregarimg(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar uma imagem");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"),
                new FileChooser.ExtensionFilter("Todos os arquivos", "*.*")
        );

        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            caminhoDoArquivo = selectedFile.getAbsolutePath();

            // Cria uma instância de Image com o arquivo selecionado
            Image imagemSelecionada = new Image(selectedFile.toURI().toString());

            // Atribui a imagem ao ImageView
            imageCamera.setImage(imagemSelecionada);
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }
    }

    @FXML
    void cadastrar(ActionEvent event) throws IOException {
        GenericDAO dao = new GenericDAO();
        Equipamento equip = new Equipamento();
        equip.setNome(txtNome.getText());
        equip.setMarca(txtMarca.getText());
        equip.setModelo(txtModelo.getText());
        
        // Verifique se o caminho do arquivo não é nulo ou vazio
        if (caminhoDoArquivo != null && !caminhoDoArquivo.isEmpty()) {
            // Leitura da imagem do arquivo e armazenamento como um array de bytes
            Path imagePath = Paths.get(caminhoDoArquivo);
            byte[] imagemBytes = Files.readAllBytes(imagePath);

            equip.setImagem(imagemBytes);

        } else {
            System.out.println("Nenhum arquivo de imagem selecionado.");
        }
        
        dao.add(equip);
    }
    
    @FXML
    void pesquisar(ActionEvent event) {
 if (!txtPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, txtPesquisa.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Campo de Texto Vazio");
        }
    }
    

    @FXML
    void editar(ActionEvent event) throws IOException {
        Class<Equipamento> classe = Equipamento.class;
        GenericDAO dao = new GenericDAO();
        Equipamento equip = new Equipamento();
       
        equip.setId(Long.valueOf(txtId.getText()));
        equip.setNome(txtNome.getText());
        equip.setMarca(txtMarca.getText());
        equip.setModelo(txtModelo.getText());
        // Verifique se o caminho do arquivo não é nulo ou vazio
        if (caminhoDoArquivo != null && !caminhoDoArquivo.isEmpty()) {
            // Leitura da imagem do arquivo e armazenamento como um array de bytes
            Path imagePath = Paths.get(caminhoDoArquivo);
             byte[] imagemBytes = Files.readAllBytes(imagePath);

            equip.setImagem(imagemBytes);

        } else {
            System.out.println("Nenhum arquivo de imagem selecionado.");
        }
     
        
        dao.Atualizar(classe, Long.valueOf(txtId.getText()), equip);
        
        JOptionPane.showMessageDialog(null, "Atualizado COm sucesso");
        txtId.setText("");
        txtMarca.setText("");
        txtNome.setText("");
        txtModelo.setText("");
        listar(event);
        
        
    }
    


    @FXML
    void excluir(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        Class<Equipamento> classe = Equipamento.class;
        dao.removeFisico(classe, Long.valueOf(txtId.getText()));
        
        txtId.setText("");
        txtMarca.setText("");
        txtNome.setText("");
        txtModelo.setText("");
        listar(event);
        
    }

    private ObservableList<Equipamento> observableList;
    @FXML
    void listar(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        Class<Equipamento> classe =  Equipamento.class;
        
        List<Equipamento> lista = (List<Equipamento>) dao.listar(classe);
        
        tabela_Nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        tabela_Marca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
        tabela_Modelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
       // tabela_Imagem.setCellValueFactory(new PropertyValueFactory<>("Imagem"));
        
        observableList = FXCollections.observableArrayList(lista);
       tabela.setItems(observableList);
        
    }

    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     tabela.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
     );
         txtId.setDisable(true);
             }   
    
     public void pegarLinhaSelecionada(Equipamento pessoa) {
     if (pessoa != null) {
         txtId.setText(String.valueOf(pessoa.getId()));
         txtNome.setText(pessoa.getNome());
         txtMarca.setText(pessoa.getMarca());
         txtModelo.setText(pessoa.getModelo());
         
          if (pessoa.getImagem() != null) {
            // Converta o array de bytes em uma Image
            byte[] imagemBytes = pessoa.getImagem();
            Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

            // Defina a imagem no ImageView
            imageCamera.setImage(imagem);
        } else {
           JOptionPane.showMessageDialog(null, "imagem nao encontrada");
        }
         

     } else {
         txtId.setText("");
         txtNome.setText("");
         txtMarca.setText("");
         txtModelo.setText("");
         
     }
     }
     
      void retornar_Imagem_Banco(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        Equipamento administrador = (Equipamento) dao.logarEmail("admin");

        if (administrador != null && administrador.getImagem() != null) {
            // Converta o array de bytes em uma Image
            byte[] imagemBytes = administrador.getImagem();
            Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

            // Defina a imagem no ImageView
            imageCamera.setImage(imagem);
            System.out.println("Encontrado");
        } else {
            System.out.println("Nao Encontrado");
        }
    }
    
}
