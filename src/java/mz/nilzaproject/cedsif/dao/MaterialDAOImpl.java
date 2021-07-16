/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.dao;

import mz.nilzaproject.cedsif.dao.datasource.ArmazemDSImpl;
import mz.nilzaproject.cedsif.model.db.Material;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nilza.graza
 */
@Repository
public class MaterialDAOImpl extends ArmazemDSImpl<Material, Integer> implements MaterialDAO{

    public MaterialDAOImpl(final HibernateTemplate htemplate) {
        super(htemplate);
    }

    
}
