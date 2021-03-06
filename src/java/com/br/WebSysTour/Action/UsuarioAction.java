package com.br.WebSysTour.Action;

import com.br.WebSysTour.ServiceDao.UsuarioDaoBean;
import com.br.WebSysTour.ServiceDao.UsuarioDaoLocal;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.Utils.SessionUtils;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 * 
 * @author Desenvolvedor
 */
@ManagedBean
@RequestScoped
public class UsuarioAction extends SessionUtils implements CrudAction<Usuario> {

    //@EJB
    //@Inject
    private UsuarioDaoLocal servico = new UsuarioDaoBean();
    private Usuario bean;
    private List<Usuario> dataTable;
    private Usuario selectedUsuario;
    private String usrSts = "true";
    private String usrSenha2 = "";
    /**
     * 
     */
    public UsuarioAction() {
        this.bean = new Usuario();
        servico.setUsuario(getUsuarioSessions());
    }

    /**
     * 
     * @return
     */
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
     * @param b
     * @throws Exception
     */
    @Override
    public void save(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        if (!bean.getUsrSenha().equalsIgnoreCase(getUsrSenha2())) {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "As senhas estao diferentes!", ""));
            context.addCallbackParam("senhas", true);
        }
        bean = null;
        bean = new Usuario();
        bean.setUsrSts(new Boolean(getUsrSts()));
        if (bean.getUsrId() == null) {
            servico.save(bean);
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso!", ""));
        } else {
            servico.update(bean);
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso!", ""));
        }
    }

    /**
     * 
     * @param b
     * @return
     * @throws Exception
     */
    @Override
    public Usuario restore(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        return (Usuario) servico.restore(bean.getUsrId());
    }

    /**
     * 
     * @param b
     * @return
     * @throws Exception
     */
    @Override
    public List<Usuario> select(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        bean.setUsrSts(new Boolean(getUsrSts()));
        this.dataTable = servico.consulta(bean);
        return this.dataTable;
    }

    /**
     * 
     * @param b
     * @throws Exception
     */
    @Override
    public void delete(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        servico.delete(bean);
    }

    /**
     * 
     * @param b
     * @throws Exception
     */
    @Override
    public void load(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        bean.setUsrSts(new Boolean(getUsrSts()));
    }

    /**
     * @return the dataTable
     */
    public List<Usuario> getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(List<Usuario> dataTable) {
        try {
            this.dataTable = dataTable;
        } catch (Exception ex) {
        }
    }

    public void limpar() {
        this.bean = null;
    }

    /**
     * @return the selectedUsuario
     */
    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    /**
     * @param selectedUsuario the selectedUsuario to set
     */
    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    /**
     * @return the usrSts
     */
    public String getUsrSts() {
        return usrSts;
    }

    /**
     * @param usrSts the usrSts to set
     */
    public void setUsrSts(String usrSts) {
        this.usrSts = usrSts;
    }

    /**
     * @return the usrSenha2
     */
    public String getUsrSenha2() {
        return usrSenha2;
    }

    /**
     * @param usrSenha2 the usrSenha2 to set
     */
    public void setUsrSenha2(String usrSenha2) {
        this.usrSenha2 = usrSenha2;
    }


}
