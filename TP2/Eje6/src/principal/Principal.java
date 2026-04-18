package principal;

import utilidades.Consola;
import datos.*;
import lista.*;

public class Principal {

    private LSE l1;
    
    public Principal(){
        l1 = new LSE();
    }
    
    private void agregarVehiculo(){
       do{
           int op;
            String titulo = "Tipo Vehiculo";
            String[] opciones = {
                "1. Automovil",
                "2. Camion",
                "3. Colectivo",
                "4. MotoVehiculo",
                "0. Salir"
            };
            Consola.imprimirMenu(opciones, titulo);
            do{
                op = Consola.readInt(0, "--> ");
            }while(op != 1 && op != 2 && op != 3 && op != 4);
            registrarVehiculo(op);
       }while(Consola.continuar("Cargar otro vehiculo (S/N): "));
    }
    
    private void registrarVehiculo(int op){
        int iTemp = 0;
        boolean b = false;
        do{
            iTemp = Consola.readInt(0, "ID del Vehiculo: ");
            b = l1.buscar(iTemp);
            if (b) {
                System.out.println("Error: El ID ingresado ya existe. Intente con otro.");
            }
        }while(b);
        Vehiculo vTemp = null;
        switch (op) {
            case 1:
                vTemp = new Automovil(iTemp);
                break;
            case 2:
                vTemp = new Camion(iTemp);
                break;
            case 3:
                vTemp = new Colectivo(iTemp);
                break;
            default:
                vTemp = new MotoVehiculo(iTemp);
                break;
        }
        vTemp.cargarDatos();
        l1.insertar(vTemp);
    }
    
    private void eliminarVehiculo(){
        if(!l1.listaVacia()){
            int iTemp = Consola.readInt(0, "ID a Eliminar: ");
            if(l1.buscar(iTemp)){
                l1.eliminar(iTemp);
            }else{
                Consola.prtRed("Vehiculo no Encontrado");
            }
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    private void mostrarVehiculo(){
        if(!l1.listaVacia()){
            Nodo p = l1.inicio();
            while(p != null){
                Vehiculo vTemp = (Vehiculo) p.getDato();
                if(vTemp instanceof Automovil){
                    Automovil auTemp = (Automovil) vTemp;
                    auTemp.mostrarDatos();
                }else if(vTemp instanceof Camion){
                    Camion caTemp = (Camion) vTemp;
                    caTemp.mostrarDatos();
                }else if(vTemp instanceof Colectivo){
                    Colectivo coTemp = (Colectivo) vTemp;
                    coTemp.mostrarDatos();
                }else if(vTemp instanceof MotoVehiculo){
                    MotoVehiculo mvTemp = (MotoVehiculo) vTemp;
                    mvTemp.mostrarDatos();
                }
                p = p.getPs();
            }   
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menu(){
        String titulo = "Menu Vehiculos";
        String[] opciones = {
            "1. Añadir Vehiculo",
            "2. Eliminar Vehiculo",
            "3. Mostrar Vehiculo",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    eliminarVehiculo();
                    break;
                case 3:
                    mostrarVehiculo();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
