package com.br.WebSysTour.UtilsDB;

import com.br.WebSysTour.Constants.Constantes;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.ServiceDao.AuditoriaDaoBean;
import com.br.WebSysTour.Utils.ArquiteturaException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @param <Obj> 
 * @param <ID> 
 * @author Cleison Ferreira
 */
public class CrudDaoImp<Obj, ID extends Serializable> implements CrudDao<Obj, ID> {

    private static final EntityManagerFactory EMF = Constantes.getEmf();
    private static final EntityManager em = EMF.createEntityManager();
    private Class<Obj> oClass = null;
    private Usuario usr = new Usuario();

    /**
     * 
     */
    public CrudDaoImp() {
        this.oClass = (Class<Obj>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * 
     * @return
     */
    public Class<Obj> getObjectClass() {
        return this.oClass;
    }

    /**
     * 
     * @param d
     * @param objUsuario
     * @return
     * @throws Exception
     * @throws SQLException
     */
    @Override
    public Obj save(Obj d) throws Exception, SQLException {
        try {
            em.clear();
            em.getTransaction().begin();
            em.persist(d);
            Usuario beanUsuario = new Usuario();
            if (d instanceof Usuario) {
                beanUsuario.setUsrId(((Usuario) d).getUsrId());
            } else {
                beanUsuario.setUsrId(usr.getUsrId());
            }
            AuditoriaDaoBean audit = new AuditoriaDaoBean(beanUsuario, oClass.getSimpleName(), "salvar".toUpperCase(), "");
            audit.start();
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (oClass.getCanonicalName().equalsIgnoreCase("com.br.WebSysTour.Entilies.ErroSistema")) {
                em.getTransaction().rollback();
                throw new ArquiteturaException("Erro ao gravar no Banco", e, usr);
            } else {
                em.getTransaction().rollback();
                throw new ArquiteturaException(e, usr);
            }

        } finally {
            Constantes.close();
            return d;
        }
    }

    /**
     * 
     * @param d
     * @param objUsuario
     * @return
     * @throws Exception
     * @throws SQLException
     */
    @Override
    public Boolean update(Obj d) throws Exception, SQLException {
        Object o = new Object();
        try {
            em.clear();
            em.getTransaction().begin();
            o = em.merge(d);
            Usuario beanUsuario = new Usuario();
            if (d instanceof Usuario) {
                beanUsuario.setUsrId(((Usuario) d).getUsrId());
            } else {
                beanUsuario.setUsrId(usr.getUsrId());
            }
            AuditoriaDaoBean audit = new AuditoriaDaoBean(beanUsuario, oClass.getSimpleName(), "atualizar".toUpperCase(), "");
            audit.start();
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ArquiteturaException(e, usr);
        } finally {
            Constantes.close();
            if (o != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 
     * @param d
     * @param objUsuario
     * @throws Exception
     * @throws SQLException
     */
    @Override
    public void delete(Obj d) throws Exception, SQLException {
        Object o = new Object();
        try {
            em.getTransaction().begin();
            o = em.merge(d);
            em.remove(o);
            Usuario beanUsuario = new Usuario();
            if (d instanceof Usuario) {
                beanUsuario.setUsrId(((Usuario) d).getUsrId());
            } else {
                beanUsuario.setUsrId(usr.getUsrId());
            }
            AuditoriaDaoBean audit = new AuditoriaDaoBean(beanUsuario, oClass.getSimpleName(), "excluir".toUpperCase(), "");
            audit.start();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            Constantes.close();
        }
    }

    /**
     * 
     * @return
     * @throws Exception
     * @throws SQLException
     */
    @Override
    public List<Obj> select() throws Exception, SQLException {
        try {
            String queryS = "SELECT obj FROM " + oClass.getSimpleName() + " obj";
            Query query = em.createQuery(queryS);
            Constantes.close();
            return query.getResultList();
        } catch (Exception e) {
            throw new ArquiteturaException(e, getUsuario());
        }
    }

    /**
     * 
     * @param id
     * @return
     * @throws Exception
     * @throws SQLException
     */
    @Override
    public Obj restore(ID id) throws Exception, SQLException {
        try {
            Obj dados = (Obj) em.find(oClass, id);
            Constantes.close();
            return dados;
        } catch (Exception e) {
            throw new ArquiteturaException(e, getUsuario());
        }
    }

    /**
     * 
     * @param params
     * @return
     * @throws Exception
     * @throws SQLException
     */
    @Override
    public List<Obj> find(Map<String, Object> params) throws Exception, SQLException {
        try {
            String query = "SELECT obj FROM " + oClass.getSimpleName() + " obj WHERE ";
            int cont = 0;
            Query q = null;
            for (String chave : params.keySet()) {
                if (cont == 0) {
                    query += "obj." + chave + " = :" + chave;
                } else {
                    query += " AND obj." + chave + " = :" + chave;
                }
                cont++;
            }
            q = em.createQuery(query);
            for (String chave : params.keySet()) {
                q.setParameter(chave, params.get(chave));
            }
            Constantes.close();
            return q.getResultList();
        } catch (Exception e) {
            throw new ArquiteturaException(e, getUsuario());
        }
    }

    /**
     *
     * @param SQL QUERY
     * @return LIST
     * @throws Exception
     * @throws SQLException
     */
    @Override
    public List<Obj> findBySqlQuery(String query) throws Exception, SQLException {
        Query q = em.createQuery(query);
        return q.getResultList();
    }

    public Usuario getUsuario() {
        return usr;
    }

    public void setUsuario(Usuario usr) {
        this.usr = usr;
    }
}
