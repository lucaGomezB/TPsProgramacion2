package com.lucagomezb.tp7.interfacesyexcepciones.ProductosPagablesConPedido;

/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class Cliente implements Notificable{
    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public String toString() {
        return  nombre + " | " + email;
    }
    
    
    
    @Override
    public void notificar(String mensaje) {
        System.out.println("He recibido una notificación : "+mensaje);
    }
    
    
}
