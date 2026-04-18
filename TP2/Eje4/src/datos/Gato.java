package datos;

/**
 * Alumno: Rojas Ulises Martin
 */
public class Gato extends Animal{

    public Gato(int id) {
        super(id);
    }
    
    @Override
    public String hacerRuido(){
        return "Miau";
    }
    
    @Override
    public String moverse(){
        return "Camina en modo gato";
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.print("Ruido: " + hacerRuido() + "\nMovimiento: " + moverse() + "\n");
    }
}
