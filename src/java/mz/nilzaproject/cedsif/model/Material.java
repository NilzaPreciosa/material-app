/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.model;

/**
 *
 * @author nilza.graca
 */
public abstract class Material extends mz.nilzaproject.cedsif.model.db.Material {
    
    
    private int id;
    
    private  String tipo;
    
    private int idade;
    
    private int anoFabrico;
    
    private String marca;
    
    //new 
    private String referencia;
    
    private String processador;
    
    private String serialNumber;
    
    
   //encapsulamento

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @param anoFabrico the anoFabrico to set
     */
    public void setAnoFabrico(int anoFabrico) {
        this.anoFabrico = anoFabrico;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the processador
     */
    public String getProcessador() {
        return processador;
    }

    /**
     * @param processador the processador to set
     */
    public void setProcessador(String processador) {
        this.processador = processador;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
  
    //garantir visibilidade apenas para classes filhas
    protected void setId(int id) {
        this.id = id;
    }
    
    
    
}
