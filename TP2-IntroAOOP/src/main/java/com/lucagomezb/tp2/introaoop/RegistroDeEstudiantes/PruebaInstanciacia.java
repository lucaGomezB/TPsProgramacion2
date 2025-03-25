package com.lucagomezb.tp2.introaoop.RegistroDeEstudiantes;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class PruebaInstanciacia {
    public static void main(String[] args) {
        Estudiante estudiante =  new Estudiante("ABC","DEFG","A4",10);
        estudiante.mostrarInfo();
        estudiante.disminuirCalificacion();
        estudiante.aumentarCalificacion();
        estudiante.mostrarInfo();
    }
}
