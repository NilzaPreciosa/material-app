/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.ModelMap;

/**
 *
 * @author nilza.graca
 */
public interface IController {
    
    String getView(HttpServletRequest request, HttpServletResponse response, ModelMap map);
    
    String postView(HttpServletRequest request, HttpServletResponse response, ModelMap map);
    
}
