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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emp_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer empId;
    @Basic(optional = false)
    @Column(name = "emp_nome")
    private String empNome;
    @Basic(optional = false)
    @Column(name = "emp_cnpj")
    private String empCnpj;
    @Basic(optional = false)
    @Column(name = "emp_sts")
    private boolean empSts;
    @JoinTable(name = "enderecoempresa", joinColumns = {
        @JoinColumn(name = "endemp_emp_id", referencedColumnName = "emp_id")}, inverseJoinColumns = {
        @JoinColumn(name = "endemp_end_id", referencedColumnName = "end_id")})
    @ManyToMany
    private Collection<Endereco> enderecoCollection;
    @OneToMany(mappedBy = "empresa")
    private Collection<Filial> filialCollection;

    public Empresa() {
    }

    public Empresa(Integer empId) {
        this.empId = empId;
    }

    public Empresa(Integer empId, String empNome, String empCnpj, boolean empSts) {
        this.empId = empId;
        this.empNome = empNome;
        this.empCnpj = empCnpj;
        this.empSts = empSts;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpNome() {
        return empNome;
    }

    public void setEmpNome(String empNome) {
        this.empNome = empNome;
    }

    public String getEmpCnpj() {
        return empCnpj;
    }

    public void setEmpCnpj(String empCnpj) {
        this.empCnpj = empCnpj;
    }

    public boolean getEmpSts() {
        return empSts;
    }

    public void setEmpSts(boolean empSts) {
        this.empSts = empSts;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    public Collection<Filial> getFilialCollection() {
        return filialCollection;
    }

    public void setFilialCollection(Collection<Filial> filialCollection) {
        this.filialCollection = filialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }
}
