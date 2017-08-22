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
@Table(name = "log")
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "log_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer logId;
    @Basic(optional = false)
    @Column(name = "log_data")
    @Temporal(TemporalType.DATE)
    private Date logData;
    @Basic(optional = false)
    @Column(name = "log_hora")
    @Temporal(TemporalType.TIME)
    private Date logHora;
    @Column(name = "log_ip")
    private String logIp;
    @JoinColumn(name = "log_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario usuario;

    public Log() {
    }

    public Log(Integer logId) {
        this.logId = logId;
    }

    public Log(Integer logId, Date logData, Date logHora) {
        this.logId = logId;
        this.logData = logData;
        this.logHora = logHora;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLogData() {
        return logData;
    }

    public void setLogData(Date logData) {
        this.logData = logData;
    }

    public Date getLogHora() {
        return logHora;
    }

    public void setLogHora(Date logHora) {
        this.logHora = logHora;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
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
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

}
