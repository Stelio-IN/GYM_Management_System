package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Tipo_Relatorio;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-02T14:07:22", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Relatorios.class)
public class Relatorios_ { 

    public static volatile SingularAttribute<Relatorios, String> data_de_geracao;
    public static volatile SingularAttribute<Relatorios, Tipo_Relatorio> tipo_de_relatorio;
    public static volatile SingularAttribute<Relatorios, String> nome;
    public static volatile SingularAttribute<Relatorios, Integer> id;

}