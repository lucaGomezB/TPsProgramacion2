package com.lucagomezb.tp7.interfacesyexcepciones.ProductosPagablesConPedido;

/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class Producto implements Pagable{
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public double calcularTotal(){
        double total = 0;
        return total;
    }

    @Override
    public String toString() {
        return nombre + " | " + precio;
    }
    
    
}
