package com.lucagomezb.tp3.introaoop;
import java.util.HashSet;
import java.util.Random;
/**
 *
 * @author lucaGomezB
 */
public class Empleado {
    private static int totalEmpleados = 0;
    private static HashSet<Integer> ids = new HashSet<>();
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    public static HashSet<Integer> getIds() {
        return ids;
    }

    public static int getTotalEmpleados() {
        return totalEmpleados;
    }
    
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        ids.add(id);
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        asignarIDAlAzar(); 
        this.nombre = nombre;
        this.puesto = puesto;
        totalEmpleados++;
        this.salario = 200000.00;
    }
    
    private void asignarIDAlAzar(){
        Random rand = new Random();
        int id = rand.nextInt(getTotalEmpleados());
        while(true){
            if(getIds().contains(id)){
                id = rand.nextInt(getTotalEmpleados());
            }else{
                this.id = id;
            }
        }
    }
}
