package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Avaliacoes_Fisicas;
import model.Cliente;
import model.Plano_de_Associacao;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-12T23:16:47", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-04T18:08:55", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Pessoa_ {

    public static volatile SingularAttribute<Cliente, String> doenca;
    public static volatile SingularAttribute<Cliente, Cliente> clinteAssociado;
    public static volatile SingularAttribute<Cliente, String> nome_Do_Conjuge;
    public static volatile SingularAttribute<Cliente, String> esporte_que_Pratica;
    public static volatile SingularAttribute<Cliente, Double> altura;
    public static volatile SingularAttribute<Cliente, Double> peso;
    public static volatile SingularAttribute<Cliente, String> objectivo;
    public static volatile SingularAttribute<Cliente, String> data_inscricao;
    public static volatile ListAttribute<Cliente, Avaliacoes_Fisicas> avaliacoes;
    public static volatile SingularAttribute<Cliente, String> contato_emergencia;
    public static volatile SingularAttribute<Cliente, Plano_de_Associacao> plano_de_associacao;

}