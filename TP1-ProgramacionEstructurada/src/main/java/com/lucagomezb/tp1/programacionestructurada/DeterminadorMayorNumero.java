package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class DeterminadorMayorNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[3];
        numeros = ingresoNumeros(sc,numeros);
        averiguadorNumeroMasGrande(numeros);
    }
    public static int[] ingresoNumeros(Scanner sc, int[] numeros){
        for(int i = 0 ; i < numeros.length ; i++){
            System.out.println("Porfavor ingrese un número entero");
            numeros[i] = CheckAnioBisiesto.obtenerNumeroEntero(sc); //Estoy reutilizando el try-catch que obtiene números enteros.
        }
        return numeros;
    }
    public static void averiguadorNumeroMasGrande(int[] numeros){
        int numeroMasGrande = numeros[0];
        for(int i = 1 ; i < numeros.length ; i++){
            if(numeros[i] > numeroMasGrande){
                numeroMasGrande = numeros[i];
            }
        }
        System.out.println("El número más grande ingresado es : "+numeroMasGrande);
    }
}
