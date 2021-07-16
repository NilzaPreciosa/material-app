/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service;

import java.util.List;
import mz.nilzaproject.cedsif.dao.ArmazemItemDAO;
import mz.nilzaproject.cedsif.model.db.ArmazemItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nilza.graca
 */
@Service
public class ArmazemItemServiceImpl implements ArmazemItemService{

    @Autowired
    private ArmazemItemDAO itemDAO;
    
    @Override
    public void createOrUpdate(ArmazemItem t) {
        this.itemDAO.createOrUpdate(t);
    }

    @Override
    public ArmazemItem read(Integer id) {
        return this.itemDAO.read(id);
    }

    @Override
    public ArmazemItem delete(Integer id) {
        return this.itemDAO.delete(id);
    }

    @Override
    public List<ArmazemItem> list() {
        return this.itemDAO.list();
    }
    
      
}
