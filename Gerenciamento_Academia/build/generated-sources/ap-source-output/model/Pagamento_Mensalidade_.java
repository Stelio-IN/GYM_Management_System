package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Funcionario;
import model.Plano_de_Associacao;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-02T15:15:52", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pagamento_Mensalidade.class)
public class Pagamento_Mensalidade_ { 

    public static volatile SingularAttribute<Pagamento_Mensalidade, Cliente> cliente;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Plano_de_Associacao> plano_de_Associacao;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Double> valor;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Integer> id;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Funcionario> funcionario;
    public static volatile SingularAttribute<Pagamento_Mensalidade, String> data_Pagamento;

}