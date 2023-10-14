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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Plano_de_Associacao;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Admin_Menu_Clientes_Controller implements Initializable {

    @FXML
    private TableColumn<Cliente, String> colunaCodigo;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaObjectivo;

    @FXML
    private TableColumn<Cliente, String> colunaPlanoAssociacao;

    @FXML
    private TableView<Cliente> tabela;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDataFim;

    @FXML
    private TextField txtDataInicio;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtObjectivo;

    @FXML
    private TextField txtPagamento;

    @FXML
    private TextField txtPlanoAssociacao;

    private ObservableList<Cliente> observableListe;

    @FXML
    void listar(ActionEvent event) {
        GenericDAO dao = new GenericDAO();

        Class<Cliente> Instr_Classe = Cliente.class;
        List<Cliente> lista = (List<Cliente>) dao.listar(Instr_Classe);

        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaPlanoAssociacao.setCellValueFactory(new PropertyValueFactory<>("plano_de_associacao"));
        colunaObjectivo.setCellValueFactory(new PropertyValueFactory<>("objectivo"));

        observableListe = FXCollections.observableArrayList(lista);

        tabela.setItems(observableListe);
    }

    @FXML
    private LineChart<?, ?> grafico;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1", 5));
        series.getData().add(new XYChart.Data("2", 4));
        series.getData().add(new XYChart.Data("3", 6));
        series.getData().add(new XYChart.Data("4", 3));
        series.getData().add(new XYChart.Data("5", 1));

//        XYChart.Series seriesV1 = new XYChart.Series();
//        seriesV1.getData().add(new XYChart.Data("1", 1));
//        seriesV1.getData().add(new XYChart.Data("2", 2));
//        seriesV1.getData().add(new XYChart.Data("3", 3));
//        seriesV1.getData().add(new XYChart.Data("4", 2));
//        seriesV1.getData().add(new XYChart.Data("5", 8));

       grafico.getData().add(series);
        //grafico.getData().addAll(series, seriesV1);

        tabela.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> pegarLinhaSelecionada(newValue)
        );
        txtId.setDisable(true);

    }

    public void pegarLinhaSelecionada(Cliente cli) {
        if (cli != null) {
            txtId.setText(String.valueOf(cli.getId()));
            txtNome.setText(cli.getNome());
            txtCodigo.setText(cli.getCodigo());
            txtPlanoAssociacao.setText(cli.getPlano_de_associacao().getNome());
            txtDataInicio.setText(cli.getPlano_de_associacao().getDataInicio());
            txtDataFim.setText(cli.getPlano_de_associacao().getDataTermino());
            txtPagamento.setText(cli.getPlano_de_associacao().getSituacao());

        } else {
            txtId.setText("");
            txtNome.setText("");
            txtCodigo.setText("");
            txtPagamento.setText("");
            txtPlanoAssociacao.setText("");
            txtDataFim.setText("");
            txtDataInicio.setText("");

        }
    }

}
