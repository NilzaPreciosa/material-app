/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mz.nilzaproject.cedsif.model.db.ArmazemItem;
import mz.nilzaproject.cedsif.service.ArmazemItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nilza.graca
 */
@Named("itemView")
@ViewScoped
public class ItemView implements Serializable {
    
    @Autowired
    private ArmazemItemService itemService;
    
    private List<ArmazemItem> items;

    @PostConstruct
    public void init(){
        items = itemService.list();
    }
    
    public List<ArmazemItem> getItems() {
        
        return items; 
    }
    
    
    
    
}
