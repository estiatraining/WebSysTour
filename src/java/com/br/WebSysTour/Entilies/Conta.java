/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Entilies;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "conta")
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "con_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer conId;
    @Basic(optional = false)
    @Column(name = "con_valorconta")
    private BigDecimal conValorconta;
    @Column(name = "con_valorpagto")
    private BigDecimal conValorpagto;
    @Basic(optional = false)
    @Column(name = "con_dataemissao")
    @Temporal(TemporalType.DATE)
    private Date conDataemissao;
    @Column(name = "con_datapagto")
    @Temporal(TemporalType.DATE)
    private Date conDatapagto;
    @Basic(optional = false)
    @Column(name = "con_tipo")
    private String conTipo;
    @JoinColumn(name = "con_fil_id", referencedColumnName = "fil_id")
    @ManyToOne
    private Filial filial;

    public Conta() {
    }

    public Conta(Integer conId) {
        this.conId = conId;
    }

    public Conta(Integer conId, BigDecimal conValorconta, Date conDataemissao, String conTipo) {
        this.conId = conId;
        this.conValorconta = conValorconta;
        this.conDataemissao = conDataemissao;
        this.conTipo = conTipo;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public BigDecimal getConValorconta() {
        return conValorconta;
    }

    public void setConValorconta(BigDecimal conValorconta) {
        this.conValorconta = conValorconta;
    }

    public BigDecimal getConValorpagto() {
        return conValorpagto;
    }

    public void setConValorpagto(BigDecimal conValorpagto) {
        this.conValorpagto = conValorpagto;
    }

    public Date getConDataemissao() {
        return conDataemissao;
    }

    public void setConDataemissao(Date conDataemissao) {
        this.conDataemissao = conDataemissao;
    }

    public Date getConDatapagto() {
        return conDatapagto;
    }

    public void setConDatapagto(Date conDatapagto) {
        this.conDatapagto = conDatapagto;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
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
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }
}
