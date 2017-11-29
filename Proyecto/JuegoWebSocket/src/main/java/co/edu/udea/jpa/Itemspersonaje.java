/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "itemspersonaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemspersonaje.findAll", query = "SELECT i FROM Itemspersonaje i")
    , @NamedQuery(name = "Itemspersonaje.findById", query = "SELECT i FROM Itemspersonaje i WHERE i.id = :id")
    , @NamedQuery(name = "Itemspersonaje.findByCantidad", query = "SELECT i FROM Itemspersonaje i WHERE i.cantidad = :cantidad")})
public class Itemspersonaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idPersonaje", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personajes idPersonaje;
    @JoinColumn(name = "idItem", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Items idItem;

    public Itemspersonaje() {
    }

    public Itemspersonaje(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Personajes getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(Personajes idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public Items getIdItem() {
        return idItem;
    }

    public void setIdItem(Items idItem) {
        this.idItem = idItem;
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
        if (!(object instanceof Itemspersonaje)) {
            return false;
        }
        Itemspersonaje other = (Itemspersonaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.jpa.Itemspersonaje[ id=" + id + " ]";
    }
    
}
