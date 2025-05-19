package ManejoDeExcepciones;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class LecturaDeArchivo {
    private static final String NOMBRE_POR_DEFECTO = "archivoDePrueba.txt";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "";
        System.out.println("Ingrese el nombre de un archivo para mostrarlo (También puede presionar ENTER para usar "+NOMBRE_POR_DEFECTO+" )");
        nombreArchivo = sc.nextLine();
        if(nombreArchivo.trim().isEmpty()){
            nombreArchivo = NOMBRE_POR_DEFECTO;
        }
        leerArchivo(nombreArchivo);
        sc.close();
    }
    
    public static void leerArchivo(String nombreArchivo){
        System.out.println("Intentando leer el archivo "+nombreArchivo+" ...");
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) { // Acá está con try-with-resources de una porque sino me confundía.
            String linea;
            System.out.println("\n--- Contenido de '" + nombreArchivo + "' ---");
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("--- Fin del contenido ---");
        } catch (FileNotFoundException e) {
            System.err.println("\nExcepción: El archivo '" + nombreArchivo + "' no fue encontrado.");
            System.err.println("Asegúrese de que el archivo exista en el mismo directorio del programa.");
        } catch (IOException e) {
            System.err.println("\nExcepción de lectura: Ocurrió un problema al leer el archivo '" + nombreArchivo + "'.");
            System.err.println("Detalles: " + e.getMessage());
        }
    }
}
