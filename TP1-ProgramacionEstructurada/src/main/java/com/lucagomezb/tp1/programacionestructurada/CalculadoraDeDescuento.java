package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class CalculadoraDeDescuento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese un precio :");
        double precio = CheckAnioBisiesto.obtenerNumeroEntero(sc);
        System.out.println("Porfavor ingrese la categoría (A, B o C)");
        String categoria = sc.next();
        double descuento = categorizarDescuento(categoria, precio, sc);
        System.out.println("Precio original : "+precio);
        System.out.println("Precio con descuento : "+(precio-descuento));
    }
    public static double categorizarDescuento(String categoria,  double precio, Scanner sc){
        while(true){
            categoria = categoria.toUpperCase();
            switch (categoria){
                case "A" ->{
                    System.out.println("Corresponde un descuento del 10%");
                    return (precio * 0.10);
                }
                case "B" ->{
                    System.out.println("Corresponde un descuento del 15%");
                    return (precio * 0.15);
                }
                case "C" ->{
                    System.out.println("Corresponde un descuento del 20%");
                    return (precio * 0.20);
                }default ->{
                    System.out.println("Porfavor ingrese solo A, B o C.");
                    categoria = sc.next();
                }
            }   
        }
    }
}
