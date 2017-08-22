/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Action;

import com.br.WebSysTour.Entilies.Fornecedor;
import com.br.WebSysTour.ServiceDao.FornecedorDaoBean;
import com.br.WebSysTour.ServiceDao.FornecedorDaoLocal;
import java.util.List;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Juliana Andreyves
 */
public class FornecedorAction implements CrudAction<Fornecedor> {
    //@EJB
    //@Inject
    private FornecedorDaoLocal servico = new FornecedorDaoBean();
    private Fornecedor bean;

    public FornecedorAction() {
        this.bean = new Fornecedor();
    }

    public Fornecedor getBean() {
        return bean;
    }

    public void setBean(Fornecedor bean) {
        this.bean = bean;
    }

    @Override
    public void save(ActionEvent actionEvent) throws Exception {
        if (bean.getForId() == null) {
            servico.save(bean);
        } else {
            servico.update(bean);
        }
    }

    @Override
    public Fornecedor restore(ActionEvent actionEvent) throws Exception {
        return (Fornecedor) servico.restore(bean.getForId());
    }

    @Override
    public List<Fornecedor> select(ActionEvent actionEvent) throws Exception {
        return servico.select();
    }

    @Override
    public void delete(ActionEvent actionEvent) throws Exception {
        servico.delete(bean);
    }

    @Override
    public void load(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        servico.restore(bean.getForId());
    }

}
