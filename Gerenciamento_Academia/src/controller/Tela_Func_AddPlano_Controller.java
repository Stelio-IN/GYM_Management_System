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
    Plano_de_Associacao planoClienteAssociado = new Plano_de_Associacao();
    Plano_de_Associacao planoCliente = new Plano_de_Associacao();

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
            if(cli.getPlano_de_associacao().getNome()!=null)
            txtObjectivoClientePrincipal.setText(cli.getPlano_de_associacao().getNome());

            if (cli.getClinteAssociado() != null) {
                clienteAssociadoNovosDados = cli.getClinteAssociado();
                txtNomeClienteAssociado.setText(cli.getClinteAssociado().getNome());
                txtCodigoClienteAssociado.setText(cli.getClinteAssociado().getCodigo());
                txtGeneroClienteAssociado.setText(cli.getClinteAssociado().getGenero());
                if(cli.getClinteAssociado().getPlano_de_associacao().getNome()!=null)
                txtObjectivoClienteAssociado.setText(cli.getClinteAssociado().getPlano_de_associacao().getNome());
                if (clienteAssociadoNovosDados.getPlano_de_associacao() != null) {
                    planoClienteAssociado = clienteAssociadoNovosDados.getPlano_de_associacao();
                }
                if (cli.getClinteAssociado().getImagem() != null) {
                    // Converta o array de bytes em uma Image
                    byte[] imagemBytes = cli.getClinteAssociado().getImagem();
                    Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                    // Definir largura e altura desejadas
                    imageViewAssociado.setFitWidth(79); // Largura desejada
                    imageViewAssociado.setFitHeight(93); // Altura desejada
                    // Defina a imagem no ImageView
                    imageViewAssociado.setImage(imagem);
                }
            }
            if (cli.getImagem() != null) {
                // Converta o array de bytes em uma Image
                byte[] imagemBytes = cli.getImagem();
                Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

                // Definir largura e altura desejadas
                imageView.setFitWidth(150); // Largura desejada
                imageView.setFitHeight(170); // Altura desejada
                // Defina a imagem no ImageView
                imageView.setImage(imagem);
            }
            if (cli.getPlano_de_associacao() != null) {
                planoCliente = cli.getPlano_de_associacao();
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
        }
    }

    @FXML
    void LimparCampos(ActionEvent event) {
        imageView.setImage(null);
        txtCodigoClientePrincipal.setText("");
        txtNomeClientePrincipal.setText("");
        txtNomePlano.setText("");
        txtDuracaoPlano.setText("");
        txtNomeClienteAssociado.setText("");
    }

    @FXML
    void RemoverPlano(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        Class<Cliente> classe = Cliente.class;

        if (clienteNovosDados != null && planoSelecionado != null && clienteAssociadoNovosDados != null) {
            clienteNovosDados.desvincularPlanoAtivo();
            dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);

        }
    }

    public boolean isPlanoVigente(Date dataInicio, Date dataTermino) {
        Date dataAtual = new Date(); // Obtenha a data atual

        // Verifique se a data atual está entre a data de início e a data de término
        return dataAtual.after(dataInicio) && dataAtual.before(dataTermino);
    }
    Class<Cliente> classe = Cliente.class;

    @FXML
    void guardarPlano(ActionEvent event) {
        GenericDAO dao = new GenericDAO();

        LocalDate localDate = dataPickerInicio.getValue();
        ZoneId zoneId = ZoneId.systemDefault();
        Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());

        if (planoSelecionado.getNome().equals("Plano Casal")) {
            if (clienteNovosDados != null && clienteAssociadoNovosDados
                    != null && planoCliente.equals(planoClienteAssociado)) {
                ///Metodo Importante para disveeicular plano fora da data

                if (!isPlanoVigente(planoCliente.getDataInicio(), planoCliente.getDataTermino())) {
                    clienteNovosDados.desvincularPlanoAtivo();
                    clienteAssociadoNovosDados.desvincularPlanoAtivo();

                    planoSelecionado.setDuracao(Integer.parseInt(txtDuracaoPlano.getText()));
                    planoSelecionado.setDataInicio(date);
                    planoSelecionado.setDuracaoEmMeses(planoSelecionado.getDuracao());

                    clienteAssociadoNovosDados.setPlano_de_associacao(planoSelecionado);
                    clienteNovosDados.setPlano_de_associacao(planoSelecionado);

                    dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);
                    dao.Atualizar(classe, clienteAssociadoNovosDados.getId(), clienteAssociadoNovosDados);

                }
            }
            JOptionPane.showMessageDialog(null, "Não cumpre com os requesitos");
        }
        if (clienteNovosDados.getPlano_de_associacao() == null || !isPlanoVigente(planoCliente.getDataInicio(), planoCliente.getDataTermino())) {

            planoSelecionado.setDuracao(Integer.parseInt(txtDuracaoPlano.getText()));
            planoSelecionado.setDataInicio(date);
            planoSelecionado.setDuracaoEmMeses(planoSelecionado.getDuracao());

            clienteNovosDados.setPlano_de_associacao(planoSelecionado);

            dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);

//            if (clienteAssociadoNovosDados != null) {
//                dao.Atualizar(classe, clienteAssociadoNovosDados.getId(), clienteAssociadoNovosDados);
//            }
            System.out.println(clienteNovosDados.toString());
            System.out.println(planoSelecionado.toString());
            JOptionPane.showMessageDialog(null, "Sucesso");

        }
    }

//    @FXML
//    void guardarPlano(ActionEvent event) {
//        GenericDAO dao = new GenericDAO();
//        if (clienteNovosDados != null && planoSelecionado != null) {
//            Class<Cliente> classe = Cliente.class;
//            LocalDate localDate = dataPickerInicio.getValue();
//            ZoneId zoneId = ZoneId.systemDefault();
//            Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
//
//            planoSelecionado.setDuracao(Integer.parseInt(txtDuracaoPlano.getText()));
//            planoSelecionado.setDataInicio(date);
//            planoSelecionado.setDuracaoEmMeses(planoSelecionado.getDuracao());
//
//            dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);
//
//            if (clienteAssociadoNovosDados != null) {
//                dao.Atualizar(classe, clienteAssociadoNovosDados.getId(), clienteAssociadoNovosDados);
//            }
//            System.out.println(clienteNovosDados.toString());
//            System.out.println(planoSelecionado.toString());
//            JOptionPane.showMessageDialog(null, "Sucesso");
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Selecione um cliente e um plano antes de salvar.");
//        }
//
//    }
}
