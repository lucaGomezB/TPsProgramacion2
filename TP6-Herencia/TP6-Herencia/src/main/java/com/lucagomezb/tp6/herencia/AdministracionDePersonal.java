package com.lucagomezb.tp6.herencia;
import java.util.ArrayList;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class AdministracionDePersonal {
    private ArrayList<Empleado> empleados;

    public AdministracionDePersonal() {
        this.empleados = new ArrayList<>();
    }
    
    public void mostrarSalarios(){
        System.out.println("Tenemos a estos empleados : ");
        for(Empleado empleado : empleados){
            System.out.println("\t"+empleado.nombre+" "+empleado.apellido+" : $"+empleado.obtenerSalario());
        }
    }
    
    public Empleado empleadoConMasClientes(){
        int i = 0;
        if(obtenerElPrimerEmpleadoPorComision() == null){
            return null;
        }
        EmpleadoPorComision empleadoConMasClientes = obtenerElPrimerEmpleadoPorComision();
        EmpleadoPorComision empleadoComodin = null;
        while(i < empleados.size()){
            if(empleados.get(i) instanceof EmpleadoPorComision empleadoPorComision){
                empleadoComodin = empleadoPorComision;
                if(empleadoComodin.getClientes() > empleadoConMasClientes.getClientes()){
                    empleadoConMasClientes = empleadoComodin;
                }
            }
            i++;
        }
        return empleadoConMasClientes;
    }
    
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }
    public void removerEmpleado(Empleado empleado){
        empleados.remove(empleado);
    }
    public Empleado getEmpleado(String nombre, String apellido){
        int i = 0;
        while(i < empleados.size()){
            if(empleados.get(i).nombre.equalsIgnoreCase(nombre) && empleados.get(i).apellido.equalsIgnoreCase(apellido)){
                return empleados.get(i);
            }
            i++;
        }
        System.out.println("No se pudo encontrar el empleado deseado, porfavor verifique que no haya cometido errores de sintáxis.");
        return null;
    }
    
    public EmpleadoPorComision obtenerElPrimerEmpleadoPorComision(){
        int i = 0;
        while(i < empleados.size()){
            if(empleados.get(i) instanceof EmpleadoPorComision empleadoPorComision){
                return empleadoPorComision;
            }
            i++;
        }
        System.out.println("No se han podido encontrar empleados que trabajen por comisión.");
        return null;
    }
}
