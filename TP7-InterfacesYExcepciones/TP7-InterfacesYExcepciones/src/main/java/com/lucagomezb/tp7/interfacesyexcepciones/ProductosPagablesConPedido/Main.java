package com.lucagomezb.tp7.interfacesyexcepciones.ProductosPagablesConPedido;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("John","Johnson@coronel.com");
        Pedido pedido1 = new Pedido("En la estación de empaquetado.",cliente1);
        Producto ajiEnPolvo = new Producto("Ají en polvo",200);
        pedido1.agregarProducto(ajiEnPolvo);
        Producto ketchup = new Producto("Ketchup granja salsa", 100);
        pedido1.agregarProducto(ketchup);
        pedido1.cambiarEstado("Se ha cerrado el envío y este se ha enviado a la aduana.");
    }
}
