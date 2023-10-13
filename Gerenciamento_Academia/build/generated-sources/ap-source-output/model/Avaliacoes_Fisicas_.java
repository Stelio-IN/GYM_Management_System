package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Funcionario;
import model.Instrutor;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-14T01:25:52", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-13T08:42:20", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> stelio
@StaticMetamodel(Avaliacoes_Fisicas.class)
public class Avaliacoes_Fisicas_ { 

    public static volatile SingularAttribute<Avaliacoes_Fisicas, Instrutor> instrutor;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, String> data;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> peso;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> indice_Massa_Corporal;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> percentual_Gordura_Corporal;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_Panturrilha;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> teste_de_Resistencia;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_Coxa;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_Braco;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_Quadril;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Cliente> cliente;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> nível_de_Condicionamento_Fisico;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> altura;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> forca_Muscular;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Integer> id;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Funcionario> funcionario;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferencia_cintura;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_Peito;

}