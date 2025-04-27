package com.lucagomezb.mavenproject2;
/**
 *
 * @author lucaGomezB
 */
public class Producto {
    String id; // Identificador único del producto, en una BDD sería la PK
    String nombre;
    double precio;
    int cantidad; // Cantidad en stock
    CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
    
    public void mostrarInfo(){
        System.out.println("Producto: "+nombre+"\n\t Id: "+id+"\n\t Precio: "+precio+"\n\t Cantidad: "+cantidad+"\n\t Categoria: "+categoria.toString());
        System.out.println("");
    }
}
