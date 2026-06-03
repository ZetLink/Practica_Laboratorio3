package principal;

import datos.Libro;
import exceptions.DatoVacioException;
import lista.LSEO;
import lista.Nodo;
import utilidades.Consola;
import exceptions.LibroException;

public class Principal {

    private final LSEO libros;

    public Principal() {
        this.libros = new LSEO<Libro>();
    }
    
    private void agregarDatos() throws LibroException {
        do {
            String titulo = "";
            boolean tituloValido = false;
            while (!tituloValido) {
                try {
                    titulo = validarCadena();
                    tituloValido = true; 
                } catch (LibroException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
            Libro lTemp = new Libro(titulo);
            lTemp.cargarDatos();
            libros.insertar(lTemp);
        }while(Consola.continuar("Agregar otro libro? (S/N): "));
    }
    
    private String validarCadena() throws LibroException {
        String sTemp = "";
        do{
            System.out.print("Titulo: ");
            sTemp = Consola.readLine();
            if(!sTemp.equals("")){
                sTemp = Consola.obtenerVariosNombresFormateado(sTemp).replace(" ", "");
            }
        }while(libros.buscar(new Libro(sTemp)));
        if(sTemp.equals("")){
            throw new DatoVacioException();
        }
        return sTemp;
    }
    
    private void mostrarLista(){
        if(!libros.listaVacia()){
            Nodo p = libros.inicio();
            while(p != null){
                Libro eTemp = (Libro) p.getDato();
                eTemp.mostrarDatos();
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menu() throws LibroException{
        String titulo = "Menu Libros";
        String[] opciones = {
            "1. Registrar libro",
            "2. Mostrar libros",
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
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) throws LibroException {
        Principal app = new Principal();
        app.menu();
    }
    
}
