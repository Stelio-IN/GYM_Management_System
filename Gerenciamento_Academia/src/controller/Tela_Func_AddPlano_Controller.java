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
import model.Pagamento_Mensalidade;
import model.PlanoCliente;
import model.Plano_de_Associacao;

public class Tela_Func_AddPlano_Controller implements Initializable {

    @FXML
    private TableColumn<PlanoCliente, String> colunaNomePlano;

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
    private TextField txtNomePlanoClienteAssociado;

    @FXML
    private TextField txtNomePlanoClientePrincipal;

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

    @FXML
    private TextField txtStatusClienteAssociado;

    @FXML
    private TextField txtStatusClientePrincipal;
    
    @FXML
    private TextField txtDataFimClienteAssociado;

    @FXML
    private TextField txtDataFimClientePrincipal;

    @FXML
    private TextField txtDataIniClienteAssociado;

    @FXML
    private TextField txtDataIniClientePrincipal;
    
    Cliente clienteNovosDados = new Cliente();
    Cliente clienteAssociadoNovosDados = new Cliente();
    PlanoCliente planoSelecionado = new PlanoCliente();
    Plano_de_Associacao planoAssociacaoAtualizar = new Plano_de_Associacao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListarPlano();

        tabelaPlano.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
        );
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada((Cliente) newValue)
        );

        clienteNovosDados = null;
        clienteAssociadoNovosDados = null;
        planoSelecionado = null;
        planoAssociacaoAtualizar = null;
    }

    public void pegarLinhaSelecionada(Cliente cli) {
        clienteNovosDados = null;
        clienteAssociadoNovosDados = null;
        if (cli != null) {
            clienteNovosDados = cli;
            txtNomeClientePrincipal.setText(clienteNovosDados.getNome());
            txtCodigoClientePrincipal.setText(clienteNovosDados.getCodigo());
            txtGeneroClientePrincipal.setText(clienteNovosDados.getGenero());
            if (clienteNovosDados.getPlanoCliente() != null) {
                txtNomePlanoClientePrincipal.setText(clienteNovosDados.getPlanoCliente().getPlano().getNome());
                txtStatusClientePrincipal.setText(clienteNovosDados.getPlanoCliente().isStatus() ? "Activo" : "Inactivo");
                txtDataIniClientePrincipal.setText(clienteNovosDados.getPlanoCliente().getDataInicio().toString());
                txtDataFimClientePrincipal.setText(clienteNovosDados.getPlanoCliente().getDataFim().toString());
            }else{
                txtNomePlanoClientePrincipal.setText("");
                txtStatusClientePrincipal.setText("");
                txtDataIniClientePrincipal.setText("");
                txtDataFimClientePrincipal.setText("");
            }
            if (clienteNovosDados.getImagem() != null) {
                byte[] imagemBytes = clienteNovosDados.getImagem();
                Image imagem = new Image(new ByteArrayInputStream(imagemBytes));
                imageView.setFitWidth(158);
                imageView.setFitHeight(130);
                imageView.setImage(imagem);
            } else {
                JOptionPane.showMessageDialog(null, "imagem nao encontrada");
            }
            if (cli.getClinteAssociado() != null) {
                clienteAssociadoNovosDados = cli.getClinteAssociado();
                txtNomeClienteAssociado.setText(clienteAssociadoNovosDados.getNome());
                txtCodigoClienteAssociado.setText(clienteAssociadoNovosDados.getCodigo());
                txtGeneroClienteAssociado.setText(clienteAssociadoNovosDados.getGenero());
                if (clienteAssociadoNovosDados.getPlanoCliente() != null) {
                    txtNomePlanoClienteAssociado.setText(clienteAssociadoNovosDados.getPlanoCliente().getPlano().getNome());
                    txtStatusClienteAssociado.setText(clienteAssociadoNovosDados.getPlanoCliente().isStatus() ? "Activo" : "Inactivo");
                    txtDataIniClienteAssociado.setText(clienteAssociadoNovosDados.getPlanoCliente().getDataInicio().toString());
                    txtDataFimClienteAssociado.setText(clienteAssociadoNovosDados.getPlanoCliente().getDataFim().toString());
                }else{
                    txtNomePlanoClienteAssociado.setText("");
                    txtStatusClienteAssociado.setText("");
                    txtDataIniClienteAssociado.setText("");
                    txtDataFimClienteAssociado.setText("");
               }
                if (clienteAssociadoNovosDados.getImagem() != null) {
                    byte[] imagemBytes = clienteAssociadoNovosDados.getImagem();
                    Image imagem = new Image(new ByteArrayInputStream(imagemBytes));
                    imageViewAssociado.setFitWidth(158);
                    imageViewAssociado.setFitHeight(130);
                    imageViewAssociado.setImage(imagem);
                } else {
                    JOptionPane.showMessageDialog(null, "imagem nao encontrada");
                }
            }
        } else {
          //  JOptionPane.showMessageDialog(null, "Selecione alguém");
        }
    }

    public void listaPesquisa() {
        EntityManagerFactory fabrica;
        EntityManager gerente;
        fabrica = Persistence.createEntityManagerFactory("SystemPU");
        gerente = fabrica.createEntityManager();

        ObservableList<Cliente> items = FXCollections.observableArrayList();

        TypedQuery<Cliente> query = gerente.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class);
        query.setParameter("nome", "%" + txtPesquisa.getText() + "%");
        List<Cliente> resultados = query.getResultList();

        items.addAll(resultados);

        listView.setItems(items);

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

        gerente.close();
        fabrica.close();
    }

    @FXML
    void listarPesquisa(KeyEvent event) {
        listaPesquisa();
    }

    private ObservableList<Plano_de_Associacao> observableListPlano;
    private ObservableList<Cliente> observableListCliente;

    private void ListarPlano() {
        GenericDAO dao = new GenericDAO();
        Class<Plano_de_Associacao> classePlano = Plano_de_Associacao.class;

        List<Plano_de_Associacao> lista = (List<Plano_de_Associacao>) dao.listar(classePlano);

        colunaNomePlano.setCellValueFactory(new PropertyValueFactory<>("nome"));

        observableListPlano = FXCollections.observableArrayList(lista);
        tabelaPlano.setItems(observableListPlano);
    }

    public void pegarLinhaSelecionada(Plano_de_Associacao plano) {
        if (plano != null) {
            PlanoCliente planoCliente = new PlanoCliente();
            planoCliente.setPlano(plano);
            planoAssociacaoAtualizar = plano;
            planoSelecionado = planoCliente;
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

        imageView.setFitWidth(158);
        imageView.setFitHeight(130);

        imageViewAssociado.setFitWidth(158);
        imageViewAssociado.setFitHeight(130);

        txtCodigoClientePrincipal.setText("");
        txtCodigoClienteAssociado.setText("");
        txtNomeClientePrincipal.setText("");
        txtNomeClienteAssociado.setText("");
        txtNomePlano.setText("");
        txtDuracaoPlano.setText("");
        txtNomeClienteAssociado.setText("");
        txtNomePlanoClientePrincipal.setText("");
        txtNomePlanoClienteAssociado.setText("");
        txtGeneroClientePrincipal.setText("");
        txtGeneroClienteAssociado.setText("");
        txtPrecoPlano.setText("");
        txtStatusClienteAssociado.setText("");
        txtStatusClientePrincipal.setText("");
        txtDataIniClientePrincipal.setText("");
        txtDataFimClientePrincipal.setText("");
        txtDataIniClienteAssociado.setText("");
        txtDataFimClienteAssociado.setText("");

        clienteNovosDados = null;
        clienteAssociadoNovosDados = null;
        planoSelecionado = null;
        planoAssociacaoAtualizar = null;
    }

    @FXML
    void RemoverPlano(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        Class<Cliente> classe = Cliente.class;
        if (clienteNovosDados != null && clienteNovosDados.getPlanoCliente() != null) {
            if (clienteNovosDados.getPlanoCliente().isStatus() == true) {
                clienteNovosDados.getPlanoCliente().setStatus(false);
                dao.Atualizar(classe, clienteNovosDados.getId(), clienteNovosDados);
                JOptionPane.showMessageDialog(null, "Plano Removido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossivel remover Plano");
        }
    }

    @FXML
    void guardarPlano(ActionEvent event) {
        GenericDAO dao = new GenericDAO();
        double valor = 0;
        Pagamento_Mensalidade pagamento = new Pagamento_Mensalidade();
        Class<Cliente> classeCliente = Cliente.class;
        Class<PlanoCliente> classePlano = PlanoCliente.class;

        if (clienteNovosDados != null && planoSelecionado != null && dataPickerInicio.getValue() != null
                && !txtDuracaoPlano.getText().isEmpty()) {

            LocalDate localDate = dataPickerInicio.getValue();
            ZoneId zoneId = ZoneId.systemDefault();
            Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
            planoSelecionado.setCliente(clienteNovosDados);
            planoSelecionado.setDuracao(Integer.parseInt(txtDuracaoPlano.getText()));
            planoSelecionado.setDataInicio(date);
            planoSelecionado.setDuracaoEmMeses(planoSelecionado.getDuracao());
            planoSelecionado.setStatus(false);
            pagamento.setPlanoCliente(planoSelecionado);
            valor = planoSelecionado.getPlano().getPreco() * Integer.valueOf(txtDuracaoPlano.getText());
            pagamento.setSituacao("Pendente");
            pagamento.setValor(valor);

            if (!planoSelecionado.getPlano().getNome().equals("Plano Casal")) {
                if (clienteNovosDados.getPlanoCliente() != null) {
                    if (clienteNovosDados.getPlanoCliente().isStatus() == false) {
                        clienteNovosDados.getPlanoCliente().setPlano(planoAssociacaoAtualizar);
                        dao.Atualizar(classeCliente, clienteNovosDados.getId(), clienteNovosDados);
                        pagamento.setPlanoCliente(clienteNovosDados.getPlanoCliente());
                        pagamento.setSituacao("Pendente");
                        dao.add(pagamento);
                        JOptionPane.showMessageDialog(null, "Sucesso ao adicionar plano Total a pagar: " + valor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente com plano: " + clienteNovosDados.getPlanoCliente().getPlano().getNome() + "__ Estado: " + clienteNovosDados.getPlanoCliente().isStatus());
                    }
                } else {
                    dao.add(planoSelecionado);
                    dao.add(pagamento);
                    clienteNovosDados.setPlanoCliente(planoSelecionado);
                    dao.Atualizar(classeCliente, clienteNovosDados.getId(), clienteNovosDados);
                    JOptionPane.showMessageDialog(null, "Sucesso ao adicionar plano Total a pagar: " + valor);
                }
            }

            if (planoSelecionado.getPlano().getNome().equals("Plano Casal")) {
                if (clienteAssociadoNovosDados != null) {
                    if (clienteNovosDados.getPlanoCliente() == null && clienteAssociadoNovosDados.getPlanoCliente() == null) {
                        // Nenhum dos clientes tem planos associados, você pode associá-los ao Plano Casal

                        // Crie um PlanoCliente para o cliente principal
                        PlanoCliente planoClienteNovo = new PlanoCliente();
                        planoClienteNovo.setCliente(clienteNovosDados);
                        planoClienteNovo.setPlano(planoAssociacaoAtualizar);
                        planoClienteNovo.setDuracao(planoSelecionado.getDuracao());
                        planoClienteNovo.setDataInicio(planoSelecionado.getDataInicio());
                        planoClienteNovo.setDuracaoEmMeses(planoSelecionado.getDuracao());
                        planoClienteNovo.setStatus(planoSelecionado.isStatus());

                        // Crie um PlanoCliente para o cliente associado
                        PlanoCliente planoClienteAssociadoNovo = new PlanoCliente();
                        planoClienteAssociadoNovo.setCliente(clienteAssociadoNovosDados);
                        planoClienteAssociadoNovo.setPlano(planoAssociacaoAtualizar);
                        planoClienteAssociadoNovo.setDuracao(planoSelecionado.getDuracao());
                        planoClienteAssociadoNovo.setDataInicio(planoSelecionado.getDataInicio());
                        planoClienteAssociadoNovo.setDuracaoEmMeses(planoSelecionado.getDuracao());
                        planoClienteAssociadoNovo.setStatus(planoSelecionado.isStatus());

                        // Persista ambos os Planos Clientes
                        dao.add(planoClienteNovo);
                        dao.add(planoClienteAssociadoNovo);
                        
                        

                        // Atualize o status do pagamento
                        pagamento.setPlanoCliente(planoClienteNovo);
                        pagamento.setSituacao("Pendente");
                        dao.add(pagamento);

                        // Atualize o status dos clientes
                        clienteNovosDados.setPlanoCliente(planoClienteNovo);
                        clienteAssociadoNovosDados.setPlanoCliente(planoClienteAssociadoNovo);
                        dao.Atualizar(classeCliente, clienteNovosDados.getId(), clienteNovosDados);
                        dao.Atualizar(classeCliente, clienteAssociadoNovosDados.getId(), clienteAssociadoNovosDados);

                        JOptionPane.showMessageDialog(null, "Sucesso ao adicionar Plano Casal. Total a pagar: " + valor);
                    }
                    if (clienteNovosDados.getPlanoCliente() == null && clienteAssociadoNovosDados.getPlanoCliente() != null
                            && !clienteAssociadoNovosDados.getPlanoCliente().isStatus()) {
                        // O cliente normal não tem plano associado, mas o cliente associado tem um plano inativo, portanto, você pode associá-los ao Plano Casal

                        clienteNovosDados.setPlanoCliente(planoSelecionado);
                        clienteAssociadoNovosDados.getPlanoCliente().setPlano(planoAssociacaoAtualizar);

                        //Gravar o planoCliente na base antes de gerar o pagamento
                        // Crie um PlanoCliente para o cliente principal
                        PlanoCliente planoClienteNovo = new PlanoCliente();
                        planoClienteNovo.setCliente(clienteNovosDados);
                        planoClienteNovo.setPlano(planoAssociacaoAtualizar);
                        planoClienteNovo.setDuracao(planoSelecionado.getDuracao());
                        planoClienteNovo.setDataInicio(planoSelecionado.getDataInicio());
                        planoClienteNovo.setDuracaoEmMeses(planoSelecionado.getDuracao());
                        planoClienteNovo.setStatus(planoSelecionado.isStatus());

                        dao.add(planoClienteNovo);

                        // Atualize o status do pagamento
                        pagamento.setPlanoCliente(clienteNovosDados.getPlanoCliente());
                        pagamento.setSituacao("Pendente");
                        dao.add(pagamento);

                        // Atualize os clientes e o Plano Cliente do associado
                        dao.Atualizar(classeCliente, clienteNovosDados.getId(), clienteNovosDados);
                        dao.Atualizar(classeCliente, clienteAssociadoNovosDados.getId(), clienteAssociadoNovosDados);

                        JOptionPane.showMessageDialog(null, "Sucesso ao adicionar Plano Casal. Total a pagar: " + valor);
                    }
                    if (clienteNovosDados.getPlanoCliente() != null && clienteAssociadoNovosDados.getPlanoCliente() == null
                            && !clienteNovosDados.getPlanoCliente().isStatus()) {
                        // O cliente associado não tem plano associado, mas o cliente normal tem um plano inativo, portanto, você pode associá-los ao Plano Casal
                        clienteNovosDados.getPlanoCliente().setPlano(planoAssociacaoAtualizar);
                        clienteAssociadoNovosDados.setPlanoCliente(planoSelecionado);
                        // Crie um PlanoCliente para o cliente associado
                        PlanoCliente planoClienteAssociadoNovo = new PlanoCliente();
                        planoClienteAssociadoNovo.setCliente(clienteAssociadoNovosDados);
                        planoClienteAssociadoNovo.setPlano(planoAssociacaoAtualizar);
                        planoClienteAssociadoNovo.setDuracao(planoSelecionado.getDuracao());
                        planoClienteAssociadoNovo.setDataInicio(planoSelecionado.getDataInicio());
                        planoClienteAssociadoNovo.setDuracaoEmMeses(planoSelecionado.getDuracao());
                        planoClienteAssociadoNovo.setStatus(planoSelecionado.isStatus());

                        dao.add(planoClienteAssociadoNovo);

                        // Atualize o status do pagamento
                        pagamento.setPlanoCliente(clienteNovosDados.getPlanoCliente());
                        pagamento.setSituacao("Pendente");
                        dao.add(pagamento);

                        // Atualize os clientes e o Plano Cliente do associado
                        dao.Atualizar(classeCliente, clienteNovosDados.getId(), clienteNovosDados);
                        dao.Atualizar(classeCliente, clienteAssociadoNovosDados.getId(), clienteAssociadoNovosDados);

                        JOptionPane.showMessageDialog(null, "Sucesso ao adicionar Plano Casal. Total a pagar: " + valor);
                    }
                    if (clienteNovosDados.getPlanoCliente() != null && clienteAssociadoNovosDados.getPlanoCliente() != null
                            && !clienteNovosDados.getPlanoCliente().isStatus() && !clienteNovosDados.getPlanoCliente().isStatus()) {
                        clienteNovosDados.getPlanoCliente().setPlano(planoAssociacaoAtualizar);
                        clienteAssociadoNovosDados.getPlanoCliente().setPlano(planoAssociacaoAtualizar);
                        pagamento.setPlanoCliente(clienteNovosDados.getPlanoCliente());
                        pagamento.setSituacao("Pendente");
                        dao.add(pagamento);

                        // Atualize os clientes e o Plano Cliente do associado
                        dao.Atualizar(classeCliente, clienteNovosDados.getId(), clienteNovosDados);
                        dao.Atualizar(classeCliente, clienteAssociadoNovosDados.getId(), clienteAssociadoNovosDados);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Sem cliente Associado");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos");
        }
    }
    /*
     @FXML
    void atualizarPlano(ActionEvent event){
        
            verificar se o plano selecionado e o mesmo 
            verificar se a data selecionada e maior em relacao a um mes da dataFim do plano ativo
            Caso plano casal verificar para ambos usuarios 
            verificar quantidade de meses adicionados
            
       
        if (clienteNovosDados != null && planoSelecionado != null && !txtDuracaoPlano.getText().isEmpty()) {
            if(clienteNovosDados.getPlanoCliente() != null){
                if(clienteNovosDados.getPlanoCliente().getPlano().getNome().equals(planoSelecionado.getPlano().getNome())){
                   
                        Adicionar meses aos meses que ja existiam duracao
                        alterar data de fim matendo a data de inicio, seria uma boa adicionar uma espaco na tabela para ver data da atualizacao
                        alterar data fim
                   
                    planoSelecionado.setDataInicio(clienteNovosDados.getPlanoCliente().getDataInicio());
                    planoSelecionado.setDuracao(clienteNovosDados.getPlanoCliente().getDuracao() + Integer.parseInt(txtDuracaoPlano.getText()));
                    planoSelecionado.setDuracaoEmMesesNew(Integer.parseInt(txtDuracaoPlano.getText()), clienteNovosDados.getPlanoCliente().getDataFim());
                    planoSelecionado.setStatus(true);
                    
                    planoSelecionado.setCliente(clienteNovosDados);
                    // Persistir as alterações no banco de dados
                    GenericDAO dao = new GenericDAO();
                    dao.Atualizar(PlanoCliente.class, clienteNovosDados.getPlanoCliente().getId(), planoSelecionado);
                    JOptionPane.showMessageDialog(null, "Atualizado");
                }else{
                    JOptionPane.showMessageDialog(null, "Impossivel atualizar para Plano difernte"); 
                }
            }else{
                JOptionPane.showMessageDialog(null,"Nao pode atualizar sem antes ter plano!!!");
            }
        
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos campos");
        }
        
    }
    */
   @FXML
   void atualizarPlano(ActionEvent event) {
       if (clienteNovosDados != null && planoSelecionado != null && !txtDuracaoPlano.getText().isEmpty()) {
           if (clienteNovosDados.getPlanoCliente() != null) {
               if (clienteNovosDados.getPlanoCliente().getPlano().getNome().equals(planoSelecionado.getPlano().getNome())) {    

                   // Atualizar os dados do plano existente
                   clienteNovosDados.getPlanoCliente().setDataInicio(clienteNovosDados.getPlanoCliente().getDataInicio());
                   clienteNovosDados.getPlanoCliente().setDuracao(clienteNovosDados.getPlanoCliente().getDuracao() + Integer.parseInt(txtDuracaoPlano.getText()));
                   clienteNovosDados.getPlanoCliente().setDuracaoEmMesesNew(Integer.parseInt(txtDuracaoPlano.getText()), clienteNovosDados.getPlanoCliente().getDataFim());
                   clienteNovosDados.getPlanoCliente().setStatus(true);

                   // Persistir as alterações no banco de dados
                   GenericDAO dao = new GenericDAO();
                   dao.Atualizar(PlanoCliente.class, clienteNovosDados.getPlanoCliente().getId(), clienteNovosDados.getPlanoCliente());

                   JOptionPane.showMessageDialog(null, "Plano atualizado com sucesso!");
               } else {
                   JOptionPane.showMessageDialog(null, "Impossível atualizar para um plano diferente.");
               }
           } else {
               JOptionPane.showMessageDialog(null, "Não é possível atualizar sem antes ter um plano.");
           }
       } else {
           JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
       }
   }


}
