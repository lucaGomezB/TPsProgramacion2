package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class ListaPreciosRecursividad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arreglo = {199.99,299.5,149.75,399,89.99};
        int i = 0;
        System.out.println("El siguiente arreglo tiene estos índices y valores : ");
        mostrarArregloRecursivamente(arreglo,(arreglo.length-1));
        do{
            System.out.println("Porfavor seleccione un índice a manipular : ");
            i = CheckAnioBisiesto.obtenerNumeroEntero(sc);   
            if(i<0 && i>arreglo.length){
                System.out.println("No se puede seleccionar ese índice.");
            }
        }while(i<0 && i>arreglo.length);
        System.out.println("Porfavor ingrese el valor que desea asignarle a ese índice : ");
        arreglo[i] = CalculoPrecioFinalDeProducto.obtenerNumeroDouble(sc);
        mostrarArregloRecursivamente(arreglo,(arreglo.length-1));
    }
    public static void mostrarArregloRecursivamente(double[] arreglo, int i){
        if(i == 0){
            System.out.println("Indice = "+i+" | Contenido = "+arreglo[i]);
        }else{
            System.out.println("Indice = "+i+" | Contenido = "+arreglo[i]);
            mostrarArregloRecursivamente(arreglo,i-1);
        }
    }
}
