/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Configuraciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cesar
 */
@Local
public interface ConfiguracionesFacadeLocal {

    void create(Configuraciones configuraciones);

    void edit(Configuraciones configuraciones);

    void remove(Configuraciones configuraciones);

    Configuraciones find(Object id);

    List<Configuraciones> findAll();

    List<Configuraciones> findRange(int[] range);

    int count();
    
}
