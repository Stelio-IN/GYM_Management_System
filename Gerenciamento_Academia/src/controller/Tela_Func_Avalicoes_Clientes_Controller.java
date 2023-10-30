/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import model.Avaliacoes_Fisicas;
import model.Cliente;
import model.Funcionario;
import model.Instrutor;
import model.Notificacao;
import model.Pessoa;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Func_Avalicoes_Clientes_Controller implements Initializable {

    @FXML
    private ListView<Cliente> listView;

    @FXML
    private ImageView imageView;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private TableColumn<Instrutor, String> colunaCodigo;

    @FXML
    private TableColumn<Instrutor, String> colunaNome;

    @FXML
    private TableView<Instrutor> tabelaInstrutor;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextArea txtAreaDiscricao;

    @FXML
    private TextField txtBraco;

    @FXML
    private TextField txtCap_Vascular;

    @FXML
    private TextField txtCodigoCliente;

    @FXML
    private TextField txtCoxa;

    @FXML
    private TextField txtForca_Muscular;

    @FXML
    private TextField txtIndi_Mass_Corp;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtNomeFuncionario;

    @FXML
    private TextField txtNomeInstrutor;

    @FXML
    private TextField txtNotaFinal;

    @FXML
    private TextField txtPanturrilha;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtQuadril;

    @FXML
    private TextField txtPeito;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                scrollPane.setVisible(false);
            } else {
                scrollPane.setVisible(true);
                //               listaPesquisa(); // Chame a função listaPesquisa() para atualizar os resultados
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada((Cliente) newValue)
        );
        tabelaInstrutor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
        );

        listarInstrutores();
        txtNomeCliente.setEditable(false);
        txtNomeFuncionario.setEditable(false);
        txtNomeInstrutor.setEditable(false);
        txtIndi_Mass_Corp.setEditable(false);
    }

    @FXML
    void LimparCampos(ActionEvent event) {
        txtAltura.setText("");
        txtAreaDiscricao.setText("");
        txtBraco.setText("");
        txtCap_Vascular.setText("");
        txtCodigoCliente.setText("");
        txtCoxa.setText("");
        txtForca_Muscular.setText("");
        txtIndi_Mass_Corp.setText("");
        txtNomeCliente.setText("");
   
        txtNomeInstrutor.setText("");
        txtNotaFinal.setText("");
        txtPanturrilha.setText("");
        txtPeso.setText("");
        txtQuadril.setText("");
        txtPeito.setText("");

    }

    Cliente cliente = new Cliente();
    Instrutor instrutor = new Instrutor();
    Funcionario funcionario = new Funcionario();

    @FXML
    void gravarAvaliacao(ActionEvent event) {
        Avaliacoes_Fisicas avaliacao = new Avaliacoes_Fisicas();
        GenericDAO dao = new GenericDAO();
       
        
        avaliacao.setCliente(cliente);
        avaliacao.setInstrutor(instrutor);
        avaliacao.setFuncionario(funcionario);
        avaliacao.setAltura(Double.valueOf(txtAltura.getText()));
        avaliacao.setPeso(Double.valueOf(txtPeso.getText()));
        avaliacao.setIndice_Massa_corporal(avaliacao.calcularIMC());
        
        avaliacao.setCapacidade_cardiovascular(Double.valueOf(txtCap_Vascular.getText()));
        avaliacao.setCircunferência_braco(Double.valueOf(txtBraco.getText()));
        avaliacao.setCircunferência_coxa(Double.valueOf(txtCoxa.getText()));
        avaliacao.setCircunferência_panturrilha(Double.valueOf(txtPanturrilha.getText()));
        avaliacao.setCircunferência_quadril(Double.valueOf(txtQuadril.getText()));
        avaliacao.setCircunferência_peito(Double.valueOf(txtPeito.getText()));
        avaliacao.setNota_da_avaliacao(Double.valueOf(txtNotaFinal.getText()));
        avaliacao.setDiscricao_comentarios(txtAreaDiscricao.getText());
        
        dao.add(avaliacao);
        
        
        //Limpar os campos
        LimparCampos(event);
        
        Notificacao notificacao = new Notificacao();
        notificacao.setCliente(cliente);
        notificacao.setMensagem("Realizacao de Avaliacao");
        notificacao.setStatus(true);
        dao.add(avaliacao);
        
        
    }

    @FXML
    void listarPesquisa(KeyEvent event) {
        listaPesquisa();
    }

    public void pegarLinhaSelecionada(Cliente cli) {
        if (cli != null) {
            cliente = cli;
            txtCodigoCliente.setText(cli.getCodigo());
            txtNomeCliente.setText(cli.getNome());
            if (cli.getImagem() != null) {
                // Converta o array de bytes em uma Image
                byte[] imagemBytes = cli.getImagem();
                Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                // Definir largura e altura desejadas
                imageView.setFitWidth(120); // Largura desejada
                imageView.setFitHeight(143); // Altura desejada
                // Defina a imagem no ImageView
                imageView.setImage(imagem);
            }

        }
    }

    public void listaPesquisa() {
        EntityManagerFactory fabrica;
        EntityManager gerente;
        fabrica = Persistence.createEntityManagerFactory("SystemPU");
        gerente = fabrica.createEntityManager();

        ObservableList<Cliente> items = FXCollections.observableArrayList(); // Crie uma ObservableList de Cliente

        TypedQuery<Cliente> query = gerente.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class);
        query.setParameter("nome", "%" + txtPesquisa.getText() + "%"); // O operador % é usado para consultas "LIKE"
        List<Cliente> resultados = query.getResultList();

        items.addAll(resultados); // Adicione objetos Cliente à listaPesquisa

        listView.setItems(items); // Defina a ObservableList de objetos Cliente no ListView

        // Defina a célula personalizada para mostrar apenas o nome na listaPesquisa
        listView.setCellFactory(new Callback<ListView<Cliente>, ListCell<Cliente>>() {
            @Override
            public ListCell<Cliente> call(ListView<Cliente> param) {
                return new ListCell<Cliente>() {
                    @Override
                    protected void updateItem(Cliente item, boolean empty) {
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

    private ObservableList<Instrutor> observableListe;

    private void listarInstrutores() {
        GenericDAO dao = new GenericDAO();

        Class<Instrutor> Instr_Classe = Instrutor.class;
        List<Instrutor> lista = (List<Instrutor>) dao.listar(Instr_Classe);

        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        observableListe = FXCollections.observableArrayList(lista);
        tabelaInstrutor.setItems(observableListe);
    }

    public void pegarLinhaSelecionada(Instrutor pessoa) {
        if (pessoa != null) {
            instrutor = pessoa;  
            txtNomeInstrutor.setText(pessoa.getNome());
        } 
    }
    
    private Pessoa pessoa; 

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        funcionario =(Funcionario) pessoa;
        txtNomeFuncionario.setText(pessoa.getNome());
        // ... Configure outros campos conforme necessário
    }

}
