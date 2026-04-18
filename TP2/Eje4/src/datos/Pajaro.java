package datos;

/**
 * Alumno: Rojas Ulises Martin
 */
public class Pajaro extends Animal{

    public Pajaro(int id) {
        super(id);
    }
    
    @Override
    public String hacerRuido(){
        return "Chirp";
    }
    
    @Override
    public String moverse(){
        return "Camina en modo pajaro";
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.print("Ruido: " + hacerRuido() + "\nMovimiento: " + moverse() + "\n");
    }
}
