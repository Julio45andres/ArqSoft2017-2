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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "partidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partidas.findAll", query = "SELECT p FROM Partidas p")
    , @NamedQuery(name = "Partidas.findById", query = "SELECT p FROM Partidas p WHERE p.id = :id")
    , @NamedQuery(name = "Partidas.findByTitulo", query = "SELECT p FROM Partidas p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Partidas.findByMaxJugadores", query = "SELECT p FROM Partidas p WHERE p.maxJugadores = :maxJugadores")
    , @NamedQuery(name = "Partidas.findByEstado", query = "SELECT p FROM Partidas p WHERE p.estado = :estado")
    , @NamedQuery(name = "Partidas.findByDuracion", query = "SELECT p FROM Partidas p WHERE p.duracion = :duracion")})
public class Partidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxJugadores")
    private int maxJugadores;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartida")
    private Collection<Chat> chatCollection;
    @JoinColumn(name = "idEscenarios", referencedColumnName = "id")
    @ManyToOne
    private Escenario idEscenarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartida")
    private Collection<Unidospartida> unidospartidaCollection;

    public Partidas() {
    }

    public Partidas(Integer id) {
        this.id = id;
    }

    public Partidas(Integer id, String titulo, int maxJugadores, int duracion) {
        this.id = id;
        this.titulo = titulo;
        this.maxJugadores = maxJugadores;
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @XmlTransient
    public Collection<Chat> getChatCollection() {
        return chatCollection;
    }

    public void setChatCollection(Collection<Chat> chatCollection) {
        this.chatCollection = chatCollection;
    }

    public Escenario getIdEscenarios() {
        return idEscenarios;
    }

    public void setIdEscenarios(Escenario idEscenarios) {
        this.idEscenarios = idEscenarios;
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
        if (!(object instanceof Partidas)) {
            return false;
        }
        Partidas other = (Partidas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.jpa.Partidas[ id=" + id + " ]";
    }
    
}
