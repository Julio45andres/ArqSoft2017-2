/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.dao.CompraFacadeLocal;
import com.udea.modelo.Compra;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class CompraServlet extends HttpServlet {

    @EJB
    private CompraFacadeLocal compraFacade;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String json="";
        try{
            String method=request.getParameter("method");
            
            if(method.equals("GET")){
                List<Compra>  compras=compraFacade.findAll();
                //response.getWriter().write("{\"nombre\":\"hola\"}");
                json="[";
                for (Compra compra : compras) {
                    json+="{";
                    json+="\"codigo\":\""+compra.getCodigo()+"\",";
                    json+="\"fechaCompra\":\""+new SimpleDateFormat("dd/MM/yyyy").format(compra.getFechaCompra())+"\",";
                    json+="\"tipoPago\":\""+compra.getTipoPago()+"\",";
                    json+="\"descuento\":\""+compra.getDescuento()+"\",";
                    json+="\"vendedor\":\""+compra.getVendedor()+"\",";
                    json+="\"cliente\":\""+compra.getCliente()+"\",";
                    json+="\"coche\":\""+compra.getCoche()+"\"";
                    json+="},";
                }
                json=json.substring(0, json.length()-1);
                json+="]";
                //response.getWriter().write(strClientes);           
            }
            else if(method.equals("POST") || method.equals("PUT") || method.equals("DELETE")){
                Compra compra=new Compra();
                compra.setCodigo(request.getParameter("codigo"));                
                compra.setFechaCompra(new Date(request.getParameter("fechaCompra")));
                compra.setTipoPago(request.getParameter("tipoPago"));
                compra.setDescuento(BigDecimal.valueOf(Double.valueOf(request.getParameter("descuento"))));
                compra.setVendedor(request.getParameter("vendedor"));
                compra.setCliente(request.getParameter("cliente"));
                compra.setCoche(request.getParameter("coche"));
                if(method.equals("POST")){
                    compraFacade.create(compra);
                    json="{\"estado\":true,\"msj\":\"Compra creado correctamente\"}";
                }
                else if(method.equals("PUT")){
                    compraFacade.edit(compra);
                    json="{\"estado\":true,\"msj\":\"Compra actualizado correctamente\"}";
                }
                else if(method.equals("DELETE")){                    
                    compraFacade.remove(compra);
                    json="{\"estado\":true,\"msj\":\"Compra eliminada correctamente\"}";
                }                
            }            
            else{
                json="{\"estado\":true,\"msj\":\"Opción no valida\"}";
            }
        }
        catch(Exception e){
            json="{\"estado\":false,\"msj\":\""+e.getMessage()+"\"}";
        }
        finally{
            response.getWriter().write(json);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
