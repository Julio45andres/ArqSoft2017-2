/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Items;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cesar
 */
@Local
public interface ItemsFacadeLocal {

    void create(Items items);

    void edit(Items items);

    void remove(Items items);

    Items find(Object id);

    List<Items> findAll();

    List<Items> findRange(int[] range);

    int count();
    
}
