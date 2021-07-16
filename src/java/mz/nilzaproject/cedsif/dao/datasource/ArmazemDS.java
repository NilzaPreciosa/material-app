/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.dao.datasource;

import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nilza.graca
 *
 * Dao Gererico das interfaces para cada entidade utiliza o conceito de
 * parametrizacao para se adaptar a qualquer entidade/modelo
 * ´
 * 
 * public interface HibernateCallback<T extends Object> reas this later
 */
public interface ArmazemDS<T extends Object, ID extends Serializable> {

    /**
     * criando as abstracoes de acesso, CRUD C-reate R-ead U-pdate D-elete
     *
     */
    //metodo create
    public void createOrUpdate(T t);

    //metodo para busca o objecto na base
    public T read(ID id);

    //deletar objecto
    public T delete(ID id);

    public List<T> list();
}
