/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.productosbackend.rest;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 * @author jnda
 */
@JsonRootName("Producto")
public class Producto {
    private long id;
    private String nombre;
    private double valor;
    private String descripcion;

    public Producto(){
        
    }
    
    public Producto(long id, String nombre, double valor, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
