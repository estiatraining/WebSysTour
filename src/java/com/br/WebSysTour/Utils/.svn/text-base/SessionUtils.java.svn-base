/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.Utils;

import com.br.WebSysTour.Entilies.Usuario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matriz
 */
public class SessionUtils implements PhaseListener {

    private Usuario usr = new Usuario();

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        String currentPage = context.getViewRoot().getViewId();
        boolean verifyCurrentPage = (currentPage.lastIndexOf("index.xhtml") > -1);
        try {
            Usuario usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usrSession");
            if (!verifyCurrentPage) {
                boolean auth = usr != null;
                if (!auth) {                    
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usrSession");
                    FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Você não tem acesso a esta página!", ""));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/system/index.jsf");
                }
            } 
        } catch (Exception e) {
            try {
                throw new ArquiteturaException(e, usr);
            } catch (Exception ex) {
            }
        }
    }

    public Usuario getUsuarioSessions() {
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usrSession");
        return usr;
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    public String getData() {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
