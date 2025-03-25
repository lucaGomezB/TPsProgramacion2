package RegistroDeMascotas;
/**
 *
 * @author lucaGomezB
 */
public class PruebaInstancia {
    public static void main(String[] args) {
        Mascota mascota = new Mascota("Jose","Quiltro",13);
        mascota.mostrarInfo();
        mascota.cumplirAnio();
        mascota.mostrarInfo();
    }
}
