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
public class Usuario {
    
    private int id;
    private String username;
    private String password;
    private String nameDescription;
    
    //encapsulamento

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nameDescription
     */
    public String getNameDescription() {
        return nameDescription;
    }

    /**
     * @param nameDescription the nameDescription to set
     */
    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }
    
    
}
