package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Administrador;
import model.Cliente;
import model.Equipamento;
import model.Funcionario;
import model.Instrutor;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-13T12:57:42", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Notificacao.class)
public class Notificacao_ { 

    public static volatile SingularAttribute<Notificacao, Instrutor> instrutor;
    public static volatile SingularAttribute<Notificacao, Cliente> cliente;
    public static volatile SingularAttribute<Notificacao, Administrador> administrador;
    public static volatile SingularAttribute<Notificacao, String> mensagem;
    public static volatile SingularAttribute<Notificacao, Equipamento> maquina;
    public static volatile SingularAttribute<Notificacao, Long> id;
    public static volatile SingularAttribute<Notificacao, Funcionario> funcionario;
    public static volatile SingularAttribute<Notificacao, Boolean> status;

}