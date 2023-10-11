package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Funcionario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-11T15:27:42", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pagamento_Mensalidade.class)
public class Pagamento_Mensalidade_ { 

    public static volatile SingularAttribute<Pagamento_Mensalidade, Cliente> cliente;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Double> valor;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Integer> id;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Funcionario> funcionario;
    public static volatile SingularAttribute<Pagamento_Mensalidade, String> data_Pagamento;

}