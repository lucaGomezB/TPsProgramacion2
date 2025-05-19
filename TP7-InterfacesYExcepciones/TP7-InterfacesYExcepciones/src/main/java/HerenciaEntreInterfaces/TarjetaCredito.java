package HerenciaEntreInterfaces;

/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public class TarjetaCredito implements PagoConDescuento{
    private String numeroTarjeta;

    public TarjetaCredito(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        System.out.println("Aplidcando descuento con tarjeta");
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago");
    }
}
