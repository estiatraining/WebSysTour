package com.br.WebSysTour.Action;

import com.br.WebSysTour.Entilies.Menu;
import com.br.WebSysTour.ServiceDao.MenuDaoBean;
import com.br.WebSysTour.ServiceDao.MenuDaoLocal;
import com.br.WebSysTour.Utils.ArquiteturaException;
import com.br.WebSysTour.Utils.SessionUtils;
import com.br.WebSysTour.Utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author Matriz
 */
@ManagedBean(value = "menuAction")
@RequestScoped
public class MenuAction extends SessionUtils implements CrudAction<Menu> {

    //@EJB
    //@Inject
    private MenuDaoLocal servico = new MenuDaoBean();
    private Menu bean;
    private MenuModel modelo;

    private DataModel dataModel;
    private List<Menu> listSearch;

    public MenuAction() throws Exception {
        this.bean = new Menu();
        this.modelo = new DefaultMenuModel();
        servico.setUsuario(getUsuarioSessions());
        try {
            List<Menu> list = servico.menusToReturn();
            Iterator itColl = list.iterator();
            Menu objMenus = new Menu();
            while (itColl.hasNext()) {
                objMenus = (Menu) itColl.next();
                Submenu submenu = new Submenu();
                submenu.setLabel(objMenus.getMenuDescricao());
                List<Menu> listSubMenus = servico.subMenusToReturn(objMenus.getMenuId());
                Iterator itCollSubMenus = listSubMenus.iterator();
                Menu objSubMenus = new Menu();
                while (itCollSubMenus.hasNext()) {
                    objSubMenus = (Menu) itCollSubMenus.next();
                    MenuItem item = new MenuItem();
                    item.setValue(objSubMenus.getMenuDescricao());
                    item.setUrl(objSubMenus.getMenuLink());
                    List<Menu> subMenusItens = servico.subMenusToReturn(3);
                    Iterator itCollSubMenusItens = subMenusItens.iterator();
                    Menu objSubMenusItens = new Menu();
                    submenu.getChildren().add(item);
                }

                this.modelo.addSubmenu(submenu);
            }
        } catch (Exception e) {
            throw new ArquiteturaException(e, getUsuarioSessions());
        }
    }

    public MenuModel getModelo() {
        return modelo;
    }

    public Menu getBean() {
        return bean;
    }

    public void setBean(Menu bean) {
        this.bean = bean;
    }

    @Override
    public void save(ActionEvent actionEvent) throws Exception {
        if (this.getBean().getMenuId() > 0) {
            this.getBean().setUsuario(Utils.getUserOfSession());
            servico.save(this.getBean());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro incluído com sucesso."));
        } else {
            servico.update(this.getBean());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro alterado com sucesso."));
        }
    }

    @Override
    public Menu restore(ActionEvent actionEvent) throws Exception {
        this.listSearch = servico.findToReturn(this.getBean());
        return null;
    }

    @Override
    public List<Menu> select(ActionEvent actionEvent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(ActionEvent actionEvent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void load(ActionEvent actionEvent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void limpar() {
        this.bean = new Menu();
    }

    public Collection getListaBySelect() throws Exception {
        List objLista = new ArrayList<Menu>();
        for (Menu objMenus : servico.select()) {
            objLista.add(new SelectItem(objMenus.getMenuId(),
                    objMenus.getMenuDescricao()));
        }
        return objLista;
    }

    public DataModel getFind() throws Exception {
        this.dataModel = new ListDataModel(this.listSearch);
        return this.dataModel;
    }

    public List<String> complete(String query) throws Exception {

        List<String> results = new ArrayList<String>();
        Menu beanTeste = new Menu();
        beanTeste.setMenuDescricao(query);

        for(Menu objMenus : servico.findToReturn(beanTeste)) {
            results.add(objMenus.getMenuDescricao());
        }

        return results;
    }
}
