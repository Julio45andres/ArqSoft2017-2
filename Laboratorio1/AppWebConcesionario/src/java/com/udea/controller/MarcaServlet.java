/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.dao.MarcaFacadeLocal;
import com.udea.modelo.Marca;
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
public class MarcaServlet extends HttpServlet {

    @EJB
    private MarcaFacadeLocal marcaFacade;

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
                List<Marca>  marcas=marcaFacade.findAll();
                
                json="[";
                for (Marca marca: marcas) {
                    json+="{";
                    json+="\"codigo\":\""+marca.getCodigo()+"\",";
                    json+="\"nombreMarca\":\""+marca.getNombreMarca()+"\"";
                    json+="},";
                }
                json=json.substring(0, json.length()-1);
                json+="]";
                //response.getWriter().write(strClientes);           
            }
            else if(method.equals("POST") || method.equals("PUT")){
                Marca marca=new Marca();
                marca.setCodigo(request.getParameter("codigo"));
                marca.setNombreMarca(request.getParameter("nombreMarca"));
                if(method.equals("POST")){
                    marcaFacade.create(marca);
                    json="{\"estado\":true,\"msj\":\"Marca creado correctamente\"}";
                }
                else if(method.equals("PUT")){
                    marcaFacade.edit(marca);
                    json="{\"estado\":true,\"msj\":\"Marca actualizado correctamente\"}";
                }
            }
            else if(method.equals("DELETE")){
                String codigo=request.getParameter("codigo");
                Marca marca=marcaFacade.find(codigo);
                marcaFacade.remove(marca);
                json="{\"estado\":true,\"msj\":\"Marca eliminada correctamente\"}";
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
