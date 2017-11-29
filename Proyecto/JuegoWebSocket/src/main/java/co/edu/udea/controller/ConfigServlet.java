/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.controller;

import co.edu.udea.dao.ConfiguracionesFacadeLocal;
import co.edu.udea.dao.UsuariosFacadeLocal;
import co.edu.udea.jpa.Configuraciones;
import co.edu.udea.jpa.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cesar
 */
public class ConfigServlet extends HttpServlet {

    @EJB
    private ConfiguracionesFacadeLocal configuracionesFacade;
    
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
        String str="";
        try{
            
            Usuarios usuario;
            int id=Integer.valueOf(request.getParameter("id"));
            usuario=usuariosFacade.find(id);           
            if(usuario!=null){
                System.out.println(request.getParameter("sonido"));
                System.out.println(request.getParameter("idioma"));
                System.out.println(request.getParameter("resolucion"));
                System.out.println(request.getParameter("avatarimg"));                
                if(usuario.getConfiguraciones()!=null){
                    usuario.getConfiguraciones().setSonido(request.getParameter("sonido").charAt(0));
                    usuario.getConfiguraciones().setIdioma(request.getParameter("idioma"));
                    usuario.getConfiguraciones().setResolucion(request.getParameter("resolucion"));
                    usuario.getConfiguraciones().setAvatarimg(request.getParameter("avatarimg"));
                    usuariosFacade.edit(usuario);
                }
                else{
                    Configuraciones conf=new Configuraciones();
                    conf.setId(1);
                    conf.setIdUsuario(usuario);
                    conf.setSonido(request.getParameter("sonido").charAt(0));
                    conf.setIdioma(request.getParameter("idioma"));
                    conf.setResolucion(request.getParameter("resolucion"));
                    conf.setAvatarimg(request.getParameter("avatarimg"));
                    usuario.setConfiguraciones(conf);
                    configuracionesFacade.create(conf);
                }
                str="Configuracion guardado";
            }
            else{
                str="Usuario no existe ("+id+")";
            }            
        }
        catch(NullPointerException e){
            str=e.getMessage();
        }
        catch(EJBException e){
            str=e.getMessage();
        }
        catch(Exception e){
            str=e.getMessage();
        }
        finally{
            response.getWriter().write(str);
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
