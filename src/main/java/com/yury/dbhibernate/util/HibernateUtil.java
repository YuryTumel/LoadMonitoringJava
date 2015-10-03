/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.dbhibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Юрий
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        } catch(Throwable t) {
            System.err.println("Initial SessionFactory creation failed. " + t);
            throw new ExceptionInInitializerError(t);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
