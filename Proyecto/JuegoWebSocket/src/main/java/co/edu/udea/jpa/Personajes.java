/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "personajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personajes.findAll", query = "SELECT p FROM Personajes p")
    , @NamedQuery(name = "Personajes.findById", query = "SELECT p FROM Personajes p WHERE p.id = :id")
    , @NamedQuery(name = "Personajes.findByNombre", query = "SELECT p FROM Personajes p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Personajes.findBySexo", query = "SELECT p FROM Personajes p WHERE p.sexo = :sexo")})
public class Personajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "sexo")
    private Character sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonaje")
    private Collection<Itemspersonaje> itemspersonajeCollection;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonaje")
    private Collection<Unidospartida> unidospartidaCollection;

    public Personajes() {
    }

    public Personajes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public Collection<Itemspersonaje> getItemspersonajeCollection() {
        return itemspersonajeCollection;
    }

    public void setItemspersonajeCollection(Collection<Itemspersonaje> itemspersonajeCollection) {
        this.itemspersonajeCollection = itemspersonajeCollection;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Unidospartida> getUnidospartidaCollection() {
        return unidospartidaCollection;
    }

    public void setUnidospartidaCollection(Collection<Unidospartida> unidospartidaCollection) {
        this.unidospartidaCollection = unidospartidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personajes)) {
            return false;
        }
        Personajes other = (Personajes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.jpa.Personajes[ id=" + id + " ]";
    }
    
}
