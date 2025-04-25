package com.mycompany.tp4.uml;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class TP4UML {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        SistemaSoporte sistemaSoporte = new SistemaSoporte();
        sistemaSoporte.agregarTicket(new TicketSoporte(reportarError(sc)));
        System.out.println("");
        Usuario usuario1 = new Usuario("abc123","Pepe","hrit@jotun.com");
        sistemaSoporte.agregarTicket(new TicketSoporte(reportarError(sc),usuario1));
        System.out.println("");
        Tecnico tecnico1 = new Tecnico("jdc432","Morrón","Hotfixes");
        sistemaSoporte.mostrarTickets();
        System.out.println("Escriba cualquier cosa para continuar.");
        sc.next();
        sistemaSoporte.asignarTecnicoATicket(tecnico1);
        sistemaSoporte.mostrarTickets();
    }
    public static String reportarError(Scanner sc){
        System.out.println("Uy! Ha ocurrido un error, voy a generar un ticket.");
        System.out.println("Porfavor reporte el error:");
        String error = sc.nextLine();
        return error;
    }
}
