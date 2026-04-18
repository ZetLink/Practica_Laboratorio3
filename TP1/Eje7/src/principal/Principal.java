package principal;

import lista.*;
import utilidades.Consola;
import datos.*;

import java.util.Scanner;

public class Principal {

    private LSE l1; // Lista para Vehiculos
    private LSE l2; // Lista para almacenar los ID y verificar que no se repitan
    private LSE l3; // Lista para Clientes
    
    public Principal(){
        l1 = new LSE();
        l2 = new LSE();
        l3 = new LSE();
    }
    
    private void agregarVehiculosAFlota(){
        do{
            int iTemp = 0;
            do{
                iTemp = Consola.readInt(0, "ID del Vehiculo: ");
            }while(l2.buscar(iTemp));
            Vehiculo vTemp = new Vehiculo(iTemp);
            vTemp.cargarDatos();
            l1.insertar(vTemp);
            l2.insertar(iTemp);
        }while(Consola.continuar("Seguir añadiendo vehiculos (S/N): "));
    }
    
    private int crearID() {
        Scanner sc = new Scanner(System.in);
        int id;
        boolean x;
        
        do { 
            System.out.print("Cree un ID nuevo: ");
            id = sc.nextInt();
        } while(id < 0);
        l2.insertar(id);
        Cliente c = new Cliente(id);
        c.cargarDatos();
        Nodo n = l3.inicio();
        l3.insertar(c);
        l2.insertar(id);
        x = l2.buscar(id);
        if(x == true) {
            System.out.println("Creado correctamente");
        }
        return id;
    }
    
    private void pedirVehiculo(int idC) {
        Scanner sc = new Scanner(System.in);
        boolean x = false;
        int id;
        Vehiculo VE = null;
        
        
        if(x != l1.listaVacia()) {
            System.out.println("Lista vacia");
        } else {
            System.out.print("Ingrese el ID del vehiculo: ");
            id = sc.nextInt();
        
            Nodo nv = l1.inicio();
            while (nv != null && VE == null) {
                Vehiculo v = (Vehiculo) nv.getDato();
                if(v.getId() == id) {
                    VE = v;
                    x = true;
                }
                nv = nv.getPs();
            }
        
            if(x == false) {
                System.out.println("Vehiculo no encontrado");
            }
        
            nv = l3.inicio();
            while (nv != null) {
                Cliente c = (Cliente) nv.getDato();
                if(c.getId() == idC) {
                    if (VE.getEstado() == 1) {
                        VE.setEstado(2);
                        c.getVehiculos().insertar(VE);
                        System.out.println("Vehiculo encontrado");
                    } else {
                        System.out.println("Vehiculo no disponible");
                    }
                }
                nv = nv.getPs();
            }
        }
    }
    
    private void alquilarVehiculo(){
        Scanner sc = new Scanner(System.in);
        boolean x;
        int id;
        int op;
        
        do {
            System.out.print("Tiene ID de cliente?\n"
                    + "1-SI\n"
                    + "2-NO\n"
                    + "--> ");
            op = sc.nextInt();
        } while(op < 1 && op > 2);
        
        if(op == 1) {
            do {
                System.out.print("Ingrese su ID: ");
                id = sc.nextInt();
                x = l3.buscar(id);
            } while(x == false);
            if (x == true) {
                pedirVehiculo(id);
            }
        } else if (op == 2) {
            id = crearID();
            pedirVehiculo(id);
        }
    }
    
    private void devolverVehiculo(){
        Scanner sc = new Scanner(System.in);
        int idC;
        int idV;
        boolean x1, x2;
        
        do {
            System.out.print("ingrese ID de cliente: ");
            idC = sc.nextInt();
            x1 = l2.buscar(idC);
        } while (x1 == false);
        do {
            System.out.print("ingrese ID del vehiculo: ");
            idV = sc.nextInt();
            x2 = l2.buscar(idV);
        } while (x2 == false);
        
        Nodo n = l1.inicio();
        Nodo n2 = l3.inicio();
        Vehiculo v;
        Cliente c;
        
        while (n != null) {
            v = (Vehiculo) n.getDato();
            if (v.getId() == idV) {
                while (n2 != null) {
                    c = (Cliente) n2.getDato();
                    if (c.getId() == idC) {
                        Nodo aux = c.getVehiculos().eliminar(idV);
                        if(aux != null){
                            v.setEstado(1);
                        }
                    }
                    n2 = n2.getPs();
                }
            }
            n = n.getPs();
       }
    }
    
    private void mostrarAutosDiponibles(){
        if(!l1.listaVacia()){
            Nodo p = l1.inicio();
            while(p != null){
                Object oTemp = p.getDato();
                if(oTemp instanceof Vehiculo){
                    Vehiculo vTemp = (Vehiculo) oTemp;
                    if(vTemp.getEstado() == 1){ // Solo muestra vehiculos en estado disponible
                        vTemp.mostrarDatos();                        
                    }
                }
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Lista de Vehiculos Vacia");
        }
    }
    
    public void menu(){
        String titulo = "Empresa de Alquiler";
        String[] opciones = {
            "1. Agregar vehiculos a la flota",
            "2. Alquilar un vehiculo a un cliente",
            "3. Devolver un vehiculo",
            "4. Mostrar la lista de autos disponibles",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarVehiculosAFlota();
                    break;
                case 2:
                    alquilarVehiculo();
                    break;
                case 3:
                    devolverVehiculo();
                    break;
                case 4:
                    mostrarAutosDiponibles();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
