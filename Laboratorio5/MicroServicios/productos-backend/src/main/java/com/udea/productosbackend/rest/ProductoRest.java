/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.productosbackend.rest;


import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jnda
 */

@Named
@Path("/")
public class ProductoRest {
    private static final List<Producto> productos = new ArrayList<Producto>();
    
    static{
        Producto pro1 = new Producto(1, "Arroz", 2750, "Arroz blanco");
        Producto pro2 = new Producto(2, "Papas", 5000, "Papas rojas");
        Producto pro3 = new Producto(3, "Aceite", 13000, "Aceite de girasol");
        Producto pro4 = new Producto(4, "Sal", 1500, "Sal blanca");
        Producto pro5 = new Producto(5, "Huevos", 12000, "Huevos AAA");
        
        productos.add(pro1);
        productos.add(pro2);
        productos.add(pro3);
        productos.add(pro4);
        productos.add(pro5);
    }
    
    @GET
    @Path("/producto")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> getProductos(){
        return productos;
    }
    
    @GET
    @Path("/producto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producto getProducto(@PathParam("id") long id){
        Producto pro = null;
        for (Producto prod : productos) {
            if (prod.getId() == id) {
                pro = prod;
            }
        }
        return pro;
    }
}
