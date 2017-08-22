/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Entilies;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "errosistema")
public class ErroSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "erro_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer erroId;
    @Basic(optional = false)
    @Column(name = "erro_data")
    @Temporal(TemporalType.DATE)
    private Date erroData;
    @Basic(optional = false)
    @Column(name = "erro_hora")
    @Temporal(TemporalType.TIME)
    private Date erroHora;
    @Basic(optional = false)
    @Column(name = "erro_desc")
    private String erroDesc;
    @JoinColumn(name = "erro_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario usuario;

    public ErroSistema() {
    }

    public ErroSistema(Integer erroId) {
        this.erroId = erroId;
    }

    public ErroSistema(Integer erroId, Date erroData, Date erroHora, String erroDesc) {
        this.erroId = erroId;
        this.erroData = erroData;
        this.erroHora = erroHora;
        this.erroDesc = erroDesc;
    }

    public Integer getErroId() {
        return erroId;
    }

    public void setErroId(Integer erroId) {
        this.erroId = erroId;
    }

    public Date getErroData() {
        return erroData;
    }

    public void setErroData(Date erroData) {
        this.erroData = erroData;
    }

    public Date getErroHora() {
        return erroHora;
    }

    public void setErroHora(Date erroHora) {
        this.erroHora = erroHora;
    }

    public String getErroDesc() {
        return erroDesc;
    }

    public void setErroDesc(String erroDesc) {
        this.erroDesc = erroDesc;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erroId != null ? erroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErroSistema)) {
            return false;
        }
        ErroSistema other = (ErroSistema) object;
        if ((this.erroId == null && other.erroId != null) || (this.erroId != null && !this.erroId.equals(other.erroId))) {
            return false;
        }
        return true;
    }
}
