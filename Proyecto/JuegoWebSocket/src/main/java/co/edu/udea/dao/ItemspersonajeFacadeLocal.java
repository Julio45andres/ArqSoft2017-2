/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Itemspersonaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cesar
 */
@Local
public interface ItemspersonajeFacadeLocal {

    void create(Itemspersonaje itemspersonaje);

    void edit(Itemspersonaje itemspersonaje);

    void remove(Itemspersonaje itemspersonaje);

    Itemspersonaje find(Object id);

    List<Itemspersonaje> findAll();

    List<Itemspersonaje> findRange(int[] range);

    int count();
    
}
