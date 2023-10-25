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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Func_Associar_Clientes_Controller implements Initializable {

    @FXML
    private ImageView imageViewPrimeiro;

    @FXML
    private ImageView imageViewPrimeiroAssociado;

    @FXML
    private ImageView imageViewSegundoAssociado;
    @FXML
    private ImageView imageViewSegundo;

    @FXML
    private ListView<Cliente> listView;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField txtCodigoPrimeiroCliente;

    @FXML
    private TextField txtCodigoSegundoCliente;

    @FXML
    private TextField txtGeneroPrimeiroCliente;

    @FXML
    private TextField txtGeneroSegundoCliente;

    @FXML
    private TextField txtNomePrimeiroAssociado;

    @FXML
    private TextField txtNomePrimeiroCliente;

    @FXML
    private TextField txtNomeSegundoAssociado;

    @FXML
    private TextField txtNomeSegundoCliente;

    @FXML
    private TextField txtPesquisa;

    public void pegarLinhaSelecionada(Cliente cli) {
        if (cli != null) {
            if (txtNomePrimeiroCliente.getText().equals("")) {

                txtNomePrimeiroCliente.setText(cli.getNome());
                txtCodigoPrimeiroCliente.setText(cli.getCodigo());
                txtGeneroPrimeiroCliente.setText(cli.getGenero());

                if (cli.getClinteAssociado() != null) {
                    txtNomePrimeiroAssociado.setText(cli.getClinteAssociado().getNome());
                    if (cli.getClinteAssociado().getImagem() != null) {
                        // Converta o array de bytes em uma Image
                        byte[] imagemBytes = cli.getImagem();
                        Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                        // Definir largura e altura desejadas
                        imageViewPrimeiroAssociado.setFitWidth(79); // Largura desejada
                        imageViewPrimeiroAssociado.setFitHeight(93); // Altura desejada
                        // Defina a imagem no ImageView
                        imageViewPrimeiroAssociado.setImage(imagem);
                    } else {
                        JOptionPane.showMessageDialog(null, "imagem nao encontrada");
                    }
                }
                if (cli.getImagem() != null) {
                    // Converta o array de bytes em uma Image
                    byte[] imagemBytes = cli.getImagem();
                    Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                    // Definir largura e altura desejadas
                    imageViewPrimeiro.setFitWidth(79); // Largura desejada
                    imageViewPrimeiro.setFitHeight(93); // Altura desejada
                    // Defina a imagem no ImageView
                    imageViewPrimeiro.setImage(imagem);
                } else {
                    JOptionPane.showMessageDialog(null, "imagem nao encontrada");
                }
            } else  if ((txtCodigoPrimeiroCliente.getText().equals(cli.getCodigo())==false) && (txtGeneroPrimeiroCliente.getText().equals(cli.getGenero()))==false) {
                txtNomeSegundoCliente.setText(cli.getNome());
                txtCodigoSegundoCliente.setText(cli.getCodigo());
                txtGeneroSegundoCliente.setText(cli.getGenero());

                if (cli.getClinteAssociado() != null) {
                    txtNomeSegundoAssociado.setText(cli.getClinteAssociado().getNome());
                    if (cli.getClinteAssociado().getImagem() != null) {
                        // Converta o array de bytes em uma Image
                        byte[] imagemBytes = cli.getImagem();
                        Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                        // Definir largura e altura desejadas
                        imageViewSegundoAssociado.setFitWidth(79); // Largura desejada
                        imageViewSegundoAssociado.setFitHeight(93); // Altura desejada
                        // Defina a imagem no ImageView
                        imageViewSegundoAssociado.setImage(imagem);
                    } else {
                        JOptionPane.showMessageDialog(null, "imagem nao encontrada");
                    }
                }
                if (cli.getImagem() != null) {
                    // Converta o array de bytes em uma Image
                    byte[] imagemBytes = cli.getImagem();
                    Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                    // Definir largura e altura desejadas
                    imageViewSegundo.setFitWidth(99); // Largura desejada
                    imageViewSegundo.setFitHeight(113); // Altura desejada
                    // Defina a imagem no ImageView
                    imageViewSegundo.setImage(imagem);
                } else {
                    JOptionPane.showMessageDialog(null, "imagem nao encontrada");
                }
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
        //expressao Lapda
        listView.setCellFactory((ListView<Cliente> param) -> new ListCell<Cliente>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNome());
                }
            }
        });

        gerente.close(); // Não se esqueça de fechar o EntityManager quando terminar
        fabrica.close(); // E a EntityManagerFactory também
    }

    @FXML
    void listarPesquisa(KeyEvent event) {
        listaPesquisa();
    }

    @FXML
    void AssociarClientes(ActionEvent event) {

    }

    @FXML
    void desassociarClientes(ActionEvent event) {

    }

    @FXML
    void limparCampos(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada((Cliente) newValue)
        );
    }

}
