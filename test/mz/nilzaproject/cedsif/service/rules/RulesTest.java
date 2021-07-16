/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service.rules;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mz.nilzaproject.cedsif.model.db.ArmazemItem;
import mz.nilzaproject.cedsif.model.db.Material;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.BeforeClass;

/**
 *
 * @author nilza.graca
 */
public class RulesTest implements RuleTest {
   
    private Rule rule;
    
  
    @Test
    @Override
    public void testRegra3DefineQuantidadeMaterialObsoletoArmazenadoOuLeiloado() {
   
        //TDD - //itemDAO.list();
        List<ArmazemItem> itens = new ArrayList<>();
        
        //refractory
        //Criar um objecto Item
        ArmazemItem item1 = new ArmazemItem(1);
        
        //atribuir valores aos atributos do item
        //adicionando valores do material do item
        Material m1 = new Material(1);
        //anofabrico
        m1.setAnoFabrico(2021);
        //tipo
        m1.setTipo("DESKTOP");
        //
        item1.setMaterial(m1);
        //dataEntrada
        item1.setDataEntrada(Calendar.getInstance().getTime());
        
        //item2
        ArmazemItem item2 = new ArmazemItem(2);
        
        //atribuir valores aos atributos do item
        //adicionando valores do material do item
        Material m2 = new Material(2);
        //anofabrico
        m1.setAnoFabrico(2021);
        //tipo
        m1.setTipo("IMPRESSORA");
        //
        item2.setMaterial(m2);
        //dataEntrada
        item2.setDataEntrada(Calendar.getInstance().getTime());
        
        //adicionar os items a lista de item que e um armazem
        itens.add(item1);
        itens.add(item2);
        
        assertEquals(2, itens.size());
    }
    
    //Definiçao de cenarios de teste de Negocio

    @Override
    public void testRegra1DeterminaIdadeDeUmEquipamentoOuMaterial() {
        
        Material m1 = new Material(1);
        //anofabrico
        m1.setAnoFabrico(2021);
        
        int idadeMaterial = rule.executarRegra01(m1);
        
        assertEquals(0, idadeMaterial);
    }

    @Test
    @Override
    public void testRegra2DefineQuandoUmDeterminiadoEquipamentoPodeSerLeiloado() {
        
         //1st pega a data do sistema para extrair o ano
        final Calendar cal = Calendar.getInstance();
        int anoActual = cal.get(Calendar.YEAR);
        
        //2nd pegar a lista de itens de material do armazem
        //List<ArmazemItem> items = //this.itemDAO.list();
        
        //TDD - //itemDAO.list();
        List<ArmazemItem> itens = new ArrayList<>();
        
        //refractory
        //Criar um objecto Item
        ArmazemItem item1 = new ArmazemItem(1);
        
        //atribuir valores aos atributos do item
        //adicionando valores do material do item
        Material m1 = new Material(1);
        //anofabrico
        m1.setAnoFabrico(2020);
        //tipo
        m1.setTipo("DESKTOP");
        //matrial
        item1.setMaterial(m1);
        
        //dataEntrada
        //item1.setDataEntrada(Calendar.getInstance().getTime());
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2012, 2, 14);
        item1.setDataEntrada(cal2.getTime());
        
        //adicionar os items a lista de item que e um armazem
        itens.add(item1);
        
        //2.1nd verificar para cada item se este e igual ao item de entrada
        ArmazemItem itemConsultado = null;
        
        for(ArmazemItem eachitem : itens){

                if(eachitem.getMaterial().getId().equals(m1.getId())){
                    //pega o item
                    itemConsultado = eachitem;
                    //quebra o ciclo
                    break;
                }
            }
            //3st. Para o item de armazem encontrado, extrai a data de entrada no armazem
            cal.setTime(itemConsultado.getDataEntrada());

            int anoEntradaArmazem = cal.get(Calendar.YEAR);

            //4nd. retorna a diferenca das datas e valida se é > 2
            //2021-2000=10 e 2021-2020=1
            int idadeMaterial = rule.executarRegra01(itemConsultado.getMaterial());
            assertEquals(1,idadeMaterial);
            
            int idadeItemNoArmazem = anoActual - anoEntradaArmazem;
            assertEquals(9, idadeItemNoArmazem);
            
           boolean podeLeiloar = rule.executarRegra01(itemConsultado.getMaterial()) > 9 && (anoActual - anoEntradaArmazem) > 1; 
           //assertTrue("Este Material Nao pode ser leiloado, ainda no Activo segundo o Art.XX de 20XX", podeLeiloar);
           assertFalse(podeLeiloar); 
    }

    @Override
    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoAIdadeDoEquipamentoFor1() {
        
        
    }

    @Override
    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoAIdadeDoEquipamentoFor2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    @Override
    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoIdadeItemNoArmazemForMaiorQue9EIdadeDoEquipamentoMaiorQue1() {
        
          //1st pega a data do sistema para extrair o ano
        final Calendar cal = Calendar.getInstance();
        int anoActual = cal.get(Calendar.YEAR);
        
        //2nd pegar a lista de itens de material do armazem
        //List<ArmazemItem> items = //this.itemDAO.list();
        
        //TDD - //itemDAO.list();
        List<ArmazemItem> itens = new ArrayList<>();
        
        //refractory
        //Criar um objecto Item
        ArmazemItem item1 = new ArmazemItem(1);
        
        //atribuir valores aos atributos do item
        //adicionando valores do material do item
        Material m1 = new Material(1);
        //anofabrico
        m1.setAnoFabrico(2010);
        //tipo
        m1.setTipo("DESKTOP");
        //matrial
        item1.setMaterial(m1);
        
        //dataEntrada
        //item1.setDataEntrada(Calendar.getInstance().getTime());
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2011, 2, 14);
        item1.setDataEntrada(cal2.getTime());
        
        //adicionar os items a lista de item que e um armazem
        itens.add(item1);
        
        //2.1nd verificar para cada item se este e igual ao item de entrada
        ArmazemItem itemConsultado = null;
        
        for(ArmazemItem eachitem : itens){

                if(eachitem.getMaterial().getId().equals(m1.getId())){
                    //pega o item
                    itemConsultado = eachitem;
                    //quebra o ciclo
                    break;
                }
            }
            //3st. Para o item de armazem encontrado, extrai a data de entrada no armazem
            cal.setTime(itemConsultado.getDataEntrada());

            int anoEntradaArmazem = cal.get(Calendar.YEAR);

            //4nd. retorna a diferenca das datas e valida se é > 2
            //2021-2000=10 e 2021-2020=1
            int idadeMaterial = rule.executarRegra01(itemConsultado.getMaterial());
            assertTrue(idadeMaterial >9);
            
            int idadeItemNoArmazem = anoActual - anoEntradaArmazem;
            assertTrue(idadeItemNoArmazem >1);
            
            boolean podeLeiloar = (idadeMaterial > 9 && idadeItemNoArmazem > 1);
            assertTrue(podeLeiloar);
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

    @Ignore
    @Override
    public void testRegra3DefineQuantidadeMaterialObsoletoQuandoTipoForImpressora() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
