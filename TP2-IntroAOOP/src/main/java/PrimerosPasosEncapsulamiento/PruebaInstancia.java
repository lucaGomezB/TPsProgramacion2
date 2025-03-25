package PrimerosPasosEncapsulamiento;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB
 */
public class PruebaInstancia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Libro libro = new Libro("Titulo","Autor",1985);
        System.out.println(libro.getTitulo()+" | "+libro.getAutor()+" | "+libro.getAnioPublicacion());
        System.out.println("Está apunto de cambiar el año de publicacion del libro : ");
        int nuevoAnio = Libro.obtenerNumeroEntero(sc);
        libro.setAnioPublicacion(nuevoAnio);
        System.out.println(libro.getTitulo()+" | "+libro.getAutor()+" | "+libro.getAnioPublicacion());
    }
}
