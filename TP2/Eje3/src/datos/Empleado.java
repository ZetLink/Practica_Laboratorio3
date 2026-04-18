package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Empleado {
    private int id;
    private String nombre;

    public Empleado(int id) {
        this.id = id;
        this.nombre = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void cargarDatos(){
        setNombre(cargarNombre());
    }
    
    private String cargarNombre(){
        String sTemp = "";
        do{
            sTemp = Consola.readString("Nombre: ");
        }while(sTemp.equals(""));
        return sTemp;
    }
    
    protected void mostrarDatos(){
        String formato = "ID: %s\nNombre: %s\n";
        System.out.format(formato, this.getId(), this.getNombre());
    }
}
