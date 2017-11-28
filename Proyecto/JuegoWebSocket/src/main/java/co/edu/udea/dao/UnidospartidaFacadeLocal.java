/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Unidospartida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cesar
 */
@Local
public interface UnidospartidaFacadeLocal {

    void create(Unidospartida unidospartida);

    void edit(Unidospartida unidospartida);

    void remove(Unidospartida unidospartida);

    Unidospartida find(Object id);

    List<Unidospartida> findAll();

    List<Unidospartida> findRange(int[] range);

    int count();
    
}
