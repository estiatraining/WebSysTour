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
@Table(name = "auditoria")
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "aud_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer audId;
    @Basic(optional = false)
    @Column(name = "aud_data")
    @Temporal(TemporalType.DATE)
    private Date audData;
    @Basic(optional = false)
    @Column(name = "aud_hora")
    @Temporal(TemporalType.TIME)
    private Date audHora;
    @Basic(optional = false)
    @Column(name = "aud_acao")
    private String audAcao;
    @Basic(optional = false)
    @Column(name = "aud_tabela")
    private String audTabela;
    @Column(name = "aud_descricao")
    private String audDescricao;
    @JoinColumn(name = "aud_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario usuario;

    public Auditoria() {
    }

    public Auditoria(Integer audId) {
        this.audId = audId;
    }

    public Auditoria(Integer audId, Date audData, Date audHora, String audAcao, String audTabela) {
        this.audId = audId;
        this.audData = audData;
        this.audHora = audHora;
        this.audAcao = audAcao;
        this.audTabela = audTabela;
    }

    public Integer getAudId() {
        return audId;
    }

    public void setAudId(Integer audId) {
        this.audId = audId;
    }

    public Date getAudData() {
        return audData;
    }

    public void setAudData(Date audData) {
        this.audData = audData;
    }

    public Date getAudHora() {
        return audHora;
    }

    public void setAudHora(Date audHora) {
        this.audHora = audHora;
    }

    public String getAudAcao() {
        return audAcao;
    }

    public void setAudAcao(String audAcao) {
        this.audAcao = audAcao;
    }

    public String getAudTabela() {
        return audTabela;
    }

    public void setAudTabela(String audTabela) {
        this.audTabela = audTabela;
    }

    public String getAudDescricao() {
        return audDescricao;
    }

    public void setAudDescricao(String audDescricao) {
        this.audDescricao = audDescricao;
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
        hash += (audId != null ? audId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.audId == null && other.audId != null) || (this.audId != null && !this.audId.equals(other.audId))) {
            return false;
        }
        return true;
    }
}
