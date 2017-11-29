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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "unidospartida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidospartida.findAll", query = "SELECT u FROM Unidospartida u")
    , @NamedQuery(name = "Unidospartida.findById", query = "SELECT u FROM Unidospartida u WHERE u.id = :id")
    , @NamedQuery(name = "Unidospartida.findByPuntos", query = "SELECT u FROM Unidospartida u WHERE u.puntos = :puntos")
    , @NamedQuery(name = "Unidospartida.findByBajas", query = "SELECT u FROM Unidospartida u WHERE u.bajas = :bajas")
    , @NamedQuery(name = "Unidospartida.findByMuertes", query = "SELECT u FROM Unidospartida u WHERE u.muertes = :muertes")})
public class Unidospartida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bajas")
    private int bajas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "muertes")
    private int muertes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonaje")
    private Collection<Chat> chatCollection;
    @JoinColumn(name = "idPartida", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Partidas idPartida;
    @JoinColumn(name = "idPersonaje", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personajes idPersonaje;

    public Unidospartida() {
    }

    public Unidospartida(Integer id) {
        this.id = id;
    }

    public Unidospartida(Integer id, int puntos, int bajas, int muertes) {
        this.id = id;
        this.puntos = puntos;
        this.bajas = bajas;
        this.muertes = muertes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getBajas() {
        return bajas;
    }

    public void setBajas(int bajas) {
        this.bajas = bajas;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    @XmlTransient
    public Collection<Chat> getChatCollection() {
        return chatCollection;
    }

    public void setChatCollection(Collection<Chat> chatCollection) {
        this.chatCollection = chatCollection;
    }

    public Partidas getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Partidas idPartida) {
        this.idPartida = idPartida;
    }

    public Personajes getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Personajes idPersonaje) {
        this.idPersonaje = idPersonaje;
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
        if (!(object instanceof Unidospartida)) {
            return false;
        }
        Unidospartida other = (Unidospartida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.jpa.Unidospartida[ id=" + id + " ]";
    }
    
}
