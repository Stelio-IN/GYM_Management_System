package controller;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
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
    private TableColumn<Cliente, Image> colunaImagem;

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
    @FXML
    private TextField txtConjuge;

    @FXML
    private TextField txtDuracao;
    @FXML
    private DatePicker dataPickerInicio;

    Cliente clienteNovosDados = new Cliente();
    Plano_de_Associacao planoSelecionado = new Plano_de_Associacao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listarClientes();
        ListarPlano();

        tabelaPlano.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> Tela_Func_AddPlano_Controller.this.pegarLinhaSelecionada(newValue)
        );

        tabelaCliente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
        );

    }

    private ObservableList< Plano_de_Associacao> observableListe;
    private ObservableList< Cliente> observableList;

    private void listarClientes() {
        GenericDAO dao = new GenericDAO();
        Class<Cliente> classe = Cliente.class;

        List<Cliente> lista = (List<Cliente>) dao.listar(classe);

        // Use FilteredList para filtrar a lista com base em um predicado
        FilteredList<Cliente> filteredList = new FilteredList<>(FXCollections.observableList(lista));

        // Define o predicado de filtro para incluir apenas clientes com plano ativo
        filteredList.setPredicate(cliente -> cliente.getPlano_de_associacao() == null);

        Platform.runLater(() -> {
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            // colunaImagem.setCellValueFactory(new PropertyValueFactory<>("imagem"));

              colunaImagem.setCellValueFactory(cellData -> {
                Image imagem = cellData.getValue().getImagemComoImage();
                return new SimpleObjectProperty<>(imagem);
            });
//            colunaImagem.setCellValueFactory(cellData -> {
//                byte[] imagemBytes = cellData.getValue().getImagem();
//                if (imagemBytes != null) {
//                    Image imagem = new Image(new ByteArrayInputStream(imagemBytes));
//                    return new SimpleObjectProperty<>(imagem);
//                } else {
//                    // Trate o caso em que a imagem está ausente, se necessário
//                    return new SimpleObjectProperty<>();
//                }
//            });

            observableList = FXCollections.observableArrayList(filteredList);
            tabelaCliente.setItems(observableList);
        });
    }

    public void pegarLinhaSelecionada(Cliente cli) {
        //   clienteNovosDados.setId(cli.getId());
        clienteNovosDados = cli;
        if (cli != null) {
            txtNome.setText(cli.getNome());
            txtCodigo.setText(String.valueOf(cli.getCodigo()));
            if (cli.getPlano_de_associacao() == null) {
                txtNomePlano.setText("");
            } else {
                txtNomePlano.setText(cli.getPlano_de_associacao().getNome());
            }

            if (cli.getImagem() != null) {
                byte[] imagemBytes = cli.getImagem();
                Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                imageView.setImage(imagem);
                imageView.setFitWidth(95); // Largura desejada
                imageView.setFitHeight(91); // Altura desejada
                imageView.setImage(imagem);
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
    void LimparCampos(ActionEvent event) {
        imageView.setImage(null);
        txtCodigo.setText("");
        txtNome.setText("");
        txtNomePlano.setText("");
        txtDuracao.setText("");
        txtConjuge.setText("");
    }

    @FXML
    void RemoverPlano(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        Class<Cliente> classe = Cliente.class;
        if (clienteNovosDados != null && planoSelecionado != null) {
            clienteNovosDados.desvincularPlanoAtivo();

            dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);

        }
    }

    @FXML
    void ListarClie_Planos(ActionEvent event) {
        listarClientes();
    }

    @FXML
    void guardarPlano(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        if (clienteNovosDados != null && planoSelecionado != null) {
            Class<Cliente> classe = Cliente.class;
            LocalDate localDate = dataPickerInicio.getValue();
            ZoneId zoneId = ZoneId.systemDefault();
            Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());

            planoSelecionado.setDuracao(Integer.parseInt(txtDuracao.getText()));
            planoSelecionado.setDataInicio(date);
            planoSelecionado.setDuracaoEmMeses(planoSelecionado.getDuracao());

            dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);

            System.out.println(clienteNovosDados.toString());
            System.out.println(planoSelecionado.toString());
            JOptionPane.showMessageDialog(null, "Sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente e um plano antes de salvar.");
        }

    }

}
