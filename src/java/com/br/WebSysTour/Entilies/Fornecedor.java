/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Entilies;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "for_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer forId;
    @Basic(optional = false)
    @Column(name = "for_nome")
    private String forNome;
    @Column(name = "for_datacadastro")
    @Temporal(TemporalType.DATE)
    private Date forDatacadastro;
    @Basic(optional = false)
    @Column(name = "for_cnpjcpf")
    private String forCnpjcpf;
    @Basic(optional = false)
    @Column(name = "for_sts")
    private boolean forSts;
    @Basic(optional = false)
    @Column(name = "for_tipo")
    private String forTipo;
    @JoinTable(name = "telefonefornecedor", joinColumns = {
        @JoinColumn(name = "telfor_for_id", referencedColumnName = "for_id")}, inverseJoinColumns = {
        @JoinColumn(name = "telfor_tel_id", referencedColumnName = "tel_id")})
    @ManyToMany
    private Collection<Telefone> telefoneCollection;
    @ManyToMany(mappedBy = "fornecedorCollection")
    private Collection<Endereco> enderecoCollection;
    @ManyToMany(mappedBy = "fornecedorCollection")
    private Collection<Email> emailCollection;
    @JoinColumn(name = "for_fil_id", referencedColumnName = "fil_id")
    @ManyToOne
    private Filial filial;

    public Fornecedor() {
    }

    public Fornecedor(Integer forId) {
        this.forId = forId;
    }

    public Fornecedor(Integer forId, String forNome, String forCnpjcpf, boolean forSts, String forTipo) {
        this.forId = forId;
        this.forNome = forNome;
        this.forCnpjcpf = forCnpjcpf;
        this.forSts = forSts;
        this.forTipo = forTipo;
    }

    public Integer getForId() {
        return forId;
    }

    public void setForId(Integer forId) {
        this.forId = forId;
    }

    public String getForNome() {
        return forNome;
    }

    public void setForNome(String forNome) {
        this.forNome = forNome;
    }

    public Date getForDatacadastro() {
        return forDatacadastro;
    }

    public void setForDatacadastro(Date forDatacadastro) {
        this.forDatacadastro = forDatacadastro;
    }

    public String getForCnpjcpf() {
        return forCnpjcpf;
    }

    public void setForCnpjcpf(String forCnpjcpf) {
        this.forCnpjcpf = forCnpjcpf;
    }

    public boolean getForSts() {
        return forSts;
    }

    public void setForSts(boolean forSts) {
        this.forSts = forSts;
    }

    public String getForTipo() {
        return forTipo;
    }

    public void setForTipo(String forTipo) {
        this.forTipo = forTipo;
    }

    public Collection<Telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<Telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forId != null ? forId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.forId == null && other.forId != null) || (this.forId != null && !this.forId.equals(other.forId))) {
            return false;
        }
        return true;
    }
}
