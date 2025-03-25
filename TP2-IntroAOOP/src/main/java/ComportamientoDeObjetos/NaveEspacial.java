package ComportamientoDeObjetos;

/**
 *
 * @author lucaGomezB
 */
public class NaveEspacial {
    public String nombre;
    public int combustible;

    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
    }
    
    public void despegar(){
        if(((this.combustible - 10) < 10)){
            System.out.println(this.nombre+" no puede despegar, falta combustible.");
        }else{
            System.out.println(this.nombre+" acaba de despegar!");
            this.combustible = this.combustible - 10;
        }
    }
    
    public void avanzar(int distancia){
        if(((this.combustible - distancia) <= 0)){
            System.out.println("No puede avanzar, por cada unidad de distancia se resta una de combustible.");
        }else{
            System.out.println("Ha avanzado "+distancia);
            this.combustible = this.combustible - distancia;
        }
    }
    
    public void recargarCombustible(int cantidad){
        if(((this.combustible + cantidad) > 100)){
            System.out.println("No puede agregar "+cantidad+" porque la capacidad máxima es 100.");
        }
    }
    
    public void mostrarEstado(){
        System.out.println(this.nombre+" | "+this.combustible);
    }
}
