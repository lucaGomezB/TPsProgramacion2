package com.mycompany.tp4.uml;
/**
 *
 * @author lucaGomezB
 */
public class Usuario {
    private String id;
    private String nombre;
    private String email;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{ \n ID = " + id + " | \n Nombre = " + nombre + " | \n Email = " + email + "\n }";
    }
    
    
}
