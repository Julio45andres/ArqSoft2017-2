/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.dao.EstadoFacadeLocal;
import com.udea.modelo.Estado;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EstadoServlet extends HttpServlet {

    @EJB
    private EstadoFacadeLocal estadoFacade;

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
                List<Estado>  estados=estadoFacade.findAll();
                
                json="[";
                for (Estado estado: estados) {
                    json+="{";
                    json+="\"codigo\":\""+estado.getCodigo()+"\",";
                    json+="\"descripcion\":\""+estado.getDescripcion()+"\",";
                    json+="\"estado\":\""+estado.getEstado()+"\"";
                    json+="},";
                }
                json=json.substring(0, json.length()-1);
                json+="]";
                //response.getWriter().write(strClientes);           
            }
            else if(method.equals("POST") || method.equals("PUT")){
                Estado estado=new Estado();
                estado.setCodigo(request.getParameter("codigo"));
                estado.setDescripcion(request.getParameter("descripcion"));
                estado.setEstado(request.getParameter("estado"));               
                if(method.equals("POST")){
                    estadoFacade.create(estado);
                    json="{\"estado\":true,\"msj\":\"Estado creado correctamente\"}";
                }
                else{
                    estadoFacade.edit(estado);
                    json="{\"estado\":true,\"msj\":\"Estado actualizado correctamente\"}";
                }
                
            }
            else if(method.equals("DELETE")){
                Estado estado=new Estado();
                estado.setCodigo(request.getParameter("codigo").trim());
                estadoFacade.remove(estado);
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
