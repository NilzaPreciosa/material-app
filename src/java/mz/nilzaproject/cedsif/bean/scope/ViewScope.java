/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean.scope;

import java.util.Map;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author nilza.graca
 */
@Component
public class ViewScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> of) {

        if (FacesContext.getCurrentInstance().getViewRoot() != null) {

            Map<String, Object> viewMap = FacesContext.getCurrentInstance()
                    .getViewRoot()
                    .getViewMap(); // Map do JSF cujo os valores são referentes ao escopo de view

            if (viewMap.containsKey(name)) {
                return viewMap.get(name);
            } else {
                Object object = of.getObject();
                // da próxima vez que for requisitado, dentro do escopo de view,
                // ele não precisará ser construído.
                viewMap.put(name, object);
                return object;
            }
        } else {
            return null;
        }
    }

    @Override
    public Object remove(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerDestructionCallback(String string, Runnable r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object resolveContextualObject(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getConversationId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
