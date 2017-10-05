package com.udea.controller;

import com.udea.dao.ComprobanteFacadeLocal;
import com.udea.dao.TransaccionFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

public class TransaccionMBean implements Serializable
{

    @EJB
    private ComprobanteFacadeLocal comprobanteFacade;

    @EJB
    private TransaccionFacadeLocal transaccionFacade;
    
    private List<String> canasta = new ArrayList<>();
    private int numItemsEnCanasta;
    
    
    public TransaccionMBean()
    {
        numItemsEnCanasta = 0;
    }
    
    public List<String> getCanasta()
    {
        return canasta;
    }
    
    public void vaciarCanasta()
    {
        System.out.println("vaciar");
        numItemsEnCanasta = 0;
        canasta.clear();
    }
    
    public void imprimirCanasta()
    {
        int i;
        int numArticulos = canasta.size();
        
        System.out.println("Los articulos en la canasta son:");
        for (i = 0; i < numArticulos; i++)
        {
            System.out.println(canasta.get(i));
        }
        System.out.println("----");
    }

    public void agregarArticuloACanasta(String item)
    {
        System.out.println("Se agrego:" + item);
        canasta.add(item);
        numItemsEnCanasta++;
    }
    
    public void quitarArticuloDeCanasta(String item)
    {
        System.out.println("Se saco:" + item);
        canasta.remove(item);
        numItemsEnCanasta--;
    }
    
    public boolean estaArticulo(String item)
    {
        return canasta.contains(item);
    }
    
    public int getNumItemsEnCanasta() {
        return numItemsEnCanasta;
    }
}
