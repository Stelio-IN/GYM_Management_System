package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Endereco;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-10-12T23:16:47", comments="EclipseLink-2.7.10.v20211216-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-04T18:08:55", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> f57dd2763a9a89c48eef3f37cfe8ed5419e1dfb3
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, String> codigo;
    public static volatile SingularAttribute<Pessoa, String> telefone;
    public static volatile SingularAttribute<Pessoa, String> nascimento;
    public static volatile SingularAttribute<Pessoa, Endereco> endereco;
    public static volatile SingularAttribute<Pessoa, byte[]> imagem;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, String> bilhete_Identificacao;
    public static volatile SingularAttribute<Pessoa, Boolean> isAtivo;
    public static volatile SingularAttribute<Pessoa, String> naturalidade;
    public static volatile SingularAttribute<Pessoa, String> password;
    public static volatile SingularAttribute<Pessoa, String> estado_Civil;
    public static volatile SingularAttribute<Pessoa, String> genero;
    public static volatile SingularAttribute<Pessoa, String> telefone_Alternativo;
    public static volatile SingularAttribute<Pessoa, Long> id;
    public static volatile SingularAttribute<Pessoa, String> nacionalidade;
    public static volatile SingularAttribute<Pessoa, String> email;

}