/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service.rules;

/**
 *
 * @author nilza.graca
 */
public interface RuleTest {
    
    //regra1
    public void testRegra1DeterminaIdadeDeUmEquipamentoOuMaterial();
    
    //regra2
    public void testRegra2DefineQuandoUmDeterminiadoEquipamentoPodeSerLeiloado();
    
    //subtestes da regra2
    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoAIdadeDoEquipamentoFor1();

    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoAIdadeDoEquipamentoFor2();
    
    public void testRegra2DefineSeUmDeterminiadoEquipamentoPodeSerLeiloadoQuandoIdadeItemNoArmazemForMaiorQue9EIdadeDoEquipamentoMaiorQue1();
    
    //subtestes regra2 com cenarios para materiais obsoletos leiloados
    public void testRegra2DefineQuantidadeMaterialObsoletoLeiloadoTipoDesktop();
    
    public void testRegra2DefineQuantidadeMaterialObsoletoLeiloadoTipoLaptop();
    
    public void testRegra2DefineQuantidadeMaterialObsoletoLeiloadoTipoImpressora();
    
    //regra3
    public void testRegra3DefineQuantidadeMaterialObsoletoPorTipo();
    
    //subtestes regra3 com cenarios para materiais obsoletos
    public void testRegra3DefineQuantidadeMaterialObsoletoQuandoTipoForDesktop();
    
    public void testRegra3DefineQuantidadeMaterialObsoletoQuandoTipoForLaptop();
    
    public void testRegra3DefineQuantidadeMaterialObsoletoQuandoTipoForImpressora();
    
    public void testRegra3DefineQuantidadeMaterialObsoletoArmazenadoOuLeiloado();
   
    
    
}
