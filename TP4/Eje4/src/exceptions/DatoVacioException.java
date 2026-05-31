package exceptions;

/**
 * Alumno: Rojas Ulises Martin
 */
public class DatoVacioException extends LibroException{

    public DatoVacioException() {
        super("La cadena no contiene caracteres");
    }
    
}
