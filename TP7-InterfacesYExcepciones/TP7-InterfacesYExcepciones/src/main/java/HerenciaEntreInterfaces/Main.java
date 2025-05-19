package HerenciaEntreInterfaces;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class Main {
    public static void main(String[] args) {
        TarjetaCredito tarjeta1 = new TarjetaCredito("AS1231");
        PayPal paypal1 = new PayPal("PepitoCOmeteFraude@disposable.com");
        tarjeta1.aplicarDescuento(123);
        tarjeta1.procesarPago(0);
        paypal1.aplicarDescuento(0);
        paypal1.procesarPago(0);
    }
    
}
