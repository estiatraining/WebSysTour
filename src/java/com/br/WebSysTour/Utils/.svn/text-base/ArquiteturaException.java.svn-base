/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.Utils;

/**
 *
 * @author Maycon Fernandes
 */
import com.br.WebSysTour.Entilies.ErroSistema;
import com.br.WebSysTour.Entilies.Usuario;
import com.br.WebSysTour.ServiceDao.ErroSistemaDaoBean;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ArquiteturaException extends Exception {

    public ArquiteturaException(String arg0, Throwable arg1, Usuario usr) {
        super(arg0, arg1);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        arg1.printStackTrace(pw);
        ErroSistema erro = new ErroSistema();
        usr.setUsrId(usr.getUsrId());
        erro.setUsuario(usr);
        erro.setErroData(Utils.getDataAtual());
        erro.setErroDesc(sw.toString());
        erro.setErroHora(Utils.getHoraAtual());
        String assunto = arg0 + " " + erro.getErroData() + " " + erro.getErroHora();
        EnviaEmail enviar = new EnviaEmail();
        enviar.email(assunto, erro.getErroDesc());

    }

    public ArquiteturaException(String arg0) {
        super(arg0);
    }

    public ArquiteturaException(Throwable exception, Usuario usr) throws Exception {
        super(exception);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        ErroSistema erro = new ErroSistema();
        usr.setUsrId(usr.getUsrId());
        String assunto = "Erro Sistema " + erro.getErroData() + " " + erro.getErroHora();
        EnviaEmail enviar = new EnviaEmail();
        enviar.email(assunto, erro.getErroDesc());
        ErroSistemaDaoBean servico = new ErroSistemaDaoBean(usr, assunto);
        servico.run();
        System.out.println("gravou");
    }
}
