/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.productosclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jnda
 */
@Controller
public class ProductoController {

    @Autowired
    ProductoService productoService;

    public ProductoController() {

    }

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/producto")
    public String greetingAll() {
        return "greetingAll";
    }

    @RequestMapping("/producto/{id}")
    @HystrixCommand(fallbackMethod =  "greetingDefault")
    public String greeting(Model model, @PathVariable("id") long id) {
        productoService = ProductosClientApplication.productoService();
        Producto greeting = productoService.greeting(id);
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", greeting.getNombre());
        params.put("valor", greeting.getValor());
        params.put("descripcion", greeting.getDescripcion());
        model.addAllAttributes(params);
        System.out.println(params);
        return "greeting";
    }

     public String greetingDefault(Model model, @PathVariable("id") long id) {
        Producto greeting = productoService.greetingDefault();
        Map<String, Object> params = new HashMap<>();
         params.put("nombre", greeting.getNombre());
        params.put("valor", greeting.getValor());
        params.put("descripcion", greeting.getDescripcion());
        model.addAllAttributes(params);
        System.out.println(params);
        return "greeting";
    }
}
