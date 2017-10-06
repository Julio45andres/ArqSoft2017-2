package com.udea.controller;

import com.udea.dao.ComprobanteFacadeLocal;
import com.udea.dao.TransaccionFacadeLocal;
import com.udea.modelo.Transaccion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolationException;

public class TransaccionMBean implements Serializable
{

    @EJB
    private ComprobanteFacadeLocal comprobanteFacade;

    @EJB
    private TransaccionFacadeLocal transaccionFacade;
    
    private List<String> canasta = new ArrayList<>();
    private int numItemsEnCanasta;
    //private Transaccion transaccion;
    
    private String duiCliente;
    private String nombreCliente;
    private String email;
    private String numTCredito;
    private String cvvTCredito;
    private String tipoTCredito;
    private String fVenceTCredito;
    private BigDecimal valorTotal;
    
    
    //Variables auxiliares para controlar la vista
    private UIComponent mybutton;
    private Locale locale=FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private boolean disabled=true;
    private String sSubCadena;
    private String mensajeCard;
    private String m;
    
    public TransaccionMBean()
    {
        numItemsEnCanasta = 0;
        duiCliente="1045021276";
        nombreCliente="CESAR";
        email="cesar@udea.com";
        numTCredito="1111111111";
        cvvTCredito="111111";
        tipoTCredito="VISA";
        fVenceTCredito="05/2020";
        valorTotal=BigDecimal.valueOf(0);        
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
        //try{
            Transaccion transaccion=new Transaccion();  
            /*this.transaccion.setDuiCliente("1045021276");
            this.transaccion.setNombreCliente("cesar");
            this.transaccion.setEmail("cesar@udea.com");
            this.transaccion.setNumTCredito("5582781234567890");
            this.transaccion.setCvvTCredito("123");
            this.transaccion.setTipoTCredito("VISA");
            this.transaccion.setFVenceTCredito("09/2018");
            this.transaccion.setValorTotal(BigDecimal.valueOf(2500));
            this.transaccionFacade.create(transaccion);*/
            transaccion.setDuiCliente(duiCliente);
            transaccion.setNombreCliente(nombreCliente);
            transaccion.setEmail(email);
            transaccion.setNumTCredito(numTCredito);
            transaccion.setCvvTCredito(cvvTCredito);
            transaccion.setTipoTCredito(tipoTCredito);
            transaccion.setFVenceTCredito(fVenceTCredito);
            transaccion.setValorTotal(valorTotal);
            this.transaccionFacade.create(transaccion);
            return "PAGAR";
        /*}
        catch(ConstraintViolationException e){
            return "Error"+e.getMessage();
        }
        catch(Exception e){
            return "No fue posible generar la transacción"+e.getMessage();
        }*/
    }
    
    public String validar(){
        String sCadena;
        sCadena=String.valueOf(numTCredito);
        sSubCadena=sCadena.substring(0, 5);
        int val=Integer.parseInt(sSubCadena);
        if(val>=11111 && val<=22222){
            FacesMessage message=new FacesMessage("Tarjeta American Express");
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(mybutton.getClientId(context), message);
            mensajeCard="Es American Express";
            disabled=false;
            this.setMensajeCard(mensajeCard);
            return this.getMensajeCard();
        }
        else if(val>=33334 && val<=44444){
            FacesMessage message=new FacesMessage("Tarjeta Diners");
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(mybutton.getClientId(context), message);
            mensajeCard="Es Diners";
            disabled=false;
            this.setMensajeCard(mensajeCard);
            return this.getMensajeCard();
        }
        else if(val>=55555 && val<=66666){
            FacesMessage message=new FacesMessage("Tarjeta Visa");
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(mybutton.getClientId(context), message);
            mensajeCard="Es Visa";
            disabled=false;
            this.setMensajeCard(mensajeCard);
            return this.getMensajeCard();
        }
        else if(val>=77777 && val<=88888){
            FacesMessage message=new FacesMessage("Tarjeta Mastercard");
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(mybutton.getClientId(context), message);
            mensajeCard="Es Mastercard";
            disabled=false;
            this.setMensajeCard(mensajeCard);
            return this.getMensajeCard();
        }
        else{
           FacesMessage message= new FacesMessage("Invalid card");
           FacesContext context= FacesContext.getCurrentInstance();
           context.addMessage(mybutton.getClientId(context), message);
        }
        return null;
    }
    
    public String getLanguage(){
        return locale.getLanguage();
    }
    public void changeLanguage(String language){
        locale=new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
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

    public ComprobanteFacadeLocal getComprobanteFacade() {
        return comprobanteFacade;
    }

    public void setComprobanteFacade(ComprobanteFacadeLocal comprobanteFacade) {
        this.comprobanteFacade = comprobanteFacade;
    }

    public TransaccionFacadeLocal getTransaccionFacade() {
        return transaccionFacade;
    }

    public void setTransaccionFacade(TransaccionFacadeLocal transaccionFacade) {
        this.transaccionFacade = transaccionFacade;
    }



    public UIComponent getMybutton() {
        return mybutton;
    }

    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getsSubCadena() {
        return sSubCadena;
    }

    public void setsSubCadena(String sSubCadena) {
        this.sSubCadena = sSubCadena;
    }

    public String getMensajeCard() {
        return mensajeCard;
    }

    public void setMensajeCard(String mensajeCarf) {
        this.mensajeCard = mensajeCarf;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    
   
    
}
