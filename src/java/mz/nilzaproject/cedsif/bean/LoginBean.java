/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import mz.nilzaproject.cedsif.dao.UsuarioDAO;
import mz.nilzaproject.cedsif.model.db.Usuario;
import mz.nilzaproject.cedsif.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.SessionScope;

/**
 *
 * @author nilza.graca
 */

@Component("loginBean")
@RequestScoped
public class LoginBean implements Serializable{
    
    /**
     * 
     * Utilizando os Backing Beans, para
     * Fazer as ligacoes dos componentes do JSF renderizados pela HTML
     * e os Controllers
     */
       
    //@ManagedProperty(value = "#{userDao}")
    @Autowired
    private UsuarioDAO userDao;
  
    private Usuario usuario;
    

     private static Log LOG = LogFactory.getLog(LoginBean.class);
     
    @Autowired(required = false)
    private UsuarioService userService;

    
    //@Inject
    //private UsuarioDAO userDao;

    @Autowired
    HibernateTemplate hibernate;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    
    /**
     * Redireciona a tela para o menu
     * @return 
     */
    public String fazerLogin(){
        
        Usuario user = null;
        String mensagem = "";
        //verificar se usuario existe, atraves do servico caso contrario retorna mensagem
       
        try{
        for (Usuario u : this.userService.list()){
            
            //se a conta for igual
            if(u.getUsername().equals(this.usuario.getUsername())){
                
                //pega no usuario
                user = u;
                break;
            }
        }
        
        if(user ==null){
            
            //envia mensagem
            mensagem = "Usuário não existente";
            //FacesServlet servle = Servlet
            FacesContext context = FacesContext.getCurrentInstance();
        
            return "login";
        }
        }catch(NullPointerException nux){
            
            
        LOG.info("Button Login Selecionado para user "+this.usuario.getNameDescription());
        }
        
        
        return "menu-item?faces-redirect=true";
    }
    
    public String fazerLogout(){
        
        //userService.createOrUpdate(new Usuario(1, "USER", username, password, "EMPTY"));
      
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,Object> session =  fc.getExternalContext().getSessionMap();
        
          LOG.info("Button Logout Requested. Sending Request to Logout.xhtml ");
          LOG.info("Mapa de Sessoes "+session);
        //session.invalidate();
        
        return "login?faces-redirect=true";
    }

    
    
    
    
    
}
