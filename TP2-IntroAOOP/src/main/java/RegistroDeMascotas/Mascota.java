package RegistroDeMascotas;
/**
 *
 * @author lucaGomezB
 */
public class Mascota {
    String nombre;
    String especie;
    int edad;

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    
    public void mostrarInfo(){
        System.out.println(this.nombre+" | "+this.especie+" | "+this.edad);
    }
    
    public void cumplirAnio(){
        this.edad++;
    }
}
