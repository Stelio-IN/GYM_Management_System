/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
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
import javax.swing.JOptionPane;
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
    void cadastrar(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        Equipamento equip = new Equipamento();
        equip.setNome(txtNome.getText());
        equip.setMarca(txtMarca.getText());
        equip.setModelo(txtModelo.getText());
        
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
    void editar(ActionEvent event) {
        Class<Equipamento> classe = Equipamento.class;
        GenericDAO dao = new GenericDAO();
        Equipamento equip = new Equipamento();
        equip.setId(Long.valueOf(txtId.getText()));
        equip.setNome(txtNome.getText());
        equip.setMarca(txtMarca.getText());
        equip.setModelo(txtModelo.getText());
        
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
         

     } else {
         txtId.setText("");
         txtNome.setText("");
         txtMarca.setText("");
         txtModelo.setText("");
         
     }
     }
    
}
