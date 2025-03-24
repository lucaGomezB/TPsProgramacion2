package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class CalculoPrecioFinalDeProducto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese el precio base : ");
        double precioBase = obtenerNumeroDouble(sc);
        System.out.println("Porfavor ingrese el impuesto : ");
        double impuesto = obtenerNumeroDouble(sc);
        System.out.println("Porfavor ingrese el descuento : ");
        double descuento = obtenerNumeroDouble(sc);
        System.out.println("El precio final es "+calcularPrecioFinal(precioBase,impuesto,descuento));
    }
    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento){
        double precioFinal = (precioBase + (precioBase*impuesto)-(precioBase*descuento));
        return precioFinal;
    }
    public static double obtenerNumeroDouble(Scanner sc){
        do{
            try{
                double anio = sc.nextDouble();
                return anio;
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Porfavor ingrese solo números.");
            }
        }while (true);
    }
}
