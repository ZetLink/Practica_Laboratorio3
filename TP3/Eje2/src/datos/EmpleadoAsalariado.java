package datos;

/**
 * @author Rojas Ulises Martin
 */

import utilidades.Consola;

public class EmpleadoAsalariado extends Empleado{
    private float sueldo;
    private float antiguedad;

    public EmpleadoAsalariado(int id) {
        super(id);
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public float getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(float antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    @Override
    public void cargarDatos() {
        setNom(Consola.readString("Nombre: ").toLowerCase());
        setSueldo(Consola.readFloat(0, "Sueldo: "));
        setAntiguedad(Consola.readFloat(0, "Años de Antiguedad: "));
    }

    @Override
    public float calcularSueldo() {
        // 1 año de antiguedad = $1000 extra
        return getSueldo() + (getAntiguedad() * 1000);
    }
    
    
}
