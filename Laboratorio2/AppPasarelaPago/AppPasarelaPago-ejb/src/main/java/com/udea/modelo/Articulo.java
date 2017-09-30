/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByCodigo", query = "SELECT a FROM Articulo a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Articulo.findByNombre", query = "SELECT a FROM Articulo a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Articulo.findByExistencia", query = "SELECT a FROM Articulo a WHERE a.existencia = :existencia")
    , @NamedQuery(name = "Articulo.findByPrecioProveedor", query = "SELECT a FROM Articulo a WHERE a.precioProveedor = :precioProveedor")
    , @NamedQuery(name = "Articulo.findByPrecioCliente", query = "SELECT a FROM Articulo a WHERE a.precioCliente = :precioCliente")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "existencia")
    private int existencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioProveedor")
    private BigDecimal precioProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioCliente")
    private BigDecimal precioCliente;
    @JoinTable(name = "item", joinColumns = {
        @JoinColumn(name = "codArticulo", referencedColumnName = "codigo")}, inverseJoinColumns = {
        @JoinColumn(name = "idTransaccion", referencedColumnName = "idTransaccion")})
    @ManyToMany
    private Collection<Transaccion> transaccionCollection;

    public Articulo() {
    }

    public Articulo(String codigo) {
        this.codigo = codigo;
    }

    public Articulo(String codigo, String nombre, int existencia, BigDecimal precioProveedor, BigDecimal precioCliente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.existencia = existencia;
        this.precioProveedor = precioProveedor;
        this.precioCliente = precioCliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public BigDecimal getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(BigDecimal precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public BigDecimal getPrecioCliente() {
        return precioCliente;
    }

    public void setPrecioCliente(BigDecimal precioCliente) {
        this.precioCliente = precioCliente;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Articulo[ codigo=" + codigo + " ]";
    }
    
}
