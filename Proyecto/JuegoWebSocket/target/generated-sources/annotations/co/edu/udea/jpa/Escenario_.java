package co.edu.udea.jpa;

import co.edu.udea.jpa.Partidas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T20:58:36")
@StaticMetamodel(Escenario.class)
public class Escenario_ { 

    public static volatile SingularAttribute<Escenario, String> tipo;
    public static volatile CollectionAttribute<Escenario, Partidas> partidasCollection;
    public static volatile SingularAttribute<Escenario, String> obstaculos;
    public static volatile SingularAttribute<Escenario, Integer> id;

}