package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.PlanoCliente;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-08T10:40:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pagamento_Mensalidade.class)
public class Pagamento_Mensalidade_ { 

    public static volatile SingularAttribute<Pagamento_Mensalidade, PlanoCliente> planoCliente;
    public static volatile SingularAttribute<Pagamento_Mensalidade, String> situacao;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Double> valor;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Long> id;
    public static volatile SingularAttribute<Pagamento_Mensalidade, String> data_Pagamento;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Boolean> status;

}