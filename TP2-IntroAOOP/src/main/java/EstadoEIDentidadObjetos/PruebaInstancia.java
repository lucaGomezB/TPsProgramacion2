package EstadoEIDentidadObjetos;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class PruebaInstancia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gallina gallina1 = rellenarInfoGallina(sc);
        gallina1.mostrarEstado();
        Gallina gallina2 = rellenarInfoGallina(sc);
        gallina2.mostrarEstado();
        System.out.println("Pasó 1 año...");
        gallina1.envejecer();
        gallina1.mostrarEstado();
        gallina2.envejecer();
        gallina2.mostrarEstado();
    }
    
    public static Gallina rellenarInfoGallina(Scanner sc){
        int huevosPuestos = 0;
        System.out.println("A continuación, rellene los atributos de Gallina correspondientes : ");
        System.out.println("Porfavor ingrese el ID de la gallina : ");
        String idGallina = sc.next();
        System.out.println("Porfavor ingrese la edad de la gallina : ");
        int edad = Gallina.obtenerNumeroEntero(sc);
        do{
            System.out.println("Porfavor ingrese la cantidad de huevos puestos : ");
            huevosPuestos = Gallina.obtenerNumeroEntero(sc);
        }while(huevosPuestos < 1);
        Gallina gallinaRellenada = new Gallina(idGallina, edad, huevosPuestos);
        return gallinaRellenada;
    }
}
