package principal;

import utilidades.Consola;
import lista.*;
import datos.*;

/**
 * Alumno: Rojas Ulises Martin
 */
public class Principal {

    private LSE l1;
    
    public Principal(){
        l1 = new LSE();
    }
    
    private void agregarDispositivos(){
        String titulo = "Seleccione Tipo de DIspositivo";
        String[] opciones = {
            "1. Celular",
            "2. Computadora",
            "3. Tablet"
        };
        int op;
        Consola.imprimirMenu(opciones, titulo);
        do{
            op = Consola.readInt(0, "--> ");
        }while(op != 1 && op != 2 && op != 3);
        registrarDispositivo(op);
    }
    
    private void registrarDispositivo(int op){
        int iTemp = 0;
        boolean b = false;
        do{
            iTemp = Consola.readInt(0, "ID del Dispositivo: ");
            b = l1.buscar(iTemp);
            if (b) {
                System.out.println("Error: El ID ingresado ya existe. Intente con otro.");
            }
        }while(b);
        Dispositivo oTemp = null;
        switch(op){
            case 1:
                oTemp = new Celular(iTemp);
                break;
            case 2:
                oTemp = new Computadora(iTemp);
                break;
            case 3:
                oTemp = new Tablet(iTemp);
                break;
        }
        oTemp.cargarDatos();
        l1.insertar(oTemp);
    }
    
    private void mostrarDispositivos(){
        Nodo p = l1.inicio();
        while(p != null){
            Object oTemp = p.getDato();
            if(oTemp instanceof Celular){
                Celular celTemp = (Celular) oTemp;
                celTemp.mostrarDatos();
            } else if(oTemp instanceof Computadora){
                Computadora comTemp = (Computadora) oTemp;
                comTemp.mostrarDatos();
            } else if(oTemp instanceof Tablet){
                Tablet tabTemp = (Tablet) oTemp;
                tabTemp.mostrarDatos();
            }
            p = p.getPs();
        }
    }
    
    public void menu(){
        String titulo = "Menu Dispositivos";
        String[] opciones = {
            "1. Agregar",
            "2. Mostrar"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarDispositivos();
                    break;
                case 2:
                    mostrarDispositivos();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
