package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class GestionDeProductos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese el stock actual : ");
        int stockActual = CheckAnioBisiesto.obtenerNumeroEntero(sc);
        System.out.println("Porfavor ingrese la cantidad vendida : ");
        int cantidadVendida = CheckAnioBisiesto.obtenerNumeroEntero(sc);
        System.out.println("Porfavor ingrese la cantidad recibida : ");
        int cantidadRecibida = CheckAnioBisiesto.obtenerNumeroEntero(sc);
        stockActual = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);
        System.out.println("Stock actual : "+stockActual);
    }
    
    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida){
        int nuevoStock = (stockActual - cantidadVendida + cantidadRecibida);
        return nuevoStock;
    } 
}
