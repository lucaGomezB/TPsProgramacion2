package com.lucagomezb.mavenproject2;
import java.util.ArrayList;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class Inventario {
    private ArrayList<Producto> productos;
    
    public Inventario(){
        this.productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto){
        productos.add(producto);
        System.out.println("Producto agregado.");
        System.out.println("");
    }
    
    public void mostrarProductos(){
        for(Producto producto : productos){
            producto.mostrarInfo();
        }
        System.out.println("");
    }
    
    public Producto buscarProductoPorID(String id){
        Producto productoEncontrado = null;
        int i = 0;
        while(i < (productos.size())){
            if(productos.get(i).id.equals(id)){ 
                return productos.get(i);
            }
            i++;
        }
        if(i == (productos.size())){
            System.out.println("No se ha podido encontrar el producto deseado.");
        }
        System.out.println("");
        return new Producto("NULL","PRODUCTO NO ENCONTRADO",0,0,CategoriaProducto.ND);
    }
    
    public void eliminarProducto(String id){
        int i = 0;
        while(i < (productos.size())){
            if(productos.get(i).id.equals(id)){ 
                productos.remove(productos.get(i));
                System.out.println("Producto removido.");
                break;
            }
            i++;
        }
        if(i == (productos.size())){
            System.out.println("No se ha podido remover el producto porque no se pudo encontrar.");
        }
        System.out.println("");
    }
    
    public void actualizarStock(String id, int nuevaCantidad){
        int i = 0;
        while(i < (productos.size())){
            if(productos.get(i).id.equals(id)){ 
                productos.get(i).cantidad = nuevaCantidad;
                System.out.println("Stock de "+productos.get(i).nombre+" actualizado.");
                break;
            }
            i++;
        }
        if(i == (productos.size())){
            System.out.println("No se ha podido encontrar el producto.");
        }
        System.out.println("");
    }
    
    public void filtrarPorCategoria (CategoriaProducto categoria){
        int i = 0;
        System.out.println("Los productos encontrados son los siguientes :");
        while(i < (productos.size())){
            if(productos.get(i).categoria.equals(categoria)){ 
                productos.get(i).mostrarInfo();
            }
            i++;
        }
        System.out.println("");
    }
    
    public int obtenerTotalStock(){
        int total = 0;
        for(Producto producto : productos){
            total += producto.cantidad;
        }
        System.out.println("El stock total de todos los productos es : "+total);
        System.out.println("");
        return total;
    }
    
    public Producto obtenerProductoConMayorStock(){
        int i = 0;
        Producto productoMayorCantidad = new Producto("","",0,0,CategoriaProducto.ND);
        while(i < (productos.size())){
            if(productos.get(i).cantidad > productoMayorCantidad.cantidad){ 
                productoMayorCantidad = productos.get(i);
            }
            i++;
        }
        System.out.println("El producto con mayor cantidad es : "+productoMayorCantidad.nombre+" | id : "+productoMayorCantidad.id);
        System.out.println("");
        return productoMayorCantidad;
    }
    
    public void filtrarProductosPorPrecio(double min, double max){
        System.out.println("Los productos encontrados son : ");
        for(Producto producto : productos){
            if(producto.precio >= min && producto.precio <= max){
                producto.mostrarInfo();
            }
        }
        System.out.println("");
    }
    
    public void mostrarCategoriasDisponibles() {
        CategoriaProducto[] categorias = CategoriaProducto.values();
        int i = 1;
        System.out.println("A continuación se muestran todas las categorías disponibles acompañadas de una pequeña descripción :");
        for(CategoriaProducto categoria : categorias){
            System.out.println(i+") "+categoria.getDescripcion());
            i++;
        }
        System.out.println("");
    }
}
