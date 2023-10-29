/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Equipamento;
import model.Funcionario;
import model.Instrutor;
import model.Pessoa;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author steli
 */
public class Tela_Menu_Admin_Controller implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private AnchorPane panelGeral;
    
    
    @FXML
    private AreaChart<String, Number> GraficoArea;

    @FXML
    void tela_Admin_Menu_Clientes(ActionEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Clientes");
    }

    @FXML
    void tela_Admin_Menu_Funcionarios(ActionEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Funcionarios");
    }

    @FXML
    void tela_Admin_Menu_Geral(ActionEvent event) {
        contabilizar();
        borderPane.setRight(panelGeral);
    }

    @FXML
    void tela_Admin_Menu_Instrutores(ActionEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Instrutores");
    }

    @FXML
    void tela_Admin_Menu_Maquinas(ActionEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Maquinas");
    }

    private void carregarTela(String tela) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(tela + ".fxml"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu_Admin_Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        borderPane.setRight(root);
    }
    ///////////////////////////////////////////

    @FXML
    private ImageView imageViewAdmin;
    @FXML
    private TextField txtNomeAdmin;
    private Pessoa pessoa;

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        txtNomeAdmin.setEditable(false);
        txtNomeAdmin.setAlignment(javafx.geometry.Pos.CENTER);
        txtNomeAdmin.setText(pessoa.getNome());
        if (pessoa.getImagem() != null) {
            // Converta o array de bytes em uma Image
            byte[] imagemBytes = pessoa.getImagem();
            Image imagem = new Image(new ByteArrayInputStream(imagemBytes));

            // Defina a imagem no ImageView
            imageViewAdmin.setImage(imagem);

            // Definir largura e altura desejadas
            imageViewAdmin.setFitWidth(79); // Largura desejada
            imageViewAdmin.setFitHeight(93); // Altura desejada

            // Preservar a proporção da imagem enquanto ajusta as dimensões
            imageViewAdmin.setPreserveRatio(true);
        } else {
            JOptionPane.showMessageDialog(null, "imagem nao encontrada");
        }
    }

    @FXML
    void logout(ActionEvent event) throws IOException {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("LogOut");
        alerta.setHeaderText("Quer realmente terminar seccao");
        alerta.setContentText("Fazer backup antes de sair!");
        if (alerta.showAndWait().get() == ButtonType.OK) {

            Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    private Label txtQuanClientes;

    @FXML
    private Label txtQuanFuncionarios;

    @FXML
    private Label txtQuanInstrutores;
    @FXML
    private Label txtQuanMaquinas;

    private int quandidade_Clientes = 0;
    private int quandidade_Funcionarios = 0;
    private int quandidade_Instrutores = 0;
    private int quandidade_Maquinas = 0;

    private void contabilizar() {
        quandidade_Instrutores = 0;
        quandidade_Funcionarios = 0;
        quandidade_Clientes = 0;

        GenericDAO dao = new GenericDAO();
        Class<Equipamento> classe = Equipamento.class;
        List<Pessoa> pessoas = dao.listarTodosParaRelatorio(Pessoa.class);
        quandidade_Maquinas = dao.contar_Quantidade_Base(classe);
        if (pessoas != null) {
            for (int i = 0; i < pessoas.size(); i++) {
                Pessoa pessoa = pessoas.get(i);
                if (pessoa instanceof Cliente) {
                    quandidade_Clientes++;
                } else if (pessoa instanceof Instrutor) {
                    quandidade_Instrutores++;
                } else if (pessoa instanceof Funcionario) {
                    quandidade_Funcionarios++;
                }

            }
        } else {
            // Trate o caso em que a lista está vazia ou ocorreu um erro
            quandidade_Clientes = 0;
            quandidade_Funcionarios = 0;
            quandidade_Instrutores = 0;
        }
        txtQuanMaquinas.setText(String.valueOf(quandidade_Maquinas));
        txtQuanClientes.setText(String.valueOf(quandidade_Clientes));
        txtQuanFuncionarios.setText(String.valueOf(quandidade_Funcionarios));
        txtQuanInstrutores.setText(String.valueOf(quandidade_Instrutores));
    }

    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contabilizar();
        carregarDadosDoBanco();

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Homens", quandidade_Homens),
                new PieChart.Data("Mulheres", quandidade_Mulheres)
        );

        // Vincular os nomes e valores dos dados aos rótulos do gráfico
        pieChartData.forEach(data -> {
            data.nameProperty().bind(
                    Bindings.concat(data.getName(), " amount: ", data.pieValueProperty())
            );
        });

        // Configure o PieChart
        pieChart.setData(pieChartData);
        //chamando o grafico de barra
        GraficoBarra();
        //////////////////////////////////////////////////////////////////////////////////////////   
//           // Inicialize o gráfico
        Series<String, Number> series = new Series<>();
        series.setName("Série de Dados Fictícios");
        GraficoArea.getData().add(series);

        // Crie um Timeline para atualizar automaticamente o gráfico a cada 5 segundos
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            // Limpe os dados existentes no gráfico
            series.getData().clear();

            // Adicione novos dados fictícios à série
            Random random = new Random();
            for (int i = 1; i <= 10; i++) {
                series.getData().add(new Data<>("Mês " + i, random.nextInt(100)));
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
///////////////////////////////////////////////////////////////////////////////////





//         CategoryAxis xAxis = new CategoryAxis();
//        NumberAxis yAxis = new NumberAxis();
//
//        AreaChart<String, Number> grafico1 = new AreaChart<>(xAxis, yAxis);
//        grafico1.setTitle("Gráfico de Área 1");
//        grafico1.setPrefWidth(400); // Largura do primeiro gráfico
//
//        AreaChart<String, Number> grafico2 = new AreaChart<>(xAxis, yAxis);
//        grafico2.setTitle("Gráfico de Área 2");
//        grafico2.setPrefWidth(400); // Largura do segundo gráfico
//
//        // Série de dados para o primeiro gráfico
//        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
//        series1.setName("Série 1");
//
//        // Série de dados para o segundo gráfico
//        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
//        series2.setName("Série 2");
//
//        // Adicione os gráficos ao contêiner
//        graficoContainer.getChildren().addAll(grafico1, grafico2);
//
//        // Crie um Timeline para atualizar automaticamente os gráficos a cada 5 segundos
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
//            // Limpe os dados existentes nos gráficos
//            series1.getData().clear();
//            series2.getData().clear();
//
//            // Adicione novos dados fictícios às séries
//            Random random = new Random();
//            for (int i = 1; i <= 10; i++) {
//                series1.getData().add(new XYChart.Data<>("Mês " + i, random.nextInt(100)));
//                series2.getData().add(new XYChart.Data<>("Mês " + i, random.nextInt(100)));
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//
//        // Adicione as séries aos gráficos
//        grafico1.getData().add(series1);
//        grafico2.getData().add(series2);
    }

//      @FXML
//    private HBox graficoContainer;
      
      
    //private BarChart<?, ?> barChart;
    // Crie os eixos
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();

    // Crie o gráfico de barras
    @FXML
    BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

    void GraficoBarra() {
        barChart.setTitle("Clientes Idades");

        // Criar uma série de dados
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Idades");

        series.getData().add(new XYChart.Data<>("17-23", 15));
        series.getData().add(new XYChart.Data<>("24-40", 30));
        series.getData().add(new XYChart.Data<>("41-09", 45));
        // Adicione mais dados conforme necessário

        // Adicione a série ao gráfico
        barChart.getData().add(series);
    }
    
//     public void inserirDadosNoGraficoArea() {
//        // Limpe os dados existentes no gráfico
//        GraficoArea.getData().clear();
//
//        // Crie uma série de dados fictícios
//        Series<String, Number> seriess = new Series<>();
//        seriess.setName("Série de Dados Fictícios");
//
//        // Adicione dados fictícios à série
//        Random random = new Random();
//        for (int i = 1; i <= 10; i++) {
//            seriess.getData().add(new Data<>("Mês " + i, random.nextInt(100)));
//        }
//
//        // Adicione a série de dados ao gráfico
//        GraficoArea.getData().add(seriess);
//    }

    private int quandidade_Homens = 0;
    private int quandidade_Mulheres = 0;

    private void carregarDadosDoBanco() {
        GenericDAO dao = new GenericDAO();
        List<Pessoa> pessoas = dao.listarTodosParaRelatorio(Pessoa.class);
        if (pessoas != null) {
            for (int i = 0; i < pessoas.size(); i++) {
                Pessoa pessoa = pessoas.get(i);
                if (pessoa instanceof Cliente) {

                    if (pessoa.getGenero().equals("Masculino")) {
                        quandidade_Homens++;
                    } else if (pessoa.getGenero().equals("Feminino")) {
                        quandidade_Mulheres++;
                    }
                }
            }
        }
    }
    
   


    @FXML
    void Tela_Admin_Planos_Associacao(ActionEvent event) {
        carregarTela("/view/Tela_Admin_Menu_Plano_Associacao");
    }
      @FXML
    void Tela_Cadastrar_Admin(ActionEvent event) {
         carregarTela("/view/Tela_Admin_Registrar");
    }
    @FXML
    void Tela_Atualizar_Admin(ActionEvent event) {
                carregarTela("/view/Tela_Admin_Registrar");
                
    }



}
