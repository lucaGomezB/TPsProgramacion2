package com.lucagomezb.tp7.interfacesyexcepciones.ProductosPagablesConPedido;
import java.util.ArrayList;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class Pedido implements Pagable, Notificable{
    
    private ArrayList<Producto> productos;
    private String estado;
    private Cliente cliente;

    public Pedido(String estado, Cliente cliente) {
        this.productos = new ArrayList<>();
        this.estado = estado;
        this.cliente = cliente;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        return total;
    }
    
    public void agregarProducto(Producto producto){
        this.productos.add(producto);
        System.out.println("Producto "+producto+" agregado exitosamente.");
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notifica al cliente : "+cliente+", "+mensaje);
    }
    
    public void cambiarEstado(String estado){
        this.estado = estado;
        notificar(estado);
    }
}
