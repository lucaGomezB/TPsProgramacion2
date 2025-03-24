package com.lucagomezb.tp1.programacionestructurada;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class CheckAnioBisiesto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("Porfavor ingrese un año : ");
            int anio = obtenerNumeroEntero(sc);
            determinarBisiesto(anio);
    }
    
    public static int obtenerNumeroEntero(Scanner sc){
        do{
            try{
                int anio = sc.nextInt();
                return anio;
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Porfavor ingrese solo números enteros.");
            }
        }while (true);
    }
    
    public static void determinarBisiesto(int anio){
        if(((anio % 4) == 0) && ((anio % 100) != 0)){
            System.out.println("Su año es bisiesto");
        }else{
            if(((anio % 400) == 0)){
                System.out.println("Su año es bisiesto.");
            }else{
                System.out.println("Su año no es bisiesto.");
            }
        }
    }
}
