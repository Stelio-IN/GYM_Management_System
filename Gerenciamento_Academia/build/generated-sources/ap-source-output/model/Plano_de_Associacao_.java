package model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-03T09:43:07", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Plano_de_Associacao.class)
public class Plano_de_Associacao_ { 

    public static volatile SingularAttribute<Plano_de_Associacao, Double> preco;
    public static volatile SingularAttribute<Plano_de_Associacao, String> situacao;
    public static volatile SingularAttribute<Plano_de_Associacao, Date> dataTermino;
    public static volatile SingularAttribute<Plano_de_Associacao, byte[]> imagem;
    public static volatile SingularAttribute<Plano_de_Associacao, String> nome;
    public static volatile SingularAttribute<Plano_de_Associacao, Long> id;
    public static volatile SingularAttribute<Plano_de_Associacao, Integer> duracao;
    public static volatile SingularAttribute<Plano_de_Associacao, Date> dataInicio;
    public static volatile ListAttribute<Plano_de_Associacao, Cliente> clientesAssociados;
    public static volatile SingularAttribute<Plano_de_Associacao, String> descricao;
    public static volatile SingularAttribute<Plano_de_Associacao, Boolean> status;

}