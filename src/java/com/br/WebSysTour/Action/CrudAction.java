/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.Action;

import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Cleison Ferreira
 */
public interface CrudAction<Obj> extends Serializable{
    public void save(ActionEvent actionEvent) throws Exception;
    public Obj restore(ActionEvent actionEvent)throws Exception;
    public List<Obj> select(ActionEvent actionEvent)throws Exception;
    public void delete(ActionEvent actionEvent)throws Exception;
    public void load(ActionEvent actionEvent)throws Exception;
}
