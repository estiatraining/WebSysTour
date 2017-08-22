/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.WebSysTour.UtilsDB;

import com.br.WebSysTour.Entilies.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cleison Ferreira
 */
public interface CrudDao <Obj, ID extends Serializable>{
    public Obj save(Obj d) throws Exception, SQLException;
    public Boolean update(Obj d)throws Exception, SQLException;
    public void delete(Obj d)throws Exception, SQLException;
    public List<Obj> select()throws Exception, SQLException;
    public Obj restore(ID id) throws Exception, SQLException;
    public List<Obj> find(Map<String, Object> params)throws Exception, SQLException;
    public List<Obj> findBySqlQuery(String query) throws Exception, SQLException;
    public Usuario getUsuario();
    public void setUsuario(Usuario usr);
}
