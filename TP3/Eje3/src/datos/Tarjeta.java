package datos;

/**
 * @author Rojas Ulises Martin
 */

import utilidades.Consola;

public class Tarjeta implements MetodoDePago{
    private String titular;
    private float saldo;

    public Tarjeta(String titular, float saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    
    @Override
    public boolean pagar(float monto) {
        boolean b = false;
        if(monto <= saldo){
            Consola.prtGreen("Pago aprobado");
            b = !b;
        }else{
            Consola.prtRed("Pago rechazado, saldo insuficiente");
        }
        return b;
    }
    
}
