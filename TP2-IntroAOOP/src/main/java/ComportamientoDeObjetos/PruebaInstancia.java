package ComportamientoDeObjetos;
import EstadoEIDentidadObjetos.Gallina;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class PruebaInstancia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int combustible = 0;
        boolean condicionSalida = true;
        System.out.println("A continuación generará una nave espacial :");
        System.out.println("Porfavor ingrese un nombre :");
        String nombre = sc.nextLine();
        do{
            System.out.println("Porfavor ingrese la cantidad de combustible disponible : ");
            combustible = Gallina.obtenerNumeroEntero(sc);    
            if(combustible > 100){
                System.out.println("El límite de combustible es 100.");
            }
        }while(combustible > 100);
        NaveEspacial naveEspacial = new NaveEspacial(nombre,combustible);
        while(condicionSalida){
            System.out.println("Elija una opción:");
            System.out.println(" 1. Despegar \n 2. Avanzar \n 3. Recargar Combustible \n 4. Mostrar Estado \n 0. Salir");
            opcion = Gallina.obtenerNumeroEntero(sc);
           switch(opcion){
               case 1 ->{
                   naveEspacial.despegar();
               }
               case 2 ->{
                   System.out.println("Porfavor ingrese la cantidad a avanzar :");
                   opcion = Gallina.obtenerNumeroEntero(sc);
                   naveEspacial.avanzar(opcion);
               }
               case 3 ->{
                   System.out.println("Porfavor ingrese la cantidad a recargar :");
                   opcion = Gallina.obtenerNumeroEntero(sc);
                   naveEspacial.recargarCombustible(opcion);
               }
               case 4 ->{
                   naveEspacial.mostrarEstado();
               }
               case 0 ->{
                   System.out.println("Que tenga un buen día!");
                   condicionSalida = false;
               }
           }
        }
    }
}
