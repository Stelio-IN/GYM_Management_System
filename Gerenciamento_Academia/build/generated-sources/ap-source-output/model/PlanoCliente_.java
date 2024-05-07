package model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Plano_de_Associacao;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-13T12:57:42", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PlanoCliente.class)
public class PlanoCliente_ { 

    public static volatile SingularAttribute<PlanoCliente, Cliente> cliente;
    public static volatile SingularAttribute<PlanoCliente, Date> dataFim;
    public static volatile SingularAttribute<PlanoCliente, Plano_de_Associacao> plano;
    public static volatile SingularAttribute<PlanoCliente, Long> id;
    public static volatile SingularAttribute<PlanoCliente, Date> dataInicio;
    public static volatile SingularAttribute<PlanoCliente, Integer> duracao;
    public static volatile SingularAttribute<PlanoCliente, Boolean> status;

}