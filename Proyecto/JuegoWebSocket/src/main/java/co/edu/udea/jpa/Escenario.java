/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "escenario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escenario.findAll", query = "SELECT e FROM Escenario e")
    , @NamedQuery(name = "Escenario.findById", query = "SELECT e FROM Escenario e WHERE e.id = :id")
    , @NamedQuery(name = "Escenario.findByTipo", query = "SELECT e FROM Escenario e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Escenario.findByObstaculos", query = "SELECT e FROM Escenario e WHERE e.obstaculos = :obstaculos")})
public class Escenario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 100)
    @Column(name = "obstaculos")
    private String obstaculos;
    @OneToMany(mappedBy = "idEscenarios")
    private Collection<Partidas> partidasCollection;

    public Escenario() {
    }

    public Escenario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(String obstaculos) {
        this.obstaculos = obstaculos;
    }

    @XmlTransient
    public Collection<Partidas> getPartidasCollection() {
        return partidasCollection;
    }

    public void setPartidasCollection(Collection<Partidas> partidasCollection) {
        this.partidasCollection = partidasCollection;
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
        if (!(object instanceof Escenario)) {
            return false;
        }
        Escenario other = (Escenario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.jpa.Escenario[ id=" + id + " ]";
    }
    
}
