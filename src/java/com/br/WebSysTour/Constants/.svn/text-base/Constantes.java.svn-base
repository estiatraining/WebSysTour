/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.WebSysTour.Constants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class Constantes {

    private static Constantes constant;
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static final String SENHA = "12345678@";
    public static final String EMAIL = "websystour@gmail.com";
    public static final String EMAIL_REMETENTE = "websystour@gmail.com";
    public static final String EMAIL_DESTINATARIO= "websystour@googlegroups.com";
    /**
     * @return the constant
     */
    public static Constantes getIntance() {
        constant = new Constantes();
        return constant;
    }

    /**
     * @return the emf
     */
    public static EntityManagerFactory getEmf() {
        emf = Persistence.createEntityManagerFactory("WebSoftTurismoPU");
        return emf;
    }

    private Constantes() {
    }

    public static EntityManager getEm() {
        em = getEmf().createEntityManager();
        return em;
    }

    public static void close() {
        getEm().close();
        getEmf().close();
    }
}
