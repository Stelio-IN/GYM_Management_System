/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Pessoa;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Admin_Menu_Funcionarios_Controller implements Initializable {

    
    @FXML
    private TableView<Funcionario> tabela;

    @FXML
    private TableColumn<Funcionario, String> tabela_Cargo;

    @FXML
    private TableColumn<Funcionario, String> tabela_Codigo;

    @FXML
    private TableColumn<Funcionario, String> tabela_Email;

    @FXML
    private TableColumn<Funcionario, String> tabela_Nome;

    @FXML
    private TableColumn<Funcionario, String> tabela_Salario;

    @FXML
    private TableColumn<?, ?> tabela_Situacao;

   

    /*
    metodo que pega o cliks do botao
     */
    @FXML
    void listarPesquisa(KeyEvent event) {
        ///lista();
    }

    

  

    
    @FXML
    private TextField txtCargo;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtSalario;

    @FXML
    private TextField txtId;
    @FXML
    private TextArea txtArea;

    @FXML
    void cadastrar(ActionEvent event) {

        Funcionario func = new Funcionario();
        GenericDAO dao = new GenericDAO();
        func.setCargo(txtCargo.getText());
        func.setNome(txtNome.getText());
        func.setPassword(txtPassword.getText());
        func.setSalario(Double.valueOf(txtSalario.getText()));
        func.setCodigo(txtCodigo.getText());
        func.setEmail(txtEmail.getText());
        dao.add(func);

    }

    @FXML
    void editar(ActionEvent event) {

        Class<Pessoa> classe = Pessoa.class;
        Funcionario func = new Funcionario();
        GenericDAO dao = new GenericDAO();
        func.setId(Long.valueOf(txtId.getText()));
        func.setEmail(txtEmail.getText());
        func.setNome(txtNome.getText());
        func.setCodigo(txtCodigo.getText());
        func.setCargo(txtCargo.getText());
        func.setSalario(Double.valueOf(txtSalario.getText()));
        func.setPassword(txtPassword.getText());

        dao.Atualizar(classe, Long.valueOf(txtId.getText()), func);
        JOptionPane.showMessageDialog(null, "Atualizado COm sucesso");
        txtId.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtPassword.setText("");
        listar(event);
    }

    @FXML
    void excluir(ActionEvent event) {
        GenericDAO dao = new GenericDAO();

        Class<Funcionario> func_Classe = Funcionario.class;
        // dao.removerLogico(func_Classe, Long.valueOf(txtId.getText()), dao);
        dao.removeFisico(func_Classe, Long.valueOf(txtId.getText()));
        JOptionPane.showMessageDialog(null, "Removido COm sucesso");
        txtId.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtPassword.setText("");
        txtCargo.setText("");
        txtCodigo.setText("");
        txtSalario.setText("");
        listar(event);
    }

    private ObservableList<Funcionario> observableListe;

    @FXML
    void listar(ActionEvent event) {
        GenericDAO dao = new GenericDAO();

        Class<Funcionario> func_Classe = Funcionario.class;
        List<Funcionario> lista = (List<Funcionario>) dao.listar(func_Classe);

        tabela_Codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabela_Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabela_Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabela_Salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tabela_Cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        tabela_Situacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));

        observableListe = FXCollections.observableArrayList(lista);
        tabela.setItems(observableListe);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//           tabela.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue.getValue()));

        tabela.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
        );

        txtId.setDisable(true);

       

    }

    public void pegarLinhaSelecionada(Funcionario pessoa) {
        if (pessoa != null) {
            txtId.setText(pessoa.getId().toString());
            txtCodigo.setText(String.valueOf(pessoa.getCodigo()));
            txtEmail.setText(pessoa.getEmail());
            txtNome.setText(pessoa.getNome());
            txtCargo.setText(pessoa.getCargo());
            txtSalario.setText(pessoa.getSalario().toString());
            txtPassword.setText(pessoa.getPassword());

        } else {
            txtId.setText("");
            txtCodigo.setText("");
            txtEmail.setText("");
            txtNome.setText("");
            txtCargo.setText("");
            txtSalario.setText("");
            txtPassword.setText("");
        }
    }
}
