package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import exceptions.MontoInvalidoException;
import exceptions.OperacionBancariaException;
import exceptions.SaldoInsuficienteException;
import utilidades.Consola;

public class Banco {

    private double saldo;
    
    private void establecerSaldo(){
        saldo = Consola.readFloat(0, "Saldo Inicial: ");
    }
    
    private void retirarDinero() throws OperacionBancariaException{
        do{
            boolean montoValido = false;
            double dTemp = 0;
            while(!montoValido){
                try{
                   dTemp = Consola.readFloat(Integer.MIN_VALUE, "Monto a retirar: ");
                   retirar(dTemp);
                   montoValido = true;
                }catch(MontoInvalidoException e){
                    System.err.println("Error: " + e.getMessage());
                }catch(SaldoInsuficienteException e){
                    System.err.println("Error: " + e.getMessage());
                }
            }
            saldo -= dTemp;
            System.out.println("Saldo actual: " + saldo);
        }while(Consola.continuar("Seguir retirando dinero? (S/N): "));
    }
    
    private void retirar(double dTemp) throws OperacionBancariaException{
        if(dTemp < 0){
            throw new MontoInvalidoException("Monto invalido. Debe ser un monto positivo");
        }else if(dTemp > saldo){
            throw new SaldoInsuficienteException("Monto invalido. Debe ser un monto menor al saldo actual.");
        }
    }
    
    public static void main(String[] args) throws OperacionBancariaException {
        Banco app = new Banco();
        app.establecerSaldo();
        app.retirarDinero();
    }

}
