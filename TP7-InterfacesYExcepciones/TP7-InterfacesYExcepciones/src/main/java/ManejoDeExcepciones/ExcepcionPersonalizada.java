package ManejoDeExcepciones;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class ExcepcionPersonalizada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad = -1;
        do{
            System.out.println("Porfavor ingrese una edad entre 0 y 120.");
            try{
               edad = sc.nextInt();
               validarEdad(edad);
               System.out.println("La edad fué ingresada correctamente.");
            }catch(InputMismatchException e){
               System.out.println("Excepción : Porfavor ingrese un número entero para la edad.");
               sc.next();// De vuelta hay que limpiar el Scanner porque se quedó con algo que no sirve.
            }catch(EdadInvalidaException e){
               System.out.println("Excepción de validación : "+e.getMessage());
            }
        }while(edad > 120 || edad < 0);
        sc.close();
    }
    
    public static void validarEdad(int edad) throws EdadInvalidaException{
        if(edad < 0){
            throw new EdadInvalidaException("La edad ingresada no puede ser inferior a 0.");
        }else if(edad > 120){
            throw new EdadInvalidaException("La edad ingresada no puede ser superior a 120.");
        }
    }
}
