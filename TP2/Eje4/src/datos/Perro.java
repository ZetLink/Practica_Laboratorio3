package datos;

/**
 * Alumno: Rojas Ulises Martin
 */
public class Perro extends Animal{

    public Perro(int id) {
        super(id);
    }
    
    @Override
    public String hacerRuido(){
        return "Woof";
    }
    
    @Override
    public String moverse(){
        return "Camina en modo perro";
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.print("Ruido: " + hacerRuido() + "\nMovimiento: " + moverse() + "\n");
    }
}
