/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.UtilsDB.CrudDao;
import java.util.List;

/**
 *
 * @author Cleison Ferreira
 */
//@Local
public interface UsuarioDaoLocal extends CrudDao<Usuario, Integer>{
    public Usuario validaUsuario(Usuario bean)throws Exception;
    public List<Usuario> consulta(Usuario bean) throws Exception;
}
