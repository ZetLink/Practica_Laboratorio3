package principal;

import datos.*;
import lista.*;
import utilidades.*;

public class Principal {

    private LSE l1;
    
    public Principal(){
        l1 = new LSE();
    }
    
    private void cargarPagos(){
        do{
            int op;
            String titulo = "Tipo de Pago";
            String[] opciones = {
                "1. Pago Efectivo",
                "2. Pago Tarjeta",
                "0. Salir"
            };
            Consola.imprimirMenu(opciones, titulo);
            do{
                op = Consola.readInt(0, "--> ");
            }while(op != 1 && op != 2);
            registrarPago(op);
        }while(Consola.continuar("Seguir añadiendo pagos? (S/N): "));
    }
    
    private void registrarPago(int tipo){
        int iTemp = 0;
        boolean b = false;
        do{
            iTemp = Consola.readInt(0, "ID del Pago: ");
            b = l1.buscar(iTemp);
            if (b) {
                System.out.println("Error: El ID ingresado ya existe. Intente con otro.");
            }
        }while(b);
        Pago pTemp = null;
        if(tipo == 1){
            pTemp = new PagoEfectivo(iTemp);
        } else {
            pTemp = new PagoTarjeta(iTemp);
        }
        pTemp.cargarDatos();
        l1.insertar(pTemp);
    }
    
    private void mostrarPagos(){
        Nodo p = l1.inicio();
        while(p != null){
            Pago oTemp = (Pago) p.getDato();
            if(oTemp instanceof PagoEfectivo){
                PagoEfectivo peTemp = (PagoEfectivo) oTemp;
                peTemp.mostrarDatos();
            } else if(oTemp instanceof PagoTarjeta){
                PagoTarjeta ptTemp = (PagoTarjeta) oTemp;
                ptTemp.mostrarDatos();
            }
            p = p.getPs();
        }
    }
    
    public void menu(){
        String titulo = "Menu de Pagos";
        String[] opciones = {
            "1. Añadir Pagos",
            "2. Mostrar Pagos",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    cargarPagos();
                    break;
                case 2:
                    mostrarPagos();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
