/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service.rules;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import mz.nilzaproject.cedsif.dao.ArmazemItemDAO;
import mz.nilzaproject.cedsif.model.db.ArmazemItem;
import mz.nilzaproject.cedsif.model.db.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nilza.graca
 */
@Service("regras")
public class Rules implements Rule{

    //Injecao de dependencias
    @Autowired
    private ArmazemItemDAO itemDAO;
    
    @Override
    public int executarRegra01(final Material m) {
       
        //1st pega a data do sistema para extrair o ano
        final Calendar cal = Calendar.getInstance();
        
        int anoActual = cal.get(Calendar.YEAR);
        
        //2nd pega a data de fabrico do Material para extrair o ano
        int anoFabricoMaterial = m.getAnoFabrico().intValue();
        
        //3rd calcula a diference entre os anos e retorna a idade
        int idadeMaterial = (anoActual - anoFabricoMaterial);
        
        boolean eObsoleto = idadeMaterial >9;
        //verifica estado de obsolencia
        if(eObsoleto){
            ArmazemItem item = itemDAO.read(m.getId());
            //altera esta de obsolencia
            item.setStatus("OBSOLETO");
            //save
            itemDAO.createOrUpdate(item);
        }
        
        return idadeMaterial;
    }

    @Override
    public boolean executarRegra02(Material m) {
       
        //1st pega a data do sistema para extrair o ano
        final Calendar cal = Calendar.getInstance();
        int anoActual = cal.get(Calendar.YEAR);
        boolean podeLeiloar = false;
        
        //2nd pegar a lista de itens de material do armazem
        List<ArmazemItem> items = this.itemDAO.list();
        
        //2.1nd verificar para cada item se este e igual ao item de entrada
        ArmazemItem item1 = null;
        
        try{
            
            for(ArmazemItem eachitem : items){

                if(eachitem.getMaterial().getId().equals(m.getId())){
                    //pega o item
                    item1 = eachitem;
                    //quebra o ciclo
                    break;
                }
            }
            //3st. Para o item de armazem encontrado, extrai a data de entrada no armazem
            cal.setTime(item1.getDataEntrada());

            int anoEntradaArmazem = cal.get(Calendar.YEAR);

            //4nd. retorna a diferenca das datas e valida se é > 2
            podeLeiloar = (this.executarRegra01(item1.getMaterial()) >9 && (anoActual - anoEntradaArmazem) > 1);
            
            //altera o estado do matarial no item
            if(podeLeiloar){
                
                item1.setStatus("LEILOADO");
                //update item
                itemDAO.createOrUpdate(item1);
                
            }
            
            return podeLeiloar; 
        
        }catch(NullPointerException nux){
            
            return false;
        }
    }

    @Override
    public List<ArmazemItem> executarRegra34(final Material material, final String tipo) {
       
        //cria lista vazia rule04
        List<ArmazemItem> items = Collections.EMPTY_LIST;
        
        if(tipo!=null && material==null){
       
            for(ArmazemItem eachItem : this.itemDAO.list()){

                if(eachItem.getMaterial().getTipo().equals("IMPRESSORA")){

                    //impressoras
                    items.add(eachItem);

                }else if(eachItem.getMaterial().getTipo().equals("DESKTOP")){

                    //desktops
                    items.add(eachItem);

                }else if(eachItem.getMaterial().getTipo().equals("LAPTOP")){

                    //laptops
                    items.add(eachItem);
                }
            }    
            //utilizado quando é apenas material
        }else if(material!=null && tipo==null){

                //rule03    
                for(ArmazemItem eachItem : this.itemDAO.list()){

                    if(eachItem.getMaterial().getTipo().equals(material.getTipo())){

                            //add items
                            items.add(eachItem);

                    }
                }

        }

            //retorna a lista
            return items;
    }
    
}
