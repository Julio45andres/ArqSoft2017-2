/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.dao.ComprobanteFacadeLocal;
import com.udea.dao.TransaccionFacadeLocal;
import javax.ejb.EJB;

/**
 *
 * @author Cesar
 */
public class BillMBean {

    @EJB
    private TransaccionFacadeLocal transaccionFacade;

    @EJB
    private ComprobanteFacadeLocal comprobanteFacade;

    
    /**
     * Creates a new instance of BillMBean
     */
    public BillMBean() {
    }
    
}
