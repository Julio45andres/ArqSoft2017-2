package co.edu.udea.jpa;

import co.edu.udea.jpa.Partidas;
import co.edu.udea.jpa.Unidospartida;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T20:58:36")
@StaticMetamodel(Chat.class)
public class Chat_ { 

    public static volatile SingularAttribute<Chat, Partidas> idPartida;
    public static volatile SingularAttribute<Chat, Date> fechaHora;
    public static volatile SingularAttribute<Chat, Unidospartida> idPersonaje;
    public static volatile SingularAttribute<Chat, Integer> id;
    public static volatile SingularAttribute<Chat, String> mensaje;

}