/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.par.paronline.modelo;

/**
 *
 * @author root
 */
public class Producto implements java.io.Serializable {


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    private String categoria, descripcion, precio;
    
    public Producto(){
        //Constructor sin argumentos
    }

    public Producto(String cat, String des, String valor){
        categoria = cat;
        descripcion = des;
        precio = valor;
    }
    public String toString(){
        return categoria + descripcion + precio;
    }
}