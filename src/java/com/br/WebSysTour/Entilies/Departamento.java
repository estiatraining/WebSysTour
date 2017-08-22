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
@Table(name = "departamento")
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dep_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer depId;
    @Basic(optional = false)
    @Column(name = "dep_nome")
    private String depNome;
    @Basic(optional = false)
    @Column(name = "dep_sts")
    private boolean depSts;
    @OneToMany(mappedBy = "departamento")
    private Collection<Funcionario> funcionarioCollection;
    @JoinColumn(name = "dep_fil_id", referencedColumnName = "fil_id")
    @ManyToOne
    private Filial filial;

    public Departamento() {
    }

    public Departamento(Integer depId) {
        this.depId = depId;
    }

    public Departamento(Integer depId, String depNome, boolean depSts) {
        this.depId = depId;
        this.depNome = depNome;
        this.depSts = depSts;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepNome() {
        return depNome;
    }

    public void setDepNome(String depNome) {
        this.depNome = depNome;
    }

    public boolean getDepSts() {
        return depSts;
    }

    public void setDepSts(boolean depSts) {
        this.depSts = depSts;
    }

    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
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
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }
}
