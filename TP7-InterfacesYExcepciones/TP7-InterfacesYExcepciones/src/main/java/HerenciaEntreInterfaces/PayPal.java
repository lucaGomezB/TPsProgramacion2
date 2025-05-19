package HerenciaEntreInterfaces;

/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class PayPal implements PagoConDescuento{
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        System.out.println("Aplicando descuento con PayPal...");
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago");
    }
    
    
}
