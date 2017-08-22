/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Entilies.Acesso;
import com.br.WebSysTour.Entilies.Menu;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.Utils.ArquiteturaException;
import com.br.WebSysTour.UtilsDB.CrudDaoImp;
import javax.ejb.Stateless;
/**
 *
 * @author Cleison Ferreira
 */
//@Stateless
public class AcessoDaoBean extends CrudDaoImp<Acesso, Integer> implements AcessoDaoLocal{

    @Override
    public void createDefaultAcessos(Usuario usr, Menu menu, boolean inc,
            boolean alt, boolean exc, boolean pesq) throws Exception {
        try {
            Acesso objAcesso = new Acesso();
            objAcesso.setUsuario(usr);
            objAcesso.setMenu(menu);
            objAcesso.setAcessInc(inc);
            objAcesso.setAcessAlt(alt);
            objAcesso.setAcessExc(exc);
            objAcesso.setAcessPesq(pesq);
            super.save(objAcesso);
        } catch (Exception e) {
            throw new ArquiteturaException(e, getUsuario());
        }
    }

}
