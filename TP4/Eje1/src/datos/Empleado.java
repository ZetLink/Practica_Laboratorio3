package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import exceptions.EmpleadoException;
import utilidades.Consola;
import exceptions.SueldoBajoException;

public class Empleado implements Comparable<Empleado>{
    private int dni;
    private String nombre;
    private double sueldo;

    public Empleado(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public void cargarDatos() throws EmpleadoException{
        this.setNombre(Consola.readString("Nombre: "));
        cargarSueldo();
    }
    
    private void cargarSueldo() throws EmpleadoException{
        double sueldo = 0;
        boolean valido = false;
        while(!valido){
            try{
                sueldo = validarSueldo();
                valido = true;
            } catch (SueldoBajoException e){
                System.err.println("Error: " + e.getMessage());
                System.out.println("Ingrese nuevamente el sueldo.");
            }
        }
        this.setSueldo(sueldo);
    }
    
    private double validarSueldo() throws EmpleadoException{
        double dTemp = Consola.readFloat(0, "Sueldo: ");
        if(dTemp < 120000){
            throw new SueldoBajoException("Sueldo minimo: $120.000");
        }
        return dTemp;
    }
    
    public void mostrarDatos(){
        System.out.println(this.toString());
    }
    
    @Override
    public int compareTo(Empleado t) {
        return Integer.compare(this.getDni(), t.getDni());
    }

    @Override
    public String toString() {
        return String.format("DNI: %d\n Nombre: %s\n Sueldo: %.2f\n",
                this.getDni(),
                Consola.obtenerVariosNombresFormateado(this.getNombre()),
                this.getSueldo());
    }
    
}
