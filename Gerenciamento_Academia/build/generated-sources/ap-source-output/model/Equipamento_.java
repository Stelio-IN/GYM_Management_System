package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-14T01:25:52", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-13T08:42:20", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> stelio
@StaticMetamodel(Equipamento.class)
public class Equipamento_ { 

    public static volatile SingularAttribute<Equipamento, String> marca;
    public static volatile SingularAttribute<Equipamento, byte[]> imagem;
    public static volatile SingularAttribute<Equipamento, String> nome;
    public static volatile SingularAttribute<Equipamento, Long> id;
    public static volatile SingularAttribute<Equipamento, String> modelo;
    public static volatile SingularAttribute<Equipamento, String> data_Entrada;
    public static volatile SingularAttribute<Equipamento, Boolean> status;
    public static volatile SingularAttribute<Equipamento, Double> vida_Util;
    public static volatile SingularAttribute<Equipamento, String> discricao;

}