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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "filial")
public class Filial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fil_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer filId;
    @Basic(optional = false)
    @Column(name = "fil_nome")
    private String filNome;
    @Basic(optional = false)
    @Column(name = "fil_cnpj")
    private String filCnpj;
    @Basic(optional = false)
    @Column(name = "fil_sts")
    private boolean filSts;
    @ManyToMany(mappedBy = "filialCollection")
    private Collection<Endereco> enderecoCollection;
    @OneToMany(mappedBy = "filial")
    private Collection<Fornecedor> fornecedorCollection;
    @OneToMany(mappedBy = "filial")
    private Collection<Conta> contaCollection;
    @JoinColumn(name = "fil_emp_id", referencedColumnName = "emp_id")
    @ManyToOne
    private Empresa empresa;
    @OneToMany(mappedBy = "filial")
    private Collection<Cliente> clienteCollection;
    @OneToMany(mappedBy = "filial")
    private Collection<Departamento> departamentoCollection;

    public Filial() {
    }

    public Filial(Integer filId) {
        this.filId = filId;
    }

    public Filial(Integer filId, String filNome, String filCnpj, boolean filSts) {
        this.filId = filId;
        this.filNome = filNome;
        this.filCnpj = filCnpj;
        this.filSts = filSts;
    }

    public Integer getFilId() {
        return filId;
    }

    public void setFilId(Integer filId) {
        this.filId = filId;
    }

    public String getFilNome() {
        return filNome;
    }

    public void setFilNome(String filNome) {
        this.filNome = filNome;
    }

    public String getFilCnpj() {
        return filCnpj;
    }

    public void setFilCnpj(String filCnpj) {
        this.filCnpj = filCnpj;
    }

    public boolean getFilSts() {
        return filSts;
    }

    public void setFilSts(boolean filSts) {
        this.filSts = filSts;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    public Collection<Conta> getContaCollection() {
        return contaCollection;
    }

    public void setContaCollection(Collection<Conta> contaCollection) {
        this.contaCollection = contaCollection;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Collection<Departamento> getDepartamentoCollection() {
        return departamentoCollection;
    }

    public void setDepartamentoCollection(Collection<Departamento> departamentoCollection) {
        this.departamentoCollection = departamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filId != null ? filId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filial)) {
            return false;
        }
        Filial other = (Filial) object;
        if ((this.filId == null && other.filId != null) || (this.filId != null && !this.filId.equals(other.filId))) {
            return false;
        }
        return true;
    }
}
