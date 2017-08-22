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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cid_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cidId;
    @Basic(optional = false)
    @Column(name = "cid_nome")
    private String cidNome;
    @Basic(optional = false)
    @Column(name = "cid_sts")
    private boolean cidSts;
    @JoinColumn(name = "cid_uf_id", referencedColumnName = "uf_id")
    @ManyToOne
    private Uf uf;
    @OneToMany(mappedBy = "cidade")
    private Collection<Endereco> enderecoCollection;

    public Cidade() {
    }

    public Cidade(Integer cidId) {
        this.cidId = cidId;
    }

    public Cidade(Integer cidId, String cidNome, boolean cidSts) {
        this.cidId = cidId;
        this.cidNome = cidNome;
        this.cidSts = cidSts;
    }

    public Integer getCidId() {
        return cidId;
    }

    public void setCidId(Integer cidId) {
        this.cidId = cidId;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }

    public boolean getCidSts() {
        return cidSts;
    }

    public void setCidSts(boolean cidSts) {
        this.cidSts = cidSts;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidId != null ? cidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cidId == null && other.cidId != null) || (this.cidId != null && !this.cidId.equals(other.cidId))) {
            return false;
        }
        return true;
    }
}
