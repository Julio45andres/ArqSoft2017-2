package co.edu.udea.jpa;

import co.edu.udea.jpa.Chat;
import co.edu.udea.jpa.Escenario;
import co.edu.udea.jpa.Unidospartida;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T20:58:36")
@StaticMetamodel(Partidas.class)
public class Partidas_ { 

    public static volatile CollectionAttribute<Partidas, Chat> chatCollection;
    public static volatile SingularAttribute<Partidas, String> estado;
    public static volatile CollectionAttribute<Partidas, Unidospartida> unidospartidaCollection;
    public static volatile SingularAttribute<Partidas, String> titulo;
    public static volatile SingularAttribute<Partidas, Integer> duracion;
    public static volatile SingularAttribute<Partidas, Integer> id;
    public static volatile SingularAttribute<Partidas, Integer> maxJugadores;
    public static volatile SingularAttribute<Partidas, Escenario> idEscenarios;

}