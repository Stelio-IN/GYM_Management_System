package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Plano_de_Associacao;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-14T01:25:52", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-13T08:42:20", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> stelio
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Pessoa_ {

    public static volatile SingularAttribute<Cliente, String> doenca;
    public static volatile SingularAttribute<Cliente, String> nome_Do_Conjuge;
    public static volatile SingularAttribute<Cliente, String> esporte_que_Pratica;
    public static volatile SingularAttribute<Cliente, Double> altura;
    public static volatile SingularAttribute<Cliente, Double> peso;
    public static volatile SingularAttribute<Cliente, String> objectivo;
    public static volatile SingularAttribute<Cliente, String> data_inscricao;
    public static volatile SingularAttribute<Cliente, String> contato_emergencia;
    public static volatile SingularAttribute<Cliente, Plano_de_Associacao> plano_de_associacao;

}