/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service.rules;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import mz.nilzaproject.cedsif.utils.CustomDAOTestSpringJUnitTransactionalOperations;
import mz.nilzaproject.cedsif.dao.ArmazemItemDAO;
import mz.nilzaproject.cedsif.dao.ArmazemItemDAOImpl;
import mz.nilzaproject.cedsif.dao.MaterialDAO;
import mz.nilzaproject.cedsif.dao.MaterialDAOImpl;
import mz.nilzaproject.cedsif.dao.UsuarioDAO;
import mz.nilzaproject.cedsif.dao.UsuarioDAOImpl;
import mz.nilzaproject.cedsif.model.db.ArmazemItem;
import mz.nilzaproject.cedsif.model.db.Material;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
/**
 *
 * @author nilza.graca
 */

public class RulesIntegrationTest extends CustomDAOTestSpringJUnitTransactionalOperations implements RuleTest {
   
    private static Log LOG = LogFactory.getLog(RulesIntegrationTest.class);
    
    
    @Override
    public void setUp() {
        
        super.setUp();
        //if you need something spectial put it here
    }
    
   
    @Test
    @Override
    public void testRegra3DefineQuantidadeMaterialObsoletoArmazenadoOuLeiloado() {
        
        /**
         * Mockito.when(a.getStatus()).thenReturn("LEILOADO");
         * Mockito.verify(a).setStatus("obsoleto");
         * when itens equals empty
         * than fetch itemDAO.list() to itens
         * MatcherAssert.assertThat(items, CoreMatchers.is(CoreMatchers.equalTo(Collections.EMPTY_LIST)))
         */
        
        /*
        ArmazemItem item1 = Mockito.mock(ArmazemItem.class);
        ArmazemItem item2 = Mockito.mock(ArmazemItem.class);
        */
        
        List<ArmazemItem> fakeItens = this.loadFakeData();
        
        //create material first
        ArmazemItem item0       =fakeItens.get(0);
        Material material1111   =item0.getMaterial();

        //create
        this.materialDAO.createOrUpdate(material1111);
        
        //than  to item
        item0.setMaterial(material1111);
        
        //and finally create item
        this.itemDAO.createOrUpdate(item0);
        
        //pega o item da db
        item0 = this.itemDAO.read(1);
             
        //test equals
        //Assert.assertEquals(2,fakeItens.size());
        
         Assert.assertEquals(false, this.hiberTemplate.getSessionFactory().getCurrentSession().contains(item0));
        //check assertation
         
    }
    
    
    
    
    @Override
    public void testRegra1DeterminaIdadeDeUmEquipamentoOuMaterial() {
        
    }

    @Override
    public void testRegra2DefineQuandoUmDeterminiadoEquipamentoPodeSerLeiloado() {
       
    }

    @Override
    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoAIdadeDoEquipamentoFor1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoAIdadeDoEquipamentoFor2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoIdadeItemNoArmazemForMaiorQue9EIdadeDoEquipamentoMaiorQue1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra2DefineQuantidadeMaterialObsoletoLeiloadoTipoDesktop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra2DefineQuantidadeMaterialObsoletoLeiloadoTipoLaptop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra2DefineQuantidadeMaterialObsoletoLeiloadoTipoImpressora() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra3DefineQuantidadeMaterialObsoletoPorTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra3DefineQuantidadeMaterialObsoletoQuandoTipoForDesktop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra3DefineQuantidadeMaterialObsoletoQuandoTipoForLaptop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testRegra3DefineQuantidadeMaterialObsoletoQuandoTipoForImpressora() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
