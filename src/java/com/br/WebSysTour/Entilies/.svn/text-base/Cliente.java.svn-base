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
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cli_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cliId;
    @Basic(optional = false)
    @Column(name = "cli_nome")
    private String cliNome;
    @Column(name = "cli_datacadastro")
    @Temporal(TemporalType.DATE)
    private Date cliDatacadastro;
    @Column(name = "cli_datanascimento")
    @Temporal(TemporalType.DATE)
    private Date cliDatanascimento;
    @Basic(optional = false)
    @Column(name = "cli_cnpjcpf")
    private String cliCnpjcpf;
    @Basic(optional = false)
    @Column(name = "cli_rg")
    private String cliRg;
    @Basic(optional = false)
    @Column(name = "cli_sts")
    private boolean cliSts;
    @Basic(optional = false)
    @Column(name = "cli_tipo")
    private String cliTipo;
    @JoinTable(name = "emailcliente", joinColumns = {
        @JoinColumn(name = "emailcli_cli_id", referencedColumnName = "cli_id")}, inverseJoinColumns = {
        @JoinColumn(name = "emailcli_email_id", referencedColumnName = "email_id")})
    @ManyToMany
    private Collection<Email> emailCollection;
    @JoinTable(name = "enderecocliente", joinColumns = {
        @JoinColumn(name = "endcli_cli_id", referencedColumnName = "cli_id")}, inverseJoinColumns = {
        @JoinColumn(name = "endcli_end_id", referencedColumnName = "end_id")})
    @ManyToMany
    private Collection<Endereco> enderecoCollection;
    @JoinTable(name = "telefonecliente", joinColumns = {
        @JoinColumn(name = "telcli_cli_id", referencedColumnName = "cli_id")}, inverseJoinColumns = {
        @JoinColumn(name = "telcli_tel_id", referencedColumnName = "tel_id")})
    @ManyToMany
    private Collection<Telefone> telefoneCollection;
    @JoinColumn(name = "cli_fil_id", referencedColumnName = "fil_id")
    @ManyToOne
    private Filial filial;

    public Cliente() {
    }

    public Cliente(Integer cliId) {
        this.cliId = cliId;
    }

    public Cliente(Integer cliId, String cliNome, String cliCnpjcpf, String cliRg, boolean cliSts, String cliTipo) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCnpjcpf = cliCnpjcpf;
        this.cliRg = cliRg;
        this.cliSts = cliSts;
        this.cliTipo = cliTipo;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public Date getCliDatacadastro() {
        return cliDatacadastro;
    }

    public void setCliDatacadastro(Date cliDatacadastro) {
        this.cliDatacadastro = cliDatacadastro;
    }

    public Date getCliDatanascimento() {
        return cliDatanascimento;
    }

    public void setCliDatanascimento(Date cliDatanascimento) {
        this.cliDatanascimento = cliDatanascimento;
    }

    public String getCliCnpjcpf() {
        return cliCnpjcpf;
    }

    public void setCliCnpjcpf(String cliCnpjcpf) {
        this.cliCnpjcpf = cliCnpjcpf;
    }

    public String getCliRg() {
        return cliRg;
    }

    public void setCliRg(String cliRg) {
        this.cliRg = cliRg;
    }

    public boolean getCliSts() {
        return cliSts;
    }

    public void setCliSts(boolean cliSts) {
        this.cliSts = cliSts;
    }

    public String getCliTipo() {
        return cliTipo;
    }

    public void setCliTipo(String cliTipo) {
        this.cliTipo = cliTipo;
    }

    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    public Collection<Telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<Telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
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
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }
}
