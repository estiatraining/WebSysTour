/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.ServiceDao;

import com.br.WebSysTour.Entilies.Menu;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.Utils.ArquiteturaException;
import com.br.WebSysTour.UtilsDB.CrudDaoImp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Cleison Ferreira
 */
//@Stateless
public class MenuDaoBean extends CrudDaoImp<Menu, Integer> implements MenuDaoLocal {

    //@EJB
    private AcessoDaoLocal acessoServico = new AcessoDaoBean();

    @Override
    public List<Menu> menusToReturn() throws Exception {
        try {
            Menu bean = new Menu();
            Map<String, Object> params = new HashMap<String, Object>();
            bean.setMenuMenuId(0);
            bean.setMenuSts(true);
            params.put("menuMenuId", bean.getMenuMenuId());
            params.put("menuSts", bean.getMenuSts());
            return super.find(params);
        } catch (Exception e) {
            throw new ArquiteturaException(e, getUsuario());
        }
    }

    @Override
    public List<Menu> subMenusToReturn(Integer menuMenuId) throws Exception {
        try {
            Menu bean = new Menu();
            Map<String, Object> params = new HashMap<String, Object>();
            bean.setMenuMenuId(menuMenuId);
            bean.setMenuSts(true);
            params.put("menuMenuId", bean.getMenuMenuId());
            params.put("menuSts", bean.getMenuSts());
            return super.find(params);
        } catch (Exception e) {
            throw new ArquiteturaException(e, getUsuario());
        }
    }

    @Override
    public List<Menu> findToReturn(Menu bean) {
        try {
            String sql = "SELECT obj FROM Menus obj";
            String sWhere = "";
            if (bean.getMenuId() != null && bean.getMenuId() > 0) {
                sWhere = " WHERE obj.menuMenuId = " + bean.getMenuId();
            }
            if (bean.getMenuDescricao() != null && !"".equals(bean.getMenuDescricao())) {
                if (bean.getMenuId() != null && bean.getMenuId() > 0) {
                    sWhere += " AND lower(obj.menuDescricao) LIKE '%" + bean.getMenuDescricao().toLowerCase() + "%'";
                } else {
                    sWhere = " WHERE lower(obj.menuDescricao) LIKE '%" + bean.getMenuDescricao().toLowerCase() + "%'";
                }
            }
            return super.findBySqlQuery(sql + sWhere);
        } catch (Exception e) {
            System.out.println("\n\nErro fodastico: " + e + "\n\n");
            return null;
        }
    }

    @Override
    public void createDefaultMenus(Usuario usr) throws Exception {

        Map<Integer, String> defaultMenus = new HashMap<Integer, String>();

        defaultMenus.put(0, "Cadastros");
        defaultMenus.put(1, "Financeiro");
        defaultMenus.put(2, "Relatórios");
        defaultMenus.put(3, "Configurações");

        String[] cadastros = {"Cliente", "Funcionario", "Fornecedor", "Usuário"};
        String[] configuracoes = {"Menu"};

        int cont = 0;
        while (cont < defaultMenus.size()) {
            Menu objMenusAux = new Menu();
            objMenusAux = mountObjectAndSave(usr, defaultMenus.get(cont),
                    defaultMenus.get(cont), 0, "#", cont, "A", true);

            if ("Cadastros".equals(defaultMenus.get(cont))) {
                for (int i = 0; i < cadastros.length; i++) {
                    mountObjectAndSave(usr, cadastros[i],
                        cadastros[i], objMenusAux.getMenuId(),
                        "/pages/" + cadastros[i].toLowerCase().replace("á", "a") + "/" + cadastros[i].toLowerCase().replace("á", "a") + ".jsf",
                        i, "A", true);
                }
            }
            
            if ("Financeiro".equals(defaultMenus.get(cont))) { }
            if ("Relatórios".equals(defaultMenus.get(cont))) { }
            
            if ("Configurações".equals(defaultMenus.get(cont))) {
                for (int i = 0; i < configuracoes.length; i++) {
                    mountObjectAndSave(usr, configuracoes[i],
                        configuracoes[i], objMenusAux.getMenuId(),
                        "/pages/" + configuracoes[i].toLowerCase() + "/" + configuracoes[i].toLowerCase() + ".jsf",
                        i, "A", true);
                }
            }

            cont++;
        }

    }

    public Menu mountObjectAndSave(Usuario usr, String nome, String descricao,
            Integer menuMenuId, String link, int ordem, String tipo,
            Boolean sts) throws Exception {
        try {
            Menu objMenus = new Menu();
            objMenus.setUsuario(usr);
            objMenus.setMenuNome(nome);
            objMenus.setMenuDescricao(descricao);
            objMenus.setMenuMenuId(menuMenuId);
            objMenus.setMenuLink(link);
            objMenus.setMenuOrdem((short) ordem);
            objMenus.setMenuTipo(tipo);
            objMenus.setMenuSts(sts);

            Menu aux = new Menu();
            aux = super.save(objMenus);

            acessoServico.createDefaultAcessos(usr, aux, true, true, true, true);
            return aux;
        } catch (Exception e) {
            throw new ArquiteturaException(e, getUsuario());
        }
    }
}
