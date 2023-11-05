package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Avaliacoes_Fisicas;
import model.Cliente;
import model.PlanoCliente;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-06T00:09:30", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Pessoa_ {

    public static volatile SingularAttribute<Cliente, PlanoCliente> planoCliente;
    public static volatile SingularAttribute<Cliente, String> doenca;
    public static volatile SingularAttribute<Cliente, String> esporte_que_Pratica;
    public static volatile SingularAttribute<Cliente, Double> altura;
    public static volatile SingularAttribute<Cliente, Double> peso;
    public static volatile SingularAttribute<Cliente, String> objectivo;
    public static volatile SingularAttribute<Cliente, String> data_inscricao;
    public static volatile ListAttribute<Cliente, Avaliacoes_Fisicas> avaliacoes;
    public static volatile SingularAttribute<Cliente, Cliente> clienteAssociado;
    public static volatile SingularAttribute<Cliente, String> contato_emergencia;

}