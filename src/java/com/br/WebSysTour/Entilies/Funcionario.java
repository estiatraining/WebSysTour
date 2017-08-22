/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Entilies;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "funcionario")
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fun_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer funId;
    @Basic(optional = false)
    @Column(name = "fun_nome")
    private String funNome;
    @Column(name = "fun_dataadmissao")
    @Temporal(TemporalType.DATE)
    private Date funDataadmissao;
    @Column(name = "fun_datademissao")
    @Temporal(TemporalType.DATE)
    private Date funDatademissao;
    @Column(name = "fun_comissao")
    private BigDecimal funComissao;
    @Column(name = "fun_salario")
    private BigDecimal funSalario;
    @Basic(optional = false)
    @Column(name = "fun_sts")
    private boolean funSts;
    @Basic(optional = false)
    @Column(name = "fun_ctps")
    private String funCtps;
    @Column(name = "fun_cpf_cnpj")
    private String funCpfCnpj;
    @Column(name = "fun_rg")
    private String funRg;
    @Column(name = "fun_foto")
    private String funFoto;
    @ManyToMany(mappedBy = "funcionarioCollection")
    private Collection<Email> emailCollection;
    @JoinTable(name = "telefonefuncionario", joinColumns = {
        @JoinColumn(name = "telfun_fun_id", referencedColumnName = "fun_id")}, inverseJoinColumns = {
        @JoinColumn(name = "telfun_tel_id", referencedColumnName = "tel_id")})
    @ManyToMany
    private Collection<Telefone> telefoneCollection;
    @ManyToMany(mappedBy = "funcionarioCollection")
    private Collection<Endereco> enderecoCollection;
    @JoinColumn(name = "fun_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "fun_dep_id", referencedColumnName = "dep_id")
    @ManyToOne
    private Departamento departamento;
    @JoinColumn(name = "fun_car_id", referencedColumnName = "car_id")
    @ManyToOne
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(Integer funId) {
        this.funId = funId;
    }

    public Funcionario(Integer funId, String funNome, boolean funSts, String funCtps) {
        this.funId = funId;
        this.funNome = funNome;
        this.funSts = funSts;
        this.funCtps = funCtps;
    }

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public String getFunNome() {
        return funNome;
    }

    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }

    public Date getFunDataadmissao() {
        return funDataadmissao;
    }

    public void setFunDataadmissao(Date funDataadmissao) {
        this.funDataadmissao = funDataadmissao;
    }

    public Date getFunDatademissao() {
        return funDatademissao;
    }

    public void setFunDatademissao(Date funDatademissao) {
        this.funDatademissao = funDatademissao;
    }

    public BigDecimal getFunComissao() {
        return funComissao;
    }

    public void setFunComissao(BigDecimal funComissao) {
        this.funComissao = funComissao;
    }

    public BigDecimal getFunSalario() {
        return funSalario;
    }

    public void setFunSalario(BigDecimal funSalario) {
        this.funSalario = funSalario;
    }

    public boolean getFunSts() {
        return funSts;
    }

    public void setFunSts(boolean funSts) {
        this.funSts = funSts;
    }

    public String getFunCtps() {
        return funCtps;
    }

    public void setFunCtps(String funCtps) {
        this.funCtps = funCtps;
    }

    public String getFunCpfCnpj() {
        return funCpfCnpj;
    }

    public void setFunCpfCnpj(String funCpfCnpj) {
        this.funCpfCnpj = funCpfCnpj;
    }

    public String getFunRg() {
        return funRg;
    }

    public void setFunRg(String funRg) {
        this.funRg = funRg;
    }

    public String getFunFoto() {
        return funFoto;
    }

    public void setFunFoto(String funFoto) {
        this.funFoto = funFoto;
    }

    public Collection<Email> getEmailCollection() {
        return emailCollection;
    }

    public void setEmailCollection(Collection<Email> emailCollection) {
        this.emailCollection = emailCollection;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funId != null ? funId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.funId == null && other.funId != null) || (this.funId != null && !this.funId.equals(other.funId))) {
            return false;
        }
        return true;
    }
}
