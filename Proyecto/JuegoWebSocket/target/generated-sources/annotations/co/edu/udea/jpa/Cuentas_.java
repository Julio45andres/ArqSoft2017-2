package co.edu.udea.jpa;

import co.edu.udea.jpa.Estadoscuenta;
import co.edu.udea.jpa.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T17:39:06")
@StaticMetamodel(Cuentas.class)
public class Cuentas_ { 

    public static volatile SingularAttribute<Cuentas, Estadoscuenta> idEstado;
    public static volatile SingularAttribute<Cuentas, Date> fechaRegistro;
    public static volatile SingularAttribute<Cuentas, Usuarios> idUsuario;
    public static volatile SingularAttribute<Cuentas, String> membresia;
    public static volatile SingularAttribute<Cuentas, Integer> id;

}