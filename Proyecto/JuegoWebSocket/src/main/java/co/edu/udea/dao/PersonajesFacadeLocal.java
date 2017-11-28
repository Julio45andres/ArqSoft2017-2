/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Personajes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cesar
 */
@Local
public interface PersonajesFacadeLocal {

    void create(Personajes personajes);

    void edit(Personajes personajes);

    void remove(Personajes personajes);

    Personajes find(Object id);

    List<Personajes> findAll();

    List<Personajes> findRange(int[] range);

    int count();
    
}
