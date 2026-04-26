package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;
import datos.*;
import lista.*;

public class Principal {

    private LSE l1;
    
    public Principal(){
        l1 = new LSE();
    }
    
    private void agregarEmpleados(){
        do{
            int op = elegirTipo();
            int iTemp = 0;
            boolean b = false;
            do{
                iTemp = Consola.readInt(0, "ID del Empleado: ");
                b = l1.buscar(iTemp);
                if(b){
                    System.out.println("ID ya registrado, ingrese otro...");
                }
            }while(b);
            registrarEmpleado(iTemp,op);
        }while(Consola.continuar("Seguir agregando empleados? (S/N): "));
    }
    
    private int elegirTipo(){
        String titulo = "Tipo de Empleado";
        String[] opciones = {
            "1. Asalariado",
            "2. Por Hora"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
        }while(op != 1 && op != 2);
        return op;
    }
    
    private void registrarEmpleado(int id, int op){
        Empleado eTemp = null;
        switch(op){
            case 1:
                eTemp = new EmpleadoAsalariado(id);
                break;
            case 2:
                eTemp = new EmpleadoPorHora(id);
                break;
        }
        eTemp.cargarDatos();
        l1.insertar(eTemp);
    }
    
    private void mostrarRecibos(){
        if(!l1.listaVacia()){
            Nodo p = l1.inicio();
            while(p != null){
                Empleado eTemp = (Empleado) p.getDato();
                eTemp.imprimirRecibo();
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menu(){
        String titulo = "Menu Empleados";
        String[] opciones = {
            "1. Añadir Empleados",
            "2. Imprimir Recibos",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarEmpleados();
                    break;
                case 2:
                    mostrarRecibos();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
