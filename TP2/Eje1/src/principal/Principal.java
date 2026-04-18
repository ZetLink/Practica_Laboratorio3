package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import datos.*;
import lista.*;
import utilidades.*;

public class Principal {

    private LSE l1; // Lista para Directivos y Clientes
    private LSE l2; // Lista para almacenar los ID y verificar que no se repitan
    
    public Principal(){
        l1 = new LSE();
        l2 = new LSE();
    }
    
    private void cargarDirectivos(){
        do{
            int iTemp = 0;
            do{
                iTemp = Consola.readInt(0, "ID del Directivo: ");
            }while(l2.buscar(iTemp));
            Directivo oTemp = new Directivo();
            oTemp.cargarDatos(iTemp);
            l1.insertar(oTemp);
            l2.insertar(iTemp);
        }while(Consola.continuar());
    }
    
    private void cargarEmpleados(){
        int iTemp = Consola.readInt(0, "ID del Directivo para ingresar empleados: ");
        Directivo dTemp = obtenerDirectivo(iTemp);
        if(dTemp != null){
            do{
                iTemp = Consola.readInt(0, "ID del Empleado: ");
            }while(l2.buscar(iTemp));
            Empleado eTemp = new Empleado();
            eTemp.cargarDatos(iTemp);
            dTemp.getSubordinados().insertar(eTemp);
            l2.insertar(iTemp);
        } else {
            Consola.prtRed("Directivo no encontrado");
        }
    }
    
    private void cargarClientes(){
        do{
            int iTemp = 0;
            do{
                iTemp = Consola.readInt(0, "ID del Cliente: ");
            }while(l2.buscar(iTemp));
            Cliente oTemp = new Cliente();
            oTemp.cargarDatos(iTemp);
            l1.insertar(oTemp);
            l2.insertar(iTemp);
        }while(Consola.continuar());
    }
    
    private void mostrarTodo(){
        if(!l1.listaVacia()){
            mostrarDirectivosEmpleados();
            mostrarClientes();   
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    private void mostrarDirectivosEmpleados(){
        Nodo p = l1.inicio();
        System.out.println("Directivos");
        String formato = "|%-8s|%-20s|%-10s|%-16s|%-10s|\n";
        String sTemp = String.format(formato, "ID", "Nombre", "Edad", "SueldoBase", "Categoria");
        System.out.println(Consola.repeat("-", sTemp.length()));
        System.out.print(sTemp);
        System.out.println(Consola.repeat("-", sTemp.length()));
        while(p != null){
            Object oTemp = p.getDato();
            if(oTemp instanceof Directivo){
                Directivo dTemp = (Directivo) oTemp;
                dTemp.mostrarDatos(formato);
                System.out.println(Consola.repeat("-", sTemp.length()));
            }
            p = p.getPs();
        }
    }
    
    private void mostrarClientes(){
        Nodo p = l1.inicio();
        System.out.println("Clientes");
        String formato = "|%-8s|%-20s|%-10s|%-18s|\n";
        String sTemp = String.format(formato, "ID", "Nombre", "Edad", "Telefono");
        System.out.println(Consola.repeat("-", sTemp.length()));
        System.out.print(sTemp);
        System.out.println(Consola.repeat("-", sTemp.length()));
        while(p != null){
            Object oTemp = p.getDato();
            if(oTemp instanceof Cliente){
                Cliente cTemp = (Cliente) oTemp;
                cTemp.mostrarDatos(formato);
                System.out.println(Consola.repeat("-", sTemp.length()));
            }
            p = p.getPs();
        }
    }
    
    private Directivo obtenerDirectivo(int elem){
        Directivo x = null;
        Nodo p = l1.inicio();
        while(p != null){
            Object aux = p.getDato();
            if(aux instanceof Directivo){
                Directivo dTemp = (Directivo) aux;
                if(dTemp.getId() == elem){
                    x = dTemp;
                }
            }
            p = p.getPs();
        }
        return x;
    }
    
    public void menu(){
        String titulo = "Menu Empresa";
        String[] opciones = {
            "1. Cargar Directivos",
            "2. Cargar Empleados",
            "3. Cargar Clientes",
            "4. Mostrar todo",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    cargarDirectivos();
                    break;
                case 2:
                    cargarEmpleados();
                    break;
                case 3:
                    cargarClientes();
                    break;
                case 4:
                    mostrarTodo();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
