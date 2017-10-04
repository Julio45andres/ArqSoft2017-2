package com.udea.controller;

import com.udea.modelo.Articulo;
import com.udea.modelo.Transaccion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;

public class CarritoMBean implements Serializable
{

    @EJB
    private com.udea.dao.ArticuloFacadeLocal articuloFacade;
        
    private Articulo producto;
    private List<Articulo> productos;
    
    public CarritoMBean(){
        getProductos();
    }
    
    public void refrescar()
    {
        productos = new ArrayList(articuloFacade.findAll());
    }
    
    public List<Articulo> getProductos()
    {
        if ((productos == null) || (productos.isEmpty()))
        {
            refrescar();
        }
        System.out.println("entro");
        return productos;
    }
    
    
    
    
    
//    private String codigo;
//    private String nombre;
//    private String descripcion;
//    private int existencia;
//    private BigDecimal precioProveedor;
//    private BigDecimal precioCliente;
//    private Collection<Transaccion> transaccionCollection;
}
