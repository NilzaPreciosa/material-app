/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service.rules;

import java.util.List;
import mz.nilzaproject.cedsif.model.db.ArmazemItem;
import mz.nilzaproject.cedsif.model.db.Material;

/**
 *
 * @author nilza.graca
 */
public interface Rule {
    
     public final static String TIPO_EQUIPAMENTO[]={"IMPRESSORA",
                    "DESKT OP","LAPTOP"};
     
   //nesta interface vamos definir as regras de negocio
    /**
     * _____________________________________________________________
     * regra1 - Define a idade do equipamento pela diference entre o
     * ano de fabrico e ano actual(corrente), Demodo o material
     * seja classificado como Obsoleto.
     * _________________________________________________
     * 
     * executarRule01(Material) =idade(Material) = anoActualDoSistema - anoFabrico 
     * _________________________________________________
     */
     public int executarRegra01(final Material m);
    /**
     * ____________________________________________________________________________________
     * regra2 - Define quando è que determando material pode ser leiloado.
     * Portanto, para ser leiloado o equipamento, quando a diferenca entre a dataActual do sistema
     * e a data de entrada do material no armazem for > 2.
     * ___________________________________________________________________________________________________________
     * 
     * executarRule02(Material) = podeSerleilado(Material) = (anoActualDoSistema - dataEntradaMaterialArmazem) > 2
     * ___________________________________________________________________________________________________________
     */
     public boolean executarRegra02(final Material m);
     
    /**
    * ________________________________________________________________
     * regra3 - Define a quantidade de equipamentos/material obsolecto
     * existente na base por classe de material.
     * __________________________________________________________________________________
     * 
     * executarRule03(Material) = qntMaterialObsoleto(TipoMaterial) = count(TipoMaterial)
     * __________________________________________________________________________________
     */
     //public int executarRegra03(final Material m);
     
     
    /** ________________________________________________________________
     * regra4 - Define o material obsoleto por tipo de material
     * existente no armazem.
     * E retorna a lista com os dados do material do tipo especificado
     * _________________________________________________________________
     * 
     * executarRule04(tipoMaterial) = listMaterial(tipoMaterial)
     * _________________________________________________________________
     */ 
     public List<ArmazemItem> executarRegra34(final Material m, final String tipo);
     
}
