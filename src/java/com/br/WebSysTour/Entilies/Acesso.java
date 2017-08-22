/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Entilies;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "acesso")
public class Acesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acess_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer acessId;
    @Basic(optional = false)
    @Column(name = "acess_inc")
    private boolean acessInc;
    @Basic(optional = false)
    @Column(name = "acess_alt")
    private boolean acessAlt;
    @Basic(optional = false)
    @Column(name = "acess_exc")
    private boolean acessExc;
    @Basic(optional = false)
    @Column(name = "acess_pesq")
    private boolean acessPesq;
    @JoinColumn(name = "acess_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "acess_menu_id", referencedColumnName = "menu_id")
    @ManyToOne(optional = false)
    private Menu menu;

    public Acesso() {
    }

    public Acesso(Integer acessId) {
        this.acessId = acessId;
    }

    public Acesso(Integer acessId, boolean acessInc, boolean acessAlt, boolean acessExc, boolean acessPesq) {
        this.acessId = acessId;
        this.acessInc = acessInc;
        this.acessAlt = acessAlt;
        this.acessExc = acessExc;
        this.acessPesq = acessPesq;
    }

    public Integer getAcessId() {
        return acessId;
    }

    public void setAcessId(Integer acessId) {
        this.acessId = acessId;
    }

    public boolean getAcessInc() {
        return acessInc;
    }

    public void setAcessInc(boolean acessInc) {
        this.acessInc = acessInc;
    }

    public boolean getAcessAlt() {
        return acessAlt;
    }

    public void setAcessAlt(boolean acessAlt) {
        this.acessAlt = acessAlt;
    }

    public boolean getAcessExc() {
        return acessExc;
    }

    public void setAcessExc(boolean acessExc) {
        this.acessExc = acessExc;
    }

    public boolean getAcessPesq() {
        return acessPesq;
    }

    public void setAcessPesq(boolean acessPesq) {
        this.acessPesq = acessPesq;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acessId != null ? acessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.acessId == null && other.acessId != null) || (this.acessId != null && !this.acessId.equals(other.acessId))) {
            return false;
        }
        return true;
    }
}
