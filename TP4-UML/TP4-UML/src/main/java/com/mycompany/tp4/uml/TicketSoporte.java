package com.mycompany.tp4.uml;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class TicketSoporte {
    private String id;
    private String descripcion;
    private String estado;
    private Date fechaDeCreacion;
    private Usuario usuario;
    private Tecnico tecnico;

    public TicketSoporte(String descripcion, Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        this.fechaDeCreacion = (new Date()); //Esto le asigna la fecha actual de creación.
        this.id = generarID();
        this.descripcion = descripcion;
        this.estado = "ABIERTO";
        this.usuario = usuario;
        System.out.println("Ticket creado exitosamente.");
    }
    
    public TicketSoporte(String descripcion) {
        this.fechaDeCreacion = (new Date());
        this.descripcion = descripcion;
        this.estado = "ABIERTO";
        this.id = generarID();
        System.out.println("Ticket creado exitosamente.");
    }

    public String getId() {
        return id;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String generarID(){
        int length = 10; // Desired length of the hexadecimal string
        Random random = new Random();
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomInt = random.nextInt(16);
            String hexDigit = Integer.toHexString(randomInt);
            hexString.append(hexDigit);
        }
        return hexString.toString();
    }
    
    public void cerrarTicket(){
        this.estado = "CERRADO";
        System.out.println(this.id + " fué cerrado exitosamente.");
    }
    
    public void mostrarDetalle(){
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        if(this.tecnico == null){
            if(this.usuario == null){
                return "TicketSoporte { \n ID = " + id + " | \n Descripción = " + descripcion + " | \n Estado = " + estado + " | \n Fecha de Creacion = " + fechaDeCreacion + "| \n}";
            }else{
                return "TicketSoporte { \n ID = " + id + " | \n Descripción = " + descripcion + " | \n Estado = " + estado + " | \n Fecha de Creacion = " + fechaDeCreacion + "| \n Usuario = "+usuario+" \n}";
            }
        }else{
            if(this.usuario == null){
                return "TicketSoporte { \n ID = " + id + " | \n Descripción = " + descripcion + " | \n Estado = " + estado + " | \n Fecha de Creacion = " + fechaDeCreacion + "| \n Tecnico = "+tecnico+" \n}";
            }else{
                return "TicketSoporte { \n ID = " + id + " | \n Descripción = " + descripcion + " | \n Estado = " + estado + " | \n Fecha de Creacion = " + fechaDeCreacion + "| \n Usuario = "+usuario+" \n Tecnico = "+tecnico+" \n}";
            }
        }
    }
}
