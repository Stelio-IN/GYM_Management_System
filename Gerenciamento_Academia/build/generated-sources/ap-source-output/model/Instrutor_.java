package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Avaliacoes_Fisicas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-03T02:53:43", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Instrutor.class)
public class Instrutor_ extends Pessoa_ {

    public static volatile SingularAttribute<Instrutor, Double> salario;
    public static volatile ListAttribute<Instrutor, Avaliacoes_Fisicas> avaliacoesFisicas;
    public static volatile SingularAttribute<Instrutor, String> especializacao;
    public static volatile SingularAttribute<Instrutor, Double> classificacao;
    public static volatile SingularAttribute<Instrutor, String> descricao;

}