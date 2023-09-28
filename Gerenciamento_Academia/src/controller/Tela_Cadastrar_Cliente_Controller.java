/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Administrador;
import model.Cliente;
import model.Endereco;
import model.Ficha_Inscricao;
import model.Pessoa;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Cadastrar_Cliente_Controller implements Initializable {

    @FXML
    private ComboBox<String> comboBoxDesporto;
    private List<String> desportos = new ArrayList<>();
    private ObservableList<String> obserDesportos;

    @FXML
    private ComboBox<String> comboBoxDoencas;
    private final List<String> doencas = new ArrayList<>();
    private ObservableList<String> obserdoencas;

    @FXML
    private ComboBox<String> comboBoxBairro;
    private final List<String> bairro = new ArrayList<>();
    private ObservableList<String> obserBairro;

    @FXML
    private ComboBox<String> comboBoxCidade;
    private final List<String> cidade = new ArrayList<>();
    private ObservableList<String> obserCidade;

    @FXML
    private ComboBox<String> comboBoxNacionalidade;
    private final List<String> nacionalidade = new ArrayList<>();
    private ObservableList<String> obserNacionalidade;

    @FXML
    private ToggleGroup genero;

    @FXML
    private ToggleGroup grupoDesport;

    @FXML
    private ToggleGroup grupoDoenca;

    @FXML
    private ToggleGroup grupoestadocivil;

    @FXML
    private TextField txtContactoAlternativo;

    @FXML
    private TextField txtContactoEmergencia;

    @FXML
    private TextField txtNomeConjuge;

    @FXML
    private TextField txtNumeroDaCasa;
    @FXML
    private TextField txtAltura;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtRua;

    @FXML
    private DatePicker dataChosser;

    @FXML
    private ImageView imageCamera;

    @FXML
    private TextField txtContacto;

    @FXML
    private TextField txtDataInscricao;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNumeroInsc;
    @FXML
    private TextField txtCodigoMembro;
    @FXML
    private TextField txtIdentificacao;

    String caminhoDoArquivo;

    @FXML
    void carregarimg(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar uma imagem");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"),
                new FileChooser.ExtensionFilter("Todos os arquivos", "*.*")
        );

        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            caminhoDoArquivo = selectedFile.getAbsolutePath();

            // Cria uma instância de Image com o arquivo selecionado
            Image imagemSelecionada = new Image(selectedFile.toURI().toString());

            // Atribui a imagem ao ImageView
            imageCamera.setImage(imagemSelecionada);
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }
    }

    private String idFatura;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limitarDatePicker();
        // Desabilite a edição manual da data
        dataChosser.setEditable(false);
        //Carregar combo
        carregarDesportos();
        carregarDoencas();
        carregarNacionalidade();
        carregarBairros();
        carregarCidade();

        //Inicializando ficha de Inscricao e Data de inscriacao
        LocalDate dataAtual = LocalDate.now();
        // Escolha um formato de data desejado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAtualFormatada = dataAtual.format(formatter);
        txtDataInscricao.setText(dataAtualFormatada);
        txtDataInscricao.setDisable(true);

        GenericDAO dao = new GenericDAO();
        Class<Pessoa> classe = Pessoa.class;
        int quant = dao.contar(classe);
        System.out.println(quant);
        int anoAtual = Year.now().getValue(); // Obtém o ano atual
        String idUnico = "CG" + anoAtual + String.format("%04d", quant); // Formata o número com 4 dígitos
        System.out.println(idUnico);
        txtCodigoMembro.setText(idUnico);
        txtCodigoMembro.setDisable(true);

        idFatura = String.format("%05d", quant); // Formata o número com 4 dígitos 
        System.out.println(idFatura);

        txtNumeroInsc.setText(idFatura);

        txtNumeroInsc.setDisable(true);
    }

    void carregarCidade() {
        cidade.add("Niassa");
        cidade.add(" Cabo Delgado");
        cidade.add(" Nampula");
        cidade.add("Maputo");
        cidade.add(" Gaza");
        cidade.add("Inhambane");
        cidade.add(" Tete");
        cidade.add("Manica");
        obserCidade = FXCollections.observableArrayList(cidade);
        comboBoxCidade.setItems(obserCidade);
    }

    void carregarBairros() {
        bairro.add("Alto Maé");
        bairro.add(" Malhangalene");
        bairro.add(" Polana");
        bairro.add("Chamanculo");
        bairro.add(" Maxaquene");
        bairro.add("Albazine");
        bairro.add(" Costa do Sol");
        bairro.add("Zimpento");
        obserBairro = FXCollections.observableArrayList(bairro);
        comboBoxBairro.setItems(obserBairro);
    }

    void carregarDesportos() {
        desportos.add("Futebol");
        desportos.add("Basquetebol");
        desportos.add("Atletismo");
        desportos.add("Natacão");
        desportos.add("Natação");
        obserDesportos = FXCollections.observableArrayList(desportos);
        comboBoxDesporto.setItems(obserDesportos);
    }

    void carregarDoencas() {
        doencas.add(" Cardiovasculares");
        doencas.add(" Respiratórias");
        doencas.add("Gastrointestinais");
        doencas.add("Neurológicas");
        doencas.add(" Endócrinas");
        doencas.add(" Infecciosas");
        doencas.add("Musculoesqueléticas");
        doencas.add(" Renais");
        doencas.add(" Psiquiátricas");
        obserdoencas = FXCollections.observableArrayList(doencas);
        comboBoxDoencas.setItems(obserdoencas);
    }

    void carregarNacionalidade() {
        nacionalidade.add(" Moçambique");
        nacionalidade.add(" Africa do sul");
        nacionalidade.add("Angola");
        nacionalidade.add("Brasil");
        nacionalidade.add(" Portugal");
        obserNacionalidade = FXCollections.observableArrayList(nacionalidade);
        comboBoxNacionalidade.setItems(obserNacionalidade);
    }

    private void limitarDatePicker() {
        // Defina as datas mínimas e máximas que você deseja permitir
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        LocalDate minDate = LocalDate.of(anoAtual - 90, 1, 1); // Data mínima
        LocalDate maxDate = LocalDate.of(anoAtual - 16, 12, 31); // Data máxima

        // Crie uma fábrica de células de data para limitar as datas permitidas
        Callback<DatePicker, DateCell> dayCellFactory = new Callback<>() {
            @Override
            public DateCell call(DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isBefore(minDate) || item.isAfter(maxDate));
                    }
                };
            }
        };

        // Atribua a fábrica de células ao DatePicker
        dataChosser.setDayCellFactory(dayCellFactory);
    }

    @FXML
    void ativarCampoConjugue(ActionEvent event) {
        txtNomeConjuge.setDisable(false);
    }

    @FXML
    void ativarComboDesportos(ActionEvent event) {
        comboBoxDesporto.setDisable(true);
    }

    @FXML
    void ativarComboDoencas(ActionEvent event) {
        comboBoxDoencas.setDisable(true);
    }

    @FXML
    void desativarCampoConjugue(ActionEvent event) {
        txtNomeConjuge.setDisable(true);
    }

    @FXML
    void desativarComboDoencas(ActionEvent event) {
        comboBoxDoencas.setDisable(false);
    }

    @FXML
    void desabilitarComboDesportos(ActionEvent event) {
        comboBoxDesporto.setDisable(false);
    }

    @FXML
    void cadastrar(ActionEvent event) throws IOException {
        Cliente cliente = new Cliente();
        GenericDAO dao = new GenericDAO();

        //Radio Button 
        RadioButton pegarGenero = (RadioButton) genero.getSelectedToggle();
        String genero = pegarGenero.getText();

        RadioButton pegarEsporte = (RadioButton) grupoDesport.getSelectedToggle();
        String esporte = pegarEsporte.getText();

        RadioButton pegarDoenca = (RadioButton) grupoDoenca.getSelectedToggle();
        String doenca = pegarDoenca.getText();

        RadioButton pegarEstadoCivil = (RadioButton) grupoestadocivil.getSelectedToggle();
        String estadoCivil = pegarEstadoCivil.getText();
        //Pegando a data do 
        String dataAtualFormatada = "";
        if (dataChosser.getValue() != null) {
            // Obtenha o valor selecionado e faça algo com ele
            java.time.LocalDate dataSelecionada = dataChosser.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataAtualFormatada = dataSelecionada.format(formatter);

            System.out.println("Data selecionada: " + dataAtualFormatada);
        } else {
            System.out.println("Nenhuma data selecionada.");
        }

        cliente.setNome(txtNome.getText());
        cliente.setNacionalidade(comboBoxNacionalidade.getValue());
        cliente.setGenero(genero);
        cliente.setEstado_Civil(estadoCivil);
        cliente.setNascimento(dataAtualFormatada);
        cliente.setBilhete_Identificacao(txtIdentificacao.getText());
        cliente.setTelefone(txtContacto.getText());
        cliente.setTelefone_Alternativo(txtContactoAlternativo.getText());
        cliente.setContato_emergencia(txtContactoEmergencia.getText());
        cliente.setData_inscricao(txtDataInscricao.getText());
        cliente.setCodigo(txtCodigoMembro.getText());
        cliente.setEsporte_que_Pratica(comboBoxDesporto.getValue());
        cliente.setDoenca(comboBoxDoencas.getValue());
        cliente.setEmail(txtEmail.getText());
        cliente.setNaturalidade(comboBoxCidade.getValue());
        cliente.setNome_Do_Conjuge(txtNomeConjuge.getText());
        Endereco endereco = new Endereco();
        endereco.setBairro(comboBoxBairro.getValue());
        endereco.setRua(txtRua.getText());
        endereco.setNumero_Casa(txtNumeroDaCasa.getText());

        cliente.setEndereco(endereco);
        cliente.setIsAtivo(true);
        
        cliente.setPeso(Double.valueOf(txtPeso.getText()));
        
        cliente.setAltura(Double.valueOf(txtAltura.getText()));
        
        // Verifique se o caminho do arquivo não é nulo ou vazio
        if (caminhoDoArquivo != null && !caminhoDoArquivo.isEmpty()) {
            // Leitura da imagem do arquivo e armazenamento como um array de bytes
            Path imagePath = Paths.get(caminhoDoArquivo);
            byte[] imagemBytes = Files.readAllBytes(imagePath);

            cliente.setImagem(imagemBytes);

        } else {
            System.out.println("Nenhum arquivo de imagem selecionado.");
        }

        
        //System.out.println(cliente);
        dao.add(cliente);
        
        /*
        Ficha de inscricao sala
        */
        
        Ficha_Inscricao ficha = new Ficha_Inscricao();
        ficha.setNumero_Da_Ficha(idFatura);
        ficha.setCliente(txtNome.getText());
        ficha.setFuncionario("Funcionario maluco");
        ficha.setData_Da_Inscriacao(dataAtualFormatada);
        dao.add(ficha);
    }

}
