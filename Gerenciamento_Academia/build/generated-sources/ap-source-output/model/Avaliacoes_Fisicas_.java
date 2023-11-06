package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Funcionario;
import model.Instrutor;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-07T01:14:26", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Avaliacoes_Fisicas.class)
public class Avaliacoes_Fisicas_ { 

    public static volatile SingularAttribute<Avaliacoes_Fisicas, Instrutor> instrutor;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> nível_de_condicionamento_fisico;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, String> data;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, String> discricao_comentarios;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> peso;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> capacidade_cardiovascular;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> realizacao_Metas_pessoas;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_braco;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> Nota_da_avaliacao;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Cliente> cliente;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_panturrilha;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> altura;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> forca_Muscular;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_peito;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_coxa;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferência_quadril;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Integer> id;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Funcionario> funcionario;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> indice_Massa_corporal;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> circunferencia_cintura;
    public static volatile SingularAttribute<Avaliacoes_Fisicas, Double> satisfacao_do_Cliente;

}