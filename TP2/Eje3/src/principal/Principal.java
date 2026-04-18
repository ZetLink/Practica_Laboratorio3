package principal;

import utilidades.Consola;
import datos.*;
import lista.*;

/**
 * Alumno: Rojas Ulises Martin
 */
public class Principal {

    private LSE l1;
    
    public Principal(){
        l1 = new LSE();
    }
    
    private void agregarEmpleado(){
        do{
            int op;
            String titulo = "Tipo de Empleado";
            String[] opciones = {
                "1. Asalariado",
                "2. Por Hora"
            };
            Consola.imprimirMenu(opciones, titulo);
            do{
                op = Consola.readInt(0, "--> ");
            }while(op != 1 && op != 2);
            registrarEmpleado(op);
        }while(Consola.continuar("Seguir agregando empleados? (S/N): "));
    }
    
    private void registrarEmpleado(int tipo){
        int iTemp = 0;
        boolean b = false;
        do{
            iTemp = Consola.readInt(0, "ID del Empleado: ");
            b = l1.buscar(iTemp);
            if (b) {
                System.out.println("Error: El ID ingresado ya existe. Intente con otro.");
            }
        }while(b);
        Empleado eTemp = null;
        switch (tipo) {
            case 1:
                eTemp = new EmpleadoAsalariado(iTemp);
                break;
            case 2:
                eTemp = new EmpleadoPorHora(iTemp);
                break;
        }
        eTemp.cargarDatos();
        l1.insertar(eTemp);
    }
    
    private void mostrarEmpleados(){
        if(!l1.listaVacia()){
            Nodo p = l1.inicio();
            while(p != null){
                Empleado oTemp = (Empleado) p.getDato();
                if(oTemp instanceof EmpleadoAsalariado){
                    EmpleadoAsalariado eaTemp = (EmpleadoAsalariado) oTemp;
                    eaTemp.mostrarDatos();
                } else if(oTemp instanceof EmpleadoPorHora){
                    EmpleadoPorHora ephTemp = (EmpleadoPorHora) oTemp;
                    ephTemp.mostrarDatos();
                }
                System.out.println("");
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menu(){
        String titulo = "Menu de Empleados";
        String[] opciones = {
            "1. Añadir Empleados",
            "2. Mostrar Empleados",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    mostrarEmpleados();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
