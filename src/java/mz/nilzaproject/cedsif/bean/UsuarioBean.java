/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.registry.infomodel.User;
import mz.nilzaproject.cedsif.model.db.Usuario;
import mz.nilzaproject.cedsif.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author nilza.graca
 */

@Component("usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
    
   
    @ManagedProperty(value="#{menuBean}")
    private String link;
  
    private static Log LOG = LogFactory.getLog(UsuarioBean.class);
   
    @Autowired
    private transient UsuarioService userService;
    
    private Usuario user;

    @PostConstruct
    public void init() {
        
        user = new Usuario();
    }
    
    public Usuario getUser() {
        return user;
    }
    
    //-----------------------------------------operacoes
    public String registarUsuario(){
        
        //criar o object usuaruio
        Usuario userPorlogar = new Usuario(user.getPerfil(), user.getUsername(), user.getPassword(), user.getNameDescription());
        
        for (Usuario u : this.userService.list()){
            
            //se a conta for igual
            if(u.getUsername().equals(user.getUsername())){
                
                //pega no usuario
                String message ="Usuario "+u.getUsername()+" já existe no sistema";
                
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                        "Erro", 
                        message);
                
                FacesContext.getCurrentInstance().addMessage(null, msg);
                
                return "login?faces-redirect=true";  
            }
        }
     
        //invoca um recuros de FacesServlet, para enviar a messagem ao
        //componente de mensagem na tela
        
        this.userService.createOrUpdate(user);
        
        String message ="Usuario "+user.getUsername()+" ja foi registado";
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                        "Sucesso", 
                        message);
                
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //retornar a pagina redirecionada
        return "menu?faces-redirect=true";
        
    }

       /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
  
    
}
