/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Utils.Utils;
import com.br.WebSysTour.Entilies.Log;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.Utils.ArquiteturaException;
import com.br.WebSysTour.UtilsDB.CrudDaoImp;
import java.net.InetAddress;
import java.sql.SQLException;
import javax.ejb.Stateless;

/**
 *
 * @author Cleison Ferreira
 */
//@Stateless
public class LogDaoBean extends CrudDaoImp<Log, Integer> implements LogDaoLocal {

    @Override
    public void gravarLogs(Usuario bean) throws SQLException {
        try {
            Log objLogs = new Log();
            objLogs.setLogData(Utils.getDataAtual());
            objLogs.setLogHora(Utils.getHoraAtual());
            objLogs.setUsuario(bean);
            objLogs.setLogIp(InetAddress.getLocalHost().getHostAddress());

            super.save(objLogs);
        } catch (Exception e) {
            try {
                throw new ArquiteturaException(e, getUsuario());
            } catch (Exception ex) {
            }
        }
    }
}
