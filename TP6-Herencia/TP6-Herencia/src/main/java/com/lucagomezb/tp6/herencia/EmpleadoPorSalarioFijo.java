package com.lucagomezb.tp6.herencia;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class EmpleadoPorSalarioFijo extends Empleado{
    private double salarioBasico = 200000;
    public EmpleadoPorSalarioFijo(int numeroDeDNI,String nombre, String apellido,int anioIngreso){
        super(numeroDeDNI,nombre,apellido,anioIngreso);
        salarioBasico = obtenerSalario();
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }
    
    @Override
    public final double obtenerSalario(){
        double salario = 0;
        int anioActual = 2025; //Acá podría haber implementado la lógica para manejar dates.
        int antiguedad = anioActual-anioIngreso;
        if(antiguedad >= 2 && antiguedad <= 5){
            salario = salarioBasico + salarioBasico*0.05; 
        }else if(antiguedad > 5){
            salario = salarioBasico + salarioBasico*0.10;
        }
        return salario;
    }
}
