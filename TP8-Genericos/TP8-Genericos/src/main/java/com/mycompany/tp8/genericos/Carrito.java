package com.mycompany.tp8.genericos;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author lucaGomezB
 */
public class Carrito<T extends Producto<?>> {
    private List<T> productos;
    
    public Carrito(){
        productos = new ArrayList<>();
    }
    
    public void agregarProducto(T producto){
        productos.add(producto);
    }
    
    public void eliminarProducto(T producto){
        productos.remove(producto);
    }
    
    public double obtenerTotal(){
        double total = 0;
        for(Producto producto : productos){
            total += producto.getPrecio();
        }
        return total;
    }
    
    public void mostrarProductos(){
        for(Producto producto : productos){
            System.out.println(producto);
        }
    }
}
