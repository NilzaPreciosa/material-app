/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.dao.datasource;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nilza.graca
 * @param <T>
 * @param <ID>
 */
@Repository
public abstract class ArmazemDSImpl<T extends Object,ID extends Serializable> implements ArmazemDS<T,ID> {
   
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    
    private static Log LOG = LogFactory.getLog(ArmazemDSImpl.class);
    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public ArmazemDSImpl(final HibernateTemplate htemplate) {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        
       
         
            this.session = htemplate.getSessionFactory().openSession();
               
        LOG.warn("Loading class[" + this.clazz.getName()+"]");  

    }

   public Class<T> getPersistentClass() {
        
        return clazz;
    }
    
    @Transactional
    @Override
    public void createOrUpdate(T entity) {
        
       session.saveOrUpdate(entity);
       session.flush();
    }

    @Transactional
    @Override
    public T read(ID id) {
      return (T) session.get(this.clazz, id);
    }
   
    @Transactional
    @Override
    public T delete(ID id) {
        T t = (T) this.read(id);
        session.delete(t);
        session.flush();
        return (T) t;
    }
    
    @Transactional
    @Override
    public List<T> list() {
        return (List<T>) session.createCriteria(this.clazz).list();
    }
    
    
}
