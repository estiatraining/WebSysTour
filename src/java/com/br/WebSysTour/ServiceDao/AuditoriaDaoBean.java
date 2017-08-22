/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Constants.Constantes;
import com.br.WebSysTour.Entilies.Auditoria;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.Utils.Utils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Cleison Ferreira
 */
public class AuditoriaDaoBean extends Thread implements AuditoriaDaoLocal {

    private static final EntityManagerFactory EMF = Constantes.getEmf();
    private static final EntityManager em = EMF.createEntityManager();
    private Usuario usr;
    private String acao;
    private String tabela;
    private String descricao;

    public AuditoriaDaoBean(Usuario usr, String tabela, String acao, String descricao) {
        this.usr = usr;
        this.acao = acao;
        this.tabela = tabela;
        this.descricao = descricao;
    }

    @Override
    public void run() {
        Auditoria bean = new Auditoria();
        try {
            em.clear();
            em.getTransaction().begin();
            bean.setAudAcao(acao);
            bean.setAudData(Utils.getDataAtual());
            bean.setAudHora(Utils.getHoraAtual());
            bean.setAudTabela(tabela);
            bean.setAudDescricao(descricao);
            bean.setUsuario(usr);
            em.persist(bean);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
