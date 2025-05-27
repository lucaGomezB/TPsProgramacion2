package com.mycompany.tp8.genericos;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Skywalker
 */
public class TP8Genericos {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        Producto producto1 = new Producto("ABC",150.99,"Leche entera");
        carrito.agregarProducto(producto1);
        Producto producto2 = new Producto(123,160.99,"Leche descremada");
        carrito.agregarProducto(producto2);
        carrito.mostrarProductos();
        System.out.println("El total de los productos añadidos al carrito es : $"+carrito.obtenerTotal());
        Pedido pedido1 = new Pedido(123);
        pedido1.agregarProducto(producto2);
        pedido1.agregarProducto(producto1);
        System.out.println("Pedido "+pedido1.getID()+" | Precio total = "+pedido1.calcularTotal());
        Pedido pedido2 = new Pedido(1234);
        pedido2.agregarProducto(producto1);
        pedido2.agregarProducto(producto2);
        pedido2.agregarProducto(producto1);
        pedido2.agregarProducto(producto2);
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        mostrarArreglo(pedidos);
        System.out.println("---");
        Collections.sort(pedidos);
        mostrarArreglo(pedidos);
        Buscador buscador = new Buscador();
        Pedido pedidoEncontrado = (Pedido) buscador.buscar(pedidos, 123);
        System.out.println("El pedido encontrado es : "+pedidoEncontrado);
        // Pedido pedidoEncontrado2 = (Pedido) buscador.buscar(null,null); Funciona
        // Pedido pedidoEncontrado2 = (Pedido) buscador.buscar(null,1234); Funciona
        // Pedido pedidoEncontrado2 = (Pedido) buscador.buscar(pedidos, null); Funciona
    }
    
    public static void mostrarArreglo(ArrayList arreglo){
        for(Object o : arreglo){
            System.out.println(o);
        }
    }
}
