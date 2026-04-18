package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Empleado extends Persona{
    private float sueldoB;

    public Empleado() {
        super();
        this.sueldoB = 0;
    }

    public float getSueldoB() {
        return sueldoB;
    }

    public void setSueldoB(float sueldoB) {
        this.sueldoB = sueldoB;
    }
    
    public void cargarDatos(int id){
        setId(id);
        setNombre(super.cargarNombre());
        setEdad(super.cargarEdad());
        setSueldoB(cargarSueldo());
    }
    
    protected float cargarSueldo(){
        float fTemp = 0;
        do{
            fTemp = Consola.readFloat(0, "Sueldo base: ");
        }while(fTemp < 0);
        return fTemp;
    }
    
    public void mostrarDatos(String formato){
        //String formato = "    - %-6d%-20s%-6d%-10.2f\n";
        System.out.format(formato, this.getId(), super.obtenerNombreFormateado(), this.getEdad(), this.getSueldoB());
    }
}
