package principal;

import datos.*;
import utilidades.*;

public class Principal {
    
    private float recaudacion = 0;
    
    private float pagarConTarjeta(){
        String sTemp = Consola.readString("Nombre: ");
        float fTemp = Consola.readFloat(0, "Saldo de la Tarjeta: ");
        MetodoDePago oTemp = new Tarjeta(sTemp, fTemp);
        System.out.println("--- Tarjeta registrada ---\n");
        
        float monto = Consola.readFloat(0, "Ingrese el monto a cobrar: ");
        if(!oTemp.pagar(monto)){
            Consola.prtRed("No se pudo hacer el pago");
            monto = 0;
        }
        return monto;
    }
    
    private float pagarConEfectivo(){
        MetodoDePago oTemp = new Efectivo();
        System.out.println("--- Efectivo registrada ---\n");
        
        float monto = Consola.readFloat(0, "Ingrese el monto a cobrar: ");
        if(!oTemp.pagar(monto)){
            Consola.prtRed("No se pudo hacer el pago");
            monto = 0;
        }
        return monto;
    }
    
    private void mostrarRecaudado(){
        System.out.println("Recaudado: " + recaudacion);
    }
    
    public void menu(){
        String titulo = "Menu de Pagos";
        String[] opciones = {
            "1. Pagar con tarjeta",
            "2. Pagar con efectivo",
            "3. Mostrar recaudacion",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    recaudacion += pagarConTarjeta();
                    break;
                case 2:
                    recaudacion += pagarConEfectivo();
                    break;
                case 3:
                    mostrarRecaudado();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
