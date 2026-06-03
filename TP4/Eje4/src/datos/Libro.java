package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import exceptions.LibroException;
import utilidades.Consola;
import exceptions.DatoVacioException;
import exceptions.FechaInvalidaException;
import java.time.Year;

public class Libro implements Comparable<Libro>{
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    
    public void cargarDatos() throws LibroException{
        cargarAutor();
        cargarAnioPublicacion();
    }
    
    private void cargarAutor() throws LibroException{
        String sTemp = "";
        boolean valido = false;
        while(!valido){
            try{
                sTemp = validarAutor();
                valido = true;
            }catch(LibroException e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        this.setAutor(sTemp);
    }
    
    private String validarAutor() throws LibroException{
        System.out.print("Autor: ");
        String sTemp = Consola.readLine();
        if(sTemp.trim().equals("")){
            throw new DatoVacioException();
        }
        return sTemp;
    }
    
    private void cargarAnioPublicacion() throws LibroException{
        int anio = 0;
        boolean valido = false;
        while(!valido){
            try{
                anio = validarAnio();
                valido = true;
            } catch (LibroException e){
                System.err.println("Error: " + e.getMessage());
            }
        }
        this.setAnioPublicacion(anio);
    }
    
    private int validarAnio() throws LibroException{
        int iTemp = Consola.readInt(0, "Año de publicacion: ");
        if(iTemp > Year.now().getValue()){
            throw new FechaInvalidaException("Año mayor al actual.");
        }
        return iTemp;
    }
    
    public void mostrarDatos(){
        System.out.println(this.toString());
    }
    
    @Override
    public int compareTo(Libro l) {
        return this.getTitulo().compareToIgnoreCase(l.getTitulo());
    }

    @Override
    public String toString() {
        return String.format("Titulo: %s\n Autor: %s\n Año de publicacion: %d\n",
                separarMayusculasRegex(this.getTitulo()),
                Consola.obtenerVariosNombresFormateado(this.getAutor()),
                this.getAnioPublicacion());
    }
    
    private String separarMayusculasRegex(String texto) {
        // (?<!^) significa "que no sea el inicio de la cadena"
        // (?=[A-Z]) significa "que esté seguido de una mayúscula"
        return texto.replaceAll("(?<!^)(?=[A-Z])", " ");
    }
    
}
