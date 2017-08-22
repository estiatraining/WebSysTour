/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Entilies.Log;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.UtilsDB.CrudDao;
import java.sql.SQLException;
import javax.ejb.Local;

/**
 *
 * @author Cleison Ferreira
 */
//@Local
public interface LogDaoLocal extends CrudDao<Log, Integer>{
    public void gravarLogs(Usuario bean) throws SQLException;    
}
