
package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author steli
 */
@Entity
public class Plano_de_Associacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int duracao;
    private String nome;
    private String descricao;
    private Double preco;
    private boolean status;

    private String situacao;

//    @Temporal(TemporalType.DATE)
//    private String dataInicio;
//    
//    @Temporal(TemporalType.DATE)
//    private String dataTermino;
    
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataTermino;

    @Lob
    protected byte[] imagem;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Cliente> cliente;

    public Plano_de_Associacao(){
        this.status = true;
    }
    public List<Cliente> getCliente() {
        return cliente;
    }

    public void zerarPlanoNoFinalDoMes() {
        Date dataAtual = new Date();
        if (dataTermino != null && dataAtual.after(dataTermino)) {
            // O plano expirou, defina a data de término para o final do próximo mês
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataTermino);
            calendar.add(Calendar.MONTH, 1);
            dataTermino = calendar.getTime();
        }
    }
     public void desvincularClienteQuandoPlanoExpirar() {
        Date dataAtual = new Date();
        if (dataTermino != null && dataAtual.after(dataTermino) && cliente != null) {
            // O plano expirou, defina a data de término para o final do próximo mês
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataTermino);
            calendar.add(Calendar.MONTH, 1);
            dataTermino = calendar.getTime();
            
            // Desvincule o cliente definindo-o como nulo
            cliente = null;
        }
    }

    public void setDuracaoEmMeses(int duracaoEmMeses) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicio);
        calendar.add(Calendar.MONTH, duracaoEmMeses);
        dataTermino = calendar.getTime();
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Plano_de_Associacao{" + "id=" + id + ", duracao=" + duracao + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", status=" + status + ", situacao=" + situacao + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", imagem=" + imagem + '}';
    }

}
