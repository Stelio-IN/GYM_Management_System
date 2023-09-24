/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author steli
 */
@Entity
public class Cliente extends Pessoa implements Serializable {

    private String contato_emergencia;
    private String data_inscricao;
    private Double altura;
    private Double peso;
    private Plano_de_Associacao plano_de_associacao;

    public String getContato_emergencia() {
        return contato_emergencia;
    }

    public void setContato_emergencia(String contato_emergencia) {
        this.contato_emergencia = contato_emergencia;
    }

    public String getData_inscricao() {
        return data_inscricao;
    }

    public void setData_inscricao(String data_inscricao) {
        this.data_inscricao = data_inscricao;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Plano_de_Associacao getPlano_de_associacao() {
        return plano_de_associacao;
    }

    public void setPlano_de_associacao(Plano_de_Associacao plano_de_associacao) {
        this.plano_de_associacao = plano_de_associacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone_Alternativo() {
        return telefone_Alternativo;
    }

    public void setTelefone_Alternativo(String telefone_Alternativo) {
        this.telefone_Alternativo = telefone_Alternativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getBilhete_Identificacao() {
        return bilhete_Identificacao;
    }

    public void setBilhete_Identificacao(String bilhete_Identificacao) {
        this.bilhete_Identificacao = bilhete_Identificacao;
    }

    public String getEstado_Civil() {
        return estado_Civil;
    }

    public void setEstado_Civil(String estado_Civil) {
        this.estado_Civil = estado_Civil;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }
    



}
