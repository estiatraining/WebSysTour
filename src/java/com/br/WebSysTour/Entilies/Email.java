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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer emailId;
    @Basic(optional = false)
    @Column(name = "email_descricao")
    private String emailDescricao;
    @Basic(optional = false)
    @Column(name = "email_tipo")
    private String emailTipo;
    @Basic(optional = false)
    @Column(name = "email_sts")
    private boolean emailSts;
    @JoinTable(name = "emailfuncionario", joinColumns = {
        @JoinColumn(name = "emailfun_email_id", referencedColumnName = "email_id")}, inverseJoinColumns = {
        @JoinColumn(name = "emailfun_fun_id", referencedColumnName = "fun_id")})
    @ManyToMany
    private Collection<Funcionario> funcionarioCollection;
    @ManyToMany(mappedBy = "emailCollection")
    private Collection<Cliente> clienteCollection;
    @JoinTable(name = "emailfornecedor", joinColumns = {
        @JoinColumn(name = "emailfor_email_id", referencedColumnName = "email_id")}, inverseJoinColumns = {
        @JoinColumn(name = "emailfor_for_id", referencedColumnName = "for_id")})
    @ManyToMany
    private Collection<Fornecedor> fornecedorCollection;

    public Email() {
    }

    public Email(Integer emailId) {
        this.emailId = emailId;
    }

    public Email(Integer emailId, String emailDescricao, String emailTipo, boolean emailSts) {
        this.emailId = emailId;
        this.emailDescricao = emailDescricao;
        this.emailTipo = emailTipo;
        this.emailSts = emailSts;
    }

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getEmailDescricao() {
        return emailDescricao;
    }

    public void setEmailDescricao(String emailDescricao) {
        this.emailDescricao = emailDescricao;
    }

    public String getEmailTipo() {
        return emailTipo;
    }

    public void setEmailTipo(String emailTipo) {
        this.emailTipo = emailTipo;
    }

    public boolean getEmailSts() {
        return emailSts;
    }

    public void setEmailSts(boolean emailSts) {
        this.emailSts = emailSts;
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

    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailId != null ? emailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }
}
