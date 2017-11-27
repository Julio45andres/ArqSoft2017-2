/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.productosclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jnda
 */
@Service
public class ProductoService {

    @Autowired
    protected RestTemplate restTemplate;
    protected String serviceUrl;

    public ProductoService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public Producto greeting(long id) {
        restTemplate = ProductosClientApplication.restTemplate();
        return restTemplate.getForObject(serviceUrl + "producto/{id}", Producto.class, id);
    }

    public Producto greetingDefault() {
        return new Producto(0, "Ha ocurrido un error", 0, "Ha ocurrido un error");
    }
}
