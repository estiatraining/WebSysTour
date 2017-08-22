/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Entilies.Menu;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.UtilsDB.CrudDao;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Cleison Ferreira
 */
//@Local
public interface MenuDaoLocal extends CrudDao<Menu, Integer>{
    public List<Menu> menusToReturn() throws Exception;
    public List<Menu> subMenusToReturn(Integer menuMenuId) throws Exception;
    public List<Menu> findToReturn(Menu bean) throws Exception;
    public void createDefaultMenus(Usuario usr) throws Exception;
}
