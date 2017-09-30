/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.modelo.Articulo;
import java.time.zone.ZoneRulesProvider;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
public class CarritoBean {

    @EJB
    private com.udea.dao.ArticuloFacadeLocal articuloFacade;
    
    private Articulo producto;
    private List<Articulo> productos;

    public Articulo getProducto() {
        return producto;
    }

    public void setProducto(Articulo producto) {
        this.producto = producto;
    }

    public List<Articulo> getProductos() {
        if (productos == null || productos.isEmpty()){
            refrescarPagina();
        }
        return productos;
    }

    public void setProductos(List<Articulo> productos) {
        this.productos = productos;
    }
    
    
    
    /**
     * Creates a new instance of CarritoBean
     */
    public CarritoBean() {
    }
    
//    public List<Articulo> getAllArticulos()
//    {
//        if (productos == null || productos.isEmpty()){
//            refrescarPagina();
//        }
//        return productos;
//    }
//    
    private void refrescarPagina()
    {
        productos = articuloFacade.findAll();
    }
}
