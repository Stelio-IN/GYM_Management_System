package controller;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Funcionario;
import model.Pagamento_Mensalidade;
import model.Pessoa;
import model.Plano_de_Associacao;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Func_AddPlano_Controller implements Initializable {

    @FXML
    private TableColumn<Plano_de_Associacao, String> colunaNomePlano;

    @FXML
    private DatePicker dataPickerInicio;

    @FXML
    private ImageView imageViewAssociado;

    @FXML
    private TextField txtCodigoClienteAssociado;

    @FXML
    private TextField txtCodigoClientePrincipal;

    @FXML
    private TextField txtDuracaoPlano;

    @FXML
    private TextField txtGeneroClienteAssociado;

    @FXML
    private TextField txtGeneroClientePrincipal;

    @FXML
    private TextField txtNomeClienteAssociado;

    @FXML
    private TextField txtNomeClientePrincipal;

    @FXML
    private TextField txtNomePlano;

    @FXML
    private TextField txtObjectivoClienteAssociado;

    @FXML
    private TextField txtObjectivoClientePrincipal;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private TextField txtPrecoPlano;

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Cliente> listView;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TableView<Plano_de_Associacao> tabelaPlano;

    Cliente clienteNovosDados = new Cliente();
    Cliente clienteAssociadoNovosDados = new Cliente();
    Plano_de_Associacao planoSelecionado = new Plano_de_Associacao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ListarPlano();

        tabelaPlano.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> Tela_Func_AddPlano_Controller.this.pegarLinhaSelecionada(newValue)
        );
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada((Cliente) newValue)
        );

    }

    public void pegarLinhaSelecionada(Cliente cli) {
        if (cli != null) {
            clienteNovosDados = cli;
            txtNomeClientePrincipal.setText(cli.getNome());
            txtCodigoClientePrincipal.setText(cli.getCodigo());
            txtGeneroClientePrincipal.setText(cli.getGenero());
            if (cli.getPlano_de_associacao() != null) {
                txtObjectivoClientePrincipal.setText(cli.getPlano_de_associacao().getNome());
            }
            if (cli.getClinteAssociado() != null) {
                clienteAssociadoNovosDados = cli.getClinteAssociado();
                txtNomeClienteAssociado.setText(cli.getClinteAssociado().getNome());
                txtCodigoClienteAssociado.setText(cli.getClinteAssociado().getCodigo());
                txtGeneroClienteAssociado.setText(cli.getClinteAssociado().getGenero());
                if (cli.getClinteAssociado().getPlano_de_associacao() != null) {
                    txtObjectivoClienteAssociado.setText(cli.getClinteAssociado().getPlano_de_associacao().getNome());
                }
                if (cli.getClinteAssociado().getImagem() != null) {
                    // Converta o array de bytes em uma Image
                    byte[] imagemBytes = cli.getClinteAssociado().getImagem();
                    Image imagem = new Image(new ByteArrayInputStream(imagemBytes));
                    // Definir largura e altura desejadas
                    imageViewAssociado.setFitWidth(158); // Largura desejada
                    imageViewAssociado.setFitHeight(130); // Altura desejada
                    // Defina a imagem no ImageView
                    imageViewAssociado.setImage(imagem);
                } else {
                    JOptionPane.showMessageDialog(null, "imagem nao encontrada");
                }
            }
            if (cli.getImagem() != null) {
                // Converta o array de bytes em uma Image
                byte[] imagemBytes = cli.getImagem();
                Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                // Definir largura e altura desejadas
                imageView.setFitWidth(158); // Largura desejada
                imageView.setFitHeight(130); // Altura desejada
                // Defina a imagem no ImageView
                imageView.setImage(imagem);
            } else {
                JOptionPane.showMessageDialog(null, "imagem nao encontrada");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione alguem");
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

    private ObservableList< Plano_de_Associacao> observableListe;
    private ObservableList< Cliente> observableList;

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
        clienteAssociadoNovosDados.setPlano_de_associacao(plano);
        planoSelecionado = plano;
        if (plano != null) {
            txtNomePlano.setText(plano.getNome());
            txtPrecoPlano.setText(String.valueOf(plano.getPreco()));
        } else {
            JOptionPane.showMessageDialog(null, "Selecione Uma linha");
        }
    }

    @FXML
    void LimparCampos(ActionEvent event) {
        Image imageLimpar = new Image("/img/adicionar-usuario.png");
        imageView.setImage(imageLimpar);
        imageViewAssociado.setImage(imageLimpar);

        imageView.setFitWidth(158); // Largura desejada
        imageView.setFitHeight(130); // Altura desejada

        imageViewAssociado.setFitWidth(158); // Largura desejada
        imageViewAssociado.setFitHeight(130); // Altura desejada

        txtCodigoClientePrincipal.setText("");
        txtCodigoClienteAssociado.setText("");
        txtNomeClientePrincipal.setText("");
        txtNomeClienteAssociado.setText("");
        txtNomePlano.setText("");
        txtDuracaoPlano.setText("");
        txtNomeClienteAssociado.setText("");
        txtObjectivoClientePrincipal.setText("");
        txtObjectivoClienteAssociado.setText("");

        clienteNovosDados = null;
        clienteAssociadoNovosDados = null;

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
    void guardarPlano(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        if (clienteNovosDados != null && planoSelecionado != null) {
            Class<Cliente> classe = Cliente.class;
            LocalDate localDate = dataPickerInicio.getValue();
            ZoneId zoneId = ZoneId.systemDefault();
            Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());

            planoSelecionado.setDuracao(Integer.parseInt(txtDuracaoPlano.getText()));
            planoSelecionado.setDataInicio(date);
            planoSelecionado.setDuracaoEmMeses(planoSelecionado.getDuracao());
            planoSelecionado.setStatus(false);
            
            clienteNovosDados.setPlano_de_associacao(planoSelecionado);
            
            dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);

//            if (clienteAssociadoNovosDados != null) {
//                dao.Atualizar(classe, clienteAssociadoNovosDados.getId(), clienteAssociadoNovosDados);
//            }
            
            Pagamento_Mensalidade pagamento = new Pagamento_Mensalidade();
            pagamento.setCliente(clienteNovosDados);
            pagamento.setPlano_de_Associacao(planoSelecionado);
            pagamento.setValor(planoSelecionado.getPreco());
            
            dao.add(pagamento);
            
            
            JOptionPane.showMessageDialog(null, "Sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente e um plano antes de salvar.");
        }

    }
    private Funcionario funcionario = new Funcionario();
    private Pessoa pessoa; 
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        funcionario =(Funcionario) pessoa;
       // txtNomeFuncionario.setText(pessoa.getNome());
        // ... Configure outros campos conforme necessário
    }

}
