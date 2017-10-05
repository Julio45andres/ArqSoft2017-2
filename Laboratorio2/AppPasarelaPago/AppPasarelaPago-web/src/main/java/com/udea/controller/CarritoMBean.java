package com.udea.controller;

import com.udea.modelo.Articulo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

public class CarritoMBean implements Serializable
{
    @EJB
    private com.udea.dao.ArticuloFacadeLocal articuloFacade;
    
    private List<Articulo> productos = new ArrayList<>();
    
    public CarritoMBean(){}
    
    public void refrescar()
    {
        productos = new ArrayList(articuloFacade.findAll());
    }
    
    public List<Articulo> getProductos()
    {
        if (productos.isEmpty())
        {
            this.refrescar();
        }
        
        return productos;
    }

    public void setProductos(List<Articulo> productos) {
        this.productos = productos;
    }
    
    
    
    // Metodos especificos para los casos navegacionales
    
    public String volverAInicio()
    {
        return "INICIO";
    }
    
    public String irATienda()
    {
        return "VERARTICULOS";
    }
    
    public String volverATienda()
    {
        return "VOLVERATIENDA";
    }
    
    public String irACaja()
    {
        return "PASARACAJA";
    }
    
    public String pagarArticulos()
    {
        return "PAGAR";
    }
}
