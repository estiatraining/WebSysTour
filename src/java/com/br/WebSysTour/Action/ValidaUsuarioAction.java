/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Action;

import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.ServiceDao.MenuDaoBean;
import com.br.WebSysTour.ServiceDao.MenuDaoLocal;
import com.br.WebSysTour.ServiceDao.UsuarioDaoBean;
import com.br.WebSysTour.ServiceDao.UsuarioDaoLocal;
import com.br.WebSysTour.Utils.ArquiteturaException;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;


/**
 *
 * @author Destroyer
 */
@ManagedBean
@SessionScoped
public class ValidaUsuarioAction implements Serializable{
    //@EJB
    private UsuarioDaoLocal servico = new UsuarioDaoBean();
    //@EJB
    private MenuDaoLocal menuServico = new MenuDaoBean();
    
    private Usuario bean;
    /** Creates a new instance of ValidaUsuarioAction */
    public ValidaUsuarioAction() {
        this.bean = new Usuario();
    }
    public Usuario getBean() {
        return bean;
    }

    /**
     *
     * @param bean
     */
    public void setBean(Usuario bean) {
        this.bean = bean;
    }
    /**
     *
     * @return
     * @throws Exception
     */
    public void validarUsuario(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        try {
            if (!validaPrimeiroUsu()) {
                if ("admin".equalsIgnoreCase(this.getBean().getUsrLogin()) && "202cb962ac59075b964b07152d234b70".equalsIgnoreCase(this.getBean().getUsrSenha())) {
                    bean = addUsuarioDefault();
                    if (bean.getUsrId() != null) {
                        FacesContext.getCurrentInstance().addMessage("acao", new FacesMessage(FacesMessage.SEVERITY_INFO, "Logando...", ""));
                        menuServico.createDefaultMenus(bean);
                        context.addCallbackParam("login", true);
                        logIn(bean);
                    }
                } else {
                    FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha incorretos!", ""));
                    context.addCallbackParam("login", false);
                }
            } else {
                Usuario objAuxiliar = (Usuario) servico.validaUsuario(this.getBean());
                if (objAuxiliar.getUsrId() != null) {
                    FacesContext.getCurrentInstance().addMessage("acao", new FacesMessage(FacesMessage.SEVERITY_INFO, "Logando...", ""));
                    context.addCallbackParam("login", true);
                    logIn(objAuxiliar);
                } else {
                    FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha incorretos!", ""));
                    context.addCallbackParam("login", false);
                }
            }
        } catch (Exception e) {
            throw new ArquiteturaException(e, bean);
        }
    }

    public Boolean validaPrimeiroUsu() throws Exception {
        if (servico.select().size() > 0) {
            return true;
        }
        return false;
    }

    public Usuario addUsuarioDefault() throws Exception {
        bean.setUsrLogin("admin");
        bean.setUsrNome("Administrador");
        bean.setUsrSenha("123");
        bean.setUsrSts(true);
        bean.setUsrTipo("A");
        return servico.save(bean);
    }
    public void logIn(Usuario bean) throws Exception {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usrSession", bean);
            FacesContext.getCurrentInstance().getExternalContext().redirect("principal.jsf");
        } catch (Exception e) {
            throw new ArquiteturaException(e, bean);
        }
    }

    public void logOut() {
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usrSession");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("validaUsuarioAction");
            bean = null;
            FacesContext.getCurrentInstance().getExternalContext().redirect("/system/index.jsf");
        } catch (Exception e) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/system/index.jsf");
            } catch (IOException ex) {
                
            }
        }
    }
}
