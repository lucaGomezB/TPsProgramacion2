package com.lucagomezb.tp6.herencia;

/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public abstract class Empleado {
    public int numeroDeDNI;
    public String nombre;
    public String apellido;
    public int anioIngreso;

    public Empleado(int numeroDeDNI, String nombre, String apellido, int anioIngreso) {
        this.numeroDeDNI = numeroDeDNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioIngreso = anioIngreso;
    }

    @Override
    public String toString() {
        return "Empleado{ \n\t DNI : " + numeroDeDNI + "\n\t Nombre : " + nombre + "\n\t Apellido: " + apellido + "\n\t Año de ingreso : " + anioIngreso + "\n}";
    }
    
    
    
    public abstract double obtenerSalario();
}
