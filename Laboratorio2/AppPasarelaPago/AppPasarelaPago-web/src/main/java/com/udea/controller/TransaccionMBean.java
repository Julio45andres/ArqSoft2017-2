package com.udea.controller;

import com.udea.dao.ComprobanteFacadeLocal;
import com.udea.dao.TransaccionFacadeLocal;
import com.udea.modelo.Transaccion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.ConstraintViolationException;

public class TransaccionMBean implements Serializable
{

    @EJB
    private ComprobanteFacadeLocal comprobanteFacade;

    @EJB
    private TransaccionFacadeLocal transaccionFacade;
    
    private List<String> canasta = new ArrayList<>();
    private int numItemsEnCanasta;
    private Transaccion transaccion;
    
    private String duiCliente;
    private String nombreCliente;
    private String email;
    private String numTCredito;
    private String cvvTCredito;
    private String tipoTCredito;
    private String fVenceTCredito;
    private BigDecimal valorTotal;
    
    
    private boolean disabled;
    
    public TransaccionMBean()
    {
        numItemsEnCanasta = 0;
        duiCliente="";
        nombreCliente="asd";
        email="";
        numTCredito="";
        cvvTCredito="";
        tipoTCredito="";
        fVenceTCredito="";
        valorTotal=BigDecimal.valueOf(0);
        disabled=true;
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
    
    public String pagar(){
        try{
            this.transaccion=new Transaccion();  
            /*this.transaccion.setDuiCliente("1045021276");
            this.transaccion.setNombreCliente("cesar");
            this.transaccion.setEmail("cesar@udea.com");
            this.transaccion.setNumTCredito("5582781234567890");
            this.transaccion.setCvvTCredito("123");
            this.transaccion.setTipoTCredito("VISA");
            this.transaccion.setFVenceTCredito("09/2018");
            this.transaccion.setValorTotal(BigDecimal.valueOf(2500));
            this.transaccionFacade.create(transaccion);*/
            this.transaccion.setDuiCliente(duiCliente);
            this.transaccion.setNombreCliente(nombreCliente);
            this.transaccion.setEmail(email);
            this.transaccion.setNumTCredito(numTCredito);
            this.transaccion.setCvvTCredito(cvvTCredito);
            this.transaccion.setTipoTCredito(tipoTCredito);
            this.transaccion.setFVenceTCredito(fVenceTCredito);
            this.transaccion.setValorTotal(valorTotal);
            this.transaccionFacade.create(transaccion);
            System.out.println("Pago efectuado correctamente");
        }
        catch(ConstraintViolationException e){
            System.out.println("Error"+e.getMessage());
        }
        catch(Exception e){
            System.out.println("No fue posible generar la transacción");
        }
        return "PAGAR";
    }

    public String getDuiCliente() {
        return duiCliente;
    }

    public void setDuiCliente(String duiCliente) {
        this.duiCliente = duiCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNumTCredito() {
        return numTCredito;
    }

    public void setNumTCredito(String numTCredito) {
        this.numTCredito = numTCredito;
    }

    public String getCvvTCredito() {
        return cvvTCredito;
    }

    public void setCvvTCredito(String cvvTCredito) {
        this.cvvTCredito = cvvTCredito;
    }

    public String getTipoTCredito() {
        return tipoTCredito;
    }

    public void setTipoTCredito(String tipoTCredito) {
        this.tipoTCredito = tipoTCredito;
    }

    public String getfVenceTCredito() {
        return fVenceTCredito;
    }

    public void setfVenceTCredito(String fVenceTCredito) {
        this.fVenceTCredito = fVenceTCredito;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void validar(){
        this.disabled= !this.disabled;
    }
    /*
    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    */

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    
   
    
}
