/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dao;

import co.edu.udea.jpa.Partidas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cesar
 */
@Stateless
public class PartidasFacade extends AbstractFacade<Partidas> implements PartidasFacadeLocal {

    @PersistenceContext(unitName = "co.edu.udea_JuegoWebSocket_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartidasFacade() {
        super(Partidas.class);
    }
    
}
