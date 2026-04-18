package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class EmpleadoPorHora extends Empleado{
    private float precioPorHora;
    private float horasTrabajadas;

    public EmpleadoPorHora(int id) {
        super(id);
    }

    public float getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(float precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public float getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(float horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        setPrecioPorHora(cargarFloat("Precio por Hora: "));
        setHorasTrabajadas(cargarFloat("Horas Trabajadas: "));
    }
    
    private float cargarFloat(String msg){
        float fTemp = 0;
        fTemp = Consola.readFloat(0, msg);
        return fTemp;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Sueldo Ganado: %s\n\n";
        System.out.format(formato, this.getHorasTrabajadas() * this.getPrecioPorHora());
    }
}
