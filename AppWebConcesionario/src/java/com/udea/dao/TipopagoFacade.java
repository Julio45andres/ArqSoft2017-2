/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.modelo.Tipopago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class TipopagoFacade extends AbstractFacade<Tipopago> implements TipopagoFacadeLocal {

    @PersistenceContext(unitName = "AppWebConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipopagoFacade() {
        super(Tipopago.class);
    }
    
}
