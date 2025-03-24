package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class ContadorDeTiposDeNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contadorNegativos = 0;
        int contadorPositivos = 0;
        int contadorCeros = 0;
        int numeroIngresado = 0;
        System.out.println("A continuación, ingresará 10 números por pantalla.");
        for (int i = 0; i < 10; i++) {
            System.out.println("Porfavor ingrese un número:");
            numeroIngresado = CheckAnioBisiesto.obtenerNumeroEntero(sc);
            if(numeroIngresado == 0){
                contadorCeros++;
            }else if(numeroIngresado > 0){
                contadorPositivos++;
            }else if(numeroIngresado < 0){
                contadorNegativos++;
            }
        }
        System.out.println("Números positivos ingresados :"+contadorPositivos);
        System.out.println("Números negativos ingresados :"+contadorNegativos);
        System.out.println("Ceros ingresados :"+contadorCeros);
    }
}
