package datos;

/**
 * @author Rojas Ulises Martin
 */

import utilidades.Consola;

public class Efectivo implements MetodoDePago{
    
    @Override
    public boolean pagar(float monto) {
        Consola.prtGreen("Pago aprobado");
        return true;
    }
    
}
