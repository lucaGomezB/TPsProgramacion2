package com.mycompany.tp8.genericos;
import java.util.Collection;
/**
 *
 * @author lucaGomezB
 */
public class Buscador<T extends Identificable<K>, K>{
    public T buscar(Collection<? extends T> elementos, K id) throws IllegalArgumentException{
        if(elementos == null || id == null){
            throw new IllegalArgumentException("Se ha ingresado una colección de elementos o un identificador nulo.");
        }
        for(T elemento : elementos){
            if(elemento.tieneMismoID(id)){
                return elemento;
            }
        }
        System.out.println("No se ha podido encontrar su elemento por ID.");
        return null;
    }
}
