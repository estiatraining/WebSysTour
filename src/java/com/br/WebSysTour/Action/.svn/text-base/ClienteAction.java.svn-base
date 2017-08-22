/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Action;

import com.br.WebSysTour.Entilies.Cliente;
import com.br.WebSysTour.ServiceDao.ClienteDaoBean;
import com.br.WebSysTour.ServiceDao.ClienteDaoLocal;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

 
public class ClienteAction implements CrudAction<Cliente> {
    @EJB
    private ClienteDaoLocal servico = new ClienteDaoBean();
    private Cliente bean;
    private Book book = new Book();
    private List<Book> books = new ArrayList<Book>();

    
    public ClienteAction() {
        this.bean = new Cliente();
    }

    public Cliente getBean() {
        return bean;
    }

    public void setBean(Cliente bean) {
        this.bean = bean;
    }
        public String reinit() {
        book = new Book();

        return null;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }  

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public void save(ActionEvent actionEvent) throws Exception {
        if (bean.getCliId() == null) {
            servico.save(bean);
        } else {
            servico.update(bean);
        }
    }

    @Override
    public Cliente restore(ActionEvent actionEvent) throws Exception {
        return (Cliente) servico.restore(bean.getCliId());
    }

    @Override
    public List<Cliente> select(ActionEvent actionEvent) throws Exception {
        return servico.select();
    }

    @Override
    public void delete(ActionEvent actionEvent) throws Exception {
        servico.delete(bean);
    }

    @Override
    public void load(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        servico.restore(bean.getCliId());
    }

}
