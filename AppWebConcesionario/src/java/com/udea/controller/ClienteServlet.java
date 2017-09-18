/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.dao.ClienteFacadeLocal;
import com.udea.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ClienteServlet extends HttpServlet {

    @EJB
    private ClienteFacadeLocal clienteFacade;

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
        String strClientes="";
        try{
            String method=request.getParameter("method");
            
            if(method.equals("GET")){
                List<Cliente>  clientes=clienteFacade.findAll();
                //response.getWriter().write("{\"nombre\":\"hola\"}");
                strClientes="[";
                for (Cliente cliente : clientes) {
                    strClientes+="{";
                    strClientes+="\"id\":\""+cliente.getId()+"\",";
                    strClientes+="\"nombre\":\""+cliente.getNombre()+"\",";
                    strClientes+="\"apellidos\":\""+cliente.getApellidos()+"\",";
                    strClientes+="\"direccion\":\""+cliente.getDireccion()+"\",";
                    strClientes+="\"email\":\""+cliente.getEmail()+"\",";
                    strClientes+="\"telefono\":\""+cliente.getTelefono()+"\",";
                    strClientes+="\"celular\":\""+cliente.getCelular()+"\"";
                    strClientes+="},";
                }
                strClientes=strClientes.substring(0, strClientes.length()-1);
                strClientes+="]";
                //response.getWriter().write(strClientes);           
            }
            else if(method.equals("POST") || method.equals("PUT") || method.equals("DELETE")){
                Cliente cliente=new Cliente();
                cliente.setId(request.getParameter("id"));
                cliente.setNombre(request.getParameter("nombre"));
                cliente.setApellidos(request.getParameter("apellidos"));
                cliente.setDireccion(request.getParameter("direccion"));
                cliente.setCelular(request.getParameter("celular"));
                cliente.setEmail(request.getParameter("email"));
                cliente.setTelefono(request.getParameter("telefono"));
                if(method.equals("POST")){
                    clienteFacade.create(cliente);
                    strClientes="{\"estado\":true,\"msj\":\"Cliente creado correctamente\"}";
                }
                else if(method.equals("PUT")){
                    clienteFacade.edit(cliente);
                    strClientes="{\"estado\":true,\"msj\":\"Cliente actualizado correctamente\"}";
                }
                else if(method.equals("DELETE")){
                    clienteFacade.remove(cliente);
                    strClientes="{\"estado\":true,\"msj\":\"Cliente eliminado correctamente\"}";
                }
                
            }            
            else{
                strClientes="{\"estado\":true,\"msj\":\"Opción no valida\"}";
            }
        }
        catch(Exception e){
            strClientes="{\"estado\":false,\"msj\":\""+e.getMessage()+"\"}";
        }
        finally{
            response.getWriter().write(strClientes);
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
