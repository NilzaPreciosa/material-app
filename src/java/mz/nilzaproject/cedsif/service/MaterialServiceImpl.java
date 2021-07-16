/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service;

import java.util.List;
import mz.nilzaproject.cedsif.dao.MaterialDAO;
import mz.nilzaproject.cedsif.dao.MaterialDAOImpl;
import mz.nilzaproject.cedsif.model.db.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author nilza.graca
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    //Chamada dinamica da referencia ao objecto do DAO
    //pela configuracao do spring.xml
    @Autowired 
    private MaterialDAO materialDAO;

    @Override
    public void createOrUpdate(Material t) {
        
        this.materialDAO.createOrUpdate(t);
    }

    @Override
    public Material read(Integer id) {
        
        return this.materialDAO.read(id);
    }

    @Override
    public Material delete(Integer id) {
       
        return this.materialDAO.delete(id);
    }

    @Override
    public List<Material> list() {
        
        return this.materialDAO.list();
    }
    
    
}
