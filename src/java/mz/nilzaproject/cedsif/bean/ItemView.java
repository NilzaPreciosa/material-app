/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mz.nilzaproject.cedsif.model.db.ArmazemItem;
import mz.nilzaproject.cedsif.model.db.Material;
import mz.nilzaproject.cedsif.service.ArmazemItemService;
import mz.nilzaproject.cedsif.service.MaterialService;
import mz.nilzaproject.cedsif.service.rules.Rules;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nilza.graca
 */
@Named("itemView")
@ViewScoped
public class ItemView implements Serializable {
    
    private static Log LOG = LogFactory.getLog(ItemView.class);
    
    //@Autowired permite chamar ou invocar Beans do spring
    @Autowired
    private ArmazemItemService itemService;
    
    @Autowired
    private MaterialService materialService;
    
    
    @Autowired
    private Rules regra;
    
    private List<ArmazemItem> items;

    @PostConstruct
    public void init(){
        //items = itemService.list();
    }
    
    public List<ArmazemItem> getItems() {
        
        return itemService.list(); 
    }
    
        
    public String deletar(){
        
        Map<String,String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        
        LOG.info("Removendo Item "+params.get("id"));
        
        //pegar item para validar existencia
        ArmazemItem item = this.itemService.read(Integer.parseInt(params.get("id")));
           
        this.itemService.delete(item.getId());
        
        this. materialService.delete(item.getId());
        
        return "equipamento-listar";
    }
    
    public String leiloar(){
        
        Map<String,String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        
        ArmazemItem item = this.itemService.read(Integer.parseInt(params.get("id")));
        
        boolean podeLeiloar = this.regra.executarRegra02(item.getMaterial());
        
        LOG.info("Material Leiloado "+podeLeiloar);
        
        
        
        return "equipamento-listar";
    }
    
    
}
