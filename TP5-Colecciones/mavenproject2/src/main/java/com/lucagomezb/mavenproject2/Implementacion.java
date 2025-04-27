package com.lucagomezb.mavenproject2;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class Implementacion {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Producto producto1 = new Producto("1","Zapatos",2000.45,5,CategoriaProducto.ROPA);
        inventario.agregarProducto(producto1);
        Producto producto2 = new Producto("2","Monitor - 24.5'' ",5000.25,1,CategoriaProducto.ELECTRONICA);
        inventario.agregarProducto(producto2);
        Producto producto3 = new Producto("3","Celular",3000.45,10,CategoriaProducto.ELECTRONICA);
        inventario.agregarProducto(producto3);
        inventario.mostrarProductos();
        System.out.println("------------------"); //parte 2
        Producto producto4 = new Producto("4","Sillón",4000.99,2,CategoriaProducto.HOGAR);
        inventario.agregarProducto(producto4);
        Producto producto5 = new Producto("5","CPU P0-13NT4",7000.89,5,CategoriaProducto.ELECTRONICA);
        inventario.agregarProducto(producto5);
        Producto productoABuscar = inventario.buscarProductoPorID("1");
        productoABuscar.mostrarInfo();
        productoABuscar = inventario.buscarProductoPorID("0");
        productoABuscar.mostrarInfo();
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        inventario.eliminarProducto("1");
        inventario.mostrarProductos();
        System.out.println("------------------"); //parte 3
        int totalStock = inventario.obtenerTotalStock();
        Producto productoConMayorStock = inventario.obtenerProductoConMayorStock();
        inventario.filtrarProductosPorPrecio(1000, 3000);
        inventario.mostrarCategoriasDisponibles();
    }
}
