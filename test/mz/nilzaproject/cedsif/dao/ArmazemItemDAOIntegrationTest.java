/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.dao;

import mz.nilzaproject.cedsif.dao.datasource.ArmazemDSImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 *
 * @author nilza.graca
 *
 * @TestPropertySource(locations   = "datasource-test-integration.properties")
 * spring.datasource.url=jdbc:h2:file:/opt/jpadb if, save file is needed
*/
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:datasource-test-configuration.xml")
public class ArmazemItemDAOIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests{
  
    //MockInject Here over this class DAO
    private static Log LOG = LogFactory.getLog(ArmazemDSImpl.class);
    
    @Autowired
    private HibernateOperations hTemplate;
    
    
    @Test
    public void setUp() {
        
        //start mocking
        hTemplate.toString();
        
        //if empty put all over ArrayList of items with scope definition
        
        
    }
    
    
    
}
