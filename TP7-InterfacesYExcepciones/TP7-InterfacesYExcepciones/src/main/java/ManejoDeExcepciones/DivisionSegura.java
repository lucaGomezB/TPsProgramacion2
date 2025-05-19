package ManejoDeExcepciones;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class DivisionSegura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = obtenerNumeroEntero(sc);
        int n2 = obtenerNumeroEntero(sc);
        if(n1 == 0){
            System.out.println("0 dividido por cualquier número es 0.");
        }else{
             obtenerDivision(n1,n2);
        }
        sc.close();
    }
    
    public static int obtenerNumeroEntero(Scanner sc) throws InputMismatchException{
        boolean validInput = false;
        int numero = 0;
        while (!validInput) {
            System.out.print("Por favor, ingrese un número entero: ");
            try {
                numero = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese solo números enteros.");
                sc.next(); //Acá tengo que poner esto para que no se trabe el Scanner
            }
        }
        return numero;
    }
    
    public static void obtenerDivision(int n1, int n2) throws ArithmeticException{
        try {
            int resultado = n1 / n2;
            System.out.println("El resultado de la división de " + n1 + " entre " + n2 + " es: " + resultado + " (redondeado)");
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero. " + e.getMessage());
        }
    }
}