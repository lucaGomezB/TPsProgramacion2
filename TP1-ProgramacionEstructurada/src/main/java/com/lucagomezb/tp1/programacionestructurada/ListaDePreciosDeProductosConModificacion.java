package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class ListaDePreciosDeProductosConModificacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arreglo = {199.99,299.5,149.75,399,89.99};
        int i = 0;
        mostrarArray(arreglo);
        do{
            System.out.println("Porfavor seleccione un índice a manipular : ");
            i = CheckAnioBisiesto.obtenerNumeroEntero(sc);   
            if(i<0 && i>arreglo.length){
                System.out.println("No se puede seleccionar ese índice.");
            }
        }while(i<0 && i>arreglo.length);
        System.out.println("Porfavor ingrese el valor que desea asignarle a ese índice : ");
        arreglo[i] = CalculoPrecioFinalDeProducto.obtenerNumeroDouble(sc);
        mostrarArray(arreglo);
    }
    public static void mostrarArray(double[] arreglo){
        int i = 0;
        System.out.println("A continuación, se muestra el array, con sus ínidices y contenido: ");
        for (double d : arreglo) {
            System.out.println("Indice "+i+" = "+d);
            i++;
        }
    }
}
