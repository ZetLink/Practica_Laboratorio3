package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Persona {
    protected int id;
    protected String nombre;
    protected int edad;
    
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    protected String cargarNombre(){
        String sTemp = "";
        do{
            sTemp = Consola.readString("Nombre: ").toLowerCase();
        }while(sTemp.equals(""));
        return sTemp;
    }
    
    protected int cargarEdad(){
        int iTemp = 0;
        do{
            iTemp = Consola.readInt(0, "Edad: ");
        }while(iTemp < 0);
        return iTemp;
    }
    
    protected String obtenerNombreFormateado(){
        StringBuilder str = new StringBuilder();
        str.append(String.valueOf(nombre.charAt(0)).toUpperCase());
        str.append(nombre.substring(1));
        return str.toString();
    }
}
