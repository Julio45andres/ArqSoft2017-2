package co.edu.udea.jpa;

import co.edu.udea.jpa.Chat;
import co.edu.udea.jpa.Partidas;
import co.edu.udea.jpa.Personajes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T17:39:06")
@StaticMetamodel(Unidospartida.class)
public class Unidospartida_ { 

    public static volatile CollectionAttribute<Unidospartida, Chat> chatCollection;
    public static volatile SingularAttribute<Unidospartida, Partidas> idPartida;
    public static volatile SingularAttribute<Unidospartida, Personajes> idPersonaje;
    public static volatile SingularAttribute<Unidospartida, Integer> id;
    public static volatile SingularAttribute<Unidospartida, Integer> puntos;
    public static volatile SingularAttribute<Unidospartida, Integer> muertes;
    public static volatile SingularAttribute<Unidospartida, Integer> bajas;

}