package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Tipo_Relatorio;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-12T23:16:47", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-04T18:08:55", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
@StaticMetamodel(Relatorios.class)
public class Relatorios_ { 

    public static volatile SingularAttribute<Relatorios, String> data_de_geracao;
    public static volatile SingularAttribute<Relatorios, Tipo_Relatorio> tipo_de_relatorio;
    public static volatile SingularAttribute<Relatorios, String> nome;
    public static volatile SingularAttribute<Relatorios, Integer> id;

}