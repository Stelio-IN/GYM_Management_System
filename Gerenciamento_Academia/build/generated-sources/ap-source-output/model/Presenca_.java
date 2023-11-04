package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Funcionario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-05T05:45:28", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Presenca.class)
public class Presenca_ { 

    public static volatile SingularAttribute<Presenca, Cliente> cliente;
    public static volatile SingularAttribute<Presenca, String> data;
    public static volatile SingularAttribute<Presenca, Integer> id;
    public static volatile SingularAttribute<Presenca, Funcionario> funcionario;

}