/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Estadoscuenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cesar
 */
@Local
public interface EstadoscuentaFacadeLocal {

    void create(Estadoscuenta estadoscuenta);

    void edit(Estadoscuenta estadoscuenta);

    void remove(Estadoscuenta estadoscuenta);

    Estadoscuenta find(Object id);

    List<Estadoscuenta> findAll();

    List<Estadoscuenta> findRange(int[] range);

    int count();
    
}
