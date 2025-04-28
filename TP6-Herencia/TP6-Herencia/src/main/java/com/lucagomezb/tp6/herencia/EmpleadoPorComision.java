package com.lucagomezb.tp6.herencia;

/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class EmpleadoPorComision extends Empleado{
    private double salario;
    private double salarioMinimo = 200000;
    private int clientes;
    private double montoPorCliente;
    public EmpleadoPorComision(int numeroDeDNI,String nombre, String apellido,int anioIngreso, int clientes, double montoPorCliente) {
        super(numeroDeDNI,nombre,apellido,anioIngreso);
        this.clientes = clientes;
        this.montoPorCliente = montoPorCliente;
        this.salario = obtenerSalario();
    }

    public double getSalarioMinimo() {
        return salarioMinimo;
    }
    
    public int getClientes(){
        return clientes;
    }
    
    @Override
    public final double obtenerSalario(){
        double salarioObtenido = 0;
        if(clientes * montoPorCliente > salarioMinimo){
            salarioObtenido = clientes * montoPorCliente;
        }else{
            salarioObtenido = salarioMinimo;
        }
        return salarioObtenido;
    }
}
