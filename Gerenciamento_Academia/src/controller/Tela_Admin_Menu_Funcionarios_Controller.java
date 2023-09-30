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
    private TextField txtPesquisa;
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

    @FXML
    private ScrollPane scrollPane;

    /*
    metodo que pega o cliks do botao
     */
    @FXML
    void listarPesquisa(KeyEvent event) {
        lista();
    }

    /*
    metodo que cria a lista de busca!
     */
    void lista() {
        EntityManagerFactory fabrica;
        EntityManager gerente;
        fabrica = Persistence.createEntityManagerFactory("SystemPU");
        gerente = fabrica.createEntityManager();

        ObservableList<Pessoa> items = FXCollections.observableArrayList(); // Crie uma ObservableList de Pessoa

        TypedQuery<Pessoa> query = gerente.createNamedQuery("Pessoa.findByName", Pessoa.class);
        query.setParameter("nome", "%" + txtPesquisa.getText() + "%"); // O operador % é usado para consultas "LIKE"
        List<Pessoa> resultados = query.getResultList();

        items.addAll(resultados); // Adicione objetos Pessoa à lista

        listView.setItems(items); // Defina a ObservableList de objetos Pessoa no ListView

        // Defina a célula personalizada para mostrar apenas o nome na lista
        listView.setCellFactory(new Callback<ListView<Pessoa>, ListCell<Pessoa>>() {
            public ListCell<Pessoa> call(ListView<Pessoa> param) {
                return new ListCell<Pessoa>() {
                    protected void updateItem(Pessoa item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getNome());
                        }
                    }
                };
            }
        });

        gerente.close(); // Não se esqueça de fechar o EntityManager quando terminar
        fabrica.close(); // E a EntityManagerFactory também
    }

    @FXML
    void pesquisar(ActionEvent event) {
//        if (!txtPesquisa.getText().isEmpty()) {
//            GenericDAO dao = new GenericDAO();
//            List<Pessoa> pessoas = dao.buscarPessoasPorNome(txtPesquisa.getText());
//
//            ObservableList<Pessoa> nomes = FXCollections.observableArrayList();
//
//            for (Pessoa pessoa : pessoas) {
//                nomes.add(pessoa.getNome());
//            }
//
//            if (!nomes.isEmpty()) {
//                listView.setItems(nomes); // Configurar o modelo de dados no ListView
//            } else {
//                JOptionPane.showMessageDialog(null, "Nenhum nome de pessoa encontrado.");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Campo de Texto Vazio");
//        }
    }

    @FXML
    private ListView<Pessoa> listView;
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

        /*
        controlar a visibilidade do scroll Pane 
        */
        //   scrollPane.setVisible(false);
        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                scrollPane.setVisible(false);
            } else {
                scrollPane.setVisible(true);
                lista(); // Chame a função lista() para atualizar os resultados
            }
        });

        /*
        Metodo para setar os valores da busca google 
        */
        // Configurar um evento de seleção para o ListView
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada((Funcionario) newValue)
        );

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
