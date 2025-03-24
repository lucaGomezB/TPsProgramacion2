package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class ValidacionDeEntrada {
    public static void main(String[] args) {
        int nota = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese una nota entre 0 y 10.");
        do{
            nota = CheckAnioBisiesto.obtenerNumeroEntero(sc);
            if(((nota >= 0) && (nota <= 10))){
                System.out.println("Nota guardada exitosamente.");
            }else{
                System.out.println("Nota inválida. Tiene que estar entre 0 y 10.");
            }
        }while(((nota < 0) || (nota > 10)));
    }
}
