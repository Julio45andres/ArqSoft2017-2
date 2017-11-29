/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.controller;

import co.edu.udea.dao.UsuariosFacadeLocal;
import co.edu.udea.jpa.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cesar
 */
public class UsuarioServlet extends HttpServlet {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

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
        response.setContentType("text/plain;charset=UTF-8");
        String strClientes="";
        try{
            String method=request.getParameter("method");
            
            Usuarios usuarios=new Usuarios();            
            int id=Integer.valueOf(request.getParameter("id"));
            usuarios.setId(id);
            usuarios.setNombre(request.getParameter("nombre"));
            usuarios.setAvatar(request.getParameter("avatar"));
            usuarios.setEmail(request.getParameter("email"));
            //usuarios.setFechaNacimiento(new Date(request.getParameter("fechaNacimiento")));
            usuarios.setFechaNacimiento(new Date());
            usuariosFacade.create(usuarios);
            
            strClientes="Registro guardado correctamente";
               
        }
        catch(PersistenceException e){
            strClientes=e.getMessage();
        }
        catch(Exception e){
            strClientes=e.getMessage();
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
