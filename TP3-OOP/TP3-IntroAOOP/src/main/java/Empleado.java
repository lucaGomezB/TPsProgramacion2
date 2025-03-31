
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
    
    
    
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        ids.add(id);
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
        System.out.println("Se ha creado un nuevo empleado");
    }
    
    public Empleado(String nombre, String puesto) {
        asignarIDAlAzar(); 
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 200000.00;
        totalEmpleados++;
        System.out.println("Se ha creado un nuevo empleado");
    }
    
    public static HashSet<Integer> getIds() {
        return ids;
    }

    public static int getTotalEmpleados() {
        return totalEmpleados;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void actualizarSalario(int porcentajeAumento){
        setSalario((getSalario() + (getSalario() * (porcentajeAumento * 0.01))));
        System.out.println("El salario ha sido actualizado el "+porcentajeAumento+" %");
    }
    
    public void actualizarSalario(double cantidadFijaAumento){
        setSalario((getSalario() + cantidadFijaAumento));
    }
    
    private void asignarIDAlAzar(){
        Random rand = new Random();
        int idAzar = rand.nextInt(getTotalEmpleados(), 1000) + 1;
        while(true){
            if(getIds().contains(idAzar)){
                id = rand.nextInt(getTotalEmpleados(), 1000) + 1;
            }else{
                this.id = idAzar;
                break;
            }
        }
    }
    
    public static int mostrarTotalEmpleados(){
        return getTotalEmpleados();
    } 

    @Override
    public String toString() {
        return "Empleado{ " + "id = " + id + " | nombre = " + nombre + " | puesto = " + puesto + " | salario = " + salario + '}';
    }
    
    
}
