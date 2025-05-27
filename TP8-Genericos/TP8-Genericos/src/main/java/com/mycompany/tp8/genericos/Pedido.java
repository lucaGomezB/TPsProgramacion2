package com.mycompany.tp8.genericos;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
/**
 *
 * @author lucaGomezB
 */
public class Pedido implements Comparable<Pedido>, Identificable<Integer> {
    private int id;
    private List<Producto<?>> productos;
    private LocalDate fecha;
    
    public Pedido(int id){
        this.fecha = LocalDate.now();
        this.id = id;
        productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto<?> producto){
        this.productos.add(producto);
    }
    
    public double calcularTotal(){
        double total = 0;
        for(Producto producto : productos){
            total += producto.getPrecio();
        }
        return total;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }
    
    @Override
    public int compareTo(Pedido otro) {
        return Double.compare(this.calcularTotal(), otro.calcularTotal());
    }

    @Override
    public String toString() {
        return "Pedido{" + "id = " + id + "\n productos = " + productos + "\n fecha=" + fecha + "\n}";
    }    

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public boolean tieneMismoID(Integer id) {
        return this.id == id;
    }
}
