/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Entilies;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "menu_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer menuId;
    @Basic(optional = false)
    @Column(name = "menu_nome")
    private String menuNome;
    @Basic(optional = false)
    @Column(name = "menu_descricao")
    private String menuDescricao;
    @Column(name = "menu_menu_id")
    private Integer menuMenuId;
    @Basic(optional = false)
    @Column(name = "menu_link")
    private String menuLink;
    @Basic(optional = false)
    @Column(name = "menu_ordem")
    private short menuOrdem;
    @Basic(optional = false)
    @Column(name = "menu_tipo")
    private String menuTipo;
    @Basic(optional = false)
    @Column(name = "menu_sts")
    private boolean menuSts;
    @JoinColumn(name = "menu_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private Collection<Acesso> acessoCollection;

    public Menu() {
    }

    public Menu(Integer menuId) {
        this.menuId = menuId;
    }

    public Menu(Integer menuId, String menuNome, String menuDescricao, String menuLink, short menuOrdem, String menuTipo, boolean menuSts) {
        this.menuId = menuId;
        this.menuNome = menuNome;
        this.menuDescricao = menuDescricao;
        this.menuLink = menuLink;
        this.menuOrdem = menuOrdem;
        this.menuTipo = menuTipo;
        this.menuSts = menuSts;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuNome() {
        return menuNome;
    }

    public void setMenuNome(String menuNome) {
        this.menuNome = menuNome;
    }

    public String getMenuDescricao() {
        return menuDescricao;
    }

    public void setMenuDescricao(String menuDescricao) {
        this.menuDescricao = menuDescricao;
    }

    public Integer getMenuMenuId() {
        return menuMenuId;
    }

    public void setMenuMenuId(Integer menuMenuId) {
        this.menuMenuId = menuMenuId;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    public short getMenuOrdem() {
        return menuOrdem;
    }

    public void setMenuOrdem(short menuOrdem) {
        this.menuOrdem = menuOrdem;
    }

    public String getMenuTipo() {
        return menuTipo;
    }

    public void setMenuTipo(String menuTipo) {
        this.menuTipo = menuTipo;
    }

    public boolean getMenuSts() {
        return menuSts;
    }

    public void setMenuSts(boolean menuSts) {
        this.menuSts = menuSts;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Acesso> getAcessoCollection() {
        return acessoCollection;
    }

    public void setAcessoCollection(Collection<Acesso> acessoCollection) {
        this.acessoCollection = acessoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

}
