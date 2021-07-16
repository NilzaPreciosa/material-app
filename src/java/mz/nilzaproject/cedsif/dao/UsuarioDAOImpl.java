/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.dao;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import mz.nilzaproject.cedsif.dao.datasource.ArmazemDSImpl;
import mz.nilzaproject.cedsif.model.db.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nilza.graca
 */

@Transactional
public class UsuarioDAOImpl extends ArmazemDSImpl<Usuario, Integer> implements UsuarioDAO{
    
    @Inject
    public UsuarioDAOImpl(HibernateTemplate htemplate) {
        super(htemplate);
    }
   
    
}
