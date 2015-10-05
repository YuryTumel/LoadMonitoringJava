/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.dbhibernate.storage;

import com.yury.businessmonitoring.interfaces.IModel;
import com.yury.businessmonitoring.interfaces.IStorage;
import com.yury.dbhibernate.util.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Юрий
 */
public class HibernateStorage implements IStorage {

    @Override
    public synchronized <T extends IModel> int add(T model) {
        int retValue;
        try {
            getCurrentSession().beginTransaction();
            retValue = (Integer) getCurrentSession().save(model);
            getCurrentSession().getTransaction().commit();
        } catch (Exception ex) {
            getCurrentSession().getTransaction().rollback();
            throw new IllegalStateException("Couldn't add the model.", ex);
        }
        return retValue;
    }

    @Override
    public synchronized <T extends IModel> void edit(T model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized <T extends IModel> void delete(T model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized <T extends IModel> T get(Class modelClass, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized <T extends IModel> T get(Class modelClass, Object propertyValue, String propertyName) {
        T retValue = null;
        try {
            getCurrentSession().beginTransaction();
            Criteria crt = getCurrentSession().createCriteria(modelClass);
            crt.add(Restrictions.eq(propertyName, propertyValue));
            retValue = (T) crt.uniqueResult();
            getCurrentSession().getTransaction().commit();
        } catch (Exception ex) {
            getCurrentSession().getTransaction().rollback();
            throw new IllegalStateException("Couldn't add the model.", ex);
        }
        return retValue;
    }

    @Override
    public synchronized <T extends IModel> List<T> getList(Class modelClass, int count) {
        if (count <= 0) {
            throw new IllegalStateException("Cannot limit selection by not natural value");
        }
        List<T> retValue = null;
        try {
            getCurrentSession().beginTransaction();
            Criteria crt = getCurrentSession().createCriteria(modelClass);
            crt.addOrder(Order.desc("date")).setMaxResults(count);
            retValue = crt.list();
            getCurrentSession().getTransaction().commit();
        } catch (Exception ex) {
            getCurrentSession().getTransaction().rollback();
            throw new IllegalStateException("Couldn't add the model.", ex);
        }
        return retValue;
    }

    @Override
    public synchronized void close() {
        if (!HibernateUtil.getSessionFactory().isClosed())
            HibernateUtil.getSessionFactory().close();
    }

    private Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
