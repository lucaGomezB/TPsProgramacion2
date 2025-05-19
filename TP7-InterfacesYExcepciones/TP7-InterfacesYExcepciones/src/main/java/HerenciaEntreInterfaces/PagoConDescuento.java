package HerenciaEntreInterfaces;
/**
 *
 * @author lucaGomezB <lucaGomezB at https://lucagomezb.github.io/Luca-Gomez/>
 */
public interface PagoConDescuento extends Pago{
    public void aplicarDescuento(double porcentaje);
}
