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
    
    private void agregarFormas(){
        do{
            int iTemp = elegirTipo();
            String sTemp = "";
            boolean b = false;
            do{
                sTemp = Consola.readString("Nombre de la Figura: ").toLowerCase();
                b = l1.buscar(sTemp);
                if(b){
                    System.out.println("Nombre ya registrado, ingrese otro...");
                }
            }while(b);
            registrarFigura(sTemp,iTemp);
        }while(Consola.continuar("Seguir agregando figuras? (S/N): "));
    }
    
    private int elegirTipo(){
        String titulo = "Tipos de Figura";
        String[] opciones = {
            "1. Cuadrado",
            "2. Triangulo",
            "3. Circulo"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
        }while(op != 1 && op != 2 && op != 3);
        return op;
    }
    
    private void registrarFigura(String nom, int op){
        Figura fTemp = null;
        switch(op){
            case 1:
                fTemp = new Cuadrado(nom);
                break;
            case 2:
                fTemp = new Triangulo(nom);
                break;
            case 3:
                fTemp = new Circulo(nom);
                break;
        }
        fTemp.cargarDatos();
        l1.insertar(fTemp);
    }
    
    private void mostrarFormas(){
        if(!l1.listaVacia()){
            Nodo p = l1.inicio();
            while(p != null){
                Figura fTemp = (Figura) p.getDato();
                fTemp.dibujar();
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menu(){
        String titulo = "Menu Formas";
        String[] opciones = {
            "1. Añadir",
            "2. Imprimir",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarFormas();
                    break;
                case 2:
                    mostrarFormas();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
