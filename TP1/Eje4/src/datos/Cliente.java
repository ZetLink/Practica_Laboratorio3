package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Cliente extends Persona{
    private long telefono;

    public Cliente() {
        super();
        this.telefono = 0;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    public void cargarDatos(int id){
        setId(id);
        setNombre(super.cargarNombre());
        setEdad(super.cargarEdad());
        setTelefono(cargarTelefono());
    }
    
    private long cargarTelefono(){
        long lTemp = 0;
        do{
            lTemp = Consola.readLong(0, "Telefono: ");
        }while(lTemp < 0);
        return lTemp;
    }
    
    public void mostrarDatos(String formato){
        //String formato = "%-6d%-20s%-6d%-20d\n";
        System.out.format(formato, this.getId(), super.obtenerNombreFormateado(), this.getEdad(), this.getTelefono());
    }
}
