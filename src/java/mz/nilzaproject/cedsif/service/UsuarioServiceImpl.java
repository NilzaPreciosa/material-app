/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service;

import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import mz.nilzaproject.cedsif.dao.UsuarioDAO;
import mz.nilzaproject.cedsif.dao.UsuarioDAOImpl;
import mz.nilzaproject.cedsif.dao.datasource.ArmazemDSImpl;
import mz.nilzaproject.cedsif.model.db.Usuario;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author nilza.graca
 */
@Service("userService")
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    private static Log LOG = LogFactory.getLog(UsuarioService.class);

    @Override
    public void createOrUpdate(Usuario t) {
        this.usuarioDAO.createOrUpdate(t);
    }

    @Override
    public Usuario read(Integer id) {
       return this.usuarioDAO.read(id);
    }

    @Override
    public Usuario delete(Integer id) {
       return this.usuarioDAO.delete(id);
    }

    @Override
    public List<Usuario> list() {
       return this.usuarioDAO.list();
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    
    
    
}
