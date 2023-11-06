package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Avaliacoes_Fisicas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-07T01:10:41", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ extends Pessoa_ {

    public static volatile SingularAttribute<Funcionario, Double> salario;
    public static volatile ListAttribute<Funcionario, Avaliacoes_Fisicas> avaliacoesFisicas;
    public static volatile SingularAttribute<Funcionario, String> cargo;

}