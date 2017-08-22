/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.Utils.ArquiteturaException;
import com.br.WebSysTour.UtilsDB.CrudDaoImp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cleison Ferreira
 */
//@Stateless
public class UsuarioDaoBean extends CrudDaoImp<Usuario, Integer> implements UsuarioDaoLocal {

    @Override
    public Usuario validaUsuario(Usuario bean) throws Exception {
        try {
            LogDaoLocal servico = new LogDaoBean();
            Map<String, Object> params = new HashMap<String, Object>();
            bean.setUsrSts(true);
            params.put("usrLogin", bean.getUsrLogin());
            params.put("usrSenha", bean.getUsrSenha());
            params.put("usrSts", bean.getUsrSts());            
            List<Usuario> lista = super.find(params);            
            for (Usuario usr : lista) {
                bean = usr;
            }            
            if(bean.getUsrId() != null)
                servico.gravarLogs(bean);
          } catch (Exception e) {
             throw new ArquiteturaException(e, bean);
        }
        return bean;
    }

    public List<Usuario> consulta(Usuario bean) throws Exception{
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            if(!"".equalsIgnoreCase(bean.getUsrLogin()))
                params.put("usrLogin", bean.getUsrLogin());
            if(!"".equalsIgnoreCase(bean.getUsrNome()))
                params.put("usrNome", bean.getUsrNome());
            params.put("usrSts", bean.getUsrSts());
            List<Usuario> lista = super.find(params);
            return lista;
        } catch (Exception e) {
            throw new ArquiteturaException(e, bean);
        }
    }
}
