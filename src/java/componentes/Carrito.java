/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Carrito {
    private ArrayList<Producto> carrito;

    public Carrito() {
        this.carrito = new ArrayList<Producto>();
    }
    
    /**
     *La funcion recibe un producto y lo agrega al carrito
     * @param prod
     */
    public void agregar_producto(Producto prod){
        this.carrito.add(prod);
    }
    
}
