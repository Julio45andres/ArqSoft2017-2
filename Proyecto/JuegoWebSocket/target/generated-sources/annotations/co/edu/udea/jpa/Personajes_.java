package co.edu.udea.jpa;

import co.edu.udea.jpa.Itemspersonaje;
import co.edu.udea.jpa.Unidospartida;
import co.edu.udea.jpa.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T17:39:06")
@StaticMetamodel(Personajes.class)
public class Personajes_ { 

    public static volatile CollectionAttribute<Personajes, Unidospartida> unidospartidaCollection;
    public static volatile SingularAttribute<Personajes, Usuarios> idUsuario;
    public static volatile CollectionAttribute<Personajes, Itemspersonaje> itemspersonajeCollection;
    public static volatile SingularAttribute<Personajes, Integer> id;
    public static volatile SingularAttribute<Personajes, Character> sexo;
    public static volatile SingularAttribute<Personajes, String> nombre;

}