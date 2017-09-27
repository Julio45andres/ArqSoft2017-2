/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.dao.VehiculoFacadeLocal;
import com.udea.modelo.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sun.misc.IOUtils;


/**
 *
 * @author Administrador
 */
//@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class VehiculoServlet extends HttpServlet {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;

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
                
                
                List<Vehiculo>  vehiculos=vehiculoFacade.findAll();
                //response.getWriter().write("{\"nombre\":\"hola\"}");
                json="[";
                for (Vehiculo vehiculo : vehiculos) {
                    //String strFoto = Base64.getEncoder().encodeToString(vehiculo.getFoto());
                    json+="{";
                    json+="\"matricula\":\""+vehiculo.getMatricula()+"\",";
                    json+="\"modelo\":\""+vehiculo.getModelo()+"\",";
                    json+="\"marca\":\""+vehiculo.getMarca()+"\",";
                    json+="\"estado\":\""+vehiculo.getEstado()+"\",";
                    json+="\"color\":\""+vehiculo.getColor()+"\",";
                    //json+="\"foto\":\""+strFoto+"\",";
                    json+="\"precioVenta\":\""+vehiculo.getPrecioVenta()+"\"";
                    json+="},";
                }
                json=json.substring(0, json.length()-1);
                json+="]";
                //response.getWriter().write(strClientes);           
            }
            else if(method.equals("POST") || method.equals("PUT")){
                
                                
                Vehiculo vehiculo=new Vehiculo();
                vehiculo.setMatricula(request.getParameter("matricula"));
                vehiculo.setModelo(request.getParameter("modelo"));
                vehiculo.setMarca(request.getParameter("marca"));
                vehiculo.setEstado(request.getParameter("estado"));
                vehiculo.setColor(request.getParameter("color"));
                vehiculo.setPrecioVenta(BigDecimal.valueOf(Double.valueOf(request.getParameter("precioVenta"))));
                
                byte[] bytesFoto=null;
                
                Part foto=request.getPart("foto");

                bytesFoto = IOUtils.readFully(foto.getInputStream(),-1, true);                
                vehiculo.setFoto(bytesFoto);
                               
                if(method.equals("POST")){
                    vehiculoFacade.create(vehiculo);
                    json="{\"estado\":true,\"msj\":\"Vehiculo creado correctamente\"}";
                }
                else if(method.equals("PUT")){
                    vehiculoFacade.edit(vehiculo);
                    json="{\"estado\":true,\"msj\":\"Vehiculo actualizado correctamente\"}";
                }
            }
            else if(method.equals("DELETE")){
                String id=request.getParameter("matricula");
                Vehiculo vehiculo=vehiculoFacade.find(id);
                vehiculoFacade.remove(vehiculo);
                json="{\"estado\":true,\"msj\":\"Vehiculo eliminado correctamente\"}";
            }
            else{
                json="{\"estado\":true,\"msj\":\"Opción no valida\"}";
            }
        }
        catch(IOException e){
            json="{\"estado\":false,\"msj\":\""+e.getMessage()+"\"}";
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
