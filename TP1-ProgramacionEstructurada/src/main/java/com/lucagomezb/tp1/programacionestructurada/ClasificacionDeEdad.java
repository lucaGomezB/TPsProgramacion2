package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author LucaGomezB
 */
public class ClasificacionDeEdad {
    public static void main(String[] args) {
        /**
         * prueba prueba
         * La clase obtiene una edad e imprime un mensaje por pantalla correspondiente a una consigna
         */
        Scanner sc = new Scanner(System.in);
        int edad = 0;
        while(edad <= 0){
            System.out.println("Porfavor ingrese una edad");
            edad = CheckAnioBisiesto.obtenerNumeroEntero(sc);
        }
        determinadorEdad(edad);
    }
    
    public static void determinadorEdad(int edad){
        /**
         * Con <code> edad </code> se imprime por pantalla un mensaje correspondiente a la consigna.
         */
        if(edad < 12){
            System.out.println("Niño.");
        }else if((edad >= 12) && (edad <= 17)){
            System.out.println("Adolescente.");
        }else if((edad >= 18) && (edad <= 59)){
            System.out.println("Adulto.");
        }else if(edad >= 60){
            System.out.println("Adulto mayor.");
        }
    }
}
