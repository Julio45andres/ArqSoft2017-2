package co.edu.udea.jpa;

import co.edu.udea.jpa.Configuraciones;
import co.edu.udea.jpa.Cuentas;
import co.edu.udea.jpa.Personajes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-27T20:58:36")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Configuraciones> configuraciones;
    public static volatile CollectionAttribute<Usuarios, Cuentas> cuentasCollection;
    public static volatile SingularAttribute<Usuarios, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, String> avatar;
    public static volatile CollectionAttribute<Usuarios, Personajes> personajesCollection;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, String> email;

}