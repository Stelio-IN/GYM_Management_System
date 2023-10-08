///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
// */
//package copias_de_classes;
//
//import java.io.IOException;
//import java.net.URL;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.beans.binding.Bindings;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.chart.BarChart;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.PieChart;
//import javafx.scene.chart.XYChart;
//import javafx.scene.control.Label;
//import javafx.scene.control.MenuButton;
//import javafx.scene.control.MenuItem;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import model.Cliente;
//import model.Equipamento;
//import model.Funcionario;
//import model.Instrutor;
//import model.Pessoa;
//
///**
// * FXML Controller class
// *
// * @author steli
// */
//public class Tela_Menu_Admin_Controller implements Initializable {
//
//    @FXML
//    private BorderPane borderPane;
//
//    @FXML
//    private AnchorPane panelGeral;
//
//    @FXML
//    void tela_Admin_Menu_Clientes(ActionEvent event) {
//        carregarTela("/view/Tela_Admin_Menu_Clientes");
//    }
//
//    @FXML
//    void tela_Admin_Menu_Funcionarios(ActionEvent event) {
//        carregarTela("/view/Tela_Admin_Menu_Funcionarios");
//    }
//
//    @FXML
//    void tela_Admin_Menu_Geral(ActionEvent event) {
//        contabilizar();
//        borderPane.setRight(panelGeral);
//    }
//
//    @FXML
//    void tela_Admin_Menu_Instrutores(ActionEvent event) {
//        carregarTela("/view/Tela_Admin_Menu_Instrutores");
//    }
//
//    @FXML
//    void tela_Admin_Menu_Maquinas(ActionEvent event) {
//        carregarTela("/view/Tela_Admin_Menu_Maquinas");
//    }
//
//    private void carregarTela(String tela) {
//        Parent root = null;
//
//        try {
//            root = FXMLLoader.load(getClass().getResource(tela + ".fxml"));
//        } catch (IOException ex) {
//            java.util.logging.Logger.getLogger(Tela_Menu_Admin_Controller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        borderPane.setRight(root);
//    }
//    ///////////////////////////////////////////
//
//    @FXML
//    private Label txtQuanClientes;
//
//    @FXML
//    private Label txtQuanFuncionarios;
//
//    @FXML
//    private Label txtQuanInstrutores;
//    @FXML
//    private Label txtQuanMaquinas;
//
//    private int quandidade_Clientes = 0;
//    private int quandidade_Funcionarios = 0;
//    private int quandidade_Instrutores = 0;
//    private int quandidade_Maquinas = 0;
//
//    private void contabilizar() {
//        GenericDAO dao = new GenericDAO();
//        Class<Equipamento> classe = Equipamento.class;
//        List<Pessoa> pessoas = dao.listarTodosParaRelatorio(Pessoa.class);
//        quandidade_Maquinas = dao.contar_Quantidade_Base(classe);
//        if (pessoas != null) {
//            for (int i = 0; i < pessoas.size(); i++) {
//                Pessoa pessoa = pessoas.get(i);
//                if (pessoa instanceof Cliente) {
//                    quandidade_Clientes++;
//                } else if (pessoa instanceof Instrutor) {
//                    quandidade_Instrutores++;
//                } else if (pessoa instanceof Funcionario) {
//                    quandidade_Funcionarios++;
//                }
//
//            }
//        } else {
//            // Trate o caso em que a lista está vazia ou ocorreu um erro
//            quandidade_Clientes = 0;
//            quandidade_Funcionarios = 0;
//            quandidade_Instrutores = 0;
//        }
//        txtQuanMaquinas.setText(String.valueOf(quandidade_Maquinas));
//        txtQuanClientes.setText(String.valueOf(quandidade_Clientes));
//        txtQuanFuncionarios.setText(String.valueOf(quandidade_Funcionarios));
//        txtQuanInstrutores.setText(String.valueOf(quandidade_Instrutores));
//    }
//
//    @FXML
//    private PieChart pieChart;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        contabilizar();
//
//        try {
//            carregarDadosDoBanco();
//        } catch (ParseException ex) {
//            Logger.getLogger(Tela_Menu_Admin_Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//                new PieChart.Data("Homens", quandidade_Homens),
//                new PieChart.Data("Mulheres", quandidade_Mulheres)
//        );
//
//        // Vincular os nomes e valores dos dados aos rótulos do gráfico
//        pieChartData.forEach(data -> {
//            data.nameProperty().bind(
//                    Bindings.concat(data.getName(), " amount: ", data.pieValueProperty())
//            );
//        });
//
//        // Configure o PieChart
//        pieChart.setData(pieChartData);
//        
//        GraficoBarra();
//
//    }
//
//    //private BarChart<?, ?> barChart;
//    // Crie os eixos
//    CategoryAxis xAxis = new CategoryAxis();
//    NumberAxis yAxis = new NumberAxis();
//
//    // Crie o gráfico de barras
//    @FXML
//    BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
//
//    void GraficoBarra() {
//        barChart.setTitle("Clientes Idades");
//
//        // Crie uma série de dados
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        series.setName("Idades");
//
//        // Adicione os dados ao gráfico (substitua isso com seus próprios dados)
//        series.getData().add(new XYChart.Data<>("[17-25]", quandidade_Primeira_Barra));
//        series.getData().add(new XYChart.Data<>("[26-45]", quandidade_Segunda_Barra));
//        series.getData().add(new XYChart.Data<>("[46-..]", quandidade_Terceira_Barra));
//        // Adicione mais dados conforme necessário
//
//        // Adicione a série ao gráfico
//        barChart.getData().add(series);
//    }
//
//    private int quandidade_Homens = 0;
//    private int quandidade_Mulheres = 0;
//    private int quandidade_Primeira_Barra = 0;
//    private int quandidade_Segunda_Barra = 0;
//    private int quandidade_Terceira_Barra = 0;
//
//    private void carregarDadosDoBanco() throws ParseException {
//        GenericDAO dao = new GenericDAO();
//        List<Pessoa> pessoas = dao.listarTodosParaRelatorio(Pessoa.class);
//        if (pessoas != null) {
//            for (int i = 0; i < pessoas.size(); i++) {
//                Pessoa pessoa = pessoas.get(i);
//                if (pessoa instanceof Cliente ) {
//                    
//                    if (pessoa.getGenero().equals("Masculino")) {
//                        quandidade_Homens++;
//                    } else if (pessoa.getGenero().equals("Femenino")) {
//                        quandidade_Mulheres++;
//                    }
//                    
//                    
//                    String data = pessoa.getNascimento();
//                    if (data != null) {
//                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                        Date dataNascimento = sdf.parse(data);
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.setTime(dataNascimento);
//                        int anoNascimento = calendar.get(Calendar.YEAR);
//                        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
//                        int idade = anoAtual - anoNascimento;
//                        if (idade > 16 && idade <= 25) {
//                            quandidade_Primeira_Barra++;
//                        } else if (idade > 25 && idade >= 46) {
//                            quandidade_Segunda_Barra++;
//                        } else {
//                            quandidade_Terceira_Barra++;
//                        }
//                    }
//                   
//                }
//            }
//        }
//    }
//
//}
