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
import model.Instrutor;
import model.Pessoa;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Admin_Menu_Instrutores_Controller implements Initializable {

    @FXML
    private TextField txtPesquisa;
    @FXML
    private TableView<Instrutor> tabela;

    @FXML
    private TableColumn<Instrutor, String> tabela_Especializacao;

    @FXML
    private TableColumn<Instrutor, String> tabela_Codigo;

    @FXML
    private TableColumn<Instrutor, String> tabela_Email;

    @FXML
    private TableColumn<Instrutor, String> tabela_Nome;

    @FXML
    private TableColumn<Instrutor, String> tabela_Salario;
    
    @FXML
    private TableColumn<Instrutor, String> tabela_Classificacao;

    @FXML
    private TableColumn<?, ?> tabela_Situacao;

    @FXML
    void pesquisar(ActionEvent event) {
        if (!txtPesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, txtPesquisa.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Campo de Texto Vazio");
        }
    }

    @FXML
    private TextField txtEspecializacao; // Representa a variavel String Especializacao

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
    private TextField txtClassificacao;

    @FXML
    void cadastrar(ActionEvent event) {
        
        Instrutor func = new Instrutor();
        GenericDAO dao = new GenericDAO();
        func.setEspecializacao(txtEspecializacao.getText());
        func.setNome(txtNome.getText());
        func.setPassword(txtPassword.getText());
        func.setSalario(Double.valueOf(txtSalario.getText()));
        func.setCodigo(txtCodigo.getText());
        func.setEmail(txtEmail.getText());
        func.setClassificacao(Double.valueOf(txtClassificacao.getText()));
        dao.add(func);

    }

    @FXML
    void editar(ActionEvent event) {
        
        Class<Pessoa> classe = Pessoa.class;
        Instrutor func = new Instrutor();
        GenericDAO dao = new GenericDAO();
        func.setId(Long.valueOf(txtId.getText()));
        func.setEmail(txtEmail.getText());
        func.setNome(txtNome.getText());
        func.setCodigo(txtCodigo.getText());
        func.setEspecializacao(String.valueOf(txtEspecializacao.getText()));
        func.setSalario(Double.valueOf(txtSalario.getText()));
        func.setPassword(txtPassword.getText());
        func.setClassificacao(Double.valueOf(txtClassificacao.getText()));

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

        Class<Instrutor> func_Classe = Instrutor.class;
        // dao.removerLogico(func_Classe, Long.valueOf(txtId.getText()), dao);
        dao.removeFisico(func_Classe, Long.valueOf(txtId.getText()));
        JOptionPane.showMessageDialog(null, "Removido COm sucesso");
        txtId.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtPassword.setText("");
        txtEspecializacao.setText("");
        txtCodigo.setText("");
        txtSalario.setText("");
        txtClassificacao.setText("");
        listar(event);
    }

    private ObservableList<Instrutor> observableListe;

    @FXML
    void listar(ActionEvent event) {
        GenericDAO dao = new GenericDAO();

        Class<Instrutor> func_Classe = Instrutor.class;
        List<Instrutor> lista = (List<Instrutor>) dao.listar(func_Classe);

        tabela_Codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabela_Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabela_Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabela_Salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tabela_Especializacao.setCellValueFactory(new PropertyValueFactory<>("Especializacao"));
        //tabela_Situacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        tabela_Classificacao.setCellValueFactory(new PropertyValueFactory<>("Classificacao"));

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

    public void pegarLinhaSelecionada(Instrutor pessoa) {
        if (pessoa != null) {
            txtId.setText(pessoa.getId().toString());
            txtCodigo.setText(String.valueOf(pessoa.getCodigo()));
            txtEmail.setText(pessoa.getEmail());
            txtNome.setText(pessoa.getNome());
            txtEspecializacao.setText(pessoa.getEspecializacao());
            txtSalario.setText(pessoa.getSalario().toString());
            txtPassword.setText(pessoa.getPassword());
            txtClassificacao.setText(pessoa.getClassificacao().toString());

        } else {
            txtId.setText("");
            txtCodigo.setText("");
            txtEmail.setText("");
            txtNome.setText("");
            txtEspecializacao.setText("");
            txtSalario.setText("");
            txtPassword.setText("");
            txtClassificacao.setText("");
        }
    }
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
    
}
