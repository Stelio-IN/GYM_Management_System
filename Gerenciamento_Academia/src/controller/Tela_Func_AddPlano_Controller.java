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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Plano_de_Associacao;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Func_AddPlano_Controller implements Initializable {

    @FXML
    private TableColumn<Cliente, String> colunaCodigo;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaPlano;

    @FXML
    private TableColumn<Plano_de_Associacao, String> colunaNomePlano;

    @FXML
    private TableColumn<Cliente, String> colunaSituacao;

    @FXML
    private ImageView imageView;

    @FXML
    private TableView<Cliente> tabelaCliente;

    @FXML
    private TableView<Plano_de_Associacao> tabelaPlano;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNomePlano;

    Cliente clienteNovosDados = new Cliente();
    Plano_de_Associacao planoSelecionado = new Plano_de_Associacao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Listar();
        ListarPlano();
        tabelaCliente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
        );
        tabelaPlano.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
        );
    }

    private ObservableList< Plano_de_Associacao> observableListe;
    private ObservableList< Cliente> observableList;

    private void Listar() {
        GenericDAO dao = new GenericDAO();
        Class<Cliente> classe = Cliente.class;

        List<Cliente> lista = (List<Cliente>) dao.listar(classe);

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaSituacao.setCellValueFactory(new PropertyValueFactory<>("objectivo"));
        colunaPlano.setCellValueFactory(new PropertyValueFactory<>("esporte_que_Pratica"));

        observableList = FXCollections.observableArrayList(lista);
        tabelaCliente.setItems(observableList);
    }

    public void pegarLinhaSelecionada(Cliente cli) {
        //   clienteNovosDados.setId(cli.getId());
        clienteNovosDados = cli;
        if (cli != null) {
            txtNome.setText(cli.getNome());
            txtCodigo.setText(String.valueOf(cli.getCodigo()));
            if (cli.getPlano_de_associacao().getNome() == null) {
                txtNomePlano.setText("");
            } else {
                txtNomePlano.setText(cli.getPlano_de_associacao().getNome());
            }

            if (cli.getImagem() != null) {
                // Converta o array de bytes em uma Image
                byte[] imagemBytes = cli.getImagem();
                Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                // Defina a imagem no ImageView
                imageView.setImage(imagem);
                imageView.setFitWidth(95); // Largura desejada
                imageView.setFitHeight(91); // Altura desejada
            } else {
                JOptionPane.showMessageDialog(null, "imagem nao encontrada");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione Uma linha");
        }
    }

    private void ListarPlano() {
        GenericDAO dao = new GenericDAO();
        Class<Plano_de_Associacao> classe = Plano_de_Associacao.class;

        List<Plano_de_Associacao> lista = (List<Plano_de_Associacao>) dao.listar(classe);

        colunaNomePlano.setCellValueFactory(new PropertyValueFactory<>("nome"));

        observableListe = FXCollections.observableArrayList(lista);
        tabelaPlano.setItems(observableListe);
    }

    public void pegarLinhaSelecionada(Plano_de_Associacao plano) {
        clienteNovosDados.setPlano_de_associacao(plano);
        planoSelecionado = plano;
        if (plano != null) {
            txtNomePlano.setText(plano.getNome());

        } else {
            JOptionPane.showMessageDialog(null, "Selecione Uma linha");
        }
    }

    @FXML
    void guardarPlano(ActionEvent event) {
        if (clienteNovosDados != null && planoSelecionado != null) {
            Class<Cliente> classe = Cliente.class;
            GenericDAO dao = new GenericDAO();
            dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);

            System.out.println(clienteNovosDados.toString());
            JOptionPane.showMessageDialog(null, "Sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente e um plano antes de salvar.");
        }
        Listar();
        ListarPlano();
    }

}
