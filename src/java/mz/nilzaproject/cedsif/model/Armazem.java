/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.model;

import java.sql.Date;

/**
 *
 * @author nilza.graca
 */
public class Armazem {
   
    private int id;
    private String code;
    private String description;
    
    private ArmazemItem item;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the item
     */
    public ArmazemItem getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(ArmazemItem item) {
        this.item = item;
    }
    
    
    
}
