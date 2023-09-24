/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private ToggleGroup genero;

    @FXML
    private ToggleGroup grupoDesport;
    @FXML
    private ToggleGroup grupoDoenca;

    @FXML
    private DatePicker dataChosser;

    @FXML
    private ImageView imageCamera;

    @FXML
    void carregarimg(ActionEvent event) {
        //Permite navegar pelas pastas do pc
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar uma imagem");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"),
                new FileChooser.ExtensionFilter("Todos os arquivos", "*.*")
        );

        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            // Cria uma instância de Image com o arquivo selecionado
            Image imagemSelecionada = new Image(selectedFile.toURI().toString());

            // Atribui a imagem ao ImageView
            imageCamera.setImage(imagemSelecionada);
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limitarDatePicker();
        // Desabilite a edição manual da data
        dataChosser.setEditable(false);
        //Carregar combo
        carregarDesportos();
        carregarDoencas();

        // TODO
    }

    void carregarDesportos() {
        desportos.add("Futebol");
        desportos.add("Basquetebol");
        desportos.add("Atletismo");
        desportos.add("Natcão");
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
    void cadastrar(ActionEvent event) {
        if (dataChosser.getValue() != null) {
            // Obtenha o valor selecionado e faça algo com ele
            java.time.LocalDate dataSelecionada = dataChosser.getValue();
            System.out.println("Data selecionada: " + dataSelecionada);
        } else {
            System.out.println("Nenhuma data selecionada.");
        }

        //Radio Button 
        RadioButton pegarGenero = (RadioButton) genero.getSelectedToggle();
        System.out.println(pegarGenero.getText());
        RadioButton pegarEsporte = (RadioButton) grupoDesport.getSelectedToggle();
        System.out.println(pegarEsporte.getText());
        RadioButton pegarDoenca = (RadioButton) grupoDoenca.getSelectedToggle();
        System.out.println(pegarEsporte.getText());
    }
}
