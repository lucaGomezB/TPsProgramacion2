package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class CalculoDescuentoEspecial {
    public static double DESCUENTO_ESPECIAL = 0.10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese el precio :");
        double precio = CalculoPrecioFinalDeProducto.obtenerNumeroDouble(sc);
        calcularDescuentoEspecial(precio);
    }
    
    public static void calcularDescuentoEspecial(double precio){
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        System.out.println("El descuento especial aplicado es : "+descuentoAplicado);
        System.out.println("El precio final con descuento es : "+(precio-descuentoAplicado));
    }
}
