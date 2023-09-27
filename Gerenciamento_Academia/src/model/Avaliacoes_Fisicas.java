/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author steli
 */
@Entity
public class Avaliacoes_Fisicas implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Cliente cliente;
    private Double peso;
    private Double altura;
    private Double circunferencia_cintura;
    private Double circunferência_Braco;
    private Double circunferência_Coxa;
    private Double circunferência_Panturrilha;
    private Double circunferência_Quadril;
    private Double circunferência_Peito;
    private Double indice_Massa_Corporal; 
    private Double nível_de_Condicionamento_Fisico;
    private Double forca_Muscular;
    private Double teste_de_Resistencia;
    private Double percentual_Gordura_Corporal;
    @OneToOne
    private Funcionario funcionario;
    @OneToOne
    private Instrutor instrutor;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getCircunferencia_cintura() {
        return circunferencia_cintura;
    }

    public void setCircunferencia_cintura(Double circunferencia_cintura) {
        this.circunferencia_cintura = circunferencia_cintura;
    }

    public Double getCircunferência_Braco() {
        return circunferência_Braco;
    }

    public void setCircunferência_Braco(Double circunferência_Braco) {
        this.circunferência_Braco = circunferência_Braco;
    }

    public Double getCircunferência_Coxa() {
        return circunferência_Coxa;
    }

    public void setCircunferência_Coxa(Double circunferência_Coxa) {
        this.circunferência_Coxa = circunferência_Coxa;
    }

    public Double getCircunferência_Panturrilha() {
        return circunferência_Panturrilha;
    }

    public void setCircunferência_Panturrilha(Double circunferência_Panturrilha) {
        this.circunferência_Panturrilha = circunferência_Panturrilha;
    }

    public Double getCircunferência_Quadril() {
        return circunferência_Quadril;
    }

    public void setCircunferência_Quadril(Double circunferência_Quadril) {
        this.circunferência_Quadril = circunferência_Quadril;
    }

    public Double getCircunferência_Peito() {
        return circunferência_Peito;
    }

    public void setCircunferência_Peito(Double circunferência_Peito) {
        this.circunferência_Peito = circunferência_Peito;
    }

    public Double getIndice_Massa_Corporal() {
        return indice_Massa_Corporal;
    }

    public void setIndice_Massa_Corporal(Double indice_Massa_Corporal) {
        this.indice_Massa_Corporal = indice_Massa_Corporal;
    }

    public Double getNível_de_Condicionamento_Fisico() {
        return nível_de_Condicionamento_Fisico;
    }

    public void setNível_de_Condicionamento_Fisico(Double nível_de_Condicionamento_Fisico) {
        this.nível_de_Condicionamento_Fisico = nível_de_Condicionamento_Fisico;
    }

    public Double getForca_Muscular() {
        return forca_Muscular;
    }

    public void setForca_Muscular(Double forca_Muscular) {
        this.forca_Muscular = forca_Muscular;
    }

    public Double getTeste_de_Resistencia() {
        return teste_de_Resistencia;
    }

    public void setTeste_de_Resistencia(Double teste_de_Resistencia) {
        this.teste_de_Resistencia = teste_de_Resistencia;
    }

    public Double getPercentual_Gordura_Corporal() {
        return percentual_Gordura_Corporal;
    }

    public void setPercentual_Gordura_Corporal(Double percentual_Gordura_Corporal) {
        this.percentual_Gordura_Corporal = percentual_Gordura_Corporal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
