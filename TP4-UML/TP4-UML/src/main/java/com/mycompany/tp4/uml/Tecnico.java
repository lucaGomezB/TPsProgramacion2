package com.mycompany.tp4.uml;
/**
 *
 * @author lucaGomezB
 */
public class Tecnico {
    String id;
    String nombre;
    String especialidad;

    public Tecnico(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    public void trabajarEnTicket(TicketSoporte ticket){
        ticket.setEstado("ENPROGRESO");
    }

    @Override
    public String toString() {
        return "{ \n ID = " + id + ", \n Nombre = " + nombre + ", \n Especialidad = " + especialidad + "\n }";
    }
    
    
}
