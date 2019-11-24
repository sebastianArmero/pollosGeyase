/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "pollo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pollo.findAll", query = "SELECT p FROM Pollo p")
    , @NamedQuery(name = "Pollo.findById", query = "SELECT p FROM Pollo p WHERE p.id = :id")
    , @NamedQuery(name = "Pollo.findByNomCli", query = "SELECT p FROM Pollo p WHERE p.nomCli = :nomCli")
    , @NamedQuery(name = "Pollo.findByPesoPollo", query = "SELECT p FROM Pollo p WHERE p.pesoPollo = :pesoPollo")
    , @NamedQuery(name = "Pollo.findByPrePollo", query = "SELECT p FROM Pollo p WHERE p.prePollo = :prePollo")
    , @NamedQuery(name = "Pollo.findByEstado", query = "SELECT p FROM Pollo p WHERE p.estado = :estado")})
public class Pollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nom_cli")
    private String nomCli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_pollo")
    private float pesoPollo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre_pollo")
    private int prePollo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "estado")
    private String estado;

    public Pollo() {
    }

    public Pollo(Integer id) {
        this.id = id;
    }

    public Pollo(Integer id, String nomCli, float pesoPollo, int prePollo, String estado) {
        this.id = id;
        this.nomCli = nomCli;
        this.pesoPollo = pesoPollo;
        this.prePollo = prePollo;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public float getPesoPollo() {
        return pesoPollo;
    }

    public void setPesoPollo(float pesoPollo) {
        this.pesoPollo = pesoPollo;
    }

    public int getPrePollo() {
        return prePollo;
    }

    public void setPrePollo(int prePollo) {
        this.prePollo = prePollo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof Pollo)) {
            return false;
        }
        Pollo other = (Pollo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Pollo[ id=" + id + " ]";
    }
    
}
