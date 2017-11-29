package co.edu.udea.jpa;

import co.edu.udea.jpa.Cuentas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T20:58:36")
@StaticMetamodel(Estadoscuenta.class)
public class Estadoscuenta_ { 

    public static volatile SingularAttribute<Estadoscuenta, String> estado;
    public static volatile CollectionAttribute<Estadoscuenta, Cuentas> cuentasCollection;
    public static volatile SingularAttribute<Estadoscuenta, Integer> id;

}