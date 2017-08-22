/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Entilies;

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

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "uf")
public class Uf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uf_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ufId;
    @Basic(optional = false)
    @Column(name = "uf_nome")
    private String ufNome;
    @Basic(optional = false)
    @Column(name = "uf_sigla")
    private String ufSigla;
    @Basic(optional = false)
    @Column(name = "uf_sts")
    private boolean ufSts;
    @OneToMany(mappedBy = "uf")
    private Collection<Cidade> cidadeCollection;

    public Uf() {
    }

    public Uf(Integer ufId) {
        this.ufId = ufId;
    }

    public Uf(Integer ufId, String ufNome, String ufSigla, boolean ufSts) {
        this.ufId = ufId;
        this.ufNome = ufNome;
        this.ufSigla = ufSigla;
        this.ufSts = ufSts;
    }

    public Integer getUfId() {
        return ufId;
    }

    public void setUfId(Integer ufId) {
        this.ufId = ufId;
    }

    public String getUfNome() {
        return ufNome;
    }

    public void setUfNome(String ufNome) {
        this.ufNome = ufNome;
    }

    public String getUfSigla() {
        return ufSigla;
    }

    public void setUfSigla(String ufSigla) {
        this.ufSigla = ufSigla;
    }

    public boolean getUfSts() {
        return ufSts;
    }

    public void setUfSts(boolean ufSts) {
        this.ufSts = ufSts;
    }

    public Collection<Cidade> getCidadeCollection() {
        return cidadeCollection;
    }

    public void setCidadeCollection(Collection<Cidade> cidadeCollection) {
        this.cidadeCollection = cidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ufId != null ? ufId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uf)) {
            return false;
        }
        Uf other = (Uf) object;
        if ((this.ufId == null && other.ufId != null) || (this.ufId != null && !this.ufId.equals(other.ufId))) {
            return false;
        }
        return true;
    }
}
