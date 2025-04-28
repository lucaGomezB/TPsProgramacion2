package com.lucagomezb.tp6.herencia;

/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class TP6HerenciaImplementacion {
    public static void main(String[] args) {
        AdministracionDePersonal administracion = new AdministracionDePersonal();
        administracion.agregarEmpleado(new EmpleadoPorSalarioFijo(435345,"Asjde", "Strom", 2009));
        administracion.agregarEmpleado(new EmpleadoPorSalarioFijo(543533,"Sdrille", "Krvuza", 2015));
        administracion.agregarEmpleado(new EmpleadoPorComision(342422,"Juan", "Pérez", 2024,10,4000));
        administracion.agregarEmpleado(new EmpleadoPorComision(432442,"Mus", "Hunter", 2021,45,4500));
        EmpleadoPorComision empleadoConMasClientes = (EmpleadoPorComision) administracion.empleadoConMasClientes();
        System.out.println("El empleado con más clientes conseguidos este mes : \n"+empleadoConMasClientes+"\n Clientes : "+empleadoConMasClientes.getClientes());
        administracion.mostrarSalarios();
    }
}
