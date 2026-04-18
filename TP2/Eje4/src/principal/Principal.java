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
    
    private void agregarAnimal(){
        do{
            int op;
            String titulo = "Tipo de Animal";
            String[] opciones = {
                "1. Perro",
                "2. Gato",
                "3. pajaro"
            };
            Consola.imprimirMenu(opciones, titulo);
            do{
                op = Consola.readInt(0, "--> ");
            }while(op != 1 && op != 2 && op != 3);
            registrarAnimal(op);
        }while(Consola.continuar("Seguir agregando animales? (S/N): "));
    }
    
    private void registrarAnimal(int tipo){
        int iTemp = 0;
        boolean b = false;
        do{
            iTemp = Consola.readInt(0, "ID del Animal: ");
            b = l1.buscar(iTemp);
            if (b) {
                System.out.println("Error: El ID ingresado ya existe. Intente con otro.");
            }
        }while(b);
        Animal aTemp = null;
        switch (tipo) {
            case 1:
                aTemp = new Perro(iTemp);
                break;
            case 2:
                aTemp = new Gato(iTemp);
                break;
            default:
                aTemp = new Pajaro(iTemp);
                break;
        }
        aTemp.cargarDatos();
        l1.insertar(aTemp);
    }
    
    private void mostrarAnimales(){
        if(!l1.listaVacia()){
            Nodo p = l1.inicio();
            while(p != null){
                Animal oTemp = (Animal) p.getDato();
                if(oTemp instanceof Perro){
                    Perro peTemp = (Perro) oTemp;
                    peTemp.mostrarDatos();
                } else if(oTemp instanceof Gato){
                    Gato gaTemp = (Gato) oTemp;
                    gaTemp.mostrarDatos();
                } else if(oTemp instanceof Pajaro){
                    Pajaro paTemp = (Pajaro) oTemp;
                    paTemp.mostrarDatos();
                }
                System.out.println("");
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menu(){
        String titulo = "Menu de Animales";
        String[] opciones = {
            "1. Añadir Animales",
            "2. Mostrar Animales",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarAnimal();
                    break;
                case 2:
                    mostrarAnimales();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
