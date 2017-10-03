/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobante.findAll", query = "SELECT c FROM Comprobante c")
    , @NamedQuery(name = "Comprobante.findByIdComprobante", query = "SELECT c FROM Comprobante c WHERE c.idComprobante = :idComprobante")
    , @NamedQuery(name = "Comprobante.findByFechaPago", query = "SELECT c FROM Comprobante c WHERE c.fechaPago = :fechaPago")
    , @NamedQuery(name = "Comprobante.findByValorTransaccion", query = "SELECT c FROM Comprobante c WHERE c.valorTransaccion = :valorTransaccion")
    , @NamedQuery(name = "Comprobante.findByDuiCliente", query = "SELECT c FROM Comprobante c WHERE c.duiCliente = :duiCliente")})
public class Comprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idComprobante")
    private Integer idComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorTransaccion")
    private BigDecimal valorTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "duiCliente")
    private String duiCliente;
    @JoinColumn(name = "idComprobante", referencedColumnName = "idTransaccion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Transaccion transaccion;

    public Comprobante() {
    }

    public Comprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Comprobante(Integer idComprobante, Date fechaPago, BigDecimal valorTransaccion, String duiCliente) {
        this.idComprobante = idComprobante;
        this.fechaPago = fechaPago;
        this.valorTransaccion = valorTransaccion;
        this.duiCliente = duiCliente;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getValorTransaccion() {
        return valorTransaccion;
    }

    public void setValorTransaccion(BigDecimal valorTransaccion) {
        this.valorTransaccion = valorTransaccion;
    }

    public String getDuiCliente() {
        return duiCliente;
    }

    public void setDuiCliente(String duiCliente) {
        this.duiCliente = duiCliente;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobante != null ? idComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprobante)) {
            return false;
        }
        Comprobante other = (Comprobante) object;
        if ((this.idComprobante == null && other.idComprobante != null) || (this.idComprobante != null && !this.idComprobante.equals(other.idComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Comprobante[ idComprobante=" + idComprobante + " ]";
    }
    
}
