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

/**
 *
 * @author steli
 */
@Entity
public class Endereco implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String nacionalidade;
    private String naturalidade;
    private String bairro;
    private String rua;
    private Instrutores instrutor; // Chave estrangeira proveniente da classe Instrutores

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Instrutores getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutores instrutor) {
        this.instrutor = instrutor;
    }

    
}
