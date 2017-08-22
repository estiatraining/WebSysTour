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
@Table(name = "parametro")
public class Parametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "param_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer paramId;
    @Column(name = "param_img_login")
    private String paramImgLogin;
    @Column(name = "param_img_inicial")
    private String paramImgInicial;
    @Column(name = "param_img_logo")
    private String paramImgLogo;
    @Column(name = "param_versao")
    private String paramVersao;
    @Basic(optional = false)
    @Column(name = "param_data")
    @Temporal(TemporalType.DATE)
    private Date paramData;
    @JoinColumn(name = "param_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario usuario;

    public Parametro() {
    }

    public Parametro(Integer paramId) {
        this.paramId = paramId;
    }

    public Parametro(Integer paramId, Date paramData) {
        this.paramId = paramId;
        this.paramData = paramData;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamImgLogin() {
        return paramImgLogin;
    }

    public void setParamImgLogin(String paramImgLogin) {
        this.paramImgLogin = paramImgLogin;
    }

    public String getParamImgInicial() {
        return paramImgInicial;
    }

    public void setParamImgInicial(String paramImgInicial) {
        this.paramImgInicial = paramImgInicial;
    }

    public String getParamImgLogo() {
        return paramImgLogo;
    }

    public void setParamImgLogo(String paramImgLogo) {
        this.paramImgLogo = paramImgLogo;
    }

    public String getParamVersao() {
        return paramVersao;
    }

    public void setParamVersao(String paramVersao) {
        this.paramVersao = paramVersao;
    }

    public Date getParamData() {
        return paramData;
    }

    public void setParamData(Date paramData) {
        this.paramData = paramData;
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
        hash += (paramId != null ? paramId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.paramId == null && other.paramId != null) || (this.paramId != null && !this.paramId.equals(other.paramId))) {
            return false;
        }
        return true;
    }
}
