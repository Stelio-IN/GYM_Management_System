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
import javax.persistence.ManyToOne;

/**
 *
 * @author steli
 */
@Entity
public class Pagamento_Mensalidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Plano_de_Associacao plano_de_Associacao;
    private String data_Pagamento;
    private Double valor;
    private boolean status;

    public Plano_de_Associacao getPlano_de_Associacao() {
        return plano_de_Associacao;
    }

    public void setPlano_de_Associacao(Plano_de_Associacao plano_de_Associacao) {
        this.plano_de_Associacao = plano_de_Associacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData_Pagamento() {
        return data_Pagamento;
    }

    public void setData_Pagamento(String data_Pagamento) {
        this.data_Pagamento = data_Pagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    

}
