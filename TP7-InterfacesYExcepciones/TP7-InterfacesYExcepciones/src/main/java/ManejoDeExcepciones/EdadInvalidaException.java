package ManejoDeExcepciones;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class EdadInvalidaException extends Exception {
    // Constructor que acepta un mensaje de error
    public EdadInvalidaException(String message) {
        super(message);
    }

    // Constructor que acepta un mensaje y una causa (otra excepción)
    public EdadInvalidaException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
}
