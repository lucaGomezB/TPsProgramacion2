package PrimerosPasosEncapsulamiento;
import java.time.Year;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    
    public void setAnioPublicacion(int nuevoAnio){
        Year currentYear = Year.now();
        Scanner sc = new Scanner(System.in);
        int anioActual = currentYear.getValue();
        do{
            if(((1900 > nuevoAnio) || (nuevoAnio > anioActual))){
                System.out.println("Porfavor asegurese de escribir un año superior a 1900 e inferior o igual al año actual.");
                nuevoAnio = obtenerNumeroEntero(sc);
            }else{
                this.anioPublicacion = nuevoAnio;        
                break;
            }       
        }while(true);
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
