package com.udea.controller;

import com.udea.modelo.Articulo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

public class CarritoMBean implements Serializable
{
    @EJB
    private com.udea.dao.ArticuloFacadeLocal articuloFacade;
    
    private List<Articulo> productos = new ArrayList<>();
    
    public CarritoMBean(){
        
    }
    
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
        
        int i;
        int numArticulos = productos.size();
        
        System.out.println("Num articulos: " + numArticulos);
        for (i = 0; i < numArticulos; i++)
        {
            System.out.println(productos.get(i));
        }   
        
        System.out.println("Eso es todo!");
        return productos;
    }

    public void setProductos(List<Articulo> productos) {
        this.productos = productos;
    }
    
    // Metodos especificos para los casos navegacionales
    
    public String volverAInicio()
    {
        System.out.println("INICIO");
        return "INICIO";
    }
    
    public String irATienda()
    {
        System.out.println("VERARTICULOS");
        return "VERARTICULOS";
    }
    
    public String volverATienda()
    {
        System.out.println("VOLVERATIENDA");
        return "VOLVERATIENDA";
    }
    
    public String irACaja()
    {
        System.out.println("PASARACAJA");
        return "PASARACAJA";
    }
    
    public String pagarArticulos()
    {
        System.out.println("PAGAR");
        return "PAGAR";
    }
}
