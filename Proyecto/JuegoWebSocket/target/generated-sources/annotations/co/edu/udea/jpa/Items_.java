package co.edu.udea.jpa;

import co.edu.udea.jpa.Itemspersonaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T20:58:36")
@StaticMetamodel(Items.class)
public class Items_ { 

    public static volatile SingularAttribute<Items, String> descripcion;
    public static volatile SingularAttribute<Items, Integer> precio;
    public static volatile CollectionAttribute<Items, Itemspersonaje> itemspersonajeCollection;
    public static volatile SingularAttribute<Items, Integer> id;
    public static volatile SingularAttribute<Items, String> nombre;

}