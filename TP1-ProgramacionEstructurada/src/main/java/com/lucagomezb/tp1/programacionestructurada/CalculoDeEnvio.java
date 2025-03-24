package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class CalculoDeEnvio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double costoEnvio = 0;
        System.out.println("Porfavor ingrese el precio del producto : ");
        double precioProducto = CalculoPrecioFinalDeProducto.obtenerNumeroDouble(sc);
        System.out.println("Porfavor ingrese el peso del paquete en kilos : ");
        double peso = CalculoPrecioFinalDeProducto.obtenerNumeroDouble(sc);
        String zona;
        do{
            System.out.println("Porfavor ingrese la zona del envio (Nacional o Internacional) : ");
            zona = sc.next();
            costoEnvio = calcularCostoEnvio(peso,zona,costoEnvio);
        }while(costoEnvio == 0);
        System.out.println("El costo del envío es : "+costoEnvio);
        System.out.println("El costo total de su compra es : "+calcularTotalCompra(precioProducto, costoEnvio));
    }
    
    public static double calcularCostoEnvio(double peso, String zona, double costoEnvio){
        if(zona.equalsIgnoreCase("Nacional")){
            costoEnvio = 5 * peso;
            return costoEnvio;
        }else if(zona.equalsIgnoreCase("Internacional")){
            costoEnvio = 10 * peso;
            return costoEnvio;
        }else{
            System.out.println("Porfavor ingrese solo {Nacional} o {Internacional}");
            return 0;
        }
    }
    public static double calcularTotalCompra(double precioProducto, double costoEnvio){
        return precioProducto + costoEnvio;
    }
}
