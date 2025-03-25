package EstadoEIDentidadObjetos;
import java.util.Scanner;

/**
 *
 * @author lucaGomezB
 */
public class Gallina {
    public String idGallina;
    public int edad;
    public int huevosPuestos;

    public Gallina(String idGallina, int edad, int huevosPuestos) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = huevosPuestos;
    }
    
    public void ponerHuevo(){
        this.huevosPuestos++;
    }
    
    public void envejecer(){
        this.edad++;
    }
    
    public void mostrarEstado(){
        System.out.println(this.idGallina+" | "+this.edad+" | "+this.huevosPuestos);
    }
    public static int obtenerNumeroEntero(Scanner sc){
        do{
            try{
                int anio = sc.nextInt();
                return anio;
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Porfavor ingrese solo números enteros.");
            }
        }while (true);
    }
}
