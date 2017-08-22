/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Entilies.Acesso;
import com.br.WebSysTour.Entilies.Menu;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.UtilsDB.CrudDao;
import javax.ejb.Local;
/**
 *
 * @author Cleison Ferreira
 */
//@Local
public interface AcessoDaoLocal extends CrudDao<Acesso, Integer>{
    public void createDefaultAcessos(Usuario usr, Menu menu, boolean inc,
            boolean alt, boolean exc, boolean pesq) throws Exception;
}
