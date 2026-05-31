package exceptions;

/**
 * Alumno: Rojas Ulises Martin
 */
public class NotaInvalidaException extends NotaException{

    public NotaInvalidaException() {
        super("Nota invalida. Debe estar entre 0 y 10.");
    }
    
}
