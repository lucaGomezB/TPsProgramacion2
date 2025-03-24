package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class SumaDeNumerosPares {
    public static void main(String[] args) {
        int numerosPares = 0;
        System.out.println("Porfavor ingrese números, o 0 para terminar.");
        numerosPares = sumaNumerosPares(numerosPares);
        System.out.println("La suma de todos los numeros pares ingresados es : "+numerosPares);
    }
    
    public static int sumaNumerosPares(int numerosPares){
        Scanner sc = new Scanner(System.in);
        int numeroIngresado = 1;
        while(numeroIngresado != 0){
            System.out.println("Ingrese un número entero:");
            numeroIngresado = CheckAnioBisiesto.obtenerNumeroEntero(sc);
            if((numeroIngresado % 2) == 0){
                numerosPares += numeroIngresado;
            }
        }
        return numerosPares;
    }
}
