package principal;

import exceptions.*;
import lista.LSEO;
import lista.Nodo;
import utilidades.Consola;

public class Principal {

    private final LSEO notas;

    public Principal() {
        this.notas = new LSEO<Integer>();
    }
    
    private void agregarDatos() throws NotaException {
        do {
            int iTemp = 0;
            boolean notaValida = false;
            while (!notaValida) {
                try {
                    iTemp = validarNota();
                    notaValida = true; 
                } catch (NotaException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
            notas.insertar(iTemp);
        }while(Consola.continuar("Agregar otra nota? (S/N): "));
    }
    
    private int validarNota() throws NotaException {
        int iTemp = Consola.readInt(Integer.MIN_VALUE, "Nota: ");
        if(iTemp < 0 || iTemp > 10){
            throw new NotaInvalidaException();
        }
        return iTemp;
    }
    
    private void mostrarLista() throws NotaException{
        try{
            if(!validarListaVacia()){
                Nodo p = notas.inicio();
                while(p != null){
                    System.out.println("Nota: " + (Integer) p.getDato());
                    p = p.getPs();
                }
            }
        }catch(NotaException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private void calcularPromedio(){
        try{
            if(!validarListaVacia()){
                int contador = 0;
                float suma = 0;
                Nodo p = notas.inicio();
                while(p != null){
                    suma += (Integer) p.getDato();
                    contador++;
                    p = p.getPs();
                }
                System.out.println("Promedio: " + suma / contador);
            }
        }catch(NotaException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private boolean validarListaVacia() throws NotaException{
        boolean b = false;
        if(notas.listaVacia()){
            b = true;
            throw new ListaVaciaException();
        }
        return b;
    }
    
    public void menu() throws NotaException{
        String titulo = "Menu Notas";
        String[] opciones = {
            "1. Registrar nota",
            "2. Mostrar notas",
            "3. Calcular promedio de notas",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarDatos();
                    break;
                case 2:
                    mostrarLista();
                    break;
                case 3:
                    calcularPromedio();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) throws NotaException {
        Principal app = new Principal();
        app.menu();
    }
    
}
