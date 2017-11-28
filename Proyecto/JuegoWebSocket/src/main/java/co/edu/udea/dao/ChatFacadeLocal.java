/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Chat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cesar
 */
@Local
public interface ChatFacadeLocal {

    void create(Chat chat);

    void edit(Chat chat);

    void remove(Chat chat);

    Chat find(Object id);

    List<Chat> findAll();

    List<Chat> findRange(int[] range);

    int count();
    
}
