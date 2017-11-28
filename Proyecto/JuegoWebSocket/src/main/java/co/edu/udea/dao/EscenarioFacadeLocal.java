/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Escenario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cesar
 */
@Local
public interface EscenarioFacadeLocal {

    void create(Escenario escenario);

    void edit(Escenario escenario);

    void remove(Escenario escenario);

    Escenario find(Object id);

    List<Escenario> findAll();

    List<Escenario> findRange(int[] range);

    int count();
    
}
