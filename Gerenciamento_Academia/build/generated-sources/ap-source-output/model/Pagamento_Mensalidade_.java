package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Funcionario;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-12T23:16:47", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-04T18:08:55", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
@StaticMetamodel(Pagamento_Mensalidade.class)
public class Pagamento_Mensalidade_ { 

    public static volatile SingularAttribute<Pagamento_Mensalidade, Cliente> cliente;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Double> valor;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Integer> id;
    public static volatile SingularAttribute<Pagamento_Mensalidade, Funcionario> funcionario;
    public static volatile SingularAttribute<Pagamento_Mensalidade, String> data_Pagamento;

}