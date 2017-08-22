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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "car_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer carId;
    @Basic(optional = false)
    @Column(name = "car_descricao")
    private String carDescricao;
    @Basic(optional = false)
    @Column(name = "car_sts")
    private boolean carSts;
    @OneToMany(mappedBy = "cargo")
    private Collection<Funcionario> funcionarioCollection;

    public Cargo() {
    }

    public Cargo(Integer carId) {
        this.carId = carId;
    }

    public Cargo(Integer carId, String carDescricao, boolean carSts) {
        this.carId = carId;
        this.carDescricao = carDescricao;
        this.carSts = carSts;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarDescricao() {
        return carDescricao;
    }

    public void setCarDescricao(String carDescricao) {
        this.carDescricao = carDescricao;
    }

    public boolean getCarSts() {
        return carSts;
    }

    public void setCarSts(boolean carSts) {
        this.carSts = carSts;
    }

    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }
}
