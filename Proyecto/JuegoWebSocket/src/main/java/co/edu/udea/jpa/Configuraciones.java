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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "configuraciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuraciones.findAll", query = "SELECT c FROM Configuraciones c")
    , @NamedQuery(name = "Configuraciones.findById", query = "SELECT c FROM Configuraciones c WHERE c.id = :id")
    , @NamedQuery(name = "Configuraciones.findBySonido", query = "SELECT c FROM Configuraciones c WHERE c.sonido = :sonido")
    , @NamedQuery(name = "Configuraciones.findByIdioma", query = "SELECT c FROM Configuraciones c WHERE c.idioma = :idioma")
    , @NamedQuery(name = "Configuraciones.findByResolucion", query = "SELECT c FROM Configuraciones c WHERE c.resolucion = :resolucion")
    , @NamedQuery(name = "Configuraciones.findByAvatarimg", query = "SELECT c FROM Configuraciones c WHERE c.avatarimg = :avatarimg")})
public class Configuraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "sonido")
    private Character sonido;
    @Size(max = 50)
    @Column(name = "idioma")
    private String idioma;
    @Size(max = 30)
    @Column(name = "resolucion")
    private String resolucion;
    @Size(max = 500)
    @Column(name = "avatarimg")
    private String avatarimg;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuarios idUsuario;

    public Configuraciones() {
    }

    public Configuraciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getSonido() {
        return sonido;
    }

    public void setSonido(Character sonido) {
        this.sonido = sonido;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getAvatarimg() {
        return avatarimg;
    }

    public void setAvatarimg(String avatarimg) {
        this.avatarimg = avatarimg;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Configuraciones)) {
            return false;
        }
        Configuraciones other = (Configuraciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.jpa.Configuraciones[ id=" + id + " ]";
    }
    
}
