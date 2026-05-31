package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import exceptions.AnioFuturoException;
import exceptions.VehiculoException;
import utilidades.Consola;
import exceptions.AnioMuyAntiguoException;
import java.time.Year;

public class Vehiculo implements Comparable<Vehiculo>{
    private String patente;
    private int anioFabricacion;

    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    
    public void cargarDatos() throws VehiculoException{
        cargarAnioFabricacion();
    }
    
    private void cargarAnioFabricacion() throws VehiculoException{
        int anio = 0;
        boolean valido = false;
        while(!valido){
            try{
                anio = validarAnio();
                valido = true;
            } catch (VehiculoException e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        this.setAnioFabricacion(anio);
    }
    
    private int validarAnio() throws VehiculoException{
        int iTemp = Consola.readInt(0, "Año de fabricacion: ");
        if(iTemp < 1950){
            throw new AnioMuyAntiguoException("Año demasiado antiguo.");
        }else if(iTemp > Year.now().getValue()){
            throw new AnioFuturoException("Año mayor al altual.");
        }
        return iTemp;
    }
    
    public void mostrarDatos(){
        System.out.println(this.toString());
    }
    
    @Override
    public int compareTo(Vehiculo v) {
        return this.getPatente().compareToIgnoreCase(v.getPatente());
    }

    @Override
    public String toString() {
        return String.format("Patente: %s\nAño de fabricacion: %d\n",
                this.getPatente(),
                this.getAnioFabricacion());
    }
    
}
