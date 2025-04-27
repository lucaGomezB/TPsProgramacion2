package com.lucagomezb.mavenproject2;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public enum CategoriaProducto {
    ALIMENTOS("ALIMENTOS : Productos comestibles."),
    ELECTRONICA("ELECTRONICA : Dispositivos electrónicos."),
    ROPA("ROPA : Prendas de vestir."),
    HOGAR("HOGAR : Artículos para el hogar."),
    ND("ND : El producto no está disponible."); 
    
    private final String descripcion;
    
    private CategoriaProducto(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
}


