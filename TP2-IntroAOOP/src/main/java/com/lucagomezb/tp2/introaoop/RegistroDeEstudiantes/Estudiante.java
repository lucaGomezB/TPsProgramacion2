package com.lucagomezb.tp2.introaoop.RegistroDeEstudiantes;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class Estudiante {
    public String nombre;
    public String apellido;
    public String curso;
    public double calificacion;
    
    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }
    
    public void mostrarInfo(){
        System.out.println(this.apellido+" | "+this.nombre+" | "+this.curso+" | "+this.calificacion);
    }
    
    public void aumentarCalificacion(){
        Scanner sc = new Scanner(System.in);
        double cantidadAumentada = 0;
        if(this.calificacion == 10){
            System.out.println("La calificación de este alumno no se puede aumentar.");
        }else{
            while(true){
                System.out.println("Porfavor ingrese la cantidad a aumentar respecto a la calificación del estudiante (actual : "+this.calificacion+"), no puede ser superior a 10");
                cantidadAumentada = obtenerNumeroDouble(sc);
                if((this.calificacion+cantidadAumentada > 10)){
                    System.out.println("Porfavor ingrese un número menor para aumentar la calificación actual.");
                }else{
                    this.calificacion = this.calificacion+cantidadAumentada;
                    break;
                }    
            }
        }
    }
    
    public void disminuirCalificacion(){
        Scanner sc = new Scanner(System.in);
        double cantidadDisminuida = 0;
        if(this.calificacion == 0){
            System.out.println("La calificación de este alumno no se puede disminuir.");
        }else{
            while(true){
                System.out.println("Porfavor ingrese la cantidad a disminuir respecto a la calificación del estudiante (actual : "+this.calificacion+"), no puede ser inferior a 0");
                cantidadDisminuida = obtenerNumeroDouble(sc);
                if((this.calificacion-cantidadDisminuida < 0)){
                    System.out.println("Porfavor ingrese un número menor para disminuir la calificación actual.");
                }else{
                    this.calificacion = this.calificacion-cantidadDisminuida;
                    break;
                }    
            }
        }
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
