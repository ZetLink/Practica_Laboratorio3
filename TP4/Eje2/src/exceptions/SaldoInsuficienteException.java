package exceptions;

/**
 * Alumno: Rojas Ulises Martin
 */
public class SaldoInsuficienteException extends OperacionBancariaException{

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
    
}
