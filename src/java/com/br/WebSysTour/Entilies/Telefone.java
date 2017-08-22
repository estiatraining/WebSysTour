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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tel_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer telId;
    @Basic(optional = false)
    @Column(name = "tel_numero")
    private String telNumero;
    @Basic(optional = false)
    @Column(name = "tel_tipo")
    private String telTipo;
    @Basic(optional = false)
    @Column(name = "tel_sts")
    private boolean telSts;
    @Column(name = "tel_ramal")
    private Integer telRamal;
    @ManyToMany(mappedBy = "telefoneCollection")
    private Collection<Fornecedor> fornecedorCollection;
    @ManyToMany(mappedBy = "telefoneCollection")
    private Collection<Funcionario> funcionarioCollection;
    @ManyToMany(mappedBy = "telefoneCollection")
    private Collection<Cliente> clienteCollection;

    public Telefone() {
    }

    public Telefone(Integer telId) {
        this.telId = telId;
    }

    public Telefone(Integer telId, String telNumero, String telTipo, boolean telSts) {
        this.telId = telId;
        this.telNumero = telNumero;
        this.telTipo = telTipo;
        this.telSts = telSts;
    }

    public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        this.telId = telId;
    }

    public String getTelNumero() {
        return telNumero;
    }

    public void setTelNumero(String telNumero) {
        this.telNumero = telNumero;
    }

    public String getTelTipo() {
        return telTipo;
    }

    public void setTelTipo(String telTipo) {
        this.telTipo = telTipo;
    }

    public boolean getTelSts() {
        return telSts;
    }

    public void setTelSts(boolean telSts) {
        this.telSts = telSts;
    }

    public Integer getTelRamal() {
        return telRamal;
    }

    public void setTelRamal(Integer telRamal) {
        this.telRamal = telRamal;
    }

    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telId != null ? telId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.telId == null && other.telId != null) || (this.telId != null && !this.telId.equals(other.telId))) {
            return false;
        }
        return true;
    }
}
