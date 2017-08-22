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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "end_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer endId;
    @Basic(optional = false)
    @Column(name = "end_rua")
    private String endRua;
    @Column(name = "end_numero")
    private String endNumero;
    @Column(name = "end_quadra")
    private String endQuadra;
    @Column(name = "end_lote")
    private String endLote;
    @Basic(optional = false)
    @Column(name = "end_bairro")
    private String endBairro;
    @Basic(optional = false)
    @Column(name = "end_cep")
    private String endCep;
    @Column(name = "end_complemento")
    private String endComplemento;
    @Basic(optional = false)
    @Column(name = "end_sts")
    private boolean endSts;
    @ManyToMany(mappedBy = "enderecoCollection")
    private Collection<Empresa> empresaCollection;
    @JoinTable(name = "enderecofornecedor", joinColumns = {
        @JoinColumn(name = "endfor_end_id", referencedColumnName = "end_id")}, inverseJoinColumns = {
        @JoinColumn(name = "endfor_for_id", referencedColumnName = "for_id")})
    @ManyToMany
    private Collection<Fornecedor> fornecedorCollection;
    @JoinTable(name = "enderecofuncionario", joinColumns = {
        @JoinColumn(name = "endfun_end_id", referencedColumnName = "end_id")}, inverseJoinColumns = {
        @JoinColumn(name = "endfun_fun_id", referencedColumnName = "fun_id")})
    @ManyToMany
    private Collection<Funcionario> funcionarioCollection;
    @ManyToMany(mappedBy = "enderecoCollection")
    private Collection<Cliente> clienteCollection;
    @JoinTable(name = "enderecofilial", joinColumns = {
        @JoinColumn(name = "endfil_end_id", referencedColumnName = "end_id")}, inverseJoinColumns = {
        @JoinColumn(name = "endfil_fil_id", referencedColumnName = "fil_id")})
    @ManyToMany
    private Collection<Filial> filialCollection;
    @JoinColumn(name = "end_cid_id", referencedColumnName = "cid_id")
    @ManyToOne
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(Integer endId) {
        this.endId = endId;
    }

    public Endereco(Integer endId, String endRua, String endBairro, String endCep, boolean endSts) {
        this.endId = endId;
        this.endRua = endRua;
        this.endBairro = endBairro;
        this.endCep = endCep;
        this.endSts = endSts;
    }

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndQuadra() {
        return endQuadra;
    }

    public void setEndQuadra(String endQuadra) {
        this.endQuadra = endQuadra;
    }

    public String getEndLote() {
        return endLote;
    }

    public void setEndLote(String endLote) {
        this.endLote = endLote;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public boolean getEndSts() {
        return endSts;
    }

    public void setEndSts(boolean endSts) {
        this.endSts = endSts;
    }

    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
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

    public Collection<Filial> getFilialCollection() {
        return filialCollection;
    }

    public void setFilialCollection(Collection<Filial> filialCollection) {
        this.filialCollection = filialCollection;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endId != null ? endId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.endId == null && other.endId != null) || (this.endId != null && !this.endId.equals(other.endId))) {
            return false;
        }
        return true;
    }
}
