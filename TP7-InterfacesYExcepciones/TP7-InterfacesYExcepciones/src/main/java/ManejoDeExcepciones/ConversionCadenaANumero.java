package ManejoDeExcepciones;
import java.util.Scanner;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class ConversionCadenaANumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese una cadena : ");
        String cadena = sc.nextLine();
        intentarConvertirAEntero(cadena);
        sc.close();
    }
    public static void intentarConvertirAEntero(String cadena) throws NumberFormatException{
        try{
            System.out.println("Su string convertido a número entero es : "+Integer.valueOf(cadena));
        }catch(NumberFormatException e){
            System.out.println("Su String no se ha podido convertir a entero.");
        }
    }
}
