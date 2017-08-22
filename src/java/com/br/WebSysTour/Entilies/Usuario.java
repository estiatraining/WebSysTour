/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Entilies;

import com.br.WebSysTour.Utils.Utils;
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
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usr_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer usrId;
    @Basic(optional = false)
    @Column(name = "usr_nome")
    private String usrNome;
    @Basic(optional = false)
    @Column(name = "usr_login")
    private String usrLogin;
    @Basic(optional = false)
    @Column(name = "usr_senha")
    private String usrSenha;
    @Basic(optional = false)
    @Column(name = "usr_sts")
    private boolean usrSts;
    @Basic(optional = false)
    @Column(name = "usr_tipo")
    private String usrTipo;
    @OneToMany(mappedBy = "usuario")
    private Collection<ErroSistema> erroSistemaCollection;

    public Usuario() {
    }

    public Usuario(Integer usrId) {
        this.usrId = usrId;
    }

    public Usuario(Integer usrId, String usrNome, String usrLogin, String usrSenha, boolean usrSts, String usrTipo) {
        this.usrId = usrId;
        this.usrNome = usrNome;
        this.usrLogin = usrLogin;
        this.usrSenha = usrSenha;
        this.usrSts = usrSts;
        this.usrTipo = usrTipo;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrNome() {
        return usrNome;
    }

    public void setUsrNome(String usrNome) {
        this.usrNome = usrNome.toUpperCase();
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin.toLowerCase();
    }

    public String getUsrSenha() {
        return usrSenha;
    }

    public void setUsrSenha(String usrSenha) {
        this.usrSenha = new Utils().gerarMD5( usrSenha );
    }

    public boolean getUsrSts() {
        return usrSts;
    }

    public void setUsrSts(boolean usrSts) {
        this.usrSts = usrSts;
    }

    public String getUsrTipo() {
        return usrTipo;
    }

    public void setUsrTipo(String usrTipo) {
        this.usrTipo = usrTipo.toUpperCase();
    }

    public Collection<ErroSistema> getErroSistemaCollection() {
        return erroSistemaCollection;
    }

    public void setErroSistemaCollection(Collection<ErroSistema> erroSistemaCollection) {
        this.erroSistemaCollection = erroSistemaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }
}
