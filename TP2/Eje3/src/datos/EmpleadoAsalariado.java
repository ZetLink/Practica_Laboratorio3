package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class EmpleadoAsalariado extends Empleado{
    private float sueldoFijo;

    public EmpleadoAsalariado(int id) {
        super(id);
    }

    public float getSueldoFijo() {
        return sueldoFijo;
    }

    public void setSueldoFijo(float sueldoFijo) {
        this.sueldoFijo = sueldoFijo;
    }
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        setSueldoFijo(cargarSueldo());
    }
    
    private float cargarSueldo(){
        float fTemp = 0;
        fTemp = Consola.readFloat(0, "Sueldo Fijo: ");
        return fTemp;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Sueldo Fijo Mensual: %s\n\n";
        System.out.format(formato, this.getSueldoFijo());
    }
}
