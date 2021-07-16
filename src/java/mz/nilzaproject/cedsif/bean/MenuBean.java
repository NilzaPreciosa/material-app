/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author nilza.graca
 */
@Component("menuBean")
//@ManagedBean(name="menuBean")
@ViewScoped
public class MenuBean implements Serializable {
    
    //@ManagedProperty(value="#{menuBean}")
    //private String link;
    
    private static Log LOG = LogFactory.getLog(MenuBean.class);
    
    private List<MenuItem> items;
    
    //public String getLink() {
      //  return link;
    //}

    //public void setLink(String link) {
      //  this.link = link;
    //}

    //public String chooseLink(String link) {
        
        //add parameter dynamically to view
      //  this.link = link;
        
        //LOG.info("Button Link Requested. Selected Link"+this.link);
        //return "menu?faces-redirect=true";
    //}
    
    public List<MenuItem> getItems(){
    
        ArrayList<MenuItem> items = new ArrayList();
        
        items.add(new MenuItem("Registar  Equipamento", "equipamento-registar.jsf"));
        items.add(new MenuItem("Listar    Equipamento", "equipamento-listar.jsf"));
        items.add(new MenuItem("Relatório Equipamento", "equipamento-relatorio.jsf"));
        
        
        return (this.items = items);
    }
    
    public class MenuItem {
    
        private String descricao;
        private String xhtml;

        public MenuItem(String descricao, String xhtml) {
            this.descricao = descricao;
            this.xhtml = xhtml;
        }
        
        public String getDescricao() {
            return descricao;
        }

        public String getXhtml() {
            return xhtml;
        }

     
    }
    
    
}
