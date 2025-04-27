package com.mycompany.tp4.uml;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class SistemaSoporte {
    private List<TicketSoporte> tickets;
    
    public SistemaSoporte(){
        this.tickets = new ArrayList();
    }
    
    public void agregarTicket(TicketSoporte ticket){
        this.tickets.add(ticket);
    }
    
    public void asignarTecnicoATicket(Tecnico tecnico){
        Scanner sc = new Scanner(System.in);
        Boolean idEncontrado = true;
        String idABuscar = "";
        do{
            System.out.println("Porfavor ingrese un id de ticket para agregarle un técnico.");
            idABuscar = sc.next();
            for(TicketSoporte ticket : this.tickets){
                if(idABuscar.equals(ticket.getId())){
                    idEncontrado = false;
                    ticket.setTecnico(tecnico);
                    tecnico.trabajarEnTicket(ticket);
                }
            }
        }while(idEncontrado);
        System.out.println("Tecnico agregado exitosamente.");
    }
    
    public void mostrarTickets(){
        System.out.println("A continuación, se mostrarán todos los tickets : ");
        for(TicketSoporte ticket : this.tickets){
            System.out.println(ticket);
            System.out.println("");
        }
        System.out.println("-----------------------------------------------");
    }

    @Override
    public String toString() {
        return "SistemaSoporte{" + "tickets=" + tickets + '}';
    }
    
}
