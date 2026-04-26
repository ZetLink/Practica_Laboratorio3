package datos;

/**
 * @author Rojas Ulises Martin
 */

import utilidades.Consola;

public class EmpleadoPorHora extends Empleado{
    private int horasTrabajadas;
    private float valorHora;

    public EmpleadoPorHora(int id) {
        super(id);
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }
    
    @Override
    public void cargarDatos() {
        setNom(Consola.readString("Nombre: ").toLowerCase());
        setHorasTrabajadas(Consola.readInt(0, "Cantidad de Horas Trabajadas: "));
        setValorHora(Consola.readFloat(0, "Valor monetario de una hora de trabajo: "));
    }

    @Override
    public float calcularSueldo() {
        return getHorasTrabajadas() * getValorHora();
    }
    
}
