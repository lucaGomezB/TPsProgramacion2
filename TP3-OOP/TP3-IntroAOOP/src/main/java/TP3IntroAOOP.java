
import java.util.Scanner;
import java.util.HashSet;
import java.util.InputMismatchException;
/**
 *
 * @author lucaGomezB
 */
public class TP3IntroAOOP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Empleado> empleados = new HashSet<>();
        Empleado empleado1 = new Empleado(357,"Magnum José","Sheriff",345000);
        empleados.add(empleado1);
        Empleado empleado2 = new Empleado("Giancarlo Petunias","Caballo del sheriff");
        empleados.add(empleado2);
        System.out.println("Porfavor ingrese el nombre del nuevo empleado :");
        String nombre = sc.nextLine();
        System.out.println("Porfavor ingrese el puesto del nuevo empleado : ");
        String puesto = sc.nextLine();
        Empleado empleado3 = new Empleado(nombre,puesto);
        empleados.add(empleado3);
        mostrarCantidadEmpleados(empleados);
        System.out.println("Porfavor ingrese el porcentaje a aumentar respecto al sueldo del empleado "+empleado2.getNombre()+". No es necesario poner %.");
        empleado2.actualizarSalario(ingresarEntero(sc));
        System.out.println("Porfavor ingrese la cantidad a aumentar respecto al salario del empleado "+empleado3.getNombre()+".");
        empleado3.actualizarSalario(ingresarDouble(sc));
        mostrarCantidadEmpleados(empleados);
        System.out.println("La cantidad total de empleados creados es : "+Empleado.getTotalEmpleados());
    }
    
    public static void mostrarCantidadEmpleados(HashSet<Empleado> empleados){
        for(Empleado empleado : empleados){
            System.out.println(empleado);
        }
    }
    
    public static int ingresarEntero(Scanner sc){
        int entero = 0;
        while(true){
            try{
                entero = sc.nextInt();
                return entero;
            }catch(InputMismatchException e){
                System.out.println("Porfavor ingrese solo números enteros.");
            }
            sc.next();
        }
    }
    
    public static double ingresarDouble(Scanner sc){
        double doble = 0;
        while(true){
            try{
                doble = sc.nextDouble();
                return doble;
            }catch(InputMismatchException e){
                System.out.println("Porfavor ingrese solo números del tipo double.");
            }
            sc.next();
        }
    }
}
