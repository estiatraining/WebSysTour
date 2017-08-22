/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Constants.Constantes;
import com.br.WebSysTour.Entilies.ErroSistema;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.Utils.Utils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Cleison Ferreira
 */
public class ErroSistemaDaoBean extends Thread implements ErroSistemaDaoLocal{
    private static final EntityManagerFactory EMF = Constantes.getEmf();
    private static final EntityManager em = EMF.createEntityManager();
    private Usuario usr;
    private String descricao;

    public ErroSistemaDaoBean(Usuario usr, String descricao) {
        this.usr = usr;
        this.descricao = descricao;
    }

    @Override
    public void run() {
        ErroSistema bean = new ErroSistema();
        try {
            em.clear();
            em.getTransaction().begin();
            bean.setUsuario(usr);
            bean.setErroData(Utils.getDataAtual());
            bean.setErroHora(Utils.getHoraAtual());
            bean.setErroDesc(descricao);
            em.persist(bean);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
