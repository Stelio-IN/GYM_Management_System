/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Pagamento_Mensalidade;
import model.Plano_de_Associacao;

/**
 * FXML Controller class
 *
 * @author $umeid_ibr
 */
public class Tela_Func_Pagamentos_Controller implements Initializable {

    @FXML
    private TableView<Pagamento_Mensalidade> tabela_Pagemento;

    @FXML
    private TableColumn<Pagamento_Mensalidade, String> coluna_Cliente;

    @FXML
    private TableColumn<Pagamento_Mensalidade, Long> coluna_ID;

    @FXML
    private TableColumn<Plano_de_Associacao, String> coluna_Pacote;

    @FXML
    private TableColumn<Pagamento_Mensalidade, Double> coluna_Valor;

   // @FXML
   // private TableColumn<Pagamento_Mensalidade, String> coluna_Funcionario;

    @FXML
    private ImageView emola;

    @FXML
    private ToggleGroup metodoPagamento;

    @FXML
    private ImageView mkesh;

    @FXML
    private ImageView mpesa;

    @FXML
    private TextField txtContacto;

    @FXML
    private TextField txtCvv;

    @FXML
    private TextField txtCvvCard;

    @FXML
    private TextField txtDataExpiracao;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtExpireDate;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNumberCard;

    @FXML
    private TextField txtNumeroCartao;

    @FXML
    private TextField txtTitular;

    @FXML
    private AnchorPane CartaoDeCredito;

    @FXML
    private Label lblData;

    @FXML
    private Label lblNumeroCartao;

    @FXML
    private Label lblTitular;

    @FXML
    private Label lblCvv;

    @FXML
    private Button btnPagamento;
        @FXML
    private TextField txtValor;

    public void EscritaSimultanea() {
        // NOME
        txtNome.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() < 7 && !newValue.matches(".*\\d.*")) {
                txtNome.setStyle("-fx-text-fill: red;");
            } else {
                txtNome.setStyle("");
            }
        });

        // primaryStage.setTitle("Real-Time TextField Synchronization Example");
        // Crie um binding bidirecional entre as TextFields
        Bindings.bindBidirectional(txtNumeroCartao.textProperty(), txtNumberCard.textProperty());
        Bindings.bindBidirectional(txtDataExpiracao.textProperty(), txtExpireDate.textProperty());
        Bindings.bindBidirectional(txtCvv.textProperty(), txtCvvCard.textProperty());

        // Inicializando com o mpesa selecionado
        mkesh.setVisible(false);
        emola.setVisible(false);

        lblData.setVisible(false);
        lblTitular.setVisible(false);
        lblNumeroCartao.setVisible(false);
        lblCvv.setVisible(false);

        txtDataExpiracao.setVisible(false);
        txtNumeroCartao.setVisible(false);
        txtTitular.setVisible(false);
        txtCvv.setVisible(false);
        CartaoDeCredito.setVisible(true);
        mkesh.setVisible(false);
        emola.setVisible(false);
        mpesa.setVisible(false);

    }

    @FXML
    void AtivarCartao(ActionEvent event) {
        CartaoDeCredito.setVisible(true);
        mkesh.setVisible(false);
        emola.setVisible(false);
        mpesa.setVisible(false);

        lblData.setVisible(true);
        lblTitular.setVisible(true);
        lblNumeroCartao.setVisible(true);
        lblCvv.setVisible(true);

        txtDataExpiracao.setVisible(true);
        txtNumeroCartao.setVisible(true);
        txtTitular.setVisible(true);
        txtCvv.setVisible(true);

        btnPagamento.setStyle(" -fx-background-color: linear-gradient(to right,  #0ac1758f, #055c36bb);");
    }

    @FXML
    void AtivarEmola(ActionEvent event) {
        emola.setVisible(true);
        mkesh.setVisible(false);
        mpesa.setVisible(false);
        CartaoDeCredito.setVisible(false);

        lblData.setVisible(false);
        lblTitular.setVisible(false);
        lblNumeroCartao.setVisible(false);
        lblCvv.setVisible(false);

        txtDataExpiracao.setVisible(false);
        txtNumeroCartao.setVisible(false);
        txtTitular.setVisible(false);
        txtCvv.setVisible(false);

        btnPagamento.setStyle(" -fx-background-color: linear-gradient(to right,  #fa7f45, #ae410e);");
    }

    @FXML
    void AtivarMkesh(ActionEvent event) {
        mkesh.setVisible(true);
        mpesa.setVisible(false);
        emola.setVisible(false);
        CartaoDeCredito.setVisible(false);

        lblData.setVisible(false);
        lblTitular.setVisible(false);
        lblNumeroCartao.setVisible(false);
        lblCvv.setVisible(false);

        txtDataExpiracao.setVisible(false);
        txtNumeroCartao.setVisible(false);
        txtTitular.setVisible(false);
        txtCvv.setVisible(false);

        btnPagamento.setStyle(" -fx-background-color: linear-gradient(to right,  #ffe95c, #8b7903e0);");
    }

    @FXML
    void AtivarMpesa(ActionEvent event) {
        mpesa.setVisible(true);
        mkesh.setVisible(false);
        emola.setVisible(false);
        CartaoDeCredito.setVisible(false);

        lblData.setVisible(false);
        lblTitular.setVisible(false);
        lblNumeroCartao.setVisible(false);
        lblCvv.setVisible(false);

        txtDataExpiracao.setVisible(false);
        txtNumeroCartao.setVisible(false);
        txtTitular.setVisible(false);
        txtCvv.setVisible(false);
        btnPagamento.setStyle("-fx-background-color: linear-gradient(to right,  #ff5c61, #8f060b);");
    }

//    private void retornarPagamentos(){
//        GenericDAO dao = new GenericDAO();
//        List<Pagamento_Mensalidade> lista = (List<Pagamento_Mensalidade>) dao.listar(Pagamento_Mensalidade.class);
//    }
    private ObservableList<Pagamento_Mensalidade> observableListe;

 void listar() {
        GenericDAO dao = new GenericDAO();

        
    Class<Pagamento_Mensalidade> pagamento_Classe = Pagamento_Mensalidade.class;
    List<Pagamento_Mensalidade> lista = (List<Pagamento_Mensalidade>) dao.listar(pagamento_Classe);

    // Filter the list to include only payments with status == false
    List<Pagamento_Mensalidade> filteredList = lista.stream()
            .filter(p -> !p.isStatus())  // Assuming isStatus() returns the boolean status
            .collect(Collectors.toList());

    coluna_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
    coluna_Cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
    coluna_Pacote.setCellValueFactory(new PropertyValueFactory<>("plano_de_Associacao"));
    coluna_Valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
  //  coluna_Funcionario.setCellValueFactory(new PropertyValueFactory<>("funcionario"));

    observableListe = FXCollections.observableArrayList(filteredList);
    tabela_Pagemento.setItems(observableListe);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EscritaSimultanea();
        listar();
    
        tabela_Pagemento.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
        );
    }

    private Cliente cliente = new  Cliente();
   GenericDAO dao = new GenericDAO();
   //   private Funcionario funcionario;
    private Pagamento_Mensalidade pagamento;
    
    
    @FXML
    void efetuarPagamento(ActionEvent event) {
        if (pagamento != null) {

            pagamento.setStatus(true);

            Cliente cliente = pagamento.getPlanoCliente().getCliente();
            
            cliente.getPlanoCliente().setStatus(true);
            
            dao.Atualizar(Cliente.class, cliente.getId(), cliente);
            dao.Atualizar(Pagamento_Mensalidade.class, pagamento.getId(), pagamento);
            JOptionPane.showMessageDialog(null, "Pago");
        } else {
            JOptionPane.showMessageDialog(null, "Fail");
        }
    }
    public void pegarLinhaSelecionada(Pagamento_Mensalidade factura) {
        if (factura != null) {
            pagamento = factura;
            cliente = factura.getPlanoCliente().getCliente();
            txtNome.setText(cliente.getNome());
            txtEmail.setText(cliente.getEmail());
            txtContacto.setText(cliente.getTelefone());
            txtValor.setText(factura.getValor().toString());
            //JOptionPane.showMessageDialog(null,"Stelio");       
        }
    }

}
